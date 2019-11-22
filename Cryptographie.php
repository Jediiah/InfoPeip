
<html><h2>TP3 Cryptographie | LALLEMAND-BIRCK Zacharie</h2><br></html>

<?php

function genere_alphabet($decalage = 0, $cle = NULL, $affAlpha = FALSE){
    /* Fonction qui génére un alphabet avec le décalage demandé ou avec une clé de vigenère. */
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
    if($affAlpha){
        echo '<pre>'; print_r($alphabetCrypte); echo '</pre>';
    }
    return($alphabetCrypte);
}




/* ------------------------- Ecercice 1 ------------------------------ */ 

function ex_1($phrase, $affAlpha){
    $alphabetDecale = genere_alphabet($decalage = 1, $cle = NULL, $affAlpha = $affAlpha);
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
    return($phrase);
}

echo"<p><strong>---------------- Exercice 1 ------------------</strong></p>";
if(!isset($_POST['phrase1'])) {
    ?>
    
    <form method="POST">
        <p>Phrase à crypter : <input type="text" name="phrase1" /></p>
        <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
        <p><input type="submit" value="Envoyer"></p>
    </form>

    <?php
    } 
    else {
        $phrase1 = $_POST["phrase1"];
        $affAlpha = $_POST["AfficheAlphabet"]
        ?> 

        <form method="POST">
            <p>Phrase à crypter : <input type="text" name="phrase1" /></p>
            <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="0"></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase1 = ex_1($phrase1, $affAlpha);
        echo $phrase1;
    }




echo"<br>";
/* ------------------------- Ecercice 2 ------------------------------ */ 

function ex_2($phrase, $decalageDemande, $affAlpha){
    $alphabetDecale = genere_alphabet($decalage = $decalageDemande, $cle = NULL, $affAlpha = $affAlpha);
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
    return($phrase);
}


echo"<p><strong>---------------- Exercice 2 ------------------</strong></p>";
if(!isset($_POST['phrase2'])) {
    ?>
    
    <form method="POST">
        <p>Phrase à crypter : <input type="text" name="phrase2" /></p>
        <p>Decalage : <input type="int" name="decalage" /></p>
        <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
        <p><input type="submit" value="Envoyer"></p>
    </form>

    <?php
    } 
    else {
        $phrase2 = $_POST["phrase2"];
        $decalage = $_POST["decalage"];
        $affAlpha = $_POST["AfficheAlphabet"]
        ?> 

        <form method="POST">
            <p>Phrase à crypter : <input type="text" name="phrase2" /></p>
            <p>Decalage : <input type="int" name="decalage" /></p>
            <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase2 = ex_2($phrase2, $decalage, $affAlpha);
        echo $phrase2;
    }





echo"<br>";
/* ------------------------- Ecercice 3 ------------------------------ */ 

function ex_3($phrase, $cleEntre, $affAlpha){
    $alphabetDecale = genere_alphabet($decalage = 0, $cle = $cleEntre, $affAlpha = $affAlpha);
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
    return($phrase);
}


echo"<p><strong>---------------- Exercice 3 ------------------</strong></p>";
if(!isset($_POST['phrase3'])) {
    ?>
    
    <form method="POST">
        <p>Phrase à crypter : <input type="text" name="phrase3" /></p>
        <p>Nouvel alphabet : <input type="text" name="cle" /></p>
        <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
        <p><input type="submit" value="Envoyer"></p>
    </form>

    <?php
    } 
    else {
        $phrase3 = $_POST["phrase3"];
        $cle = $_POST["cle"];
        $affAlpha = $_POST["AfficheAlphabet"]
        ?> 

        <form method="POST">
            <p>Phrase à crypter : <input type="text" name="phrase3" /></p>
            <p>Nouvel alphabet : <input type="text" name="cle" /></p>
            <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase3 = ex_3($phrase3, $cle, $affAlpha);
        echo $phrase3;
    }






echo"<br>";
/* ------------------------- Ecercice 4 ------------------------------ */ 

function ex_4($phrase, $cleVigenere, $affAlpha){
    $alphabetsVigenere = array();
    for($i=0; $i<strlen($cleVigenere); $i++){
        array_push($alphabetsVigenere, genere_alphabet($decalage = (ord(strtolower($cleVigenere[$i]))-97), $cle = NULL, $affAlpha = $affAlpha));
    }

    for($j=0; $j<strlen($phrase); $j++){
        $caractere = $phrase[$j];
        if((65<=ord($caractere) and ord($caractere)<=90) or (97<=ord($caractere) and ord($caractere)<=122)){
            if(IntlChar::islower($caractere)){
                $phrase[$j] = $alphabetsVigenere[$j%(strlen($cleVigenere))][$caractere];
            }
            elseif(IntlChar::isupper($caractere)){
                $phrase[$i] = strtoupper($alphabetsVigenere[$j%(strlen($cleVigenere))][strtolower($caractere)]);
            } 
        }
    }
    return($phrase);
}


echo"<p><strong>---------------- Exercice 4 ------------------</strong></p>";
if(!isset($_POST['phrase4'])) {
    ?>
    
    <form method="POST">
        <p>Phrase à crypter : <input type="text" name="phrase4" /></p>
        <p>Clé de Vigenère : <input type="text" name="cleVigenere" /></p>
        <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
        <p><input type="submit" value="Envoyer"></p>
    </form>

    <?php
    } 
    else {
        $phrase4 = $_POST["phrase4"];
        $cleVigenere = $_POST["cleVigenere"];
        $affAlpha = $_POST["AfficheAlphabet"]
        ?> 

        <form method="POST">
            <p>Phrase à crypter : <input type="text" name="phrase4" /></p>
            <p>Clé de Vigenère : <input type="text" name="cleVigenere" /></p>
            <p>Afficher l'alphabet généré : <input type="checkbox" name="AfficheAlphabet" value="TRUE"></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase4 = ex_4($phrase4, $cleVigenere, $affAlpha);
        echo $phrase4;
    }
