
RMDIR /S /Q "release/%2-%3"

"%~1\bin\jlink" --module-path ./bin --add-modules %2 --output release/%2-%3

echo @start "" "%~dp0\release\%2-%3\bin\javaw" -m NationGen/nationGen.GUI.GUI > ./release/%2-%3/NationGen.bat
echo @start "" "%~dp0\release\%2-%3\bin\javaw" -m NationGen/nationGen.GUI.SpriteGen > ./release/%2-%3/SpriteGen.bat