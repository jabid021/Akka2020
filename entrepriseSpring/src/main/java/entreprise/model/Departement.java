package entreprise.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.SequenceGenerators;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name = "departement", initialValue = 50, allocationSize = 10)
@Table(name = "dept")
public class Departement implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "departement")
	@Column(name = "deptno")
	private Integer numero;

	@Column(name = "dname")
	private String nom;

	@Column(name = "Loc")
	private String lieu;

	@OneToMany(mappedBy = "departement")
	private List<Employe> employes;

	public Departement() {
	}

	public Departement(String nom, String lieu) {
		this.nom = nom;
		this.lieu = lieu;
	}

	public Departement(Integer id, String nom, String lieu) {
		this.numero = id;
		this.nom = nom;
		this.lieu = lieu;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
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
		Departement other = (Departement) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

}
