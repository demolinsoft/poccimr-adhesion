package atos.cimr.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
import atos.cimr.entity.SousActivite;
import atos.cimr.repository.SousActiviteRepository;
import atos.cimr.services.SousActiviteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@Api( description="API pour les opérations sur les sous-activités.")
@RequestMapping("/contrat-groupe")
public class SousActiviteController {
	@Autowired
     SousActiviteRepository activiteRepo;
	
	@Autowired
	SousActiviteService service;
	
	
	@ApiOperation(value = "rechercher tous les sous-activités")
	@GetMapping("/sousActivites")
	  List<SousActivite> all() { 
	    return activiteRepo.findAll();
	  }
	
	@ApiOperation(value = "creer une sous-activite")
	@PostMapping (value="/addSousactivite")
	  public ResponseEntity<SousActivite> newActivite(@Valid @RequestBody SousActivite sousactivite) {
		
		SousActivite createdSousActivite = service.save(sousactivite);
		
		
		if(createdSousActivite==null) {
			return ResponseEntity.noContent().build();
		}else {
			URI uri = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("{id}")
					.buildAndExpand(createdSousActivite.getId())
					.toUri();
	
			return ResponseEntity.created(uri)
			          .body(createdSousActivite);
			
		}
		
	  }
	
	 @GetMapping("/sousActivite/{id}")
	    public Optional<SousActivite> read(@PathVariable long id) {
	        return activiteRepo.findById(id);
	    }

	 
	 
	 
	 @PutMapping("/updateSousActivite/{id}")
	 public ResponseEntity<SousActivite> saveResource(@RequestBody SousActivite activite,
	   @PathVariable("id") long id) {
		 SousActivite ss = service.getSousActiviteById(id);
		 ss.setLibelleSousActivite(activite.getLibelleSousActivite()); 
	     SousActivite saUpdated = activiteRepo.save(ss);
	     //return ResponseEntity<SousActivite>.ok("resource saved");
	      return  ResponseEntity.ok(saUpdated);
	 }

	 @DeleteMapping(value = "/deleteSousActivite/{id}")
	    public ResponseEntity<Long> deletePost(@PathVariable Long id) {

	        Optional<SousActivite> activeDel = activiteRepo.findById(id);
	        
	        if (activeDel==null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }

	        activiteRepo.delete(activeDel.get());  
	        return new ResponseEntity<>(id, HttpStatus.OK);
	    }
	    
}
