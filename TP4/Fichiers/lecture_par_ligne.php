<?php 
// on d�clare le nom du fichier � ouvrir
$fichier = 'fichier_test.txt'; 
//ouverture du fichier en lecture seule
$fp = fopen($fichier,'r'); 
//feof indiquera la fin du fichier
//le fichier est parcouru jusqu'� la fin
while(!feof($fp)) 
{
    //lecture du fichier, stockage dans $ligne
    $ligne = fgets($fp); 
    //affiche la ligne � l'�cran, n'oubliez pas
    echo $ligne.'<br/>';  
}
fclose($fp); //pensez � refermer � la fin du script
?>