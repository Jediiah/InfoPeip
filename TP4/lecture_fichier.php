<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="fr">
    <title>lecture_fichier - TP4 Fichiers</title>
    <link rel="stylesheet" type="text/css" href="CryptoStyle.css">
    <link rel="shortcut icon" href="favicon-polytech.png">
  </head>


<body>

    <header id="header"> 
      <a href="TetrisSite.html" title="Home"> 
        <h2>TP4 Fichiers | LALLEMAND-BIRCK Zacharie</h2><br>
        </a> </header>
        <nav id="menu">
          <table width="100%" cellspacing="0" cellpadding="0" border="0">
              <tbody><tr>
                  
                  <td>&nbsp;</td>
                  <td align="center"><a href="Fonctions.php">Fonctions</a></td>

                  <td align="center"><a href="compare_temps.php">compare_temps</a></td>
                  
                  <td align="center"><a href="lecture_fichier.php">lecture_fichier</a></td>
                  
                  <td align="center"><a href="arrive_skieur.php">arrivé_skieur</a></td>
                  
                  <td align="center"><a href="Ex4.php">Exercice 4</a></td>
                   
                  <td align="center"><a href="Ex5.php">Exercice 5</a></td>
                  <td>&nbsp;</td>
                  
              </tr></tbody>
          </table>  
      </nav>
    </header>




<span id="content">
    <p style="font-size: 16pt; font-weight: bold">
    lecture_fichier : <br>

    <h4>Le format du fichier texte doit être :</h4>
    <pre>
    [SKIEUR]
    numero_dossard
    NOM
    Prénom
    [/SKIEUR]

    [SKIEUR]
    . 
    . 
    . 
    [/SKIEUR]</pre><br>

<?php
include('TP4.php');

if(!isset($_POST['fichierSkieurs'])) {
  ?>
  
  <form method="POST">
      <p>Liste des Skieurs au départ : <br><input type="file" name="fichierSkieurs" accept=".txt"></p>
      <p><input type="submit" value="Envoyer"></p>
  </form><br><br>

  <?php
  } 
  else {
      $fichier = $_POST["fichierSkieurs"];
      
      ?>
      <form method="POST">
          <p>Liste des Skieurs au départ : <br><input type="file" name="fichierSkieurs" accept=".txt"></p>
          <p><input type="submit" value="Envoyer"></p>
      </form><br><br>
      <?php

    echo ':<br><pre>'; print_r(parcours_depart($fichier)); echo '</pre>';
  }

?>
</p></span></body>