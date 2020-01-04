<?php

$fichier1 = fopen('fichier_test.txt','r');
$fichier2 = fopen('fichier_test.txt','r');
$fichier3 = fopen('fichier3.txt','w+');

while(!feof($fichier1)) 
{
    //traitement du premier fichier
    $ligne = fgets($fichier1); 
    fwrite($fichier3,$ligne);
}
fwrite($fichier3,PHP_EOL);

while(!feof($fichier2)) 
{
    //traitement du deuxième fichier
    $ligne = fgets($fichier2); 
    fwrite($fichier3,$ligne);
}

echo "terminé1";

fclose($fichier1);
fclose($fichier2);
fclose($fichier3);

$fichier3 = fopen('fichier3.txt','r');

while(!feof($fichier3)) 
{
    //lecture du fichier, stockage dans $ligne
    $ligne = fgets($fichier3); 
    //affiche la ligne à l'écran, n'oubliez pas
    echo $ligne.'<br/>';  
}

echo "terminé2"; 

fclose($fichier3);

?>



