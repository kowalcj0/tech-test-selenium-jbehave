# yell.com using Java with Spring, Selenium and JBehave

Simple project based on the JBehave tutorial available at [github](https://github.com/jbehave/jbehave-tutorial)

## Pre-requisits

* JDK 6+
* Maven 2+
* Firefox 10+


## Windows configuration

Once all the required tools are installed:
* create two new system variables:
    * JAVA\_HOME e.g.: JAVA\_HOME=C:\Program Files\Java\jdk1.7.0\_10
    * M2\_HOME e.g.: M2\_HOME=C:\Program Files\apache-maven-3.0.5

* add paths to the firefox, java and maven folders containing corresponding binaries to the Path variable, e.g.:

    Path=WHATEVER\_WAS\_THERE\_BEFORE;C:\Program Files\Java\jdk1.7.0\_10\bin\;C:\Program Files\apache-maven-3.0.5\bin\;C:\Program Files (x86)\Mozilla Firefox\

NOTES:
* More information on [FirefoxDriver] [1] 
* Handy [tutorial](http://www.computerhope.com/issues/ch000549.htm) on setting $PATH and environmental variables in Windows.
* FF binary (firefox.exe) can usually be found in %PROGRAMFILES%\Mozilla Firefox


## Linux configuration

Is similar to Windows one.
Simply make sure that:
* JAVA\_HOME and M2\_HOME system variables are properly set.
* folder with Firefox binary is in your $PATH system variable

NOTES:
* More information on [FirefoxDriver] [1] 
* Handy [tutorial](http://www.cyberciti.biz/faq/set-environment-variable-linux/) on setting $PATH and environmental variables under \*nix systems.
* Another one just on setting up the [java path variable](http://www.cyberciti.biz/faq/linux-unix-set-java_home-path-variable/).
* FF binary can be found using "which" command.


## Mac configuration

Same thing as with Windows and Linux
You need to make sure that:
* JAVA\_HOME and M2\_HOME are set accordingly
* folder with Firefox binary is in your $PATH system variable

NOTES:
* More information on [FirefoxDriver] [1] 
* Here's a nice [tutorial](http://www.semioticpixels.com/crib-notes/mac-10-7-path-settings-and-environment-variables) on setting $PATH and environmental variables in Mac.
* Usually FF binary (filename is firefox-bin) is placed in:
    
    /Applications/Firefox.app/Contents/MacOS/


## Add new user story

Create a new text file with '.story' extension in the src/main/stories folder.
Then write down the body of the user story you want to run.


## Running all the stories in IDE

IntelliJ Idea 12
* Right-click on the Stories class, select "Run 'Stories'"

Eclipse EE Juno SR2 with M2E plugin v1.3.0
* Right-click on the Stories class, select "Run as" -> "JUnit Test"

## Running a single story in IDE

Go to the 'RunSingleStory.java' method 'runTest' and change the name of the user story you want to run.
Remember that the story name has to be exactly the same as the story filename but without the '.story' extension.

After that in:

IntelliJ Idea 12
* Right-click on the RunSingleStory class, select "Run 'RunSingleStory'"

Eclipse EE Juno SR2 with M2E plugin v1.3.0
* Right-click on the RunSingleStory class, select "Run as" -> "JUnit Test"


## Running stories from the command line

This will run the build and (after a minute or so) Firefox will open and test the yell.com website:

    mvn clean install 

You should see Firefox (installed on your system) flicker as it tests yell.com

This will run a single story (one contained in a searchFromHomePage.story file):

    mvn clean install -DstoryFilter=searchFromHomePage

This will run a suite based on the meta filters in the three story files:

    mvn clean install -Dmeta.filter="+page home"

## Viewing the results

After each run new report can be found in target/jbehave/view. 
Report file is named: 'reports.html'
There should be a row for each story.
The story reports are clickable to via links on the right-most column.

## Using this tutorial to start your own JBehave-based integration tests for a web site.

The tutorial aims to provide a fully-functional project that you can use to model you own project:

1. src/main/java/com/yelllabs/techtest/Stories.java is the entry-point that JBehave uses to run the stories.
2. src/main/stories contains the stories run by JBehave via Stories.java.
3. src/main/java/com/yelllabs/techtest/steps/Steps.java contains the steps mapped to the textual steps.
4. src/main/java/com/yelllabs/techtest/pages contains the Java page-objects used by steps to abstract in a more manageable and maintainable way the interaction with the web pages via Selenium WebDriver.
5. src/main/resources/techtest-steps.xml contains the Spring configuration for composition the steps




[1]: http://code.google.com/p/selenium/wiki/FirefoxDriver   "FirefoxDriver"
