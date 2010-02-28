package morph

import MorphAST._
import java.io._
import scala.util.parsing.combinator._
object MorphParser extends RegexParsers with PackratParsers {

	def term = (env | SYM)+

	def envCase = term ~ ((":"  ~> term)?) ^^ {
		case t1 ~ t2 => EnvCase(t1,t2)
	}

	def env: Parser[Env] = (
		  "(" ~> repsep(envCase, ",") <~ ")"
		| "{" ~> repsep(envCase, (";"|NL)+) <~ "}") ^^ { Env(_) }

	val SYM = "[^\\s(){}:,;]+".r ^^ { Symbol(_) }
	val NL = "\r\n" | "\r" | "\n"

	def parse(f:File) = {
		val r = new FileReader(f)
		try {
			parseAll(term,r)
		} finally r.close()
	}
}