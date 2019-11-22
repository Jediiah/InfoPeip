
<?php

function compare_temps($temps1, $temps2){
    # on convertit les temps initialement au format str(mm : ss : cc)
    #   au format array(int(mm), int(ss), int(cc))
    $temps1 = array_map('intval', explode(' : ', $temps1));
    $temps2 = array_map('intval', explode(' : ', $temps2));

    # on convertit en centiemes de secondes
    $temps1 = $temps1[0]*600 + $temps1[1]*100 + $temps1[2];
    $temps2 = $temps2[0]*600 + $temps2[1]*100 + $temps2[2];

    # on compare les temps et renvoie vrai si le temps1 est superieur au temps2
    return($temps1>$temps2);
}

/* On utilisera une base XML triée par ordre de départ (listeDepart.xml) et une autre triée par ordre d'arrivée (listeArrive.xml):
<skieurs>
    <skieur>
        <numero_dossard> </numero_dossard>
        <nom> </nom>
        <prenom> </prenom>
        <pays> </pays>
    </skieur>
</skieurs>

En plus de sa compatibilité avec PHP grace à SimpleXML ce format permet d'organiser parfaitement 
le classementet et le fichier texte est facilement lisible.
https://www.w3schools.com/Php/php_ref_simplexml.asp
*/

