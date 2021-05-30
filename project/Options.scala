import sbt._
import Keys._

object Options {

  def scalacOptions(
    scalaVersion: String,
    optimize: Boolean
  ) = {
    val baseOptions =
      CrossVersion.partialVersion(scalaVersion) match {
        case Some((2, 11)) =>
          Seq(
            "-feature",
            "-deprecation",
            "-explaintypes",
            "-unchecked",
            "-encoding",
            "UTF-8",
            "-language:higherKinds",
            "-language:existentials",
            "-Xfatal-warnings",
            "-Xlint:_,-type-parameter-shadow",
            "-Ywarn-value-discard",
            "-Ywarn-numeric-widen",
            "-Ywarn-unused",
            "-Yrangepos"
          )
        case Some((2, 12)) =>
          Seq(
            "-feature",
            "-deprecation",
            "-explaintypes",
            "-unchecked",
            "-encoding",
            "UTF-8",
            "-language:higherKinds",
            "-language:existentials",
            "-Xfatal-warnings",
            "-Xlint:_,-type-parameter-shadow",
            "-Ywarn-value-discard",
            "-Ywarn-numeric-widen",
            "-Ywarn-extra-implicit",
            "-Ywarn-unused",
            "-Yrangepos"
          )
        case Some((2, 13)) =>
          Seq(
            "-feature",
            "-deprecation",
            "-explaintypes",
            "-unchecked",
            "-encoding",
            "UTF-8",
            "-language:higherKinds",
            "-language:existentials",
            "-Xfatal-warnings",
            "-Xlint:_,-byname-implicit,-type-parameter-shadow",
            "-Ywarn-value-discard",
            "-Ywarn-numeric-widen",
            "-Ywarn-extra-implicit",
            "-Ywarn-unused",
            "-Yrangepos"
          )
        case _ => Seq.empty
      }

    val optimizeOptions =
      if (optimize)
        CrossVersion.partialVersion(scalaVersion) match {
          case Some((2, 11)) =>
            Seq.empty
          case Some((2, 12)) =>
            Seq("-opt:l:inline")
          case Some((2, 13)) =>
            Seq("-opt:l:inline")
          case _ =>
            Seq.empty
        }
      else Seq.empty

    baseOptions ++ optimizeOptions
  }
}
