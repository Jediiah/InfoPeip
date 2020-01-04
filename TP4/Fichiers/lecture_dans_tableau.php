    <HTML><HEAD>
    <TITLE>Utilisation des tableaux-3</TITLE>
    </HEAD><BODY><OL>
    <?php
    // lecture du fichier et stockage dans un tableau
    // (chaque ligne du fichier est dans une case du tableau)
    $lignes = file("personnes.txt");
    // traitement de chaque ligne 
    for ($i=0; $i<count($lignes); $i++) {
      // éclatement en éléments distincts
      $personne=explode(";",$lignes[$i]);
      // affichage "propre" des renseignements
      echo "<LI>".$personne[0]." ".strtoupper($personne[1])."<BR>"
        .$personne[2]."<BR>".$personne[3]." ".$personne[4];
    }
    ?>
    </OL></BODY></HTML>


