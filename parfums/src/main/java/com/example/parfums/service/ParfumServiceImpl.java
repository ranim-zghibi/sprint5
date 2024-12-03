package com.example.parfums.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parfums.entities.Marque;
import com.example.parfums.entities.Parfum;
import com.example.parfums.repos.ImageRepository;
import com.example.parfums.repos.ParfumRepository;

@Service
public class ParfumServiceImpl implements ParfumService {
	@Autowired
	private ParfumRepository parfumRepository;

	@Autowired
	ImageRepository imageRepository;

	@Override
	public Parfum saveParfum(Parfum p) {
		return parfumRepository.save(p);
	}

	@Override
	public Parfum updateParfum(Parfum p) {
	   // Long oldParfImageId = null;
	   /* if (this.getParfum(p.getIdParfum()).getImage() != null) {
	        oldParfImageId = this.getParfum(p.getIdParfum()).getImage().getIdImage();
	    }
	    Long newParfumImageId = p.getImage() != null ? p.getImage().getIdImage() : null;
	    */
	    Parfum parfumUpdated = parfumRepository.save(p);

	/*
	    if (oldParfImageId != null && !oldParfImageId.equals(newParfumImageId)) {
	        imageRepository.deleteById(oldParfImageId);
	    }*/
	    
	    return parfumUpdated;
	}


	@Override
	public void deleteParfum(Parfum p) {
		parfumRepository.delete(p);
	}
/*
	@Override
	public void deleteParfumById(Long id) {
		parfumRepository.deleteById(id);
	}
	*/

	@Override
	public Parfum getParfum(Long id) {
		return parfumRepository.findById(id).orElse(null);
	}

	@Override
	public List<Parfum> getAllParfums() {
		return parfumRepository.findAll();
	}

	@Override
	public List<Parfum> findByNomParfum(String nom) {

		return parfumRepository.findByNomParfum(nom);
	}

	@Override
	public List<Parfum> findByNomParfumContains(String nom) {
		return parfumRepository.findByNomParfumContains(nom);
	}

	@Override
	public List<Parfum> findByNomPrix(String nom, Double prix) {
		return parfumRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Parfum> findByMarque(Marque marque) {
		return parfumRepository.findByMarque(marque);
	}

	@Override
	public List<Parfum> findByMarqueId(Long id) {
		return parfumRepository.findByMarqueId(id);
	}

	@Override
	public List<Parfum> findByOrderByNomMarqueAsc() {
		return parfumRepository.findByOrderByNomParfumAsc();
	}

	@Override
	public List<Parfum> trierParfumsNomsPrix() {
		return parfumRepository.trierParfumsNomsPrix();
	}
	
	@Override
	public void deleteParfumById(Long id) {
	 Parfum p = getParfum(id);
	 imageRepository.deleteByParfum(p);
	 //suuprimer l'image avant de supprimer le produit
	/*try {
	Files.delete(Paths.get(System.getProperty("user.home")+"/OneDrive/images/"+p.getImagePath()));
	} catch (IOException e) {
	e.printStackTrace();
	}*/
	parfumRepository.deleteById(id);
	}
}
