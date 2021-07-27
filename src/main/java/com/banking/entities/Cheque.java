package com.banking.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="Cheque")
public class Cheque implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IdCheque")
	private Long idcheque;
	
	@Column(name="Numero")
	private int numero;
	
	@Column(name="Montant")
	private float montant;
	
	@Column(name="Beneficiaire")
	private String beneficiaire;
	
	@Column(name="Lieu")
	private String lieu;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	private Date date;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IdCompte",referencedColumnName="IdCompte")
	 private Compte compte;

	public Long getIdcheque() {
		return idcheque;
	}

	public void setIdcheque(Long idcheque) {
		this.idcheque = idcheque;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Cheque() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcheque == null) ? 0 : idcheque.hashCode());
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
		Cheque other = (Cheque) obj;
		if (idcheque == null) {
			if (other.idcheque != null)
				return false;
		} else if (!idcheque.equals(other.idcheque))
			return false;
		return true;
	}
	
	
}
