package com.library.hasanth.resources;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.hasanth.business.service.BookCheckout;

/**
 * Servlet implementation class GetCardId
 */
@WebServlet("/GetCard")
public class GetCardId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCardId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(request, response);
		String isbn=request.getParameter("isbn");
		String title=request.getParameter("title");
		String authors=request.getParameter("authors");
		String id=request.getParameter("id");
		
		try{
			
			BookCheckout checkout=Factory.createBookCheckoutImpl();
			String message=checkout.bookCheckoutMethod(isbn, title, authors, id);
			PrintWriter printWriter=response.getWriter();
			printWriter.write(message, 0, message.length());
			printWriter.flush();
			printWriter.close();
		}catch(Exception e){
			LibraryLogger.logError("GetCardIdServlet", "doPost", e.toString());
		}
	}

	

}
