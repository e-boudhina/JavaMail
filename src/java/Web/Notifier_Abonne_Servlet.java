/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Métier.Abonne;
import Métier.SessionForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author e-boudhina
 */
public class Notifier_Abonne_Servlet extends HttpServlet {

   private static Model modelOp;

   private static ArrayList<String> abonnesEmails;
   private static String SessionsFormsInfo;
   private static int Alength;
   private static int Slength;
   
   
   public Notifier_Abonne_Servlet(){
       
       abonnesEmails= new ArrayList<String>();
      // SessionsFormsInfo = new ArrayList<String>();
       modelOp = new Model();
       
       
   }
   
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try{
        
       Alength = modelOp.getAllAbonnesEmails().size();
       //Slength = modelOp.getAllSessionFormInfo().size();
       
        for(int i=0;i<Alength;i++){
           
        abonnesEmails.add(modelOp.getAllAbonnesEmails().get(i).getEmail());
        
        }
        
            
        
        
        
        
        
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
                return new PasswordAuthentication("e-mail","pwd");
               
            }
            
        });
        
        try {
            MimeMessage message = new MimeMessage(session);
            //System.err.println("ok2");
            message.setFrom(new InternetAddress("your-e-mail"));
           // System.out.println("ok3");
            
            InternetAddress[] address = new InternetAddress[Alength];
            
            for (int i = 0; i < Alength; i++) {
            address[i] = new InternetAddress(abonnesEmails.get(i));
            }
            
            message.setRecipients(Message.RecipientType.TO, address);
            //message.setRecipients(Message.RecipientType.TO, InternetAddress.toString(abonnesEmails));
            message.setSubject("Next Month Form Sessions :");
            
            message.setText(modelOp.getAllSessionFormInfo());
            //System.out.println("ok5");
            
            System.out.println("Sending ... ");
            Transport.send(message);
            //System.out.println("ok6");
            System.out.println("Email sent Succesfully !");
            
            request.getRequestDispatcher("MainPage.jsp").forward(request, response);
            
        }catch(MessagingException e){
            System.err.println("Something went wrong !");
            throw new RuntimeException(e);
        }
        
        
        
        }catch(Exception e){
            request.setAttribute("exception", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
        
        
        
        
        
        
        
                                                }

    
    @Override
    public String getServletInfo() {
        return "This servlets allows to take subscribers emails inside an arraylist and forward all sessionsForms information for the next month to all of them .";
    }// </editor-fold>

}
