/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métier;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author e-boudhina
 */
public class Conn{ 
        
    private Connection conn ;

    public Connection getConn() {
        return conn;
    }
    
    //note if you do not put the connection inside try and catch you must use => throws SQLException <= or else it woudln't work 
     public Conn() {
         
  //public static void main(String[] args)
    try {
        //Class.forName loads mysql Driver with out it the connection to MySQL woudln't work 
        Class.forName("com.mysql.jdbc.Driver"); 
        this.conn =   DriverManager.getConnection("jdbc:mysql://localhost:3306/javamail?zeroDateTimeBehavior=convertToNull","root","pwd");
    
        System.out.println("Successfull Connection To Your DataBase : \n");
        System.out.println("Current database is : \"JavaMail\" Containing 2 tabels as follows : \n => 'Abonne' \n => 'SessForm' .\n");
    
    
         }catch(Exception e)
         {
             System.err.println(e);    
             
         }
    
                }
     
     
                            }