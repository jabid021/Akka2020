package projet.back.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "categorie")
@SequenceGenerator(name = "seqCategorie", sequenceName = "seq_categorie", initialValue = 100, allocationSize = 1)
public class Categorie {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCategorie")
	@Column(name = "categorie_id")
	private Long id;
	@Column(name = "categorie_nom", length = 250, nullable = false)
	private String nom;
	@Lob
	@Column(name = "categorie_description")
	private String description;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name = "categorie_mere")
	private Categorie categorieMere;
	@OneToMany(mappedBy = "categorieMere")
	private Set<Categorie> sousCategories;
	@OneToMany(mappedBy = "categorie")
	private Set<Produit> produits;

	public Categorie() {

	}

	public Categorie(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	public Categorie(String nom, String description, Categorie categorieMere) {
		super();
		this.nom = nom;
		this.description = description;
		this.categorieMere = categorieMere;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Categorie getCategorieMere() {
		return categorieMere;
	}

	public void setCategorieMere(Categorie categorieMere) {
		this.categorieMere = categorieMere;
	}

	public Set<Categorie> getSousCategories() {
		return sousCategories;
	}

	public void setSousCategories(Set<Categorie> sousCategories) {
		this.sousCategories = sousCategories;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Categorie other = (Categorie) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
