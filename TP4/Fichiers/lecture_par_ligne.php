<?php 
// on déclare le nom du fichier à ouvrir
$fichier = 'fichier_test.txt'; 
//ouverture du fichier en lecture seule
$fp = fopen($fichier,'r'); 
//feof indiquera la fin du fichier
//le fichier est parcouru jusqu'à la fin
while(!feof($fp)) 
{
    //lecture du fichier, stockage dans $ligne
    $ligne = fgets($fp); 
    //affiche la ligne à l'écran, n'oubliez pas
    echo $ligne.'<br/>';  
}
fclose($fp); //pensez à refermer à la fin du script
?>