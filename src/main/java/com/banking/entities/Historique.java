package com.banking.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="Historique")
public class Historique implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IdHistorique")
	private long idHistorique;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date")
	private Date date;
	
	@Column(name="Montant")
	private float montant;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Du_Compte")
	private long id1;
	
	@Column(name="Au_Compte")
	private long id2;
	

	public long getIdHistorique() {
		return idHistorique;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIdHistorique(long idHistorique) {
		this.idHistorique = idHistorique;
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

	public Historique() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (int) (id1 ^ (id1 >>> 32));
		result = prime * result + (int) (id2 ^ (id2 >>> 32));
		result = prime * result + (int) (idHistorique ^ (idHistorique >>> 32));
		result = prime * result + Float.floatToIntBits(montant);
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
		Historique other = (Historique) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id1 != other.id1)
			return false;
		if (id2 != other.id2)
			return false;
		if (idHistorique != other.idHistorique)
			return false;
		if (Float.floatToIntBits(montant) != Float.floatToIntBits(other.montant))
			return false;
		return true;
	}


	

}
