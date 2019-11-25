

<?php

function genere_alphabet($decalage = 0, $cle = NULL){
    /* 
    *   Fonction qui génére un alphabet avec le décalage demandé ou avec une clé de vigenère. 
    *   @param int $decalage
    *
    */
    $alphabetCrypte = array();
    if($cle == NULL){ # Si on a donné un décallage et non une clé
        $decalage %= 26; # le décalage est mis au modulo 26 
        if ($decalage<0){ #Il est possible de donner un decalage negatif
            $decalage = 26+$decalage; # Ex: si on donne -43 le decalage deviendra 9 le Z fait un "tour" et 17 lettre de l'alphabet à l'envers 
        }                               # autrement dis le A devient un J (le Z un I)
        for($i=0; $i<26; $i++){
            # on untilise les caractères de la table ASCII
            $alphabetCrypte[chr(97+$i)] = chr(97+(($i+$decalage)%26)); # %26 permet un "retour au 'a'(caractère 97 dans la table ASCII)"
        }
    }
    elseif($cle != NULL){# Si on a donné une clé de Vigenère
        for($i=0; $i<26; $i++){ # Comme avant, on associe chaque lettre à son correspondant selon la clé
            $alphabetCrypte[chr(97+$i)] = strtolower($cle[$i]);
        }
    }
    return($alphabetCrypte);
}


function affichage($phrase="", $alphabet=[], $alphaID=""){
    if($phrase!=""){
        echo "Texte crypté : <br><pre>".$phrase."</pre><br>";
    }

    if($alphabet!=[]){
        echo 'Alphabet '.$alphaID.' :<br><pre>'; print_r($alphabet); echo '</pre>';
    }
}




/* ------------------------- Ecercice 1 ------------------------------ */ 

function ex_1($phrase, $affAlpha){
    $alphabetDecale = genere_alphabet($decalage = 1, $cle = NULL);
    for($i=0; $i<strlen($phrase); $i++){
        $caractere = $phrase[$i];
        if((65<=ord($caractere) and ord($caractere)<=90) or (97<=ord($caractere) and ord($caractere)<=122)){
            if(IntlChar::islower($caractere)){
                $phrase[$i] = $alphabetDecale[$caractere];
            }
            elseif(IntlChar::isupper($caractere)){
                $phrase[$i] = strtoupper($alphabetDecale[strtolower($caractere)]);
            } 
        }
    }
    if($affAlpha){
        affichage($phrase, $alphabetDecale);
    }
    else{
        affichage($phrase);
    }
    return($phrase);
}


/* ------------------------- Ecercice 2 ------------------------------ */ 

function ex_2($phrase, $decalageDemande, $affAlpha){
    $alphabetDecale = genere_alphabet($decalage = $decalageDemande, $cle = NULL);
    for($i=0; $i<strlen($phrase); $i++){
        $caractere = $phrase[$i];
        if((65<=ord($caractere) and ord($caractere)<=90) or (97<=ord($caractere) and ord($caractere)<=122)){
            if(IntlChar::islower($caractere)){
                $phrase[$i] = $alphabetDecale[$caractere];
            }
            elseif(IntlChar::isupper($caractere)){
                $phrase[$i] = strtoupper($alphabetDecale[strtolower($caractere)]);
            } 
        }
    }
    if($affAlpha){
        affichage($phrase, $alphabetDecale);
    }
    else{
        affichage($phrase);
    }
    return($phrase);
}





/* ------------------------- Ecercice 3 ------------------------------ */ 

function ex_3($phrase, $cleEntre, $affAlpha){
    $alphabetDecale = genere_alphabet($decalage = 0, $cle = $cleEntre);
    for($i=0; $i<strlen($phrase); $i++){
        $caractere = $phrase[$i];
        if((65<=ord($caractere) and ord($caractere)<=90) or (97<=ord($caractere) and ord($caractere)<=122)){
            if(IntlChar::islower($caractere)){
                $phrase[$i] = $alphabetDecale[$caractere];
            }
            elseif(IntlChar::isupper($caractere)){
                $phrase[$i] = strtoupper($alphabetDecale[strtolower($caractere)]);
            } 
        }
    }
    if($affAlpha){
        affichage($phrase, $alphabetDecale);
    }
    else{
        affichage($phrase);
    }
    return($phrase);
}





/* ------------------------- Ecercice 4 ------------------------------ */ 

function ex_4($phrase, $cleVigenere, $affAlpha){
    $alphabetsVigenere = array();
    for($i=0; $i<strlen($cleVigenere); $i++){
        array_push($alphabetsVigenere, genere_alphabet($decalage = (ord(strtolower($cleVigenere[$i]))-97), $cle = NULL));
    } 

    for($j=0; $j<strlen($phrase); $j++){
        $caractere = $phrase[$j];
        if((65<=ord($caractere) and ord($caractere)<=90) or (97<=ord($caractere) and ord($caractere)<=122)){
            if(IntlChar::islower($caractere)){
                $phrase[$j] = $alphabetsVigenere[$j%(strlen($cleVigenere))][$caractere];
            }
            elseif(IntlChar::isupper($caractere)){
                $phrase[$j] = strtoupper($alphabetsVigenere[$j%(strlen($cleVigenere))][strtolower($caractere)]);
            } 
        }
    }
    if($affAlpha){
        affichage($phrase);
        ?> <table border="0"><tr> <?php
        for($i=0; $i<count($alphabetsVigenere); $i++){
            echo "<th>";
            affichage($phrase="", $alphabet=$alphabetsVigenere[$i], $alphaID=$cleVigenere[$i]);
            echo "</th>";
        } ?> </tr></table> <?php
    }
    else{
        affichage($phrase);
    }
    return($phrase);
}

/*
echo"<p><strong>---------------- Exercice 4 ------------------</strong></p>";
if(!isset($_POST['phrase4'])) {
    ?>
    
    <form method="POST">
        <p>Phrase à crypter : <input type="text" name="phrase4" /></p>
        <p>Clé de Vigenère : <input type="text" name="cleVigenere" /></p>
        <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet"></p>
        <p><input type="submit" value="Envoyer"></p>
    </form>

    <?php
    } 
    else {
        $phrase4 = $_POST["phrase4"];
        $cleVigenere = $_POST["cleVigenere"];
        if(isset($_POST["AfficheAlphabet"])){$affAlpha = TRUE;} else{$affAlpha = FALSE;}
        ?> 
float:none;ype="text" name="cleVigenere" /></p>
            <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet"></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase4 = ex_4($phrase4, $cleVigenere, $affAlpha);
        echo $phrase4;
    } */
