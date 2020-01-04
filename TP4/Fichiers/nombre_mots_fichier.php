<?php 
// on déclare le nom du fichier à ouvrir
$fichier = 'fichier_test.txt'; 
//ouverture du fichier en lecture seule
$fp = fopen($fichier,'r'); 
//feof indiquera la fin du fichier
//le fichier est parcouru jusqu'à la fin
$nombre_mots = 0;
while(!feof($fp)) 
{
    //lecture du fichier, stockage dans $ligne
    $ligne = fgets($fp); 
    //affiche la ligne à l'écran, n'oubliez pas
    echo $ligne.'<br/>';
    $tab = explode(' ',$ligne);
    echo '<br/>Nombre de mots avec explode : '.count($tab) .'<BR />' ;  
    $nombre_mots = $nombre_mots + count($tab);
    echo $nombre_mots;
}
fclose($fp); //pensez à refermer à la fin du script
?>