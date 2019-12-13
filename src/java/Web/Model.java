/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Métier.Abonne;
import Métier.AbonneOp;
import Métier.SessionForm;
import Métier.SessionFormOp;
import java.util.ArrayList;

/**
 *
 * @author e-boudhina
 */
public class Model {
        private Abonne abonne;
        private AbonneOp abonneOp;
        
        private SessionForm sessionForm;
        private SessionFormOp sessionFormOp;
        
        private static ArrayList<SessionForm> emails;

    public Model() {
        
        abonneOp = new AbonneOp();
        sessionFormOp = new SessionFormOp();
        emails = new ArrayList<SessionForm>();
    }
        
    //Setting-up all user info 
    public void setAbonneinfo(Abonne abn){
   
        this.abonne = new Abonne(abn.getNom(),abn.getPrenom(),abn.getAdresse(),abn.getTel(),abn.getEmail());
    }       
    
    //Adding user after getting all his/her information 
    public void AjouterAbonne(){
        abonneOp.Ajouter(abonne);
    }
    
    public void setSessionForminfo(SessionForm sessfrm){
        
        this.sessionForm = new SessionForm(sessfrm.getDate_Debut(),sessfrm.getDate_Fin(),sessfrm.getDate_LimitInscription(),
                sessfrm.getCapacite(),sessfrm.getType(),sessfrm.getLieu(),sessfrm.getAdresse(),sessfrm.getCible(),
                sessfrm.getPrix(),sessfrm.getDescription(),sessfrm.getSujet(),sessfrm.getProgramme());
    }
    
    public void AjouterSessionFrom(){
        sessionFormOp.Ajouter(sessionForm);
    }
    
    //getting abonne emails
    public ArrayList<Abonne> getAllAbonnesEmails(){
        return abonneOp.Rechercher();
    }
    
    //getting sessForm information
    public String getAllSessionFormInfo(){
        emails = sessionFormOp.Rechercher();
        String AllSessionsInfo ="";
        for (int i=0;i<emails.size();i++)
        {
            
            AllSessionsInfo = AllSessionsInfo +"Session de formation \""+(i+1)+"\"\n"+emails.get(i).toString()+"\n\n";
            
           // System.out.println(formation);
            
            
        }
        return AllSessionsInfo;
    }
    
    /*
            "This class contains all Model to Database Operations that can be performed";
    */

}
