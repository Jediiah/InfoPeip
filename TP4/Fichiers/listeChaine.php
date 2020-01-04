<?php

//Classe
class Element{
    public $valeur;
    public $pSuiv = NULL;
}


//Fonctions
function cree_liste(){
    $pTete = new Element();
    $pTete->valeur = 'T';
    return $pTete;
}


function cree_liste10(){
    $pTete = cree_liste();
    $pEncours = $pTete;

    for($i=0; $i<10; $i++){
        $pNouv = new Element();
        $pNouv->valeur = $i;
        $pEncours->pSuiv = $pNouv;
        $pEncours = $pNouv;
    }

    return $pTete;
}

function parcours_liste($pTete){
    $pEncours = $pTete->pSuiv;
    while($pEncours!=NULL){
        echo $pEncours->valeur." ";
        $pEncours = $pEncours->pSuiv;
    }
    echo "<br>";
}


function recherche_liste($val, $pTete){
    $pEncours = $pTete->pSuiv;
    while($pEncours!=NULL){
        if($pEncours->valeur==$val){
            echo "Element trouvé <br>";
            return $pEncours;
        }
        #var_dump($pEncours); echo "<br>";
        $pEncours = $pEncours->pSuiv;
    }
    echo "Elément non trouvé <br>";
    return NULL;
}


function ajout_debut($pNouv, $pTete){
    $pNouv->pSuiv = $pTete->pSuiv;
    $pTete->pSuiv = $pNouv;
}


function ajout_apres($pNouv, $pPrec){
    $pNouv->pSuiv = $pPrec->pSuiv;
    $pPrec->pSuiv = $pNouv;
}


function ajout_avant($val, $vrech, $pTete){
    $pNouv = new Element;
    $pNouv->valeur = $val;
    $pPrec = recherche_liste($vrech, $pTete);

    if($pPrec==NULL){
        ajout_debut($pNouv, $pTete);
    }
    else{
        ajout_apres($pNouv,$pPrec);
    }
}


function suppr_prem($pTete){
    $pTete->pSuiv = $pTete->pSuiv->pSuiv;
}


function suppr_apres($pPrec){
    if($pPrec->pSuiv!=NULL){$pPrec->pSuiv = $pPrec->pSuiv->pSuiv;}
}


function suppr_valeur($val, $pTete){
    $pPrec = recherche_liste($val, $pTete);
    suppr_apres($pPrec);
}



// MAIN
/*
$lcv = cree_liste();
$lc10 = cree_liste10();
var_dump($lc10);
parcours_liste($lc10);
$pElem = recherche_liste(5, $lc10);
echo $pElem->valeur;
echo "<br>";
$pElem = recherche_liste(13, $lc10);
if($pElem!=NULL){echo $pElem->valeur;}
ajout_avant(60, 4, $lc10); echo "<br>";
ajout_avant("un", 23, $lc10); echo "<br>";
parcours_liste($lc10);
suppr_prem($lc10); parcours_liste($lc10); echo"<br>";
*/
?>
