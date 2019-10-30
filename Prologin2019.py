def fuel(n, p):
    """
    :param n: le nombre de membres dans l'équipage
    :type n: int
    :param p: le poids de chaque passager
    :type p: list[int]
    """
    pd_carburant = 0
    for i in range(n):
        if p[i] > 90:
            pd_carburant += 80
        else:
            pd_carburant += 60
            

'''
if __name__ == '__main__':
    n = int(input())
    p = list(map(int, input().split()))
    fuel(n, p)
'''


def interferences(n, s):
    """
    :param n: la longueur du message
    :type n: int
    :param s: le message
    :type s: str
    """
    # TODO Affichez le message sans les interférences.
    message = ""
    i = 0
    while i<len(s):
        if s[i] == ".":
            pass
        elif s[i] == "*":
            i += 1
            while i<len(s) and s[i]!="*":
                i += 1
                pass
        else:
            message += s[i]
        i += 1
    print(message)

'''
if __name__ == '__main__':
    n = int(input())
    s = input()
    interferences(n, s)
'''


def marche_nocturne(n, liste_prix, b):
    """
    :param n: nombre de minerai rare
    :type n: int
    :param liste_prix: liste des prix de chaque minerai
    :type liste_prix: list[int]
    :param b: le total d'argent que vous souhaitez dépenser dans ce souvenir
    :type b: int
    """
    # TODO Le nombre minimal de minerai que vous rapporterez, ou -1 si ce n'est
    # pas possible de résoudre le problème.
    somme = 0
    nb_minerais = 0
    for i in range(n):
        if somme < b:
            somme += liste_prix[i]
            nb_minerais += 1
        elif somme == b:
            return(nb_minerais)
        elif somme > b:
            somme = 0
            nb_minerais = 0
        
    return(-1)


if __name__ == '__main__':
    n = int(input())
    liste_prix = list(map(int, input().split()))
    b = int(input())
    #print(marche_nocturne(6, list(map(int, '4 7 3 10 1 9'.split())), 14))
    print(marche_nocturne(n, liste_prix, b))

