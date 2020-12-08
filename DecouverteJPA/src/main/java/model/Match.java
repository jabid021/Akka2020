package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="quidditch")
public class Match {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_match")
	private Integer id;
	
	
	@ManyToMany(mappedBy = "matchs")
	private List<Sorcier> joueurs;
	
	
	public Match() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public List<Sorcier> getJoueurs() {
		return joueurs;
	}


	public void setJoueurs(List<Sorcier> joueurs) {
		this.joueurs = joueurs;
	}
	
	
}
