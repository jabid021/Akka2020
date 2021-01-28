package projet.back.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", initialValue = 100, allocationSize = 1)
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "client_id")
	private Long id;
	@NotEmpty
	@Column(name = "client_prenom", length = 200, nullable = false)
	private String prenom;
	@NotEmpty
	@Column(name = "client_nom", length = 200, nullable = false)
	private String nom;
	@Enumerated(EnumType.STRING)
	@Column(name = "client_civilite")
	private Civilte civilte;
	@Column(name = "client_email", length = 200, unique = true)
	@Email
	private String email;
	@OneToOne
	@JoinColumn(name = "client_login_id", foreignKey = @ForeignKey(name = "client_login_fk"))
	private Login login;
	@OneToMany(mappedBy = "client")
	private Set<Adresse> adresses;
	@OneToMany(mappedBy = "client")
	private Set<Commande> commandes;
	@Version
	private int version;

	public Client() {

	}

	public Client(String prenom, String nom, Civilte civilte, String email) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.civilte = civilte;
		this.email = email;
	}

	public Client(String prenom, String nom, Civilte civilte, String email, Login login) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.civilte = civilte;
		this.email = email;
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Civilte getCivilte() {
		return civilte;
	}

	public void setCivilte(Civilte civilte) {
		this.civilte = civilte;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Set<Adresse> getAdresses() {
		return adresses;
	}

	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
