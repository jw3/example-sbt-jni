lazy val `example-sbt-jni` =
  project.in(file("."))
  .aggregate(`core`, `native`)
  .settings(commonSettings: _*)

lazy val `native` =
  project.in(file("native"))
  .settings(commonSettings: _*)
  .settings(name := "example-sbt-jni-native")
  .enablePlugins(JniNative)

lazy val `core` =
  project.in(file("core"))
  .dependsOn(native % Runtime)
  .settings(commonSettings: _*)
  .settings(
    name := "example-sbt-jni",
    libraryDependencies ++= {
      Seq(
        "com.typesafe.akka" %% "akka-actor" % "2.4.17"
      )
    },
    target in javah := `native`.base / "src" / "native" / "include"
  )

lazy val commonSettings = Seq(
  organization := "com.github.jw3",
  version := "0.1",
  scalaVersion := "2.12.1",
  scalacOptions ++= Seq(
    "-encoding", "UTF-8",

    "-feature",
    "-unchecked",
    "-deprecation",

    "-language:postfixOps",
    "-language:implicitConversions",

    //"-Ywarn-unused-import", // JniNative plugin doesnt like this - "Unused import"
    //"-Xfatal-warnings",     // JniNative plugin doesnt like this - Deprecation warning on ProcessBuilder.lines
    "-Xlint:_"
  )
)
