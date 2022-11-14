package tn.enig.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.tagext.TryCatchFinally;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;



import tn.enig.model.Affectation;
import tn.enig.model.Enseignant;
import tn.enig.model.Matiere;

@Repository
public class Gestionimp implements Igestion{
    @Autowired @Qualifier(value="dataSource")
    DataSource data;
    
    public void setData(DataSource data) {
    	this.data=data;
    }
    
	
	public void addEnseignant(Enseignant e) {
		 try {
			 String query="insert into enseignant values(?,?,?,?)";
			 Connection conn=data.getConnection();
			 PreparedStatement ps=conn.prepareStatement(query);
			 ps.setInt(1, e.getId());
			 ps.setString(2, e.getNom());
			 ps.setString(3, e.getPrenom());
			 ps.setFloat(4, e.getChargeH());
			 ps.execute();
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		
	}

	public void addMatiere(Matiere m) {
		try {
			 String query="insert into matiere values(?,?,?,?)";
			 Connection conn=data.getConnection();
			 PreparedStatement ps=conn.prepareStatement(query);
			 ps.setInt(1, m.getId());
			 ps.setString(2, m.getTitre());
			 ps.setString(3, m.getNiveau());
			 ps.setInt(4, m.getNbr());
			 ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}

	public void affectMatiere(Affectation a) {
		 try {
			 String query="insert into affectation values(?,?,?,?)";
			 Connection conn=data.getConnection();
			 PreparedStatement ps=conn.prepareStatement(query);
			 ps.setInt(1, a.getId());
			 ps.setInt(2, a.getEns().getId());
			 ps.setInt(3, a.getMatiere().getId());
			 ps.setInt(4, a.getNbraff());
			 ps.execute();
		} catch (Exception e) {
           e.printStackTrace();
		}
		
	}

	public void deleteAffectation(int id) {
		  try {
			
			  String query="delete from affectation where id=?";
				 Connection conn=data.getConnection();
				 PreparedStatement ps=conn.prepareStatement(query);
				 ps.setInt(1, id);
				 ps.execute();
		} catch (Exception e) {
         e.printStackTrace();
		}
		
	}

	public List<Matiere> getAllMatiere() {
		List<Matiere> l=new ArrayList<Matiere>();
		   try {
				String query="select * from matiere";
				Connection con=data.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
	            ResultSet res=ps.executeQuery(); 
	            while(res.next()) {
	            	Matiere m=new Matiere();
	            	m.setId(res.getInt("id"));
	            	m.setNbr(res.getInt("nbr"));
	            	m.setNiveau(res.getString("niveau"));
	            	m.setTitre(res.getString("titre"));
	            	l.add(m);
	            }
		} catch (Exception e) {
           e.printStackTrace();
           return null;
		}
		return l;
	}

	public List<Enseignant> getAllEnseignat() {
		List<Enseignant> l=new ArrayList<Enseignant>();
		try {
			String query="select * from enseignant";
			Connection con=data.getConnection();
			PreparedStatement ps=con.prepareStatement(query);

			ResultSet res=ps.executeQuery();
			
			while(res.next()) {
				 Enseignant e=new Enseignant();
				 e.setId(res.getInt("id"));
				 e.setNom(res.getString("nom"));
				 e.setChargeH(res.getFloat("chargeh"));
				 e.setPrenom(res.getString("prenom"));
				 l.add(e);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			return null;
		}
return l;		
	}

	public List<Affectation> getAllAffectation() {
         List<Affectation> l=new ArrayList<Affectation>();  
		try {
			
			String query="select * from affectation";
			Connection con=data.getConnection();
			PreparedStatement ps=con.prepareStatement(query);

			ResultSet res=ps.executeQuery();
			while(res.next()) {
            	Affectation a=new Affectation();
            	a.setId(res.getInt("id"));
            	a.setEns(getEnsByID(res.getInt("ide")));
            	a.setMatiere(getMatByID(res.getInt("idm")));
            	a.setNbraff(res.getInt("nbr"));
            	l.add(a);
				
			}
		} catch (Exception e) {
               e.printStackTrace();
               return null;
		}
		return l;
	}


	public Enseignant getEnsByID(int id) {
        try {
			
    		String query="select * from enseignant where id=?";
			Connection con=data.getConnection();
			PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, id);
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				Enseignant e=new Enseignant();   
				 e.setId(res.getInt("id"));
				 e.setNom(res.getString("nom"));
				 e.setChargeH(res.getFloat("chargeh"));
				 e.setPrenom(res.getString("prenom"));
				 return e;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return null;
	}


	public Affectation getAffByID(int id) {
		  try {
				String query="select * from affectation where id=?";
				Connection con=data.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
	            ps.setInt(1, id);
	            ResultSet res=ps.executeQuery();
	            if(res.next()) {
	            	Affectation a=new Affectation();
	            	a.setId(id);
	            	a.setEns(getEnsByID(res.getInt("ide")));
	            	a.setMatiere(getMatByID(res.getInt("idm")));
	            	a.setNbraff(res.getInt("nbraff"));
	            	return a;
	            }
	            
		} catch (Exception e) {
            e.printStackTrace();
            return null;
		}
		return null;
	}


	public Matiere getMatByID(int id) {
		   try {
				String query="select * from matiere where id=?";
				Connection con=data.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
	            ps.setInt(1, id);
	            ResultSet res=ps.executeQuery(); 
	            if(res.next()) {
	            	Matiere m=new Matiere();
	            	m.setId(id);
	            	m.setNbr(res.getInt("nbr"));
	            	m.setNiveau(res.getString("niveau"));
	            	m.setTitre(res.getString("titre"));
	            	return m;
	            }
		} catch (Exception e) {
            e.printStackTrace();
            return null;
		}
		return null;
	}


	public boolean matierExist(String title) {
		   try {
				String query="select * from matiere where titre=?";
				Connection con=data.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
	            ps.setString(1, title);
	            ResultSet res=ps.executeQuery(); 
	            if(res.next()) {

	            	return true;
	            }
		} catch (Exception e) {
           e.printStackTrace();
           return false;
		}		 
		return false;
	}


	public boolean ensExist(String nom, String prenom) {
		  try {
				
	    		String query="select * from enseignant where nom=? and prenom=?";
				Connection con=data.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
	            ps.setString(1, nom);
	            ps.setString(2, prenom);
				ResultSet res=ps.executeQuery();
				if(res.next()) {
					 return true;
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		return false;
		
	}


	public boolean canAffect(int id) {
 
		 try {
				String query="select * from enseignant e , affectation a   where e.id=a.ide and e.id=?";
				Connection con=data.getConnection();
				PreparedStatement ps=con.prepareStatement(query);
	            ps.setInt(1, id);
				ResultSet res=ps.executeQuery();

				if(res.next()) {
				         return true;
					
				}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		return false;
	}


	

}
