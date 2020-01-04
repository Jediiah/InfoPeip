
<?php

// Toutes les fonctions de base 

include('Fichiers/listeChaine.php');



function exception_error_handler($severity, $message, $file, $line) {
    if (!(error_reporting() & $severity)) {
        // Ce code d'erreur n'est pas inclu dans error_reporting
        return;
    }
    throw new ErrorException($message, 0, $severity, $file, $line);
}
set_error_handler("exception_error_handler");



function strlong($texte){
    /*
        Idem strlen()
    */
    $taille = 0;
    while(isset($texte[$taille])){$taille++;}
    return($taille);
}


function arraylong($array){
    /*
        Idem count()
    */
    $taille = 0;
    while(isset($array[$taille])){$taille++;}
    return($taille);
}


function sobstr($string, $carDepart, $long){
    /*
        Idem substr()
    */ 
    $souschaine = "";
    for($i=0; $i<$long; $i++){
        if(isset($string[$i+$carDepart])){
            $souschaine .= $string[$i+$carDepart];
        }
    }
    return $souschaine;
}


function explose($sep, $chaine){
    /*
        Idem explode() 
    */
    $listeMots = array();
    $mot = "";
    $i = 0;

    while(isset($chaine[$i])){
        $sousChaineTest = sobstr($chaine, $i, strlong($sep));
        if($sousChaineTest!=$sep){
            $mot .= $chaine[$i];
            if(isset($chaine[$i+1])==FALSE){
                $motEchange = $mot;
                $listeMots[arraylong($listeMots)] = $motEchange;
                $mot = "";
            }
        }
        elseif($sousChaineTest==$sep){
            $motEchange = $mot;
            $listeMots[arraylong($listeMots)] = $motEchange;
            $mot = "";
        }
        $i++;
    }
    return $listeMots;
}


function tablo_map($fctn, $tablo){
    /*
        Idem array_map()
    */
    $tabloRetour = array();
    foreach($tablo as $elmt){
        $tabloRetour[arraylong($tabloRetour)] = call_user_func($fctn, $elmt);
    }
    return $tabloRetour;
}



// Le vrai TP

function compare_temps($temps1, $temps2){
    # on convertit les temps initialement au format str(mm : ss : cc)
    #   au format array(int(mm), int(ss), int(cc))
    $temps1 = tablo_map('intval', explose(' : ', $temps1));
    $temps2 = tablo_map('intval', explose(' : ', $temps2));

    # on convertit en centiemes de secondes
    $temps1 = $temps1[0]*600 + $temps1[1]*100 + $temps1[2];
    $temps2 = $temps2[0]*600 + $temps2[1]*100 + $temps2[2];

    # on compare les temps et renvoie vrai si le temps1 est superieur au temps2
    return($temps1>$temps2);
}


class Skieur
{
    public $dossard;
    public $nom;
    public $prenom;
    public $pays;
    public $temps;

}



function parcours_depart($fichier){
    /* 
        Fonction qui parcours un fichier donnant topus les skieurs participant 
        et qui renvoie une liste de ses skieurs. 
    */
    if(is_string($fichier)){
        try{
            $fichier = fopen($fichier, 'r');
        }catch (Exeption $e){
            echo "Erreur : ". $e->getMessage()."<br>";
            return NULL;
        }
    }

    $listeSkieurs = array();
    $premiereLigne = TRUE;
    while(!feof($fichier)){
        $ligne = fgets($fichier);
        if($premiereLigne){$echgval = $ligne; $ligneTest = $echgval; $premiereLigne = FALSE;}

        if($ligne==$ligneTest){
            $nvoSkieur = new Skieur;

            $nvoSkieur->dossard = $dossard = intval(fgets($fichier));     
            $nvoSkieur->nom = fgets($fichier);     
            $nvoSkieur->prenom = fgets($fichier);     
            $nvoSkieur->pays = fgets($fichier);  
    
            $echgNvoSkieur = $nvoSkieur;
            $listeSkieurs[$dossard] = $echgNvoSkieur;
        }
    }
    return $listeSkieurs;
}


$classement = cree_liste();
$listeDepart = parcours_depart('texte.txt');
#var_dump($listeDepart); echo "<br>";

function ajout_skieur($dossard, $temps){
    /*
        Fonction qui gère l'arrivée d'un skieur et qui l'ajoute au classement 
        en fonction de son temps.
    */ 
    global $listeDepart, $classement;

    $listeDepart[$dossard]->temps = $temps;
    $skieur = $listeDepart[$dossard];
    
    $pEncours = $classement->pSuiv;
    if($pEncours==NULL){
        $arriveSkieur = new Element;
        $arriveSkieur->valeur = $skieur;
        ajout_debut($arriveSkieur, $classement);
    }
    else{
        while($pEncours!=NULL){
            if(compare_temps($pEncours->valeur->temps, $skieur->temps)){
                ajout_avant($skieur, $pEncours->valeur, $classement);
                $pEncours = NULL;
            }
            elseif($pEncours->pSuiv==NULL){
                $arriveSkieur = new Element;
                $arriveSkieur->valeur = $skieur;
                ajout_apres($arriveSkieur, $pEncours);
                $pEncours = NULL;
            }
            else{
                $pEncours = $pEncours->pSuiv;
            }
        }
    }
}

ajout_skieur(11, '01 : 24 : 00');
ajout_skieur(2, '01 : 45 : 03');

#var_dump($classement);