package projet.back.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "produit")
@SequenceGenerator(name = "seqProduit", sequenceName = "seq_produit", initialValue = 100, allocationSize = 1)
public class Produit {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduit")
	@Column(name = "produit_id")
	private Long id;
	@NotEmpty
	@Column(name = "produit_nom", length = 250, nullable = false)
	private String nom;
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	@Column(name = "produit_description")
	private String description;
	@Column(name = "produit_prix")
	private Double prix;
	@Column(name = "produit_stock")
	private Integer stock;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name = "produit_categorie_id", foreignKey = @ForeignKey(name = "produit_categorie_fk"))
	private Categorie categorie;
	@OneToMany(mappedBy = "produit")
	private Set<LigneCommande> lignesCommandes;

	public Produit() {

	}

	public Produit(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = 0d;
		this.stock = 0;
	}

	public Produit(String nom) {
		super();
		this.nom = nom;
		this.prix = 0d;
		this.stock = 0;
	}

	public Produit(String nom, String description, Double prix) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.stock = 0;
	}

	public Produit(String nom, String description, Double prix, Integer stock) {
		super();
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.stock = stock;
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

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Set<LigneCommande> getLignesCommandes() {
		return lignesCommandes;
	}

	public void setLignesCommandes(Set<LigneCommande> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
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
		Produit other = (Produit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
