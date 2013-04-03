HSTreader
=========

This is a program that can process HST files and interpret the data
to a required format. Currently that format is sorting each file and
picking the last line of each value out and placing it in a results file.

This version includes a GUI and is compatible with any computer running Java 1.6 or greater.

Usage
----

To use the GUI run the program without any arguments.
This usually means double clicking on it.

To run this program use the following format:

```console
java -jar HSTreader.jar [Input Directory] [Output file]
```

To execute this program on a single file use the following format:

```console
java -jar HSTreader.jar [SomeFile.hst]
```

Note: It must not have an output file! To test the reader on a file, you
will have to rely on the console output.

Coming soon
----
* WebApplet Version (To replace the JavaFX)

Requirements
----
Java 6 or greater.

How to compile
----
1. Install Maven 3
2. Open this directory and type `mvn clean package`
3. Build will be in the target directory ready to go.
