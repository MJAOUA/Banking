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
@Table(name="Pack")
public class Pack implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IdPack")
	private Long idpack;
	
	@Column(name="Nom")
	private String nom;
	
	@Column(name="Description")
	private String description;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IdCompte",referencedColumnName="IdCompte")
	 private Compte compte;

	public Long getIdpack() {
		return idpack;
	}

	public void setIdpack(Long idpack) {
		this.idpack = idpack;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
		
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Pack() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idpack == null) ? 0 : idpack.hashCode());
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
		Pack other = (Pack) obj;
		if (idpack == null) {
			if (other.idpack != null)
				return false;
		} else if (!idpack.equals(other.idpack))
			return false;
		return true;
	}
	
	
	
}
