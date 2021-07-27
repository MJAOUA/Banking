package com.banking.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="Credit")
public class Credit implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IdCredit")
	private Long idcredit;
	
	@Column(name="Type")
	private CreditType type;

	@Column(name="Duree")
	private float duree;

	@Column(name="Periodicite_echeance")
	private String periodiciteecheance;
	
	@Column(name="Type_Amortissement")
	private int typeamortissement;
	
	@Column(name="Montant")
	private float montant;
	
	@Column(name="Taux")
	private float rate;
	
	@Column(name="MontantEcheance")
	private float montantecheance;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IdCompte",referencedColumnName="IdCompte")
	 private Compte compte;

	public Long getIdcredit() {
		return idcredit;
	}

	public void setIdcredit(Long idcredit) {
		this.idcredit = idcredit;
	}

	public CreditType getType() {
		return type;
	}

	public void setType(CreditType type) {
		this.type = type;
	}

	public float getDuree() {
		return duree;
	}

	public void setDuree(float duree) {
		this.duree = duree;
	}

	public String getPeriodiciteecheance() {
		return periodiciteecheance;
	}

	public void setPeriodiciteecheance(String periodiciteecheance) {
		this.periodiciteecheance = periodiciteecheance;
	}

	public int getTypeamortissement() {
		return typeamortissement;
	}

	public void setTypeamortissement(int typeamortissement) {
		this.typeamortissement = typeamortissement;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getMontantecheance() {
		return montantecheance;
	}

	public void setMontantecheance(float montantecheance) {
		this.montantecheance = montantecheance;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Credit() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcredit == null) ? 0 : idcredit.hashCode());
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
		Credit other = (Credit) obj;
		if (idcredit == null) {
			if (other.idcredit != null)
				return false;
		} else if (!idcredit.equals(other.idcredit))
			return false;
		return true;
	}
	
}