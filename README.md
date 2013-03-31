HSTreader
=========

Custom reader for hst data files. The GUI will work if you are running windows and have Java 7.
Otherwise please refer to the method below.

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
You must have the LATEST java 7 installed on your computer.

Known Issues
----
* Some compatibility issues with GUI and other Systems. Will compile a version for Linux and PC. (No mac access so I can't compile for it)
* Some computers will prevent you from selecting folders without admin rights. You may need to run with elevated priveledges.

Future plans
----
- WebApplet (JavaFX)
- Cleanup JavaDoc and comments
