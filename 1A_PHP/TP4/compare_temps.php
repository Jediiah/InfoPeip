<!DOCTYPE html>
<html>

  <head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta http-equiv="Content-Language" content="fr">
    <title>compare_temps - TP4 Fichiers</title>
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
    compare_temps : <br>
    <pre>

Fonction compare_temps($temps1, $temps2){
  <span class='commentaire'># on convertit les temps initialement au format str(mm : ss : cc)
  #   au format array(int(mm), int(ss), int(cc))</span>
  tablo_map('intval', explose(' : ', $temps1)) <- $temps1;
  tablo_map('intval', explose(' : ', $temps2)) <- $temps2;

  <span class='commentaire'>#  on convertit en centiemes de secondes</span>
  $temps1[0]*600 + $temps1[1]*100 + $temps1[2] <- $temps1;
  $temps2[0]*600 + $temps2[1]*100 + $temps2[2] <- $temps2;

  <span class='commentaire'># on compare les temps et renvoie vrai si le temps1 est superieur au temps2</span>
  return($temps1>$temps2);
}
    </pre><br>


</p></span></body>