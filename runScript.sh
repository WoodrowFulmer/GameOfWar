#!/bin/bash
javac src/*.java -d ./

if [[ "$1" == -f ]]
then
	java bin/GameOfWar -f
else
	if [[ "$1" == -i ]]
	then
		java bin/GameOfWar -i
	else
		java bin/GameOfWar
	fi
fi
