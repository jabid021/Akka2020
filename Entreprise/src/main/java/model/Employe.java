package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@SequenceGenerator(name="emp")
@Table(name="emp")
public class Employe implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="empno")
	private int numero;
	
	@Column(name="ename")
	private String nom;
	
	@Column(name="job")
	private String poste;
	
	@Column(name="hiredate", columnDefinition = "DATE")
	private LocalDate embauche;
	
	@Column(name="sal")
	private int salaire;
	
	@Column(name="comm", nullable = true)
	private Integer commission;
	
	
	
	@Embedded
	private Adresse adresse;
	
	
	@ManyToOne()
	@JoinColumn(name="mgr")
	private Employe manager;
	
	@ManyToOne()
	@JoinColumn(name="deptno")
	private Departement departement;
	
	@ManyToMany()
	private List<Projet> missions = new ArrayList<>();
	
	@OneToOne
	private Ordinateur ordinateur;


	public Employe() {
	}


	public Employe(int numero, String nom, String poste, String embauche, int salaire, Integer commission,
			Departement departement) {
		this.numero = numero;
		this.nom = nom;
		this.poste = poste;
		this.embauche = LocalDate.parse(embauche);
		this.salaire = salaire;
		this.commission = commission;
		this.departement = departement;
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


	public String getPoste() {
		return poste;
	}


	public void setPoste(String poste) {
		this.poste = poste;
	}


	public Employe getManager() {
		return manager;
	}


	public void setManager(Employe manager) {
		this.manager = manager;
	}


	public LocalDate getEmbauche() {
		return embauche;
	}


	public void setEmbauche(String embauche) {
		this.embauche = LocalDate.parse(embauche);
	}


	public int getSalaire() {
		return salaire;
	}


	public void setSalaire(int salaire) {
		this.salaire = salaire;
	}


	public Integer getCommission() {
		return commission;
	}


	public void setCommission(Integer commission) {
		this.commission = commission;
	}


	public Departement getDepartement() {
		return departement;
	}


	public void setDepartement(Departement departement) {
		this.departement = departement;
	}


	public List<Projet> getMissions() {
		return missions;
	}


	public void setMissions(List<Projet> missions) {
		this.missions = missions;
	}


	public Ordinateur getOrdinateur() {
		return ordinateur;
	}


	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}



	


}
