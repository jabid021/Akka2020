package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="departement", initialValue = 50, allocationSize = 10)
@Table(name="dept")
public class Departement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departement")
	@Column(name="deptno")
	private int numero;
	@Column(name="dname")
	private String nom;
	@Column(name="loc")
	private String lieu;
	
	@OneToMany(mappedBy = "departement")
	private List<Employe> employes  = new ArrayList<>();

	public Departement() {
	}

	public Departement(String nom, String lieu) {
		this.nom = nom;
		this.lieu = lieu;
	}
	
	public Departement(Integer id,String nom, String lieu) {
		this.numero=id;
		this.nom = nom;
		this.lieu = lieu;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}


}
