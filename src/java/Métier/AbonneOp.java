/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author e-boudhina
 */
public class AbonneOp implements IAbonne {

    
    private Conn cnObject;
    private Connection cn;
    private PreparedStatement ps;
    private ResultSet rs;
    private int nbrow;
    
    private Abonne abonne;
    private ArrayList abonnes;

    public AbonneOp() {
        
        cnObject = new Conn();
        
    }

    
    
    @Override
    public void Ajouter(Abonne abonne) {
        
        cn = cnObject.getConn();
        
        try {

                String AddQuery = ("insert into abonnes(NomAbonne,PrenomAbonne,AdresseAbonne,TelAbonne,EmailAbonne) values (?,?,?,?,?)");
                ps=cn.prepareStatement(AddQuery);
                
                ps.setString(1, abonne.getNom());
                ps.setString(2,abonne.getPrenom() );
                ps.setString(3,abonne.getAdresse());
                ps.setInt(4, abonne.getTel());
                ps.setString(5, abonne.getEmail());
                //executing the query
                ps.executeUpdate();
                //Releasing resources 
                ps.close();
                cn.close();
                System.out.println("User : "+abonne.getNom() +" "+abonne.getPrenom()+" is succesfuly added to DataBase .");
            
        }catch(Exception e){
                System.err.println("Something went wrong , please retry adding again !");
        }
        
    }
    
    public ArrayList Rechercher(){
            
        cn = cnObject.getConn();
        
        abonnes = new ArrayList<Abonne>();
        
        try {
            
            String x = "select EmailAbonne from abonnes ";
            ps = cn.prepareStatement(x);
            
            rs = ps.executeQuery();
            

            rs.last();
            nbrow = rs.getRow();
            
            if (nbrow != 0)
            {
                rs.beforeFirst();
            
            
            for(int i=0;i<nbrow;i++){
                    while(rs.next()){
                        
                        abonne = new Abonne();
                        //you can add set id later 
                        //we only need emails so there is no need to retrieve the other informations
                        abonne.setEmail(rs.getString(1));
                        abonnes.add(abonne);
                       
                   } 
                   
                }
            
                 
            }else {
                System.err.println("There is no subsribers in yoru database \n");
                System.err.println(+nbrow+" Results found with that name !");
            }
            return abonnes;
            
        }catch (Exception e){
         System.err.println("Something went wrong !");
            return null;
            
        }
        
    }
    
}
