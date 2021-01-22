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
import javax.persistence.Version;

@Entity
@Table(name = "adresse")
@SequenceGenerator(name = "seqAdresse", sequenceName = "seq_adresse", initialValue = 100, allocationSize = 1)
public class Adresse {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAdresse")
	@Column(name = "adresse_id")
	private Long id;
	@Column(name = "rue", length = 255, nullable = false)
	private String rue;
	@Column(name = "code_postal", length = 20, nullable = false)
	private String codePostal;
	@Column(name = "ville", length = 200, nullable = false)
	private String ville;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name = "adresse_client_id", foreignKey = @ForeignKey(name = "adresse_client_fk"))
	private Client client;

	public Adresse() {

	}

	public Adresse(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
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
		Adresse other = (Adresse) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
