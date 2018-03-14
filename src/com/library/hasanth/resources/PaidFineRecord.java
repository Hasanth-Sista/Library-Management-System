package com.library.hasanth.resources;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.hasanth.business.service.FineDetails;

/**
 * Servlet implementation class PaidFineRecord
 */
@WebServlet("/PaidFine")
public class PaidFineRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaidFineRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String card_id = request.getParameter("card_id");
		String fine_amt = request.getParameter("fine_amt");
		String f_paid = request.getParameter("f_paid");
		String flag = request.getParameter("flag");
		

		try {
			String message="";
			FineDetails fineDetails = Factory.createFineDetailsImpl();
			if (flag.equals("0")) {
				message += "You have already paid the fine";
			} else {
				message += fineDetails.getFinePaid(card_id, fine_amt, f_paid);
			}
			PrintWriter printWriter = response.getWriter();
			printWriter.write(message, 0, message.length());
			printWriter.flush();
			printWriter.close();

		} catch (Exception e) {
			LibraryLogger.logError("CheckingInBooksServlet", "doPost", e.toString());
		}
	}

}
