# JavaMailWebApp

# ==> ** Voilà ce que résout ce projet ** <==

Imaginez  que  vous  travaillez  dans  un  centre  de  formation  et  de  certification voulant envoyer  périodiquement  des affiches  concernant  des  sessions  de  formation  à  ses abonnés.<br/>

Pour ceci elle dispose d’une base de données contenant entre autre : <br/>

* Une table Abonnes dans laquelle sont enregistrés des informations sur les abonnés (les apprenants).<br/>
* Une  table SessFormdans  laquelle  sont  enregistrés  des  informations  concernant  les sessions de formation. Les schémas de ces tables sont les suivants : <br/>

Abonnes   (idAbonne,   NomAbonne,   PrenomAbonne,   AdresseAbonne,   TelAbonne, EmailAbonne) <br/>
SessForm(idSess, date_Debut, date_Fin, date_LimiteInscription, capacite, type, lieu, adresse, cible, prix, description, sujet, programme) <br/>

On vous demande de réaliser une application java permettant au responsable du centrede :<br/>

* Envoyer par emails des newsletters aux différents abonnés contenant les informations relatives aux sessions de formationsplanifiées pour le mois prochain.<br/>
* Visualiser les emails qu’il a reçus dans sa boite email. Pour réaliser ce projet on vous demande de créer une base de données contenant les deux tables sus indiquées, de remplir ces tables avec quelques lignes pour tester l’application. <br/>

Les bibliothèques utilisées sont :
 
 * mysql-connector-java-5.1.48-bin.jar
 * mail.jar
 * activation.jar
 * JDK 1.8
 * Apache Tomcat or TomEE

