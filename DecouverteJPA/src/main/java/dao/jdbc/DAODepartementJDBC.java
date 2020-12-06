package dao.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.IDAODepartement;
import model.Departement;

public class DAODepartementJDBC  implements IDAODepartement{
	
		@Override
		public void ajouter(Departement d) {
	
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection(lien+db, login, password );
				
				//Meme chose que "INSERT INTO dept (deptno,dname,loc) VALUES (?,?,?)"
				PreparedStatement ps=conn.prepareStatement("INSERT INTO dept VALUES (?,?,?)");
				ps.setInt(1, d.getNumero());
				ps.setString(2,d.getNom());
				ps.setString(3,d.getLieu());
				
				ps.executeUpdate();
				
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
		@Override
		public void modifier(Departement d) {
			
			try {	
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection conn=DriverManager.getConnection(lien+db, login, password );
				
				PreparedStatement ps=conn.prepareStatement("UPDATE dept set dname=?,loc=? where deptno=?");
				ps.setString(1,d.getNom());
				ps.setString(2,d.getLieu());
				ps.setInt(3, d.getNumero());
				
				ps.executeUpdate();
				
				ps.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	@Override
	public void supprimer(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );

			PreparedStatement ps=conn.prepareStatement("DELETE FROM dept where deptno=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Departement selectById(Integer id) {
		Departement d=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM dept where deptno=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) 
			{
				d=new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}

	@Override
	public List<Departement> selectAll() {
		List<Departement> departements  = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM dept");
			
			ResultSet rs = ps.executeQuery();
			
			Departement d=null;
			while(rs.next()) 
			{
				d=new Departement(rs.getInt("deptno"),rs.getString("dname"),rs.getString("loc"));
				departements.add(d);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departements;
	}

}
