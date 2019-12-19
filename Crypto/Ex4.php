<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="fr">
    <title>Exercice 4 - TP3 Cryptographie </title>
    <link rel="stylesheet" type="text/css" href="CryptoStyle.css">
    <link rel="shortcut icon" href="favicon-polytech.png">
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
                  <td align="center"><a href="Fonctions.php">Fonctions</a></td>

                  <td align="center"><a href="Ex1.php">Exercice 1</a></td>

                  <td align="center"><a href="Ex2.php">Exercice 2</a></td>

                  <td align="center"><a href="Ex3.php">Exercice 3</a></td>

                  <td align="center"><a href="Ex4.php">Exercice 4</a></td>
                  
                  <td align="center"><a href="Ex5.php">Exercice 5</a></td>
                  <td>&nbsp;</td>
                  
              </tr></tbody>
          </table>  
      </nav>
    </header>


<?php include 'Cryptographie.php'; ?>
<span id="content">
    <p style="font-size: 16pt; font-weight: bold"> 
    Exercice 4 : <br>
    <p style="font-size: 12pt; font-weight= normal">
    Pour cet exercice mon programme génère un alphabet de césar pour chaque caractère de la clé (extensible à toute la table ASCII).
    Cette méthode devient plus optimisée pour les longs textes.
    </p>
    <pre>
#Exercice 4
Fonction test_cleVigenere($cle){
    Pour $i de 0 à strlen($cle){
        Si (!(65<=ord($lettre)<=90 ou 97<=ord($lettre)<=122)){ <span class="commentaire">// Si n'est pas une lettre</span>
            Retourne FALSE; <span class="commentaire">// Dés que quelque chose est retourné la fonction s'arrête.</span>
        }
    }
    Retourne TRUE;
}


$phrase = $_POST["phrase"];
$cleVigenere = $_POST["cle"];
$alphabets = array();

Si (test_cleVigenere){
    Pour $i de 0 à strlen($cleVigenere($cleVigenere)){  <span class="commentaire">// On créé un alphabet décalé pour chaque caractere de la cle</span>
        genere_alphabet(decalage = ord($cleVigenere[$i]-97)) <-- ajouter($alphabets);
    }

    Pour $j de 0 à strlen($phrase){
        $lettre = $phrase[$j];
        Si ($lettre est minuscule){  
            $alphabets[$j%(strlen($cleVigenere))][$lettre] <-- $phrase[$lettre];  
        }
        Sinon Si ($lettre est majuscule){
            $alphabets[$j%(strlen($cleVigenere))][$lettre] <-- strtoupper($phrase[$i]);
        }
    }  

    Affiche $phrase;
}
Sinon{
    Affiche 'Erreur : La clé ne doit contenir que des lettres.';
}

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
            <p>Texte à crypter : <br><textarea name="phrase4" cols="60" rows="8" maxlenght="1500"></textarea> </p>
            <p>Clé de Vigenère : <input type="text" name="cleVigenere" maxlength="100" /></p>
            <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet"></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase4 = ex_4($phrase4, $cleVigenere, $affAlpha);
        unset($affAlpha, $_POST["phrase4"], $_POST["AfficheAlphabet"]);
    }

?> </p></span></body>