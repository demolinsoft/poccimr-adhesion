package atos.cimr.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Adherents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String estAdherent;
	private String typeAdherent;
	private String raisonSociale;
	private String numRC;
	private String localiteRC;
	private String nif;
	private String adresse;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime dateCreation;
	private String activite;
	private String numeroTel;
	private String fax;
	
	 @ManyToOne (cascade = CascadeType.PERSIST)
	 @JoinColumn(name = "sous_activite_id")
	 private SousActivite sousActivite;
	
	 @ManyToOne (cascade = CascadeType.PERSIST) 
	 @JoinColumn(name = "gestionnaire_compte_id")
	 private GestionnaireCompte gestionnaireCompte;
	
	 @ManyToOne (cascade = CascadeType.PERSIST) 
	 @JoinColumn(name = "mandataires_id")
	 private Mandataires mandataires;
	
	
	
	
	public Adherents() {
		super();
		// TODO Auto-generated constructor stub
	}
	// setters and getters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstAdherent() {
		return estAdherent;
	}
	public void setEstAdherent(String estAdherent) {
		this.estAdherent = estAdherent;
	}
	public String getTypeAdherent() {
		return typeAdherent;
	}
	public void setTypeAdherent(String typeAdherent) {
		this.typeAdherent = typeAdherent;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public String getNumRC() {
		return numRC;
	}
	public void setNumRC(String numRC) {
		this.numRC = numRC;
	}
	public String getLocaliteRC() {
		return localiteRC;
	}
	public void setLocaliteRC(String localiteRC) {
		this.localiteRC = localiteRC;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public LocalDateTime getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}
	public String getActivite() {
		return activite;
	}
	public void setActivite(String activite) {
		this.activite = activite;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public SousActivite getSousActivite() {
		return sousActivite;
	}
	public void setSousActivite(SousActivite sousActivite) {
		this.sousActivite = sousActivite;
	}
	public GestionnaireCompte getGestionnaireCompte() {
		return gestionnaireCompte;
	}
	public void setGestionnaireCompte(GestionnaireCompte gestionnaireCompte) {
		this.gestionnaireCompte = gestionnaireCompte;
	}
	public Mandataires getMandataires() {
		return mandataires;
	}
	public void setMandataires(Mandataires mandataires) {
		this.mandataires = mandataires;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
	
	
}
