
<html><h2>TP3 Cryptographie | LALLEMAND-BIRCK Zacharie</h2><br></html>

<?php

function genere_alphabet($decalage = 0, $cle = NULL){
    $alphabetCrypte = array();
    if($cle == NULL){
        $decalage %= 26;
        for($i=0; $i<26; $i++){
            $alphabetCrypte[chr(97+$i)] = chr(97+(($i+$decalage)%26));
        }
    }
    elseif($cle != NULL){
        for($i=0; $i<26; $i++){
            $alphabetCrypte[chr(97+$i)] = strtolower($cle[$i]);
        }
    }
    return($alphabetCrypte);
}




/* ------------------------- Ecercice 1 ------------------------------ */ 

function ex_1($phrase){
    $alphabetDecale = genere_alphabet($decalage = 1);
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
        <p><input type="submit" value="Envoyer"></p>
    </form>

    <?php
    } 
    else {
        $phrase1 = $_POST["phrase1"];
        ?> 

        <form method="POST">
            <p>Phrase à crypter : <input type="text" name="phrase1" /></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase1 = ex_1($phrase1);
        echo $phrase1;
    }




echo"<br>";
/* ------------------------- Ecercice 2 ------------------------------ */ 

function ex_2($phrase, $decalageDemande){
    $alphabetDecale = genere_alphabet($decalage = $decalageDemande);
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
        <p><input type="submit" value="Envoyer"></p>
    </form>

    <?php
    } 
    else {
        $phrase2 = $_POST["phrase2"];
        $decalage = $_POST["decalage"];
        ?> 

        <form method="POST">
            <p>Phrase à crypter : <input type="text" name="phrase2" /></p>
            <p>Decalage : <input type="int" name="decalage" /></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase2 = ex_2($phrase2, $decalage);
        echo $phrase2;
    }





echo"<br>";
/* ------------------------- Ecercice 3 ------------------------------ */ 

function ex_3($phrase, $cleEntre){
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
    return($phrase);
}


echo"<p><strong>---------------- Exercice 3 ------------------</strong></p>";
if(!isset($_POST['phrase3'])) {
    ?>
    
    <form method="POST">
        <p>Phrase à crypter : <input type="text" name="phrase3" /></p>
        <p>Clé : <input type="text" name="cle" /></p>
        <p><input type="submit" value="Envoyer"></p>
    </form>

    <?php
    } 
    else {
        $phrase3 = $_POST["phrase3"];
        $cle = $_POST["cle"];
        ?> 

        <form method="POST">
            <p>Phrase à crypter : <input type="text" name="phrase3" /></p>
            <p>Clé : <input type="text" name="cle" /></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase3 = ex_3($phrase3, $cle);
        echo $phrase3;
    }






echo"<br>";
/* ------------------------- Ecercice 4 ------------------------------ */ 

function ex_4($phrase, $cleVigenere){
    $alphabetsVigenere = array();
    for($i=0; $i<strlen($cleVigenere); $i++){
        array_push($alphabetsVigenere, genere_alphabet($decalage = (ord(strtolower($cleVigenere[$i]))-97)));
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
        <p><input type="submit" value="Envoyer"></p>
    </form>

    <?php
    } 
    else {
        $phrase4 = $_POST["phrase4"];
        $cleVigenere = $_POST["cleVigenere"];
        ?> 

        <form method="POST">
            <p>Phrase à crypter : <input type="text" name="phrase4" /></p>
            <p>Clé de Vigenère : <input type="text" name="cleVigenere" /></p>
            <p><input type="submit" value="Envoyer"></p>
        </form>

        <?php
        
        $phrase4 = ex_4($phrase4, $cleVigenere);
        echo $phrase4;
    }
