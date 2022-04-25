@echo off
Xcopy bemenetek class\bemenetek /E /I > nul
Xcopy kimenetek class\kimenetek /E /I > nul
cd class
java main.Main
cd ..
