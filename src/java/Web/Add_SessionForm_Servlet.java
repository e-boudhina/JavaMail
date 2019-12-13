/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Métier.SessionForm;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author e-boudhina
 */
public class Add_SessionForm_Servlet extends HttpServlet {

    
    private SessionForm sessionForm;
    private Model sessionFormOp;
    
    public Add_SessionForm_Servlet(){
        
        sessionFormOp = new Model();
        
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            sessionForm = new SessionForm();
          //  System.err.println("ok1");
            sessionForm.setDate_Debut(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("d_deb")));
          //  System.err.println("ok2");
            sessionForm.setDate_Fin(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("d_fin")));
         //   System.err.println("ok3");
            sessionForm.setDate_LimitInscription(new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("d_limit")));
         //   System.err.println("ok4");
            sessionForm.setCapacite(Integer.parseInt(request.getParameter("cp")));
          //  System.err.println("ok5");
            sessionForm.setType(request.getParameter("type"));
          //  System.err.println("ok6");
            sessionForm.setLieu(request.getParameter("lieu"));
           // System.err.println("ok7");
            sessionForm.setAdresse(request.getParameter("adresse"));
           // System.err.println("ok8");
            sessionForm.setCible(request.getParameter("cible"));
           // System.err.println("o9");
            sessionForm.setPrix(Float.parseFloat(request.getParameter("prix")));
           // System.err.println("ok10");
            sessionForm.setDescription(request.getParameter("desc"));
           // System.err.println("ok11");
            sessionForm.setSujet(request.getParameter("sujet"));
           // System.err.println("ok12");
            sessionForm.setProgramme(request.getParameter("prog"));
           // System.err.println("ok13");
            
            //Filling the object with Session Data
            sessionFormOp.setSessionForminfo(sessionForm);
           // System.err.println("ok14");
            //Adding Session to Database After Data Colletion
            sessionFormOp.AjouterSessionFrom();
           // System.err.println("ok15");
            //redirecting to MainPage
            request.getRequestDispatcher("MainPage.jsp").forward(request, response);
            
        }catch(Exception e){
             request.setAttribute("exception", e);
            request.getRequestDispatcher("error.jsp").forward(request, response);
            
        }
    }

   
    @Override
    public String getServletInfo() {
        return "This servlet takes SessionData from the view and then persist it to the DataBase";
    }// </editor-fold>

}
