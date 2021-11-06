import sbt._

object Dependencies {
  object Versions {
    val cats = "2.0.0"

    val circe = "0.14.1"

    val organizeImports = "0.6.0"
  }
  import Versions._

  val RJson = Seq(
    "org.typelevel" %% "cats-core" % cats
  )

  val ScalaFix = Seq(
    "com.github.liancheng" %% "organize-imports" % organizeImports
  )

  val Schema = Seq(
    "org.typelevel" %% "cats-core" % cats
  )
}
