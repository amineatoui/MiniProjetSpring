package tn.enig.model;

import org.springframework.stereotype.Component;

public class Enseignant {

	
	
	
	public Enseignant() {
	
		
	}
	private int id;
	private String nom;
	private String prenom;
	private float chargeH;
	public float getChargeH() {
		return chargeH;
	}
	public void setChargeH(float chargeH) {
		this.chargeH = chargeH;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
