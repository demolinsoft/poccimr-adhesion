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

import atos.cimr.entity.Mandataires;
import atos.cimr.repository.MandataireRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contrat-groupe")
@Api( description="API pour les opérations sur les mandataires.")
public class MandataireController {

	@Autowired
    MandataireRepository  mandataireRepo;
	
	@ApiOperation(value = "rechercher tous les  mandataires")
	@GetMapping("/mandataires")
	  List<Mandataires> all() { 
	    return mandataireRepo.findAll();
	  }
	
	@ApiOperation(value = "creer un mandataire ")
	@PostMapping (value="/addMandataire")
	  public ResponseEntity<Mandataires> newActivite(@Valid @RequestBody Mandataires mandataires) {
		
		Mandataires mandataire = mandataireRepo.save(mandataires);
		
		if(mandataires==null) {
			return ResponseEntity.noContent().build();
		}else {
			URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("{id}")
					.buildAndExpand(mandataire.getId())
					.toUri();
	
			return ResponseEntity.created(uri)
			          .body(mandataire);
			
		}
		
	  }
	
	 @GetMapping("/mandataire/{id}")
	    public Optional<Mandataires> readMandataire(@PathVariable int id) {
	        return mandataireRepo.findById(id);
	    }

	 
		
	 @PutMapping("/updateMandataire/{id}")
	 public ResponseEntity<Mandataires> savemandataire(@RequestBody Mandataires mandataire,
	   @PathVariable("id") int id) {
		 Optional<Mandataires> mandataireUpdate = mandataireRepo.findById(id); 
		 
		 mandataireUpdate.get().setCin(mandataire.getCin());  
		 mandataireUpdate.get().setEmail(mandataire.getEmail());  
		 mandataireUpdate.get().setFonction(mandataire.getFonction());  
		 mandataireUpdate.get().setNationalite(mandataire.getNationalite());  
		 mandataireUpdate.get().setNom(mandataire.getNom());
		 mandataireUpdate.get().setPrenom(mandataire.getPrenom());		 
		 mandataireUpdate.get().setNumeroMobilegsm(mandataire.getNumeroMobilegsm()); 
		 mandataireUpdate.get().setNumeroTelFixe(mandataire.getNumeroTelFixe()); 
		 
		 
		   
		   Mandataires mandUpdated = mandataireRepo.save(mandataireUpdate.get());
	      return  ResponseEntity.ok(mandUpdated);
	 }

	 @DeleteMapping(value = "/deleteMandataire/{id}")
	    public ResponseEntity<Integer> deleteGCompte(@PathVariable int id) {

	        Optional<Mandataires> mandataireDel = mandataireRepo.findById(id);
	        
	        if (mandataireDel==null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        mandataireRepo.delete(mandataireDel.get());  
	        return new ResponseEntity<>(id, HttpStatus.OK);
	    }
	    

}
