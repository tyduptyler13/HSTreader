HSTreader
=========

Custom reader for hst data files. Keep in mind this is a pretty raw version of this and the source needs to be cleaned up.

TODO
----
* Finish GUI version.

How to use
----
Open the directory with HSTreader.jar and run the following:
```
java -jar HSTreader.jar [Input Directory] [output file]
```
This is the main way to operate the program.

Ex:
`java -jar HSTreader.jar C:\Users\Tyler\Downloads out.txt`

To test its use on a single file you may feed it directly:
`java -jar HSTreader.jar "C:\Users\Tyler\Downloads\A10\A10\M1\Participant 11, Trial 1 on 9-5-2012 at 9.46.08 AM.hst"`

This will invoke only the file reader and test its output and sorting.

Current requirements
----
You must have java 7 installed on your computer.

Future plans
----
- GUI (JavaFX)
- WebApplet (JavaFX)
- Cleanup JavaDoc and comments
