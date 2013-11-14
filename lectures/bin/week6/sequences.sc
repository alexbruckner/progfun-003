package week6

object sequences {
  
	val xs = Array(1, 2, 3, 44)               //> xs  : Array[Int] = Array(1, 2, 3, 44)
  xs map (x => x * 2)                             //> res0: Array[Int] = Array(2, 4, 6, 88)
  
  val st = "Hello World"                          //> st  : String = Hello World
  st filter (c => c.isUpper)                      //> res1: String = HW
  
  val r:Range = 1 until 5                         //> r  : Range = Range(1, 2, 3, 4)
 
  val s:Range = 1 to 5                            //> s  : Range = Range(1, 2, 3, 4, 5)
 
 	1 to 10 by 3                              //> res2: scala.collection.immutable.Range = Range(1, 4, 7, 10)
 	
 	st exists (c => c.isUpper)                //> res3: Boolean = true
  st forall (c => c.isUpper)                      //> res4: Boolean = false
  
  val pairs = List(1, 2, 3) zip st                //> pairs  : List[(Int, Char)] = List((1,H), (2,e), (3,l))
  
  pairs.unzip                                     //> res5: (List[Int], List[Char]) = (List(1, 2, 3),List(H, e, l))
  
  st flatMap (c => List('.', c))                  //> res6: String = .H.e.l.l.o. .W.o.r.l.d
  
  xs.sum                                          //> res7: Int = 50
  
  xs.product                                      //> res8: Int = 264
  
  xs.max                                          //> res9: Int = 44
  
  xs.min                                          //> res10: Int = 1
  
  def scalarProduct1(xs: Vector[Double], ys: Vector[Double]): Double =
   (xs zip ys).map(xy => xy._1 *xy._2).sum        //> scalarProduct1: (xs: Vector[Double], ys: Vector[Double])Double
  
  def scalarProduct2(xs: Vector[Double], ys: Vector[Double]): Double =
   (xs zip ys).map{case (x, y) => x * y}.sum      //> scalarProduct2: (xs: Vector[Double], ys: Vector[Double])Double
   
  def isPrime(n: Int): Boolean = (2 until n) forall (d => n % d != 0)
                                                  //> isPrime: (n: Int)Boolean
  //using for-expression:
  
  def scalarProduct3(xs: Vector[Double], ys: Vector[Double]): Double =
   (for ((x, y) <- xs zip ys) yield x * y).sum    //> scalarProduct3: (xs: Vector[Double], ys: Vector[Double])Double
   
}