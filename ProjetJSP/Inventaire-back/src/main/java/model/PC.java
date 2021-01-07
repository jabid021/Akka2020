package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class PC {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;
	@Enumerated(EnumType.STRING)
	private Marque marque;
	private int RAM;
	
	@OneToOne(mappedBy="pc")
	private Employe employe;
	@Version
	private int version;
	
	public PC() {
	}
	
	public PC(Marque marque, int RAM) {
		this.marque = marque;
		this.RAM = RAM;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int rAM) {
		RAM = rAM;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "PC [id=" + id + ", marque=" + marque + ", RAM=" + RAM + ", employe=" + employe + ", version=" + version
				+ "]";
	}
	

	
	
}
