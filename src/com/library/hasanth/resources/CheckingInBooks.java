package com.library.hasanth.resources;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.hasanth.business.service.BookCheckin;
import com.library.hasanth.business.service.BookCheckout;

/**
 * Servlet implementation class CheckingInBooks
 */
@WebServlet("/CheckIn")
public class CheckingInBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckingInBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loan_id=request.getParameter("loan_id");
		String isbn=request.getParameter("isbn");
		String card_id=request.getParameter("card_id");
		String due_date=request.getParameter("due_date");
		String date_in=request.getParameter("date_in");
		
		try{
			
			BookCheckin checkin=Factory.createBookCheckinImpl();
			String message=checkin.bookCheckinMethod(loan_id, isbn, card_id, due_date, date_in);
			PrintWriter printWriter=response.getWriter();
			printWriter.write(message, 0, message.length());
			printWriter.flush();
			printWriter.close();
			
		}catch(Exception e){
			LibraryLogger.logError("CheckingInBooksServlet", "doPost", e.toString());
		}
	

	}

}
