package atos.cimr.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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

import atos.cimr.entity.GestionnaireCompte;
import atos.cimr.repository.GestionnaireCompteRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/contrat-groupe")
@CrossOrigin(origins = "*", maxAge = 3600)
@Api( description="API pour les opérations sur les gestionnaires de comptes.")
public class GestionnaireCompteController {

	@Autowired
    GestionnaireCompteRepository gestcompteRepo;

	@ApiOperation(value = "rechercher tous les gestionnaire de compte")
	@GetMapping("/gestionnairecomptes")
	  List<GestionnaireCompte> all() { 
	    return gestcompteRepo.findAll();
	  }
	
	@ApiOperation(value = "creer un gestionnaire de compte")
	@PostMapping (value="/addGestionnaireCompte")
	  public ResponseEntity<GestionnaireCompte> newActivite(@Valid @RequestBody GestionnaireCompte gestcompte) {
		
		GestionnaireCompte gcompte = gestcompteRepo.save(gestcompte);
		
		
		if(gcompte==null) {
			return ResponseEntity.noContent().build();
		}else {
			URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("{id}")
					.buildAndExpand(gcompte.getId())
					.toUri();
	
			return ResponseEntity.created(uri)
			          .body(gcompte);
			
		}
		
	  }
	 @ApiOperation(value = "rechercher un gestionnaire de compte")
	 @GetMapping("/gestionnairecompte/{id}")
	    public Optional<GestionnaireCompte> readcpte(@PathVariable int id) {
	        return gestcompteRepo.findById(id);
	    }

	 
		
	 @ApiOperation(value = "modifier un gestionnaire de compte")
	 @PutMapping("/updateGestionnaireCompte/{id}")
	 public ResponseEntity<GestionnaireCompte> saveGesCompte(@RequestBody GestionnaireCompte gcompte,
	   @PathVariable("id") int id) {
		 Optional<GestionnaireCompte> gestCompteUpdate = gestcompteRepo.findById(id); 
		 
		 gestCompteUpdate.get().setCin(gcompte.getCin());  
		 gestCompteUpdate.get().setEmail(gcompte.getEmail());  
		 gestCompteUpdate.get().setFonction(gcompte.getFonction());  
		 gestCompteUpdate.get().setNationalite(gcompte.getNationalite());  
		 gestCompteUpdate.get().setNom(gcompte.getNom());
		 gestCompteUpdate.get().setPrenom(gcompte.getPrenom());		 
		 gestCompteUpdate.get().setNumeroMobilegsm(gcompte.getNumeroMobilegsm()); 
		 gestCompteUpdate.get().setNumeroTelFixe(gcompte.getNumeroTelFixe()); 
		 
		 
		   
		   GestionnaireCompte gcUpdated = gestcompteRepo.save(gestCompteUpdate.get());
	      return  ResponseEntity.ok(gcUpdated);
	 }

	 @ApiOperation(value = "supprimer un gestionnaire de compte")
	 @DeleteMapping(value = "/deleteGestionnaireCompte/{id}")
	    public ResponseEntity<Integer> deleteGCompte(@PathVariable int id) {

	        Optional<GestionnaireCompte> gestionaireDel = gestcompteRepo.findById(id);
	        
	        if (gestionaireDel==null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        gestcompteRepo.delete(gestionaireDel.get());  
	        return new ResponseEntity<>(id, HttpStatus.OK);
	    }
	    
}
