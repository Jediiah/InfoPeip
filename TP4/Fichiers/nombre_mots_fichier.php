<?php 
// on d�clare le nom du fichier � ouvrir
$fichier = 'fichier_test.txt'; 
//ouverture du fichier en lecture seule
$fp = fopen($fichier,'r'); 
//feof indiquera la fin du fichier
//le fichier est parcouru jusqu'� la fin
$nombre_mots = 0;
while(!feof($fp)) 
{
    //lecture du fichier, stockage dans $ligne
    $ligne = fgets($fp); 
    //affiche la ligne � l'�cran, n'oubliez pas
    echo $ligne.'<br/>';
    $tab = explode(' ',$ligne);
    echo '<br/>Nombre de mots avec explode : '.count($tab) .'<BR />' ;  
    $nombre_mots = $nombre_mots + count($tab);
    echo $nombre_mots;
}
fclose($fp); //pensez � refermer � la fin du script
?>