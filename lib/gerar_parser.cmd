java -jar java-cup-11a.jar -parser Parser -expect 1 <..\src\\doxa\version2\compiler\syntax\Parser.cup
move /Y *.java ..\src\doxa\version2\compiler\syntax
@if [%1]==[] pause