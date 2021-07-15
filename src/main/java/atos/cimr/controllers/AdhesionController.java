package atos.cimr.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import atos.cimr.entity.Adherents;
import atos.cimr.entity.GestionnaireCompte;
import atos.cimr.entity.Mandataires;
import atos.cimr.entity.SousActivite;
import atos.cimr.repository.AdherentsRepository;
import atos.cimr.repository.GestionnaireCompteRepository;
import atos.cimr.repository.MandataireRepository;
import atos.cimr.repository.SousActiviteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api( description="API pour les opérations sur l'adhésion.")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/contrat-groupe")
public class AdhesionController {

	@Autowired
	AdherentsRepository adhRepository;
	
	@Autowired
	SousActiviteRepository activiteRepository;
	
	@Autowired
	MandataireRepository mandataireRepository;
	
	@Autowired
	GestionnaireCompteRepository gestionnaireCompteRepository;
	
	

	@ApiOperation(value = "rechercher tous les adherents")
	@GetMapping("/adherents")
	  List<Adherents> all() { 
	    return adhRepository.findAll();
	  }
	
	
	@ApiOperation(value = "creer un adherent")
	@PostMapping("/addAdherent") 
	public ResponseEntity<Adherents>  newAdherents(@RequestBody Adherents adherent) {
		
	
	  if (adherent!=null) {
		  
		  //sous-activite
		  Optional<SousActivite> sousActivite = activiteRepository.findById(adherent.getSousActivite().getId());
		  adherent.setSousActivite(sousActivite.get());
		  
		  //gestionnaire-compte
		  Optional<GestionnaireCompte> gestionnaire = gestionnaireCompteRepository.findById(adherent.getGestionnaireCompte().getId());
		  adherent.setGestionnaireCompte(gestionnaire.get());
		  
		  //mandataires
		  Optional<Mandataires> mandataire = mandataireRepository.findById(adherent.getMandataires().getId());
		  adherent.setMandataires(mandataire.get());
		  
		  //save adherents
		  Adherents adh = adhRepository.save(adherent);		
		  
		  URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("{id}")
					.buildAndExpand(adh.getId())
					.toUri();
	
			return ResponseEntity.created(uri)
			          .body(adh);
		  
	  }else {
		  return ResponseEntity.noContent().build();
	  }
	  
		
	}
	 @ApiOperation(value = "rechercher un adherent")
	 @GetMapping("/adherent/{id}")
	    public Optional<Adherents> searchAdherent(@PathVariable int id) {
	        return adhRepository.findById(id);
	    }
	
	 @ApiOperation(value = "modifier un adherent")
	 @PutMapping("/updateAdherent/{id}")
	 public ResponseEntity<Adherents> updateAdherent(@RequestBody Adherents adherents,
	   @PathVariable("id") int id) {
		 Optional<Adherents> adherentUpdate = adhRepository.findById(id); 
		 
		 adherentUpdate.get().setEstAdherent(adherents.getEstAdherent());
		 adherentUpdate.get().setTypeAdherent(adherents.getTypeAdherent());
		 adherentUpdate.get().setRaisonSociale(adherents.getRaisonSociale());
		 adherentUpdate.get().setNumRC(adherents.getNumRC());
		 adherentUpdate.get().setLocaliteRC(adherents.getLocaliteRC());
		 adherentUpdate.get().setNif(adherents.getNif());
		 adherentUpdate.get().setAdresse(adherents.getAdresse());
		 adherentUpdate.get().setDateCreation(adherents.getDateCreation());
		 adherentUpdate.get().setActivite(adherents.getAdresse());
		 adherentUpdate.get().setNumeroTel(adherents.getNumeroTel());
		 adherentUpdate.get().setEstAdherent(adherents.getEstAdherent());
		 adherentUpdate.get().setFax(adherents.getFax());
		 
		//sous-activite
		  Optional<SousActivite> sousActiviteToUpdate = activiteRepository.findById(adherents.getSousActivite().getId());
		  adherentUpdate.get().setSousActivite(sousActiviteToUpdate.get());
		  
		//gestionnaire-compte
		  Optional<GestionnaireCompte> gestionnaireToUpdate = gestionnaireCompteRepository.findById(adherents.getGestionnaireCompte().getId());
		  adherentUpdate.get().setGestionnaireCompte(gestionnaireToUpdate.get());
		  
		  //mandataires
		  Optional<Mandataires> mandataireToUpdate = mandataireRepository.findById(adherents.getMandataires().getId());
		  adherentUpdate.get().setMandataires(mandataireToUpdate.get());
		  
		  
		   Adherents adherentUpdated = adhRepository.save(adherentUpdate.get());
	      return  ResponseEntity.ok(adherentUpdated);
	 }


	 @ApiOperation(value = "supprimer un adherent")
	 @DeleteMapping(value = "/deleteAdherent/{id}")
	    public ResponseEntity<Integer> deleteAdherent(@PathVariable int id) {

	        Optional<Adherents> adherentDel = adhRepository.findById(id);
	        
	        if (adherentDel==null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        adhRepository.delete(adherentDel.get());  
	        return new ResponseEntity<>(id, HttpStatus.OK);
	    }
	    
	
}

