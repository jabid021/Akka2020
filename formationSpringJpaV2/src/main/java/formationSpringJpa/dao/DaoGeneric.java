package formationSpringJpa.dao;

import java.util.List;

public interface DaoGeneric<T, K> {
	T findByKey(K key);

	List<T> findAll();

	void insert(T obj);

	T update(T obj);

	void delete(T obj);

	void deleteByKey(K key);
}
