<?php
$f="personnes.txt";

class Etudiant
{
	public $noEtu;
	public $Nom;
	public $Prenom;
	public $Adresse;
	
} 

$tabetudiants=array();
$file=fopen($f, "r");

$k=0;

while (!feof($file)) {

	$etu=fgets($file);
	$champs=explode(";", $etu);
	
	$Etudiant=new Etudiant();
	$Etudiant->noEtu=$champs[0];
	$Etudiant->Nom=$champs[1];
	$Etudiant->Prenom=$champs[2];
	$Etudiant->Adresse=$champs[3];
	$tabetudiants[$k++]=$Etudiant;

}

$n=count($tabetudiants);

echo "<table border=1>";
echo"<tr><th>Numéro étudiant</th><th>Nom</th><th>Prenom</th><th>adresse</th></tr>";

for ($i=0; $i<=$n-1 ; $i++) {
	$Etudiant=$tabetudiants[$i];
	echo '<tr>';
    echo '<td>'.$Etudiant->noEtu.'</td>';
    echo '<td>'.$Etudiant->Nom.'</td>';
    echo '<td>'.$Etudiant->Prenom.'</td>';
    echo '<td>'.$Etudiant->Adresse.'</td>';
    echo '</tr>';
}

echo"</table>";
 ?>