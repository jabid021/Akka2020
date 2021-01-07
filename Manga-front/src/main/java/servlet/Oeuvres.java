package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.Oeuvre;

@WebServlet("/oeuvres")
public class Oeuvres extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Oeuvre> oeuvres = Context.getInstance().getDaoOeuvre().findAll();
		//List<Oeuvre> oeuvres = new ArrayList();
		request.setAttribute("oeuvres", oeuvres);
		this.getServletContext().getRequestDispatcher("/WEB-INF/listOeuvres.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
