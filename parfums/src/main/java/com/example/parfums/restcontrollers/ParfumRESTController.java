package com.example.parfums.restcontrollers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.parfums.entities.Parfum;

import com.example.parfums.service.ParfumService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ParfumRESTController {
	@Autowired
	ParfumService parfumService;
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	List<Parfum> getAllParfums(){
		return parfumService.getAllParfums();
				
	}
	
	@RequestMapping(value="/getbyid/{id}",method = RequestMethod.GET)
	public Parfum getParfumById(@PathVariable("id") Long id) {
	return parfumService.getParfum(id);
	 }
	
	@RequestMapping(value="/addparfum" ,method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('ADMIN')")
	public Parfum createParfum(@RequestBody Parfum parfum) {
	return parfumService.saveParfum(parfum);
	}
	
	@RequestMapping(value="/updateparfum" ,method = RequestMethod.PUT)
	public Parfum updateParfum(@RequestBody Parfum parfum) {
	return parfumService.updateParfum(parfum);
	}
	
	@RequestMapping(value="/delparfum/{id}",method = RequestMethod.DELETE)
	public void deleteParfum(@PathVariable("id") Long id)
	{
	parfumService.deleteParfumById(id);
	}
	
	@RequestMapping(value="/parfumsmarque/{idmarq}",method = RequestMethod.GET)
	public List<Parfum> getParfumsById(@PathVariable("idmarq") Long id) {
	return parfumService.findByMarqueId(id);
	}
	

	@RequestMapping(value="/parfumsByName/{nom}",method = RequestMethod.GET)
	public List<Parfum> findByNomParfumContains(@PathVariable("nom") String nom) {
	return parfumService.findByNomParfumContains(nom);
	}
}
