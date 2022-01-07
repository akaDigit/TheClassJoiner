<h1 align="center">TheClassJoiner</h1>
<p align = "center">This Repository contains the files for the project "TheClassJoiner".</p>
<p align="center">TheClassJoiner is an <strong>Executable Jar File</strong> which will <strong>automatically</strong> join and leave my classes for me.
It is all created in Java. </p>

<p align="center">The <a href="https://www.selenium.dev/">OpenQA Selenium Library</a> was used to handle web pages and the <a href="https://poi.apache.org/">Apache POI Library</a> was used to access and manage the spreadsheet.</p>

## How to Run the File.

To run the file, run this command in the terminal.
- `start javaw -jar --enable-preview TheClassJoiner.jar`

## Does it keep running?

The jar will keep running in the background till school comes to an end (2PM)

## What if you want to stop it?

<p> To stop the application from running, execute</p>
- `taskkill /f /im javaw.exe /t`

<p>and if this gives an error, use</p>
- `taskkill /f /im java.exe /t`

irrespective of whether this gives an error, the application has stopped running.

## Is there a safer way to make it stop?

Not yet, but i'm planning to create a keybind which will terminate the application.
