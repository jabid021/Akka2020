package test;

import dao.DaoPersonne;
import dao.DaoPersonneFactory;
import entity.Personne;
import util.Context;

public class AppTest {
	public static void main(String[] args) {

		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();

		daoPersonne.insert(new Personne("olivier", "gozlan"));

		Context.destroy();
	}
}
