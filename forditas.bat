echo off

goto(){
mkdir class
touch source.txt
find . -iname "*.java" > source.txt
javac -d class @source.txt
rm -f source.txt
}

goto $@
exit

:(){
mkdir class
type nul > source.txt
dir /s /B *.java > source.txt
javac -d class @source.txt
del source.txt
exit