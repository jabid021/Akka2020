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
import model.PC;

@WebServlet("/emp")
public class ServletEmploye extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		if(id !=null) 
		{
			Employe e = Context.getInstance().getDaoEmploye().findById(Integer.parseInt(id));
			request.setAttribute("emp", e);
			this.getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(request, response);
		}
		else 
		{
			List<Employe> employes = Context.getInstance().getDaoEmploye().findAll();



			request.setAttribute("employes", employes);

			this.getServletContext().getRequestDispatcher("/pc").forward(request, response);
		}





	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tache = request.getParameter("btnForm");
		if(tache.equals("Ajouter")) 
		{
			Integer idPC = Integer.parseInt(request.getParameter("id_pc"));
			String login = request.getParameter("login");
			String password =request.getParameter("password");
			String mail = request.getParameter("mail");

			PC pc = Context.getInstance().getDaoPC().findById(idPC);
			Employe e = new Employe(login, password, mail, pc);
			Context.getInstance().getDaoEmploye().save(e);

		}
		else if(tache.equals("Modifier")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id_emp"));
			Integer idPC = Integer.parseInt(request.getParameter("id_pc"));
			String login = request.getParameter("login");
			String password =request.getParameter("password");
			String mail = request.getParameter("mail");

			PC pc = Context.getInstance().getDaoPC().findById(idPC);
			Employe e = new Employe(id,login, password, mail, pc);

			Context.getInstance().getDaoEmploye().save(e);
			
			System.out.println(request.getSession().getAttribute("compte"));
			
			if(request.getSession().getAttribute("compte") instanceof Employe) 
			{
				request.setAttribute("emp", e);
				this.getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(request, response);
			}
		}
		else if(tache.equals("Supprimer")) 
		{
			doDelete(request,response);

		}

		doGet(request,response);


	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id = Integer.parseInt(request.getParameter("id_emp"));
		Employe e = Context.getInstance().getDaoEmploye().findById(id);
		Context.getInstance().getDaoEmploye().delete(e);
	}
}
