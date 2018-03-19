name := "SparkLearner"

version := "1.0"


//Version config

val core = Map(

  "version" -> Map(
    "spark-sql" -> "1.4.1"
    ,"spark-core" -> "1.4.1"
  ),

  "dependency" -> Map(
    "org.apache.spark" -> Array( ("spark-core")
                                ,("spark-sql") )
  )
)
//Dependency config

val baseOptions = Defaults.coreDefaultSettings ++ Seq(
  scalaVersion := "2.10.6",
  fork := true,
  resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  libraryDependencies ++= core("dependency")
    .asInstanceOf[Map[String,Array[String]]]
    .flatMap{ case ( grp , childs ) =>
      childs map( artf => grp %% artf % _opt( artf ) )
    }
)


def _opt : String => String = core("version").asInstanceOf[Map[String , String]].getOrElse( _ , "provided" )
