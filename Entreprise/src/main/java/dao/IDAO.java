package dao;

import java.util.List;

public interface IDAO<T,K> {

	String lien="jdbc:mysql://localhost:3306/";
	String db="scott";
	String login="root";
	String password="";

	/*public void ajouter(T t);
	public void modifier(T t);
	public void supprimer(K id);
	public List<T> selectAll();*/
	public T selectById(K id);



	public T findById(K id);
	public List<T> findAll();
	public void insert(T objet);
	public void update(T objet);
	public void delete(T objet);
}
