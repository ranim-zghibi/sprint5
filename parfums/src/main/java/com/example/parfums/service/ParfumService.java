package com.example.parfums.service;

import java.util.List;

import com.example.parfums.entities.Marque;
import com.example.parfums.entities.Parfum;

public interface ParfumService {
	Parfum saveParfum(Parfum p);
	Parfum updateParfum(Parfum p);
	void deleteParfum(Parfum p);
	void deleteParfumById(Long id);
	Parfum getParfum(Long id);
	List<Parfum> getAllParfums();
	
	List<Parfum> findByNomParfum(String nom);
	List<Parfum> findByNomParfumContains(String nom);
	List<Parfum> findByNomPrix (String nom, Double prix);
	List<Parfum> findByMarque (Marque categorie);
	List<Parfum> findByMarqueId(Long id);
	List<Parfum> findByOrderByNomMarqueAsc();
	List<Parfum> trierParfumsNomsPrix();

}
