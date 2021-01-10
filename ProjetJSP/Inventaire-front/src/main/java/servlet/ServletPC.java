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
		String tache = request.getParameter("btnForm");
		if(tache.equals("Ajouter")) 
		{
			Marque marque = Marque.valueOf(request.getParameter("marque"));
			int ram =Integer.parseInt(request.getParameter("ram"));
			
			PC pc = new PC(marque, ram);
			Context.getInstance().getDaoPC().save(pc);

		}
		else if(tache.equals("Modifier")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id_pc"));
			Marque marque = Marque.valueOf(request.getParameter("marque"));
			int ram =Integer.parseInt(request.getParameter("ram"));
			
			PC pc = Context.getInstance().getDaoPC().findById(id);
			pc.setMarque(marque);
			pc.setRAM(ram);
			Context.getInstance().getDaoPC().save(pc);
					
		}
		else if(tache.equals("Supprimer")) 
		{
			doDelete(request,response);

		}
		response.sendRedirect("emp");
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id = Integer.parseInt(request.getParameter("id_pc"));
		PC pc = Context.getInstance().getDaoPC().findById(id);
		Context.getInstance().getDaoPC().delete(pc);
	}

}
