package tn.enig.model;

public class Affectation {

	
	private int id;
	private Matiere matiere;
	private Enseignant ens;
	private int nbraff;
	
	public Affectation() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Enseignant getEns() {
		return ens;
	}
	public void setEns(Enseignant ens) {
		this.ens = ens;
	}
	public int getNbraff() {
		return nbraff;
	}
	public void setNbraff(int nbraff) {
		this.nbraff = nbraff;
	}
}
