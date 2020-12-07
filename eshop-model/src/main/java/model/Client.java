package model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("client")
public class Client extends Personne {
	
	//age doit etre <= 99 (2 chiffres)
	@Column(columnDefinition = "int(2)")
	private int age;
	@Column(name="birthdate",columnDefinition = "DATE")
	private LocalDate naissance;
	

	public Client() {
	}


	public Client(String nom, String prenom,int age,LocalDate naissance) {
		super(nom, prenom);
		this.age=age;
		this.naissance=naissance;	
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public LocalDate getNaissance() {
		return naissance;
	}


	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}
	
	
}
