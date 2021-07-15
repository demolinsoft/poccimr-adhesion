package atos.cimr.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mandataires {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String cin;
	private String nationalite;
	private String fonction;
	private String email;
	private String numeroMobilegsm;
	private String numeroTelFixe;
	private String dateDebutValidite;
	private String dateFinValidite;
	
	
	
	
	
	
	public Mandataires() {
	}
	//setters and getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNationalite() {
		return nationalite;
	}
	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getNumeroMobilegsm() {
		return numeroMobilegsm;
	}
	public void setNumeroMobilegsm(String numeroMobilegsm) {
		this.numeroMobilegsm = numeroMobilegsm;
	}
	public String getNumeroTelFixe() {
		return numeroTelFixe;
	}
	public void setNumeroTelFixe(String numeroTelFixe) {
		this.numeroTelFixe = numeroTelFixe;
	}
	public String getDateDebutValidite() {
		return dateDebutValidite;
	}
	public void setDateDebutValidite(String dateDebutValidite) {
		this.dateDebutValidite = dateDebutValidite;
	}
	public String getDateFinValidite() {
		return dateFinValidite;
	}
	public void setDateFinValidite(String dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}
	
	
	
	
	
}
