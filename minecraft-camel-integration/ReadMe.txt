Camel Java Router Project
=========================

=== How to build

To build this project use

    mvn install

=== How to run

You can run this example using

    mvn camel:run

=== More information

You can find more information about Apache Camel at the website: http://camel.apache.org/

***ADDITIONAL INFO***
You can generate jar with dependencies using:
mvn package

You can run the jar using:
java -jar <jarname>

Ensure that you have an application.properties file in the same directory as the jar
The application.properties file needs the following info:
username
prefix
logfile

The username is your Mineecraft username, whereas the prefix is the key combination that will be
used from the chat to trigger the Apache Camel route.  The logfile is the location where the application
should look for Minecraft's latest log file.  The repo has example values.


