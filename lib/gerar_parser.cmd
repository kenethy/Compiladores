java -jar java-cup-11a.jar -parser Parser <..\src\xpress\version2\Parser.cup
move /Y *.java ..\src\xpress\version2\
@if [%1]==[] pause