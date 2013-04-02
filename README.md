HSTreader
=========

This is a program that can process HST files and interpret the data
to a required format. Currently that format is sorting each file and
picking the last line of each value out and placing it in a results file.

Currently the JavaFX has proved to be incompatible with most systems and
thus I have started writing a new interface. This should be ready soon.

Usage
----
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
* Swing Version (To replace JavaFX)

Requirements
----
Java 6 or greater.