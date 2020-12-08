package dao;

import java.util.List;

public interface IDAO<T,K> {

	public void insert(T t);
	public void update(T t);
	public void delete(K id);
	public T findById(K id);
	public List<T> findAll();
/*
	 public T findById(K id); // equivalent to selectById
	 public List<T> findAll(); //selectAll
	 public void insert(T objet); //ajouter
	 public void update(T objet); //modifier
	 public void delete(T objet); //supprimer 
	 */

}
