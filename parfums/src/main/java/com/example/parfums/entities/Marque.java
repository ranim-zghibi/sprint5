package com.example.parfums.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Marque {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
    private String nom;
    private String description;
    
    @OneToMany (mappedBy = "marque")
    @JsonIgnore
    private List<Parfum> parfums;
    
	public List<Parfum> getParfums() {
		return parfums;
	}
	public void setParfums(List<Parfum> parfums) {
		this.parfums = parfums;
	}
	public Long getId() {
		return id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Marque(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

}
