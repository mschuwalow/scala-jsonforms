import sbt._

object Dependencies {
  object Versions {
    val organizeImports = "0.5.0"
  }
  import Versions._

  val Core = Nil

  val ScalaFix =
    List(
      "com.github.liancheng" %% "organize-imports" % organizeImports
    )
}
