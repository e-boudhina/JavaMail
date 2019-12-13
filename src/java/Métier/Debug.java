/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Métier;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;
import javax.activation.*;

/**
 *
 * @author e-boudhina
 */
public class Debug {
    
    private static Abonne Abonne;
    private static AbonneOp AbonneOp;
    
    private static SessionForm SessionForm;
    private static SessionFormOp SessionFormOp;
    
    private static ArrayList<Abonne> testA;
    private static ArrayList<SessionForm> testS;
    
    public static void main(String[] args) throws AddressException
    {
        /* 
        //test 1
        AbonneOp = new AbonneOp();
        Abonne = new Abonne("nom","prénom","adresse", 99999999,"testemail");
        AbonneOp.Ajouter(Abonne);
      
        /*
        //test 2 
        SessionFormOp = new SessionFormOp();
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        
        Date d_deb = new Date("15/12/2019");
        Date d_fin = new Date("15/02/2020");
        Date d_limit = new Date("07/12/2019");
        SessionForm = new SessionForm(d_deb,d_fin,d_limit,30,"Informatique","PoleTechnologique,Ariana","Batiment A4 ,Centre IntilaQ","étudiant",
                (float)445.5,"Dévlopper une platforme enligne en utilisant les Framework Angular 8 et Symfony 4",
                "HealthCare Platform","Sujet...");
        SessionFormOp.Ajouter(SessionForm);
        */
        /*
        //test3
        AbonneOp = new AbonneOp();
        testA = new ArrayList<Abonne>(); 
        testA = AbonneOp.Rechercher();
        System.out.println("There is "+testA.size()+" Subscribers in your DataBase : ");
        for (int i=0;i<testA.size();i++)
        {
            System.out.println(testA.get(i).getEmail());
            
        }
        */
        
        //test4
        SessionFormOp = new SessionFormOp();
        testS = new ArrayList<SessionForm>();
        testS = SessionFormOp.Rechercher();
        System.out.println("There is "+testS.size()+" Sessions in your DataBase : ");
        String formation ="";
        for (int i=0;i<testS.size();i++)
        {
            
            formation = formation +"Session de formation \""+(i+1)+"\"\n"+testS.get(i).toString()+"\n\n";
            
           // System.out.println(formation);
            
            
        }
        System.out.println(formation);
        /*
        Properties props = new Properties();
        
            props.setProperty("mail.transport.protocol", "smtp");     
    props.setProperty("mail.host", "smtp.gmail.com");  
    props.put("mail.smtp.auth", "true");  
    props.put("mail.smtp.port", "465");  
    props.put("mail.debug", "true");  
    props.put("mail.smtp.socketFactory.port", "465");  
    props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");  
    props.put("mail.smtp.socketFactory.fallback", "false");         
        
       // System.err.println("ok");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator()  
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication()
            {
                // System.out.println("ok1");
                return new PasswordAuthentication("youremail","yourpwd");
               
            }
            
        });
        
        try {
            MimeMessage message = new MimeMessage(session);
            //System.err.println("ok2");
            message.setFrom(new InternetAddress("yourpwd"));
            System.out.println("ok3");
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("testemail"));
            message.setSubject("Next Month Form Sessions :");
            
            message.setText(formation);
            //System.out.println("ok5");
            
            
            Transport.send(message);
            //System.out.println("ok6");
            System.out.println("Email sent Succesfully !");
        }catch(MessagingException e){
            System.err.println("Something went wrong !");
            throw new RuntimeException(e);
        }

        */
    }
    
}
