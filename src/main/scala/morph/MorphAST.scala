package morph

object MorphAST {
	abstract class Node
	case class Symbol(name:String) extends Node
	case class EnvCase(matching:List[Node],result:Option[List[Node]]) extends Node
	case class Env(cases:List[EnvCase]) extends Node
}
