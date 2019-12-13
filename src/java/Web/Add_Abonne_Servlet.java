/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Métier.Abonne;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author e-boudhina
 */
public class Add_Abonne_Servlet extends HttpServlet {

    private static Abonne abonne;
    private static Model abonneOp;
        
    public Add_Abonne_Servlet(){
            
        abonneOp = new Model();
        
    }
        
        
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        try{
            
         
         abonne = new Abonne();
         abonne.setNom(request.getParameter("nom"));
         abonne.setPrenom(request.getParameter("prenom"));
         abonne.setAdresse(request.getParameter("adresse"));
         abonne.setTel(Integer.parseInt(request.getParameter("tel")));
         abonne.setEmail(request.getParameter("email"));
         
         //Loading the object with UserData
         abonneOp.setAbonneinfo(abonne);
         
        //Adding User to DataBase After Data Colletion
         abonneOp.AjouterAbonne();
         
         //Redirecting to Main Page
         
         request.getRequestDispatcher("MainPage.jsp").forward(request, response);
        
        
        }catch(Exception e){
            
            request.setAttribute("exception", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);

        }
        
    }
        
    @Override
    public String getServletInfo() {
        return "This servlet collects the subscriber information from the JSP then parse that "
                + "to the model to be added to DataBase";
    }

}
