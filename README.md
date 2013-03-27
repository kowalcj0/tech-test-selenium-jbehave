# yell.com using Java with Spring, Selenium and JBehave

Simple project based on the JBehave tutorial available at [github](https://github.com/jbehave/jbehave-tutorial)

## Pre-requisits
JDK 6+
Maven 2+
Firefox


## Windows configuration

Once all the required tools are installed, create two new system variables:
JAVA\_HOME e.g.: JAVA\_HOME=C:\Program Files\Java\jdk1.7.0\_10
and
M2\_HOME e.g.: M2\_HOME=C:\Program Files\apache-maven-3.0.5

and add paths to the firefox, java and maven folders containing corresponding binaries to the Path variable:
e.g: Path=WHATEVER\_WAS\_THERE\_BEFORE;C:\Program Files\Java\jdk1.7.0\_10\bin\;C:\Program Files\apache-maven-3.0.5\bin\;C:\Program Files (x86)\Mozilla Firefox\


## Linux configuration

Is similar to Windows one.
Simply make sure that:
* JAVA\_HOME and M2\_HOME system variables are properly set.
* firefox binary is on the PATH



## Running the stories

This will run the build and (after a minute or so) Firefox will open and test the etsy.com website:

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
2. src/main/stories contains the stories run by JBehave via EtsyDotComStories.java.
3. src/main/java/com/yelllabs/techtest/steps/Steps.java contains the steps mapped to the textual steps.
4. src/main/java/com/yelllabs/techtest/pages contains the Java page-objects used by steps to abstract in a more manageable and maintainable way the interaction with the web pages via Selenium WebDriver.
5. src/main/resources/techtest-steps.xml contains the Spring configuration for composition the steps


