
<p style="text-align: center;"><strong>Cadavre Exquis </strong></p>

<?php

/* creer un liste de tous les éléments dans le fichier */
$sujets = file('../CadavreExquis/Sujets.ini');
$verbes = file('../CadavreExquis/Verbes.ini');
$complements = file('../CadavreExquis/Co.ini');

function Cadavre(){
    /* Une phrase simple : sujet verbe complément 
        chasue élément étant pris au hasard dans la liste correspondante. */ 
    global $sujets, $verbes, $complements;

    $sujet = $sujets[random_int(0, count($sujets)-1)];
    $verbe = $verbes[random_int(0, count($verbes)-1)];
    $complement = $complements[random_int(0, count($complements)-1)];

    echo "$sujet $verbe $complement <br>";
}


/* On entre le nombre de phrase à générer */ 
if(!isset($_POST['nbCadavres'])) {
    ?>

        <form method="POST">
            <p>Nombre de Cadavres : <input type="int" name="nbCadavres" /></p>
            <p><input type="submit" value="Encore"></p>
        </form>

    
    <?php
    } 
    else {
        $nbCadavres = $_POST["nbCadavres"];
        unset($_POST["nbCadavres"]);
        ?> 

        <form method="POST">
            <p>Nombre de Cadavres : <input type="int" name="nbCadavres" /></p>
            <p><input type="submit" value="Encore"></p>
        </form>

        <?php
        for($i=0; $i<$nbCadavres; $i++){
            Cadavre();
        }
    }

?>