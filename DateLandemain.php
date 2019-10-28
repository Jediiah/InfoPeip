
<?php

/* Transforme la date obtenue sous forme de chaine de caractère en
    trois entiers correspondant à l'année, au moi et au jour. */
function separe_date($dateStr){
    $annee = "";
    $mois = "";
    $jour = "";
    for($i=0; $i<strlen($dateStr); $i++){
        $caractere = $dateStr[$i];
        if($caractere != '-'){
            if($i<strlen($dateStr)-6){
                $annee = "$annee$caractere";
            }
            elseif($i<strlen($dateStr)-3){
                $mois = "$mois$caractere";
            }
            else{
                $jour = "$jour$caractere";
            }
        }
    }
    $annee = intval($annee);
    $mois = intval($mois);
    $jour = intval($jour);

    return(array($annee, $mois, $jour));
}

function affiche_date($annee, $mois, $jour){
    $moisCorrespond = ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'];
    $moisAffiche = $moisCorrespond[$mois-1];
    if ($jour == 1){
        $jour = '1er';
    }
    echo "<br> Date donnée : $jour $moisAffiche $annee";
}

/* fonction demain(array(anne, moi, jour)) 
    test bisextile
    test 31 ou 30 joue (exeption février)
    tests des 2 exeption ; 31 decembre et 28/29 février
    application du +1jour */

function landemain($annee, $mois, $jour){
    $estBissextile = ($annee%4 == 0 and $annee%100 != 0) or ($annee%400 == 0);
    $longMois = array(31, '', 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);

    if($mois == 2){
        if(($jour == 29) or ($jour == 28 and !$estBissextile)){
            $mois ++;
            $jour = 1;
        }
        else{
            $jour ++; 
        }
    }
    elseif($mois == 12 and $jour == 31){
        $annee ++;
        $mois = 1;
        $jour = 1;
    }
    elseif($jour == $longMois[$mois-1]){
        $mois ++;
        $jour = 1;
    }
    else{
        $jour ++;
    }
    affiche_date($annee, $mois, $jour);
}

/* explique formulaire date */

    if(!isset($_POST['date'])) {
    ?>

    <form method="POST">
        <p>Quel jour on est ? : <input type="date" name="date" /></p>
        <p><input type="submit" value="CALCUUUULE"></p>
    </form>

    
    <?php
    } 
    else {
        $date = $_POST["date"];
        ?> 

        <form method="POST">
            <p>Premier nombre : <input type="date" name="date" /></p>
            <p><input type="submit" value="CALCUUUULE"></p>
        </form>

        <?php
        unset($_POST["date"]);
        $dateSepare = separe_date($date);
        affiche_date(...$dateSepare);
        landemain(...$dateSepare);
    }
    ?>
    
