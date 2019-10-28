<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Language" content="fr" />
        <title>TetrisSite - ISN 2019</title>
        <link rel='stylesheet' type='text/css' href="../STYLE/laFeuuille.css">
        <script defer src="https://use.fontawesome.com/releases/v5.8.1/js/all.js" integrity="sha384-g5uSoOSBd7KkhAMlnQILrecXvzst9TdC09/VM+pjDTCM+1il8RHz5fKANTFFb+gQ" crossorigin="anonymous"></script>
    </head>

    <body>
        <header id="header">
    	    <a href="TetrisSite.html" title="Home">
                <img src="../Img/tetris-logo.png" alt="Tetris" width="350px">
            </a>
        </header>
  
        <nav id="menu">
            <table width="100%" cellspacing="0" cellpadding="0" border="0">
                <tbody><tr>
                    <td>&nbsp;</td>
                    <td width="1" align="center"><a href="TetrisSite.html">Acceuil</a></td>
                    <td>&nbsp;</td>
                    <td width="1" align="center"><a href="Nidhal.html">Nidhal</a></td>
                    <td>&nbsp;</td>
                    <td width="1" align="center"><a href="Brice.html">Brice</a></td>
                    <td>&nbsp;</td>
                    <td width="1" align="center">Zacharie</td>
                    <td>&nbsp;</td> 
                    <td width="1" align="center"><a href="PHP.php">PHP</a></td>
                    <td>&nbsp;</td>
                    <!-- icon GitHub (en dessous) -->
                    <td width="1" align="center"><a target="_blank" href="https://github.com/Jediiah/Tetris-ISN-2019"><span style="font-size: 2em; color: purple;"><i class="fab fa-github"></i></span></a></td>
                    <td>&nbsp;</td>
                   
                </tr></tbody>
            </table>  
        </nav>
 
 
    <span id="content">
        <div style="float:left; width:700px; margin-right:16px; margin-bottom:16px;"><span class="title">Le super dossier de Zacharie</span><br><br> 
            <?php echo'Hello World in PHP <br>';  ?>
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
                /* Si delta<0 et tout   */

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


        </div>
    
    </span>

</body>