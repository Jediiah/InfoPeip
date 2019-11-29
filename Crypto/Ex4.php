<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="fr">
    <title>TP 3 - Cryptographie</title>
    <link rel="stylesheet" type="text/css" href="CryptoStyle.css">
  </head>


<body>

    <header id="header"> 
      <a href="TetrisSite.html" title="Home"> 
        <h2>TP3 Cryptographie | LALLEMAND-BIRCK Zacharie</h2><br>
        </a> </header>
        <nav id="menu">
          <table width="100%" cellspacing="0" cellpadding="0" border="0">
              <tbody><tr>
                  
                  <td>&nbsp;</td>
                  <td align="center"><a href="Ex1.php">Exercice 1</a></td>
                  <td align="center"><a href="Ex2.php">Exercice 2</a></td>
                  <td align="center"><a href="Ex3.php">Exercice 3</a></td>
                  <td align="center"><a href="Ex4.php">Exercice 4</a></td>
                  <td align="center"><a href="bientot.php">Exercice 5</a></td>
                  <td>&nbsp;</td>
                  
              </tr></tbody>
          </table>  
      </nav>
    </header>


<?php include 'Cryptographie.php'; ?>
<span id="content">
    <p style="font-size: 16pt; font-weight: bold"> 
    Exercice 4 : <br>
    <pre>
#Exercice 4
$phrase = $_POST["phrase"];
$cleVigenere = $_POST["cle"];
$alphabets = array();

Pour $i de 0 à strlen($cleVigenere){    // On créé un alphabet décaler pour chaque caractere de la cle
    genere_alphabet(decalage = ord($cleVigenere[$i]-97)) <-- ajouter($alphabets);
}

Pour $j de 0 à strlen($phrase){
    $lettre = $phrase[$j];
    Si (65<=ord($lettre)<=90 ou 97<=ord($lettre)<=122){  
        $alphabets[$j%(strlen($cleVigenere))][$lettre] <-- $phrase[$lettre];  
      }
      Sinon Si ($lettre est majuscule){
        $alphabets[$j%(strlen($cleVigenere))][$lettre] <-- strtoupper($phrase[$i]);
      }
    }  
  }
}

Affiche $phrase;
    </pre><br>

<h3>Application :</h3> 
    <?php

if(!isset($_POST['phrase4'])) {
    ?>
    
    <form method="POST">
    <p>Texte à crypter : <br><textarea name="phrase4" cols="60" rows="8" maxlenght="1000"></textarea> </p>
        <p>Clé de Vigenère : <input type="text" name="cleVigenere" maxlength="10" /></p>
        <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet"></p>
        <p><input type="submit" value="Envoyer"></p>
    </form>

    <?php
    } 
    else {
        $phrase4 = $_POST["phrase4"];
        $cleVigenere = $_POST["cleVigenere"];
        if(isset($_POST["AfficheAlphabet"])){$affAlpha = TRUE;} else{$affAlpha = FALSE;}
        ?> 
        <form method="POST">
            <p>Texte à crypter : <br><textarea name="phrase4" cols="60" rows="8" maxlenght="1000"></textarea> </p>
            <p>Clé de Vigenère : <input type="text" name="cleVigenere" maxlength="10" /></p>
            <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet"></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase4 = ex_4($phrase4, $cleVigenere, $affAlpha);
        unset($affAlpha, $_POST["phrase4"], $_POST["AfficheAlphabet"]);
    }

?> </p></span></body>