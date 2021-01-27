package entreprise.model;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import entreprise.validator.Post20000101;

@Entity
@SequenceGenerator(name = "emp")
@Table(name = "emp")
public class Employe implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "empno")
	private Integer numero;
	// obligaoitre
	@NotEmpty
	@Column(name = "ename")
	private String nom;
	// obligatoire
	@NotEmpty
	@Column(name = "job")
	private String poste;

	// apres 01/01/2000
	@Post20000101
	@Column(name = "hiredate", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate embauche;
	// positif
	@Positive
	@Column(name = "sal")
	private int salaire;

	@Column(name = "comm", nullable = true)
	private Integer commission;

	@Embedded
	private Adresse adresse;

	@ManyToOne()
	@JoinColumn(name = "mgr")
	private Employe manager;

	@ManyToOne()
	@JoinColumn(name = "deptno")
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setEmbauche(LocalDate embauche) {
		this.embauche = embauche;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	public String getInfos() {
		return numero + " " + nom + " " + poste;
	}

}
