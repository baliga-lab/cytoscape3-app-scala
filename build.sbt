import sbt.Package.ManifestAttributes

name         := "cytoscape-app-scala"

version      := "1.0"

organization := "org.systemsbiology"

scalaVersion := "2.9.2"

javacOptions in Compile ++= Seq("-target", "6", "-source", "6")

scalacOptions ++= Seq("-unchecked", "-deprecation")

packageOptions := Seq(ManifestAttributes(               
               ("Cytoscape-App-Version", "0.1"),
               ("Cytoscape-App-Name", "HideSingletonNodesApp"),
               ("Cytoscape-App", "HideSingletonNodesApp"),
               ("Cytoscape-App-Works-With", "3.0")))

resolvers += "official Maven mirror" at "http://mirrors.ibiblio.org/pub/mirrors/maven2/"

resolvers += "Gaggle maven" at "http://como.systemsbiology.net/maven/repo-releases"

libraryDependencies ++= Seq("org.cytoscape" % "cytoscape-api" % "3.0.0-beta2" % "provided")

seq(ProguardPlugin.proguardSettings: _*)

proguardLibraryJars <++= (update) map (_.select(module = moduleFilter(name = "cytoscape-api")))

proguardOptions ++= Seq("-keep class HideSingletonNodesApp { public protected *; }",
			"-keep class MenuAction { public protected *;} ")

