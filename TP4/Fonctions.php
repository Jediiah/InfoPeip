<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="fr">
    <title>Fonctions - TP4 Fichiers</title>
    <link rel="shortcut icon" href="favicon-polytech.png">
    <link rel="stylesheet" type="text/css" href="CryptoStyle.css">
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
    Fonctions : <br>
    <p style="font-size: 12pt; font-weight= normal">
      Voici toutes les fonctions de base que j'ai utilisées dans ce TP.
    </p>
    <pre>
 
Fonction strlong($str){
  <span class='commentaire'>// Idem strlen</span>
  0 <- $taille;
  Tant Que (isset($texte[$taille])){$taille++;}
  return($taille)
}


Fonction arraylong($array){
  <span class='commentaire'>// Idem count()</span>
  0 <- $taille;
  Tant Que (isset($array[$taille])){$taille++;}
  return($taille);
}


Fonction sobstr($string, $depart, $longueur){
  <span class='commentaire'>//Idem substr()</span>
  "" <- $sousChaine;
  Pour $i de 0 à $longueur{
    Si isset($string[$i+$depart]){
      $sousChaine + $string[$i+$depart] <- $sousChaine;
    }
  }
  retunrn $sousChaine;
}


Fonction explose($separateur, $chaine){
  <span class='commentaire'>// Idem explode()</span>
  array() <- $listeMots;
  "" <- $mot;
  0 <- $i;

  Tant Que isset($chaine[$i]){
    sobstr($chaine, $i, strlong($separateur)) <- $sousChaineTest;
    Si $sousChaineTest!=$separateur {
      $mot + $chiane[$i] <- $chaine[$i];
      Si isset($chaine[$i+1]==FALSE){
        $mot <- $motEchange;
        $motEchange <- $listeMots[arraylong($listeMots)];
        "" <- $mot;
      }
    }
    Sinon Si $sousChaineTest==$separateur {
      $mot <- $motEchange;
      $motEchange <- $listeMots[arraylong($listeMots)];
      "" <- $mot;
    }
    $i++;
  }
  return $listeMots;
}


Fonction tablo_map($fonction, $tablo){
  <span class='commentaire'>// Idem array_map()</span>
  array() <- $tabloRetour;
  Pour Chaque $element dans $tablo {
    call_user_func($fonction, $element) <- $tabloRetour[arraylong($tabloRetour)];
  }
  return $tabloRetour;
}



<span class='commentaire'>// Fonctions sur les listes chaînées </span>

Classe Element{
  $valeur;
  NULL <- pSuiv;
}


Fonction cree_liste(){
  new Element() <- $pTete;
  'T' <- $pTete->valeur;
  return $pTete;
}


Fonction recherch_liste($valeur, $pTete){
  $pTete->pSuiv <- $pEncours;
  Tant Que $pEncours != NULL{
    Si $pEncours->valeur == $valeur{
      return $pEncours;
    }
    $pEncours->pSuiv <- $pEncours;
  }
  return NULL;
}


Fonction ajout_debut($pNouv, $pTete){
  $pTete->pSuiv <- $pNouv->pSuiv;
  $pNouv <- $pTete->pSuiv;
}


Fonction ajout_apres($pNouv, $pPrec){
  $pPrec->pSuiv <- $pNouv->pSuiv;
  $pNouv <- $pPrec->pSuiv;
}


Fonction ajout_avant($valeur, $valAvant, $pTete){
  new Element <- $pNouv;
  $valeur <- $pNouv->valeur;
  recherche_liste($valCherche, $pTete) <- $pPrec;

  Si $pPrec == NULL {
    ajout_debut($pNouv, $pTete);
  }
  Sinon{
    ajout_apres($pNouv, $pPrec);
  }
}


</pre> 
</p></span></body>