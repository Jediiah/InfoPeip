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
                    <td width="1" align="center"><a href="Zacharie.html">Zacharie</a></td>
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
                
            <p style="text-align: center; font-size: 2em"><strong>Cadavre Exquis </strong></p>

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
                            <p>Nombre de Cadavres : <input type="int" name="nbCadavres" min=0 max=10000/></p>
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
        </div>
    
    </span>

</body>