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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name="Carte")
public class Carte implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IdCarte")
	private Long idcarte;
	
	@Column(name="Numero")
	private int numero;
	
	@Column(name="Date_d_expiration")	
	@Temporal(TemporalType.DATE)
	private Date datedexpiration;
	
	@NotBlank
	@Size(max = 120)
	private String password;
	
	@Column(name="Etat")
	private boolean isActive;
	
	@Column(name="Type_Carte")
	private CarteType cartetype;
	
	@Column(name="CCV2")
	private int ccv2;
	
	@Column(name="Devise")
	private Devise devise;
	
	@Column(name="Plafond")
	private float plafond;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IdCompte",referencedColumnName="IdCompte")
	 private Compte compte;


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getIdcarte() {
		return idcarte;
	}

	public void setIdcarte(Long idcarte) {
		this.idcarte = idcarte;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getDatedexpiration() {
		return datedexpiration;
	}

	public void setDatedexpiration(Date datedexpiration) {
		this.datedexpiration = datedexpiration;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public CarteType getCartetype() {
		return cartetype;
	}

	public void setCartetype(CarteType cartetype) {
		this.cartetype = cartetype;
	}

	public int getCcv2() {
		return ccv2;
	}

	public void setCcv2(int ccv2) {
		this.ccv2 = ccv2;
	}

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	public float getPlafond() {
		return plafond;
	}

	public void setPlafond(float plafond) {
		this.plafond = plafond;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Carte() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idcarte == null) ? 0 : idcarte.hashCode());
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
		Carte other = (Carte) obj;
		if (idcarte == null) {
			if (other.idcarte != null)
				return false;
		} else if (!idcarte.equals(other.idcarte))
			return false;
		return true;
	}
	
	
}
