package tn.enig.model;

import org.springframework.stereotype.Component;


public class Matiere {

	
	
	public Matiere() {

	}
	private int id;
	private String titre;
	private String niveau;
	private int nbr;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public int getNbr() {
		return nbr;
	}
	public void setNbr(int nbr) {
		this.nbr = nbr;
	}
	
     

}
