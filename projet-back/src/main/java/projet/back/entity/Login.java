package projet.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "login")
@SequenceGenerator(name = "seqLogin", sequenceName = "seq_login", initialValue = 100, allocationSize = 1)
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLogin")
	@Column(name = "login_id")
	private Long id;
	@Column(name = "login", length = 150, nullable = false, unique = true)
	private String login;
	@Column(name = "password", length = 200, nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	@Version
	private int version;
	@OneToOne(mappedBy = "login")
	private Client client;

	public Login() {

	}

	public Login(String login, String password, Role role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
