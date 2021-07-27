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
@Table(name="Transaction")
public class Transaction implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IdTransaction")
	private Long idtransaction;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	private Date date;
	
	@Column(name="Montant")
	private float montant;
	
	@Column(name="Du_Compte")
	private long id1;
	
	@Column(name="Au_Compte")
	private long id2;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IdCompte",referencedColumnName="IdCompte")
	 private Compte compte;

	public Long getIdtransaction() {
		return idtransaction;
	}

	public void setIdtransaction(Long idtransaction) {
		this.idtransaction = idtransaction;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public long getId1() {
		return id1;
	}

	public void setId1(long id1) {
		this.id1 = id1;
	}

	public long getId2() {
		return id2;
	}

	public void setId2(long id2) {
		this.id2 = id2;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Transaction() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idtransaction == null) ? 0 : idtransaction.hashCode());
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
		Transaction other = (Transaction) obj;
		if (idtransaction == null) {
			if (other.idtransaction != null)
				return false;
		} else if (!idtransaction.equals(other.idtransaction))
			return false;
		return true;
	}
	

}
