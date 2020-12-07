
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


/*  <?php echo'Hello World in PHP <br>';  ?>
                <br>
            <strong> -----  Addition des 2 nombre entier entré dans le formulaire ci-dessous   ---------------</strong>

        <?php
            if(!isset($_GET['aSomme'])) {
            ?>
            <form method="GET">
                <p>Premier nombre : <input type="int" name="aSomme" default=1 /></p>
                <p>Deuxième nombre : <input type="int" name="bSomme" default=1 /></p>
                <p><input type="submit" value="CALCUUUULE"></p>
            </form>

            <strong>
            <?php
            } else {
                $aSomme = $_GET['aSomme'];
                $bSomme = $_GET['bSomme'];
                $somme = $aSomme + $bSomme;

                echo 'Attention c\'est de la magie : ' . $aSomme . '+' . $bSomme . '=' . $somme . '  ';
            }
            ?>
            </strong>
                    <br><br><br><br>
            <strong> -----  Calcul des racines d'une équation du second degrés   ---------------</strong>  <br><br><br>


            <?php 
            function CalcRacines($a, $b, $c)
            {
                $delta = ($b*$b) - (4*$a*$c);
                echo "Delta = $delta <br>";
                /* Si delta<0 et tout   

                if ($delta<0) {
                    echo "Ce polynôme n'as pas de racines";
                }

                elseif ($delta==0) {
                    $racine = (-$b) / (2*$a);
                    echo "Ce polynôme admet pour racine double :  $racine";
                }

                elseif ($delta>0){
                    $racineA = truncate(((-$b + sqrt($delta)) / (2*$a)), 3);
                    $racineB = (-$b - sqrt($delta)) / (2*$a);

                    echo "Ce polynôme admet pour racines : $racineA et $racineB";
                }
            }

            $reset = FALSE;
            if(!isset($_GET['aEqu'])){
            ?>

            <form method="GET">
                <p>Premier nombre : <input type="int" name="aEqu" default=1/></p>
                <p>Deuxième nombre : <input type="int" name="bEqu" default=1 /></p>
                <p>Troisième nombre : <input type="int" name="cEqu" default=1 /></p>
                <p><input type="submit" value="CALCUUUULE"></p>
            </form>

            <?php
            } else {
                $aEqu = $_GET['aEqu'];
                $bEqu = $_GET['bEqu'];
                $cEqu = $_GET['cEqu'];
                echo "L'équation du second degrés à résoudre est :<strong> $aEqu x² + $bEqu x + $cEqu</strong><br>";
                CalcRacines($aEqu, $bEqu, $cEqu);
                ?>
               <form method="GET">
                    <p>Premier nombre : <input type="int" name="aEqu" default=1/></p>
                    <p>Deuxième nombre : <input type="int" name="bEqu" default=1 /></p>
                    <p>Troisième nombre : <input type="int" name="cEqu" default=1 /></p>
                    <p><input type="submit" value="CALCUUUULE"></p>
                </form>
                <?php
                unset($_GET['aEqu'], $_GET['aEqu'], $_GET['aEqu']);
            }
            ?>

            <br><br><br><br>
            <strong> -----  Calcul des racines d'une équation du second degrés   ---------------</strong>  <br><br><br>
 */ 


?>

