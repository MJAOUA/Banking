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
@Table(name="Reclamation")
public class Reclamation implements Serializable {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@Column(name="IdReclamation")
	private Long idreclamation;

	@Column(name="Description")
	private String description;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "IdUser",referencedColumnName="IdUser")
	 private User user;
	
	public Long getIdreclamation() {
		return idreclamation;
	}

	public void setIdreclamation(Long idreclamation) {
		this.idreclamation = idreclamation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Reclamation() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idreclamation == null) ? 0 : idreclamation.hashCode());
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
		Reclamation other = (Reclamation) obj;
		if (idreclamation == null) {
			if (other.idreclamation != null)
				return false;
		} else if (!idreclamation.equals(other.idreclamation))
			return false;
		return true;
	}
	
	
	
}
