package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.Employe;

@WebServlet("/filterEmp")
public class FilterEmp extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String filtre = request.getParameter("filterName");
		List<Employe> employes = Context.getInstance().getDaoEmploye().findAllFilter(filtre);

		for(Employe emp : employes) 
		{
			response.getWriter().println("<tr>");
			response.getWriter().println("<td>"+emp.getId()+"</td>");
			response.getWriter().println("<td>"+emp.getLogin()+"</td>");
			response.getWriter().println("<td>"+emp.getPassword()+"</td>");
			response.getWriter().println("<td>"+emp.getMail()+"</td>");
			response.getWriter().println("<td>"+emp.getPc().getId()+"-"+emp.getPc().getMarque()+"</td>");
			response.getWriter().println("<td>");
			response.getWriter().println("<input onclick=\"updateEmp("+emp.getId()+",'"+emp.getLogin()+"','"+emp.getPassword()+"','"+emp.getMail()+"',"+emp.getPc().getId()+",'"+emp.getPc().getMarque()+"')\" type=\"button\" class=\"btn btn-warning\" value=\"Modifier\">");
			response.getWriter().println("<form class=\"formDelete\" action=\"emp\" method=\"post\">");
			response.getWriter().println("<input type=\"hidden\" value=\""+emp.getId()+"\" name=\"id_emp\">");
			response.getWriter().println("<input type=\"submit\" name=\"btnForm\" class=\"btn btn-danger\" value=\"Supprimer\">");
			response.getWriter().println("</form></td></tr>");
		}
		
	}

}
