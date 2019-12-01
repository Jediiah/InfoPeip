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
    Exercice 1 : <br>
    <pre><span class="commentaire">
    // Les deux fonctions suivantes seront utilisées dans chaque exercice.</span>

Fonction genere_alphabet($decalage=int ou $nvoAlphabet=str){<span class="commentaire">
  /* 
    Fonction qui génère un nouvel alphabet. 
  */</span>
  array() <-- $alphabetCrypte;

  Si ($nvoAlphabet n'est pas définit){ <span class="commentaire">//Si un décalage est entré et non un nouvel alphabet</span>
    $decalage % 26 <-- $decalage;
    if($decalage < 0){
      26 + $decalage <-- $decalage;
    }
    Pour $i de 0 à 26{
      caractere(97+(($i+$decalage)%26)) <-- $alphabetCrypte[caractere(97+$i)]; <span class="commentaire">//On associe à chaque lettre (minuscule) son </span>
    }                                                                           <span class="commentaire">//nouvel équivalent grace à la table <a href="https://fr.wikibooks.org/wiki/Les_ASCII_de_0_%C3%A0_127/La_table_ASCII">ASCII</a>.</span>
  }
  Sinon Si ($nvoAlphabet est définit){
    Pour $i de 0 à 26{
      strtolower($nvoAlphabet[$i]) <-- $alphabetCrypte[caractere(97+$i)];  
    }
  }

  Retourne $alphabetCrypte;
}


Fonction remplace_lettres($phrase = str, $alphabet = array()){<span class="commentaire">
  /* 
    Fonction qui remplace toutes les lettres d'un texte par leur equivalent 
    dans l'alphabet donné tout en respectant la casse.
  */ </span>
  Pour $i de 0 à strlen($phrase){
    $lettre = $phrase[$i];
    Si (65<=ord($lettre)<=90 ou 97<=ord($lettre)<=122){  <span class="commentaire">//Le codage d'après la table ASCII du caractere</span>  
      Si ($lettre est minuscule){                         <span class="commentaire">//considéré correspond à une lettre </span>
        $alphabetDecale[$lettre] <-- $phrase[$i];  <span class="commentaire">// On  remplace la lettre par son équivalent crypté</span>
      }
      Sinon Si ($lettre est majuscule){
        $alphabetDecale[$lettre] <-- strtoupper($phrase[$i]);  <span class="commentaire">// pareil avec une lettre majuscule</span>
      }
    }  
  }
  Retourne $phrase;
}


#Exercice 1
$_POST["phrase"] <-- $phrase;
genere_alphabet(decalage = 1) <-- $alphabetDecale;

remplace_lettres($phrase, $alphabetDecale) <-- $phrase;

Affiche $phrase;
    </pre><br>

<h3>Application :</h3> 

    <?php
    
      if(!isset($_POST['phrase1'])) {
        ?>
        
        <form method="POST">
            <p>Texte à crypter : <br><textarea name="phrase1" cols="60" rows="8" maxlenght="1000"></textarea> </p>
            <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
            <p><input type="submit" value="Envoyer"></p>
        </form><br><br>
    
        <?php
        } 
        else {
            $phrase1 = $_POST["phrase1"];
            if(isset($_POST["AfficheAlphabet"])){$affAlpha = TRUE;} else{$affAlpha = FALSE;}
            ?> 
    
            <form method="POST">
                <p>Texte à crypter : <br>  <textarea name="phrase1" cols="60" rows="8" maxlenght="1000"></textarea> </p>
                <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="0"></p>
                <p><input type="submit" value="Envoyer"></p>
            </form><br><br>
    
            <?php
            $phrase1 = ex_1($phrase1, $affAlpha);
            unset($affAlpha, $_POST["phrase1"], $_POST["AfficheAlphabet"]);
        }

?> </p></span></body>