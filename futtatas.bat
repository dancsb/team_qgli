@echo off
cd class
mkdir src
cd src
mkdir img
cd ..
cd ..
Xcopy src\img class\src\img /E/H/C/S/Y
cd class
java main.Main
cd ..
