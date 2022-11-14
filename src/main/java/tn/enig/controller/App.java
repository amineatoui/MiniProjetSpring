package tn.enig.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpServerErrorException;

import tn.enig.dao.Igestion;
import tn.enig.model.Affectation;
import tn.enig.model.Enseignant;
import tn.enig.model.Matiere;

@Controller

public class App {

@Autowired 
Igestion dao;

public void setDao(Igestion dao) {
	this.dao=dao;
}
	
	
	@RequestMapping(value="/listMatiere" ,method=RequestMethod.GET)
	
	
	public String listMatieres(Model m,@RequestParam(required = false,name="success") String success) {
		
		List<Matiere> l=dao.getAllMatiere();
	    m.addAttribute("listM", l);
	    if(success!=null) {
	    	m.addAttribute("success",success);
	    	
	    }
	   return "listMat";
		
	}
	
@RequestMapping(value="/enseignants" ,method=RequestMethod.GET)
	
	public String listEnseignant(Model m, @RequestParam(required = false,name="success") String success) {
     List<Enseignant> l=dao.getAllEnseignat();
     m.addAttribute("listEns",l);
     m.addAttribute("test", true);		
     
     if(success!=null) {
          m.addAttribute("success",success);
     }
	   return "listEnsPage";
		
	}

@RequestMapping(value="/addEns" ,method=RequestMethod.POST)

public String addEnseignat(Model m,HttpServletRequest req) {
     Enseignant e=new Enseignant();
     e.setNom(req.getParameter("nom"));
     e.setPrenom(req.getParameter("prenom"));
     e.setChargeH(Float.parseFloat(req.getParameter("charge")));
     
     if(!dao.ensExist(e.getNom(), e.getPrenom())) {
    	  dao.addEnseignant(e);
    	  m.addAttribute("success", true);
     }
     else {
    	 m.addAttribute("success", false);
     }
	
   return "redirect:/enseignants";
	
}

@RequestMapping(value="/affectations" ,method=RequestMethod.GET)

public String listAffectation(Model m,@RequestParam(required = false,name="success") String success,
		   @RequestParam(required=false,name="error") String error) {
	       
	   List<Affectation> l=dao.getAllAffectation();
	   m.addAttribute("listAff",l);
	   m.addAttribute("listEns",dao.getAllEnseignat());
	   m.addAttribute("listMat",dao.getAllMatiere());
	   
	   if(success!=null) {
		   m.addAttribute("success",success);
	   }
	   
	   if(error!=null) {
		   m.addAttribute("error", error);
	   }
   return "listAffPage";
	
}

@RequestMapping(value="/addAff" ,method=RequestMethod.POST)

public String addAff(Model m,HttpServletRequest req) {
	       
    Affectation a=new Affectation();
    Enseignant ens=dao.getEnsByID(Integer.parseInt(req.getParameter("enseignant")));
    Matiere mat =dao.getMatByID(Integer.parseInt(req.getParameter("matiere")));
    a.setEns(ens);
    a.setMatiere(mat);
    a.setNbraff(Integer.parseInt(req.getParameter("nbr")));
    
 if (!dao.canAffect(ens.getId())) {
	  
	 if(a.getNbraff() <= ens.getChargeH() && a.getNbraff() <= mat.getNbr()) {
		 dao.affectMatiere(a);
		 m.addAttribute("success",true);
	 }
	 else {
		 
		 m.addAttribute("success", false);
		 m.addAttribute("error", ens.getNom()+"charge horaire invalid");
	 }
} else {
	m.addAttribute("success", false);
	m.addAttribute("error", ens.getNom()+" est deja affecte a une autre matiere");
}
    
    
	
	return "redirect:/affectations";
	
}





@RequestMapping(value="/addMatiere",method=RequestMethod.POST)
public String addM(Model m,HttpServletRequest req) {
	    Matiere mat=new Matiere();
	    mat.setNiveau(req.getParameter("niveau"));
	    mat.setTitre(req.getParameter("titre"));
	    mat.setNbr(Integer.parseInt( req.getParameter("nbr")));
	    
	    if(dao.matierExist(mat.getTitre())) {
           m.addAttribute("success", false);	    	
	    }
	    else {
	    	dao.addMatiere(mat);
	    	m.addAttribute("success", true);
	    	
	    }
	   
	    return "redirect:/listMatiere";
   }

@RequestMapping(value="/deleteAff/{id}",method=RequestMethod.GET)

public String f(Model m,@PathVariable("id") int id) {
	  dao.deleteAffectation(id);
	return "redirect:/affectations";
}

}
