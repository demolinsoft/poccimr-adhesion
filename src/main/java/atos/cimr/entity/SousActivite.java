package atos.cimr.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class SousActivite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    @NotBlank
    @NotNull
    @Size(min=2, message = "libelleSousActivite doit avoir au moins deux caractères")
    @Column(name = "libelle_sous_activite" )
	private String libelleSousActivite;

	

	public SousActivite() {
	}

	
	public SousActivite(int id, String libelleSousActivite) {
		super();
		this.id = id;
		this.libelleSousActivite = libelleSousActivite;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLibelleSousActivite() {
		return libelleSousActivite;
	}

	public void setLibelleSousActivite(String libelleSousActivite) {
		this.libelleSousActivite = libelleSousActivite;
	}
	
	
	
}
