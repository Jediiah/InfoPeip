<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="fr">
    <title>Exercice 5 - TP3 Cryptographie</title>
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
    Exercice 5 : <br>
    <p style="font-size: 12pt; font-weight= normal">
    &nbsp; Pour décrypter un chiffre de Vigenere il faut tout d'abord trouver la longueur de la clé.
    Pour faire cela on peut trouver des partie du texte répétées plusieurs fois qui correspondent à la longueur de la clé. <br>
    &nbsp; Esuite on fait une analyse de fréquence, c'est à dire comparer la fréquence d'apparition des lettres dans le message 
    à la fréquence d'apparition des lettres dans la langue du message, et ainsi emettre une hypothese sur les lettres composant la 
    clé. Il est aussi possible de tester toutes les possibilités jusqu'à obtenir un résultat cohérent. 
    </p>
</p></span></body>