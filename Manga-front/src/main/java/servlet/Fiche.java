package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.Oeuvre;

@WebServlet("/fiche")
public class Fiche extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{Class.forName("com.mysql.jdbc.Driver");}
		catch(Exception e) {}
		int id = Integer.parseInt(request.getParameter("id"));
		Oeuvre e = Context.getInstance().getDaoOeuvre().findById(id);
		
		//Param (envoyer depuis une page web) / Attributs (Gérer dans les controls et envoyés vers la page web)
		request.setAttribute("oeuvre", e);
		request.setAttribute("login", "Jordan");
		this.getServletContext().getRequestDispatcher("/fiche.jsp").forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
