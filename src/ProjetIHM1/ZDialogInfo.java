package ProjetIHM1;

public class ZDialogInfo {
	
	private String nom, equipe, tache, description;

	public ZDialogInfo(){}
	  
	public ZDialogInfo(String nom, String equipe, String tache, String description){
	    this.nom = nom;
	    this.equipe = equipe;
	    this.tache = tache;
	    this.description = description;
	}

	public String toString(){
	    String str;
	    if(this.nom != null){
	      str = "Description du Projet : \n";
	      str += "Nom : " + this.nom + "\n";
	      str += "Equipe : " + this.equipe + "\n";
	      str += "Taches : " + this.tache + "\n";
	      str += "Description : " + this.description + "\n";
	}
	else {
		str = "Aucune information !";
	}
	   return str;
	}
}

