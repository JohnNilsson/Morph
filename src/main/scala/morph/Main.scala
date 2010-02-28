package morph

import java.io._
import MorphAST._
object Main {
  val expr = "(main:Hello World)";

  def main(args:Array[String]):Unit = {
	  for(f <- new File("./pgm").listFiles; if f.isFile)
	 	println(f + ": " + MorphParser.parse(f))
  }
}
