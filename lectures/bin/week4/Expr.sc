package week4

object Expr {
	val s1 = new Test1(2)                     //> s1  : week4.Test1 = Test1(2)
	val s2 = new Test2(2)                     //> s2  : week4.Test2 = Test2(2)
	  
	s1.eval                                   //> res0: Int = 4
	s2.eval                                   //> res1: Int = 6
	
	def l1 = List(1,2,3)                      //> l1: => List[Int]
	
	Nil.::(4)                                 //> res2: List[Int] = List(4)
	
	  
}

trait Eval{

	def eval = this match {
		case Test1(x) => 2 * x
		case Test2(x) => 3 * x
	}

}
case class Test1(val n: Int) extends Eval
case class Test2(val n: Int) extends Eval
 