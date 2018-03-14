Library Management System

The project is implemented on Eclipse Neon Release and the backend Database Management is handled using MySQL Release (5.7).


Language 		:JAVA

Technologies Used	:Hibernate(ORM) , Java Server Pages , Java Server Faces

OS			:Windows 10

Libraries 		:Apache Tomcat v8.0 , JRE System Library[jdk1.8.0_144] , Web App Libraries (
		 	antlr-2.7.7 , cglib-2.2 , commons-collections-3.1 , dom4j-1.6 , gson-2.2.2 , 
		 	hibernate-commons-annotations-4.0.5.Final , hibernate-core-4.3.9.Final , 
		 	hibernate-entitymanager-4.3.9.Final , hibernate-jpa-2.1-api-1.0.0.final , 
		 	jandex-1.1.0 , javassist-3.1.18.1-GA , javax.faces-2.2.10 , javax.persistence-2.1.0-RC2 ,
		 	jboss-logging-3.1.13.ga , jboss-transaction-api_1.1_spec-1.0.1.Final , joda-time-2.2 , 
		 	jsp-api , jstl-1.2 , jta-1_1 , junit-4.9b2 , log4j-1.2.15 , mysql-connector-java-5.1.23 ,
		 	ojdbc14 , ojdbc7-12.1.0.2 , org.apache.commons.fileupload , slf4j.api-1.6.1 , standard ).

Build Configuarations	:Import the given project as existing projects into workspace.
		 	Include the provided libraries above in the build path.
		 	In the properties of project, click on project facets and make sure Dynamic Web Module is 			3.1, Java is 1.8, JavaScript is 1.0, JavaServer Faces is 2.2.

Instructions to execute – Assuming user has installed Eclipse, Apache Tomcat and MySQL.
a.	Connect to MySQL and Enter username and password
mysql –u “xxxx” –p “xxxx” 

b. Import the database source (i.e. attached in the submitted folder)
mysql> source library.sql

b.	Import the project (i.e. LibraryManagementSystem project attached in the submitted folder) in Eclipse and hit “Run on Server” choosing Apache Tomcat 

c.	Locate hibernate.cfg.xml file in the project and update MySQL username and password in the file.

How to Run Application – 
After the tomcat server has been started.
Click on --  http://localhost:8080/LibraryManagementSystem/SearchBook.jsp







