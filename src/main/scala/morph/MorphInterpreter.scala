package morph
import MorphAST._
object MorphInterpreter {
	def interpret(program:List[Node]) {
		for(n <- program)
			n match {
			case Env(cases) => ()
			case EnvCase(matching,giving) => ()
			case Symbol(s) => ()
			}
	}
}