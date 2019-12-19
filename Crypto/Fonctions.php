<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="fr">
    <title>Fonctions - TP3 Cryptographie</title>
    <link rel="shortcut icon" href="favicon-polytech.png">
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


<?php include 'Cryptographie.php';?>

<span id="content">
    <p style="font-size: 16pt; font-weight: bold">
    Fonctions : <br>
    <p style="font-size: 12pt; font-weight= normal">
    Pour ces exercices, j'ai utilisé les caractères de la table <a href="https://fr.wikibooks.org/wiki/Les_ASCII_de_0_%C3%A0_127/La_table_ASCII">ASCII</a>. <br>
    Bien que ce ne soit pas du tout la manière la plus simple ni la plus intuitive de réaliser ces exercices, 
    il serait facile d'étendre le décalage à tous les caractères de cette table, rendant le décryptage du message plus compliqué.
    </p>
    <pre><span class="commentaire">
    // Les fonctions suivantes seront utilisées dans chaque exercice.</span>
 
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


Fonction isupper($car){
  <span class='commentaire'>// Teste si la lettre est une majuscule</span>
  ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"] <- $UPPER;
  Pour ($i de 0 à 26){
    Si ($car==$UPPER[$i]){return TRUE;}
  }
}


Fonction convert_casse_upper($car){
  <span class='commentaire'>// Convertit la lettre en majuscule</span>
  ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"] <- $UPPER;
  ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"] <- $LOWER;

  Pour ($i de 0 à 26){
    Si ($car==$LOWER[$i]){return $UPPER[$i];}
  }
  return $car;
}


Fonction convert_classe_lower{
  <span class='commentaire'>// Convertit un lettre en minuscule</span>
  ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"] <- $UPPER;
  ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"] <- $LOWER;

  Pour ($i de 0 à 26){
    Si ($car==UPPER[$i]){return $LOWER[$i];}
  }
  return $car;
}


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

</pre> 
</p></span></body>