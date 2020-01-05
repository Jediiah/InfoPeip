<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="fr">
    <title>arrivé_skieur - TP4 Fichiers</title>
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
    arrivé_skieur : <br>

    <h4>Une liste chaînée me parrait être une structure de données optimale pour le classement car on peux 
    insérer ou supprimer un élément facilement et 'appeler' un élément selon le critère voulu (temps ou dossard).</h4>

    <pre>
Fonction ajout_skieur($dossard, $temps, $listeDepart, $classement){
  <span class='commentaire'>/*
  Fonction qui gère l'arrivée d'un skieur et qui l'ajoute au classement 
        en fonction de son temps.
  */
  </span>
  $temps <- $listeDepart[$dossard]->temps;
  $listeDepart[$dossard] <- $skieur;

  $classement->pSuiv <- $pEncours;
  Si $pEncours == NULL {
    new Element <- $arriveSkieur;
    $skieur <- $arriveSkieur->valeur;
    ajout_debut($arriveSkieur, $classement);
  }
  else{
    Tant Que $pEncours != NULL {
      Si compare_temps($pEncours->valeur->temps, $skieur->temps) {
        ajout_avant($skieur, $pEncours->valeur, $classement);
        NULL <- $pEncours;
      }
      Sinon Si $pEncours->pSuiv == NULL {
        new Element <- $arriveSkieur;
        $skieur <- $arriveSkieur->valeur;
        ajout_apres($arriveSkieur, $pEncours);
        NULL <- $pEncours;
      }
      Sinon {
        $pEncours->pSuiv <- $pEncours;
      }
    }
  }
}
    </pre><br>

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