package tn.enig.dao;

import java.util.List;

import tn.enig.model.Affectation;
import tn.enig.model.Enseignant;
import tn.enig.model.Matiere;

public interface Igestion {

	
	public void addEnseignant(Enseignant e);
	public void addMatiere(Matiere m);
	public void affectMatiere(Affectation a);
	public void deleteAffectation(int id);
	public List<Matiere> getAllMatiere();
	public List<Enseignant> getAllEnseignat();
	public List<Affectation> getAllAffectation();
	
	public Enseignant getEnsByID(int id);
	public Affectation getAffByID(int id);
	public Matiere getMatByID(int id );
	
	public boolean matierExist(String title);
	public boolean ensExist(String nom,String prenom);
	public boolean canAffect(int id);
	
	
	
}
