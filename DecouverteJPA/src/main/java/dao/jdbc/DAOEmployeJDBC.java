package dao.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Context;
import dao.IDAOEmploye;
import model.Departement;
import model.Employe;

public class DAOEmployeJDBC implements IDAOEmploye{

	@Override
	public void ajouter(Employe e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("INSERT INTO emp VALUES (?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, e.getNumero());
			ps.setString(2, e.getNom());
			ps.setString(3, e.getPoste());
			if(e.getManager()!=null) {ps.setObject(4, e.getManager().getNumero());}
			else{ps.setObject(4, null);}
			
			ps.setString(5, e.getEmbauche().toString());
			ps.setInt(6, e.getSalaire());
			
			ps.setObject(7,e.getCommission());
			
			
			if(e.getDepartement()!=null) {ps.setObject(8, e.getDepartement().getNumero());}
			else{ps.setObject(8, null);}
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}

	@Override
	public void modifier(Employe e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("UPDATE emp set ename=?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? where empno=?");
			
			
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPoste());
			if(e.getManager()!=null) {ps.setObject(3, e.getManager().getNumero());}
			else{ps.setObject(3, null);}
			
			ps.setString(4, e.getEmbauche().toString());
			ps.setInt(5, e.getSalaire());
			
			ps.setObject(6,e.getCommission());
			
			
			if(e.getDepartement()!=null) {ps.setObject(7, e.getDepartement().getNumero());}
			else{ps.setObject(7, null);}
			
			ps.setInt(8, e.getNumero());
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}

	@Override
	public void supprimer(Integer id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("DELETE FROM emp where empno=?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Employe selectById(Integer id) {
		Employe emp=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM emp e left join  dept on e.deptno=dept.deptno  left join emp m on e.mgr=m.empno where e.empno=?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) 
			{
				Departement d=null;
				Employe manager=null;
				if(rs.getString("dname")!=null) { d=new Departement(rs.getInt("dept.deptno"),rs.getString("dname"),rs.getString("loc"));}
				if(rs.getString("m.ename")!=null) {manager=new Employe(rs.getInt("m.empno"),rs.getString("m.ename"),rs.getString("m.job"),rs.getString("m.hiredate"),rs.getInt("m.sal"),(Integer) rs.getObject("m.comm"),null);}
				emp=new Employe(rs.getInt("e.empno"),rs.getString("e.ename"),rs.getString("e.job"),rs.getString("e.hiredate"),rs.getInt("e.sal"),(Integer) rs.getObject("e.comm"),d);
				emp.setManager(manager);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employe> selectAll() {
		List<Employe> employes  = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM emp");
			
			ResultSet rs = ps.executeQuery();
			
			Employe emp=null;
			while(rs.next()) 
			{
				Departement d = Context.getInstance().getDaoDepartement().selectById(rs.getInt("deptno"));
				Employe manager = Context.getInstance().getDaoEmploye().selectById(rs.getInt("mgr"));
				emp=new Employe(rs.getInt("empno"),rs.getString("ename"),rs.getString("job"),rs.getString("hiredate"),rs.getInt("sal"),(Integer) rs.getObject("comm"),d);
				emp.setManager(manager);
				employes.add(emp);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employes;
	}

	@Override
	public List<Employe> SelectByPoste(String poste) {
		List<Employe> employes  = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection conn=DriverManager.getConnection(lien+db, login, password );
			
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM emp e left join  dept on e.deptno=dept.deptno left join emp m on e.mgr=m.empno where job=?");
			ps.setString(1, poste);
			
			ResultSet rs = ps.executeQuery();
			
			Employe emp=null;
			while(rs.next()) 
			{
				Employe manager=null;
				Departement d = new Departement(rs.getInt("dept.deptno"),rs.getString("dname"),rs.getString("loc"));
				if(rs.getString("m.ename")!=null) {manager=new Employe(rs.getInt("m.empno"),rs.getString("m.ename"),rs.getString("m.job"),rs.getString("m.hiredate"),rs.getInt("m.sal"),(Integer) rs.getObject("m.comm"),null);}

				
				emp=new Employe(rs.getInt("e.empno"),rs.getString("e.ename"),rs.getString("e.job"),rs.getString("e.hiredate"),rs.getInt("e.sal"),(Integer) rs.getObject("e.comm"),d);
				emp.setManager(manager);
	
				employes.add(emp);
			}
			
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employes;
	}

}
