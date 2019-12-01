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
    Exercice 3 : <br>
    <pre>
#Exercice 3
$phrase = $_POST["phrase"];
$nvoAlphabet = $_POST["alphabet"];

Si (strlen($nvoAlphabet)==26 and pas_de_répétition($nvoAlphabet)){
    genere_alphabet($nvo_alphabet = $nvoAlphabet) <-- $alphabetCrypte;
    remplace_lettres($phrase, $alphabetCrypte) <-- $phrase;
    Affiche $phrase;
}
Sinon{
    Affiche "Erreur : L'alphabet doit être constitué de 26 lettres différentes.";
}
    </pre><br>

<h3>Application :</h3> 
    <?php

if(!isset($_POST['phrase3'])) {
    ?>
    
    <form method="POST">
        <p>Texte à crypter : <br><textarea name="phrase3" cols="60" rows="8" maxlenght="1000"></textarea> </p>
        <p>Nouvel alphabet : <input type="text" name="cle" minlenght="26" maxlenght="26" /></p>
        <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
        <p><input type="submit" value="Envoyer"></p>
    </form>

    <?php
    } 
    else {
        $phrase3 = $_POST["phrase3"];
        $cle = $_POST["cle"];
        if(isset($_POST["AfficheAlphabet"])){$affAlpha = TRUE;} else{$affAlpha = FALSE;}
        ?> 

        <form method="POST">
            <p>Texte à crypter : <br><textarea name="phrase3" cols="60" rows="8" maxlenght="1000"></textarea> </p>
            <p>Nouvel alphabet : <input type="text" name="cle" /></p>
            <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase3 = ex_3($phrase3, $cle, $affAlpha);
        unset($affAlpha, $_POST["phrase3"], $_POST["AfficheAlphabet"]);
    }

?> </p></span></body>