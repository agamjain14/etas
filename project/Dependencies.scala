import sbt._


/**
  * Defines all the library dependencies.
  * All dependencies must be declared here.
  */
object Dependencies {

  private object MongoDB {
    val reactiveMongo: ModuleID = "org.reactivemongo" %% "reactivemongo" % "0.12.7" exclude("com.typesafe.play", "play-iteratees_2.11")
    val reactiveMongoPlayJson: ModuleID = "org.reactivemongo" %% "reactivemongo-play-json" % "0.12.7-play24"
  }


  private object Play {
    private val version = "2.5.15"

    val play: ModuleID = "com.typesafe.play" %% "play" % version
    val json: ModuleID = "com.typesafe.play" %% "play-json" % version
    val ws: ModuleID = "com.typesafe.play" %% "play-ws" % version
    val cache: ModuleID = "com.typesafe.play" %% "play-cache" % version
  }


  val etasCommon = Seq (
    Play.json,
    Play.ws,
    MongoDB.reactiveMongo,
    MongoDB.reactiveMongoPlayJson
  )
}
