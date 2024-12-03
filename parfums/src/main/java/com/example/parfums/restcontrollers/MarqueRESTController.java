package com.example.parfums.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.parfums.entities.Marque;
import com.example.parfums.repos.MarqueRepository;

@RestController
@RequestMapping("/api/marques")
@CrossOrigin ("*")
public class MarqueRESTController {
	
	@Autowired
	MarqueRepository marqueRepository;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Marque> getAllCategories()
	{
	return marqueRepository.findAll();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Marque getMarqueById(@PathVariable("id") Long id) {
	return marqueRepository.findById(id).get();
	}
	
	
}
