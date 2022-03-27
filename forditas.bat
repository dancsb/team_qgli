@echo off
mkdir class
dir /s /B *.java > source.txt
javac -d class @source.txt
del source.txt
exit
