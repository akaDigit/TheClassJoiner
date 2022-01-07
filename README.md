<h1 align="center">TheClassJoiner</h1>
<p align = "center">This Repository contains the files for the project "TheClassJoiner"</p>

<br/>

<p align="center">TheClassJoiner is an <strong>Executable Jar File</strong> which will <strong>automatically</strong> join and leave my classes for me.
It is all created in Java. </p>

<br/>

[Java 8u311 (jre1.8.0_311)](https://www.java.com/en/download/manual.jsp) and [JDK 17.0.1 (jdk-17.0.1)](https://www.oracle.com/java/technologies/downloads/#jdk17-windows) were created to use this file.

## How to Run the File.

To run the file, run this command in the terminal.
- `start javaw -jar --enable-preview TheClassJoiner.jar`

## Does it keep running?

The jar will keep running in the background till school comes to an end (2PM)

## What if you want to stop it?

To stop the application from running, execute - 
`taskkill /f /im javaw.exe /t`

and if this gives an error,
run - 

`taskkill /f /im java.exe /t`

irrespective of whether this gives an error, the application has stopped running.

## Is there a safer way to make it stop?

Not yet, but i'm planning to create a keybind which will terminate the application.
