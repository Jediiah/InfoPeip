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
    Exercice 2 : <br>
    <pre>
#Exercice 2
$phrase = $_POST["phrase"];
$decalage = $_POST["decalage"];

Si ($decalage est entier){
    genere_alphabet($decalage = $decalage) <-- $alphabetDecale;
    remplace_lettres($phrase, $alphabetDecale) <-- $phrase;
    Affiche $phrase;
}
Sinon{
    Affiche "Erreur : Le décalage doit être un nombre entier.";
}
    </pre><br>

<h3>Application :</h3> 
    <?php

    if(!isset($_POST['phrase2'])) {
        ?>
        
        <form method="POST">
            <p>Texte à crypter : <br><textarea name="phrase2" cols="60" rows="8" maxlenght="1000"></textarea> </p>
            <p>Décalage : <input type="int" name="decalage" /></p>
            <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
            <p><input type="submit" value="Envoyer"></p>
        </form><br><br>
    
        <?php
        } 
        else {
            $phrase2 = $_POST["phrase2"];
            $decalage = $_POST["decalage"];
            if(isset($_POST["AfficheAlphabet"])){$affAlpha = TRUE;} else{$affAlpha = FALSE;}
            ?> 
    
            <form method="POST">
                <p>Texte à crypter : <br><textarea name="phrase2" cols="60" rows="8" maxlenght="1000"></textarea> </p>
                <p>Decalage : <input type="int" name="decalage" /></p>
                <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
                <p><input type="submit" value="Envoyer"></p>
            </form><br><br>
    
            <?php
            
            $phrase2 = ex_2($phrase2, $decalage, $affAlpha);
            unset($affAlpha, $_POST["phrase2"], $_POST["AfficheAlphabet"]);
        }

?> </p></span></body>