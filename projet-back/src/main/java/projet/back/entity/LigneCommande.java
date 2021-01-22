package projet.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

@Entity
@Table(name = "ligne_commande")
@SequenceGenerator(name = "seqLigneCommande", sequenceName = "seq_ligne_commande", initialValue = 100, allocationSize = 1)
public class LigneCommande {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLigneCommande")
	@Column(name = "ligne_commande_id")
	private Long id;
	@Column(name = "ligne_commande_quantite", nullable = false)
	private Integer quantite;
	@Transient
	private Double montant;
	@ManyToOne
	@JoinColumn(name = "ligne_commande_produit_id", foreignKey = @ForeignKey(name = "ligne_commande_produit_fk"))
	private Produit produit;
	@ManyToOne
	@JoinColumn(name = "ligne_commande_commande_id", foreignKey = @ForeignKey(name = "ligne_commande_commande_fk"))
	private Commande commande;
	@Version
	private int version;

	public LigneCommande() {

	}

	public LigneCommande(Produit produit, Commande commande, Integer quantite) {
		super();
		this.produit = produit;
		this.commande = commande;
		this.quantite = quantite;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
		LigneCommande other = (LigneCommande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
