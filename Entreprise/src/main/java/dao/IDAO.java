package dao;

import java.util.List;

public interface IDAO<T,K> {

	String lien="jdbc:mysql://localhost:8889/";
	String db="scott";
	String login="root";
	String password="root";
	
	
	public void ajouter(T t);
	public void modifier(T t);
	public void supprimer(K id);
	public T selectById(K id);
	public List<T> selectAll();

}
