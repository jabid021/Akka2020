package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.Marque;
import model.PC;

@WebServlet("/pc")
public class ServletPC extends HttpServlet {
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<PC> listePc = Context.getInstance().getDaoPC().findAll();
		List<PC> pcDispos = Context.getInstance().getDaoPC().findDisponibles();
		request.setAttribute("listePc", listePc);
		request.setAttribute("pcDispos", pcDispos);
		request.setAttribute("marques", Marque.values());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
