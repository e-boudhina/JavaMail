<%-- 
    Document   : Mainpage
    Created on : Nov 28, 2019, 9:16:07 PM
    Author     : e-boudhina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Menu</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css"  crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"  crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"  crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"  crossorigin="anonymous"></script>
        
    </head>
    <body>
        
        <h1 style="text-align: center;">Ajouter un abonné ou une session de formation | Notifier</h1>
        
        <form action="Add_Abonne_Servlet" method="POST">
            <div class="form-group">
            <b>Ajouter un abonné : </b>
            <br><br>
            <input type="text" maxlength="15" placeholder="Nom" name="nom" required/>
            <br>
            <input type="text" maxlength="15" placeholder="Prénom" name="prenom" required/>
            <br>
            <input type="text" maxlength="20" placeholder="Adresse" name="adresse" required/>
            <br>
            <input type="tel" maxlength="8" placeholder="Téléphone" name="tel" required/>
            <br>
            <input type="email" maxlength="20" placeholder="E-mail" name="email" required/>
            <br>
            </div>
            <button   style="width: 205px;"type="submit" class="btn btn-outline-dark">Ajouter</button>
        </form>
        <br>
        <br>
        
        <form action="Add_SessionForm_Servlet" method="POST">
            <b>Ajouter une session de formation : </b>
            <div class="form-group">
            
            <br><br>
            <input type="date" placeholder="Date Debut" name="d_deb" required/>
           <br>
            <input type="date" placeholder="Date Fin" name="d_fin" required/>
           <br>
            <input type="date" placeholder="Data Limte d'inscription" name="d_limit" required/>
            <br>
            <input type="number" maxlength="3" placeholder="Capacité" name="cp" required/>
            <br>
            <input type="text" maxlength="20" placeholder="Type de formation" name="type" required/>
            <br>
            <input type="text" maxlength="50" placeholder="Lieu" name="lieu" required/>
            <br>
            <input type="text" maxlength="50" placeholder="Adresse" name="adresse" required/>
            <br>
            <input type="text" placeholder="Cible" name="cible" required/>
            <br>
            <input type="number" maxlength="8" placeholder="Prix DT" name="prix" required/>
            <br>
            <input type="text"  placeholder="Description" name="desc" required/>
            <br>
            <input type="text"  placeholder="Sujet" name="sujet" required/>
            <br>
            <input type="text"  placeholder="Programme" name="prog" required/>
            </div>
            
            <button  style="width: 205px;" type="submit" class="btn btn-outline-dark">Ajouter</button>
        </form>
        <br><br>
        
        <form action="Notifier_Abonne_Servlet" method="POST">
            <b style="text-align: center;">Notifier Tous les Abonnés : </b>
            <br><br>
            <button  style="width: 205px;" type="submit" class="btn btn-dark">Notifier</button>
        </form>
    </body>
    
 <footer style="margin-top: 20px;position: relative;"class="footer bg-dark fixed-bottom">

  <!-- Copyright -->
  <div class="footer-copyright text-white text-center py-3">© 2019 Copyright - All Rights Reserved &reg;
  </div>
  <!-- Copyright -->

</footer>
</html>
