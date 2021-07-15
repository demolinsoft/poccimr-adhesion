package atos.cimr.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import atos.cimr.entity.SousActivite;
import atos.cimr.repository.SousActiviteRepository;

@Service
public class SousActiviteService {

	@Autowired
	SousActiviteRepository repository;
	
	public SousActivite getSousActiviteById(long id) {  
	  return repository.findById(id).get();  
	}
	
	public SousActivite save(SousActivite activite)   
	{  
	  return repository.save(activite);  
	} 
	

	
	
}
