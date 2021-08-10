package com.banking.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@SuppressWarnings("serial")
@Entity
@Table(name="Compte")
public class Compte implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IdCompte")
	private Long idcompte;
	
	@Column(name="Solde_Actuel")
	private float soldeactuel;
	
	@Column(name="Solde_Disponible")
	private float soldedisponible;
	
	@Column(name="Devise")
	@Enumerated(EnumType.STRING)
	private Devise devise;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date_de_creation")
	private Date datedecreation;
	
	@Column(name="Type")
	@Enumerated(EnumType.STRING)
	private CompteType type;
	
	@Column(name="RIB", unique = true)
	private long rib;
	
	@Column(name="Etat")
	private String etat;
	
	/* ---------------------*/
	@OneToMany(mappedBy="compte")
	@JsonIgnore
	private List<Transaction> transactions;
	
	@OneToMany(mappedBy="compte")
	@JsonIgnore
	private List<Carte> cartes;
	
	@OneToMany(mappedBy="compte")
	@JsonIgnore
	private List<Credit> credits;
	/* ---------------------*/

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	@OneToMany(mappedBy="compte")
	@JsonIgnore
	private List<Cheque> cheques;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IdUser",referencedColumnName="IdUser")
	 private User user;
	
	public Long getIdcompte() {
		return idcompte;
	}

	public void setIdcompte(Long idcompte) {
		this.idcompte = idcompte;
	}

	public float getSoldeactuel() {
		return soldeactuel;
	}

	public void setSoldeactuel(float soldeactuel) {
		this.soldeactuel = soldeactuel;
	}

	public float getSoldedisponible() {
		return soldedisponible;
	}

	public void setSoldedisponible(float soldedisponible) {
		this.soldedisponible = soldedisponible;
	}
	
	public Date getDatedecreation() {
		return datedecreation;
	}

	public void setDatedecreation(Date datedecreation) {
		this.datedecreation = datedecreation;
	}

	public CompteType getType() {
		return type;
	}

	public void setType(CompteType type) {
		this.type = type;
	}

	public long getRib() {
		return rib;
	}

	public void setRib(long rib) {
		this.rib = rib;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public List<Credit> getCredits() {
		return credits;
	}

	public void setCredits(List<Credit> credits) {
		this.credits = credits;
	}

	public List<Cheque> getCheques() {
		return cheques;
	}

	public void setCheques(List<Cheque> cheques) {
		this.cheques = cheques;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Compte() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcompte == null) ? 0 : idcompte.hashCode());
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
		Compte other = (Compte) obj;
		if (idcompte == null) {
			if (other.idcompte != null)
				return false;
		} else if (!idcompte.equals(other.idcompte))
			return false;
		return true;
	}
	
	
}
