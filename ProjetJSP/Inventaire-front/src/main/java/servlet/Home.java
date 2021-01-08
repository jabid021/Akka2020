package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.Admin;
import model.Compte;
import model.Employe;

@WebServlet("/home")
public class Home extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login=request.getParameter("login");
		String password = request.getParameter("password");
		Compte c = Context.getInstance().getDaoCompte().connect(login, password);
		
		request.getSession().setAttribute("compte", c);
		
		
		if(c instanceof Admin) 
		{
			response.sendRedirect("emp");
		}
		else if(c instanceof Employe) 
		{
			response.sendRedirect("emp?id="+c.getId());
		}
		else 
		{
			request.setAttribute("error", "Identifiants invalides");
			doGet(request,response);
		}
	}

}
