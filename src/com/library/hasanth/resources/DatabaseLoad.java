package com.library.hasanth.resources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Set;

public class DatabaseLoad {

	public void bookAuthorsDataLoad() {
		try {
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/library";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "hasanth", "sista");

			String query = "insert into book_authors(author_id,isbn) values (?,?)";

			String query1 = "select author_id from authors where name = ?";

			String query2 = "select isbn from book where title = ?";
			
			try {
				BufferedReader bReader = new BufferedReader(
						new FileReader("C:/Users/sista/OneDrive - The University of Texas at Dallas/DB/books.csv"));
				String line = "";
				bReader.readLine();

				while ((line = bReader.readLine()) != null) {
					try {
						if (line != null) {
							String[] array = line.split("\t");
							String authors = array[3];
							String title = array[2];

							for (String s : authors.split(",")) {

								PreparedStatement ps = conn.prepareStatement(query1);
								ps.setString(1, s);
								ResultSet rs = ps.executeQuery();
								rs.next();
								String id = rs.getString(1);
								ps.close();

								PreparedStatement ps1 = conn.prepareStatement(query2);
								ps1.setString(1, title);
								ResultSet rs1 = ps1.executeQuery();
								
								while(rs1.next()){
									PreparedStatement ps2 = conn.prepareStatement(query);
									ps2.setString(1, id);
									ps2.setString(2, rs1.getString("isbn"));
									ps2.executeUpdate();
									ps2.close();
								}
								
								ps1.close();

							}
						}
					} catch (Exception ex) {

						LibraryLogger.logError("DatabaseLoad", "bookAuthorsDataLoad", ex.toString());
					} finally {
						if (bReader == null) {
							bReader.close();
						}
					}
				}

			} catch (FileNotFoundException ex) {
				
			}
		} catch (Exception e) {
//			System.err.println("Got an exception!");
		}

	}

	public void authorsLoad() {
		try {
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/library";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "hasanth", "sista");

			String query = "insert into authors (name) values (?)";
			try {
				BufferedReader bReader = new BufferedReader(
						new FileReader("C:/Users/sista/OneDrive - The University of Texas at Dallas/DB/books.csv"));
				String line = "";
				bReader.readLine();
				Set<String> hashSet = new HashSet<String>();

				while ((line = bReader.readLine()) != null) {
					try {
						if (line != null) {
							String[] array = line.split("\t");

							String[] authors = array[3].split(",");

							for (String result : authors) {
								hashSet.add(result);

							}
						}

					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						if (bReader == null) {
							bReader.close();
						}
					}
				}
				for (String s : hashSet) {
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(1, s);
					ps.executeUpdate();
					ps.close();
				}

			} catch (FileNotFoundException ex) {

				LibraryLogger.logError("DatabaseLoad", "authorsLoad", ex.toString());
			}
		} catch (Exception e) {

			LibraryLogger.logError("DatabaseLoad", "authorsLoad", e.toString());
		}
	}
	
	public void personDataLoad(){
		try {
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/library";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "hasanth", "sista");

			String query = "insert into person values (?,?,?,?,?,?,?,?)";
			
			String query1 = "insert into borrower(ssn,bname,address,phone) values (?,?,?,?)";
			try {
				BufferedReader bReader = new BufferedReader(
						new FileReader("C:/Users/sista/OneDrive - The University of Texas at Dallas/DB/borrowers.csv"));
				String line = "";
				bReader.readLine();
				
				while ((line = bReader.readLine()) != null) {
					try {
						if (line != null) {
							String[] array = line.split(",");
							
							String ssn=array[1];
							String firstname=array[2];
							String lastname=array[3];
							String email=array[4];
							String address=array[5];
							String city=array[6];
							String state=array[7];
							String phone=array[8];
							
							PreparedStatement ps = conn.prepareStatement(query);
							ps.setString(1, ssn);
							ps.setString(2, firstname);
							ps.setString(3, lastname);
							ps.setString(4, email);
							ps.setString(5, address);
							ps.setString(6, city);
							ps.setString(7, state);
							ps.setString(8, phone);
							ps.executeUpdate();
							ps.close();
							

							PreparedStatement ps1 = conn.prepareStatement(query1);
//							ps1.setString(1, array[0]);
							ps1.setString(1, ssn);
							ps1.setString(2, firstname+" "+lastname);
							ps1.setString(3, address+","+city+","+state);
							ps1.setString(4, phone);
							ps1.executeUpdate();
							ps1.close();
						}

					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						if (bReader == null) {
							bReader.close();
						}
					}
				}
				

			} catch (FileNotFoundException ex) {

				LibraryLogger.logError("DatabaseLoad", "personDataLoad", ex.toString());
			}
		} catch (Exception e) {

			LibraryLogger.logError("DatabaseLoad", "personDataLoad", e.toString());
		}
	}
	
	public void availabilityDataLoad(){
		try {
			String myDriver = "com.mysql.jdbc.Driver";
			String myUrl = "jdbc:mysql://localhost:3306/library";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "hasanth", "sista");

			String query = "insert into availability values (?,?)";
			
			try {
				BufferedReader bReader = new BufferedReader(
						new FileReader("C:/Users/sista/OneDrive - The University of Texas at Dallas/DB/books.csv"));
				String line = "";
				bReader.readLine();
				
				while ((line = bReader.readLine()) != null) {
					try {
						if (line != null) {
							String[] array = line.split("\t");
							
							PreparedStatement ps = conn.prepareStatement(query);
							ps.setString(1, array[0]);
							ps.setString(2,"true");
							ps.executeUpdate();
							ps.close();

						}

					} catch (Exception ex) {
						ex.printStackTrace();
					} finally {
						if (bReader == null) {
							bReader.close();
						}
					}
				}
				

			} catch (FileNotFoundException ex) {

				LibraryLogger.logError("DatabaseLoad", "availabilityDataLoad", ex.toString());
			}
		} catch (Exception e) {

			LibraryLogger.logError("DatabaseLoad", "availabilityDataLoad", e.toString());
		}
	}
		
	public static void main(String[] args) {
		try {
			DatabaseLoad databaseLoad = new DatabaseLoad();
			//databaseLoad.authorsLoad();
			//databaseLoad.bookAuthorsDataLoad();
			databaseLoad.personDataLoad();
			//databaseLoad.availabilityDataLoad();
			
		} catch (Exception e) {

			LibraryLogger.logError("DatabaseLoad", "main", e.toString());
		}
	}
}
