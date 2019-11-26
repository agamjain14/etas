scalariformSettings(autoformat = false)
scalaVersion in ThisBuild := "2.11.11"

lazy val baseSettings = Seq(
  organization := "net.etas",
  scalaVersion := "2.11.11",
  scalacOptions ++= Seq("-deprecation", "-feature", "-unchecked"),
  parallelExecution in Test := false,
  sources in (Compile,doc) := Nil,
  com.typesafe.sbt.SbtScalariform.ScalariformKeys.preferences := {
    import scalariform.formatter.preferences._
    FormattingPreferences()
      .setPreference(AlignSingleLineCaseStatements, true)
      .setPreference(DoubleIndentConstructorArguments, true)
      .setPreference(NewlineAtEndOfFile, true)
      .setPreference(RewriteArrowSymbols, false)
      .setPreference(SpacesAroundMultiImports, false)
      .setPreference(DanglingCloseParenthesis, Force)
  },
  resolvers ++= Seq(
    Resolver.typesafeRepo("releases"),
    Resolver.typesafeRepo("snapshots"),
    Resolver.sonatypeRepo("releases"))
)

lazy val commonSettings = baseSettings

lazy val etasCommon = (project in file("etas-common"))
  .settings(commonSettings, libraryDependencies ++= Dependencies.etasCommon)


lazy val etasClientApi = (project in file("etas-client-api"))
  .enablePlugins(play.sbt.PlayScala)
  .settings(
    libraryDependencies ++= Dependencies.etasClientApi)
  .dependsOn(etasCommon)

lazy val root = (project in file("."))
  .aggregate(
    etasCommon,
    etasClientApi
  )
  .settings(commonSettings)