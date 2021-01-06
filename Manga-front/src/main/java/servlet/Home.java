package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class Home extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		
		if(login.equalsIgnoreCase("Jordan") && password.equals("ajc"))
		{
			this.getServletContext().getRequestDispatcher("listOeuvre.jsp").forward(request, response);
		}
		else 
		{
			request.setAttribute("error", "Identifians invalides");
			doGet(request,response);
		}
	}
	
	
	

}
