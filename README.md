# GameOfWar
A recreation of the card game "War" in Java

##How to run
To run a simple game of War, just execute the runScript.sh
> ./runScript.sh

However, for debuging/testing purposes there are also some addition modes:

###Fast Mode
Fast mode causes the game to run 10 rounds before pausing.
This mode pauses right after the card totals are reported.
To run in fast mode, append "-f" to the end of the script call
> ./runScript.sh -f

###Instant Mode
Instant mode causes the game to run without pause.
This is the fastest way to get a final victory, but a winner may never occur.
On average, most ends occur within a few thousand rounds (a couple seconds).
To run in instant mode, append "-i" to the end of the script call
> ./runScript.sh -i