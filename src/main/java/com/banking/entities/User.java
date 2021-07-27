package com.banking.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(	name = "User", 
		uniqueConstraints = { 
			@UniqueConstraint(columnNames = "username"),
			@UniqueConstraint(columnNames = "email") 
		})
public class User {
	@Id
	@Column(name="IdUser")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Size(max = 20)
	private String username;

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@NotBlank
	@Size(max = 120)
	private String password;
	
	@Column(name="Nom")
	private String nom;
	
	@Column(name="Prenom")
	private String prenom;
	
	@Column(name="Prenom_Pere")
	private String prenompere;
	
	@Column(name="Prenom_Grand_Pere")
	private String prenomgrandpere;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Date_de_Naissance")
	private Date datenaissance;
	
	@Column(name="Adresse")
	private String adresse;
	
	@Column(name="ZIP")
	private int zip;
	
	@Column(name="Profession")
	private String profession;
	
	@Column(name="Etat_Civile")
	private EtatCivil etatcivile;
	
	@Column(name="Residence")
	private Residence residence;
	
	@Column(name="Telephone")
	private int telephone;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Compte> comptes;
	
	@OneToMany(mappedBy="user")
	@JsonIgnore
	private List<Reclamation> reclamations;

	public List<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(List<Compte> comptes) {
		this.comptes = comptes;
	}

	public List<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(List<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public User() {
	}

	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPrenompere() {
		return prenompere;
	}

	public void setPrenompere(String prenompere) {
		this.prenompere = prenompere;
	}

	public String getPrenomgrandpere() {
		return prenomgrandpere;
	}

	public void setPrenomgrandpere(String prenomgrandpere) {
		this.prenomgrandpere = prenomgrandpere;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public EtatCivil getEtatcivile() {
		return etatcivile;
	}

	public void setEtatcivile(EtatCivil etatcivile) {
		this.etatcivile = etatcivile;
	}

	public Residence getResidence() {
		return residence;
	}

	public void setResidence(Residence residence) {
		this.residence = residence;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 50) @Email String email,
			@NotBlank @Size(max = 120) String password, String nom, String prenom, String prenompere,
			String prenomgrandpere, Date datenaissance, String adresse, int zip, String profession,
			com.banking.entities.EtatCivil etatcivile, com.banking.entities.Residence residence, int telephone) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.prenompere = prenompere;
		this.prenomgrandpere = prenomgrandpere;
		this.datenaissance = datenaissance;
		this.adresse = adresse;
		this.zip = zip;
		this.profession = profession;
		this.etatcivile = etatcivile;
		this.residence = residence;
		this.telephone = telephone;
	}
	
	
	
}
