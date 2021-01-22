package projet.back.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 100, allocationSize = 1)
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	@Column(name = "commande_id")
	private Long id;
	@Transient
	private Integer nbProduits;
	@Transient
	private Double prixTotal;
	@Column(name = "commande_date")
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "commande_livraion", foreignKey = @ForeignKey(name = "commande_livraison_fk"))
	private Adresse livraison;
	@ManyToOne
	@JoinColumn(name = "commande_faturation", foreignKey = @ForeignKey(name = "commande_faturation_fk"))
	private Adresse facturation;
	@OneToMany(mappedBy = "commande",fetch=FetchType.LAZY)
	private Set<LigneCommande> lignesCommandes;
	@ManyToOne
	@JoinColumn(name = "commande_client_id", foreignKey = @ForeignKey(name = "commande_client_id_fk"))
	private Client client;

	public Commande() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNbProduits() {
		return nbProduits;
	}

	public void setNbProduits(Integer nbProduits) {
		this.nbProduits = nbProduits;
	}

	public Double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(Double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Adresse getLivraison() {
		return livraison;
	}

	public void setLivraison(Adresse livraison) {
		this.livraison = livraison;
	}

	public Adresse getFacturation() {
		return facturation;
	}

	public void setFacturation(Adresse facturation) {
		this.facturation = facturation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		Commande other = (Commande) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
