
<?php
function mille(){
    $i = 0;
    $j = 0;
    $k = 0;
    while($i<10){
        $j =0;
        while($j<10){
            $k = 0;
            while($k<10){
                $nombre = $i*100 + $j*10 + $k;
                echo"$nombre ";
                $k++;
            }
            $j++;
        }
        $i++;
    }
}

function plus(){
    $i = 0;
    $j = 0;
    $k = 0;
    while($i<=10){
        $j =0;
        while($j<=10){
            $k = 0;
            while($k<=10){
                $test = ("$i$j$k" == $i**3 + $j**3 + $k**3);
                if($test){
                    echo "A=$i, B=$j, C=$k  vérifient la propriété <br>";
                }
                $k++;
            }
            $j++;
        }
        $i++;
    }
}

#TD7

function GenereTablo($taille){
    $tablo = array();
    for($i=0; $i<$taille; $i++){
        array_push($tablo, rand(0, 10));
    }
    return($tablo);
}

//1)

function Ex1($tablo){
    foreach ($tablo as $val) {
        echo "$val | ";
    }
    echo "<br>";
    $valeurMax = 0;
    $valeurMin = 10000000000;
    $somme = 0;
    foreach($tablo as $nbr){
        if($nbr > $valeurMax){
            $valeur = $nbr;
            $valeurMax = $valeur;
        }   
        if($nbr < $valeurMin){
            $valeur = $nbr;
            $valeurMin = $valeur;
        }
       $somme += $nbr;
    }
    $moyenne = $somme/count($tablo);

    echo "Valeur Max = $valeurMax <br>
            Valeur Min = $valeurMin <br>
            Somme = $somme <br>
            Moyenne = $moyenne";
}

#Ex1(GenereTablo(20));

//2)

function Ex2($tablo, $valeurCherche){
    asort($tablo);
    foreach ($tablo as $val) {
        echo "$val | ";
    }
    echo"<br> $valeurCherche";
    $debut = 0;
    $estDedant = FALSE;
    $estFini = FALSE;
    $fin = count($tablo)-2;
    while(!($estDedant or $estFini)){
        $rang = floor(($debut+$fin)/2);
        if($valeurCherche != $tablo[$rang]){
            if($valeurCherche < $tablo[$rang]){
                $fin = $rang;
            }
            elseif($valeurCherche > $tablo[$rang]){
                $debut = $rang;
            }
        }    
        else{
            $estDedant = True;
        }
        if($debut <= $fin){
            $estFini = TRUE;
        }
        
    }
    if($estDedant){
        echo "<br> La valeur $valeurCherche est dans le tableau.";
    }
    else{
        echo "<br> La valeur $valeurCherche n'est pas dans le tableau.";
    }
    
    }


Ex2(GenereTablo(5), rand(0, 10));

?>
