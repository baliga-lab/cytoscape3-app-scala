## cytoscape3-app-scala - A starting point for writing Cytoscape 3.x apps in Scala

### Description

This is a small project setup that can be used as a starting point to create apps for Cytoscape 3.x. It provides a minimal source tree that contains the example from the Cytoscape developer tutorial, rewritten in Scala.

Most important, it comes with an SBT setup that includes an automatic dependency to the Cytoscape 3.x API and a Proguard configuration to package the final product as a jar file that contains only the necessary dependencies from the Scala runtime library.

### Requirements

This project was tested on Scala 2.9.2, OpenJDK 7, Proguard 4.7 and sbt 0.12.
In order to get this to run, the sbt-proguard-plugin must be checked out from

	https://github.com/siasia/xsbt-proguard-plugin

the pull request for the SBT version 0.12.0 API must be applied and the
project then built with

	sbt publish-local

This is a small inconvenience, hopefully this is resolved in the near future.

### Usage

	sbt clean package proguard

Should build the example project out of the box, for your own apps, the
build.sbt file should be modified accordingly

