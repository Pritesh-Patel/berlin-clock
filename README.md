#Berlin Clock

A Scala project that converts 24H time into its berlin clock representation.

The time should be entered in this format: "HH:MM:SS".

Please ensure you have SBT installed.

To run:

    sbt "run 24H_TIME"
  
Example run:

    sbt "run 09:40:01"
  
  To run tests:
  

    sbt test

Clock representation:
-   "0" - Lamp is off
-   "R" - Red lamp is on
-   "Y" - Yellow lamp is on

Libraries used:
 - ScalaTest
