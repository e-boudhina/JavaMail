/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métier;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author e-boudhina
 */
public class SessionFormOp implements ISessionForm{

    private Conn cnObject;
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;
    private int nbrow;
    
    private SessionForm sessionForm;
    private ArrayList sessionForms;
    
    public SessionFormOp(){
        
        cnObject= new Conn();
    }
    
    @Override
    public void Ajouter(SessionForm sessionForm) {
       cn =  cnObject.getConn();
       
       try {

                String AddQuery = ("insert into sessform(date_Debut,date_fin ,"
                        + "date_LimiteInscription,capacite,type,lieu,adresse,cible,"
                        + "prix,description,sujet,programme) values (?,?,?,?,?,?,?,?,?,?,?,?)");
                /* Be carefull when using setString text/varchar2 , you wasted 1hour looking for a mistake that shouldn't even be there , 
                "lieu" was 25 char but you exceeded it , so yeah mind those small details */
                //how to enter debug mode to detect where exactly is the error
                ps=cn.prepareStatement(AddQuery);
                
                ps.setDate(1, new java.sql.Date(sessionForm.getDate_Debut().getTime()));
                ps.setDate(2,  new java.sql.Date(sessionForm.getDate_Fin().getTime()));
                ps.setDate(3, new java.sql.Date(sessionForm.getDate_LimitInscription().getTime()));
                ps.setInt(4,sessionForm.getCapacite());
                ps.setString(5,sessionForm.getType());
                ps.setString(6,sessionForm.getLieu());
                
               ps.setString(7,sessionForm.getAdresse());
                ps.setString(8,sessionForm.getCible());
                ps.setFloat(9,sessionForm.getPrix());
                ps.setString(10,sessionForm.getDescription());
                ps.setString(11,sessionForm.getSujet());
                ps.setString(12,sessionForm.getProgramme());
                
                //executing the query
                ps.executeUpdate();
                //Releasing resources 
                ps.close();
                cn.close();
                System.out.println("Session is succesfuly added to DataBase .");
       }catch(Exception e)
       {
           System.err.println("Something went wrong ,make sure that all fields are not empty , please retry adding again !");
       }
       
       
    }

    
   public ArrayList Rechercher(){
            
        cn = cnObject.getConn();
        
        sessionForms = new ArrayList<SessionForm>();
        
        try {
            //next month simple query
            String x = "SELECT * FROM sessform WHERE MONTH(date_Debut) = MONTH(CURDATE())-11 ";
            ps = cn.prepareStatement(x);
            
            rs = ps.executeQuery();
            

            rs.last();
            nbrow = rs.getRow();
            
            if (nbrow != 0)
            {
                rs.beforeFirst();
            
            
            for(int i=0;i<nbrow;i++){
                    while(rs.next()){
                        
                        sessionForm = new SessionForm();
                        sessionForm.setDate_Debut(rs.getDate(2));
                        sessionForm.setDate_Fin(rs.getDate(3));
                        sessionForm.setDate_LimitInscription(rs.getDate(4));
                        sessionForm.setCapacite(rs.getInt(5));
                        sessionForm.setType(rs.getString(6));
                        sessionForm.setLieu(rs.getString(7));
                        sessionForm.setAdresse(rs.getString(8));
                        sessionForm.setCible(rs.getString(9));
                        sessionForm.setPrix(rs.getFloat(10));
                        sessionForm.setDescription(rs.getString(11));
                        sessionForm.setSujet(rs.getString(12));
                        sessionForm.setProgramme(rs.getString(13));
                        sessionForms.add(sessionForm);
                       
                   } 
                   
                }
            
                 
            }else {
                System.err.println("There is no SessonForms in your database \n");
                System.err.println(+nbrow+" Results found with that name !");
            }
            return sessionForms;
            
        }catch (Exception e){
         System.err.println("Something went wrong !");
            return null;
            
        }
        
   }
    
    
}
