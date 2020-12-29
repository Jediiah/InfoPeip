import os, sys, re, random

nb_track = int(sys.argv[1])
pathToFile = sys.argv[2]
probability = int(sys.argv[3]) / nb_track

fileTracks = open(pathToFile, 'r')
filePicks = open('Track_Picks.txt', 'w')

for i in range(nb_track):
    trackPath = fileTracks.readline()
    if random.random() < probability:
        filePicks.write(trackPath)

filePicks.close()
fileTracks.close()