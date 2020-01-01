
<?php

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


$str = "abcdef";
$tablo = ['12', '13', '14', '15'];
$tablo[6] = '18';
var_dump($tablo);


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
    public $dossard = 0;
    public $nom = "";
    public $prenom = "";
    public $pays = "";
    public $temps = 0;

}

