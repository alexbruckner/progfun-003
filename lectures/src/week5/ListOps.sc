package week5

object ListOps {
  
  def removeAt(n: Int, xs: List[Int]) = (xs take n) ::: (xs drop n + 1)
                                                  //> removeAt: (n: Int, xs: List[Int])List[Int]

  val nums = List(2, -4, 5, 7, 1)                 //> nums  : List[Int] = List(2, -4, 5, 7, 1)
  val fruit = List("apple", "pineapple", "orange", "banana")
                                                  //> fruit  : List[String] = List(apple, pineapple, orange, banana)
  
  nums filter (x => x > 0)                        //> res0: List[Int] = List(2, 5, 7, 1)
  nums filterNot (x => x > 0)                     //> res1: List[Int] = List(-4)
  nums partition (x => x > 0)                     //> res2: (List[Int], List[Int]) = (List(2, 5, 7, 1),List(-4))
  
  nums takeWhile (x => x > 0)                     //> res3: List[Int] = List(2)
  nums dropWhile (x => x > 0)                     //> res4: List[Int] = List(-4, 5, 7, 1)
  nums span (x => x > 0)                          //> res5: (List[Int], List[Int]) = (List(2),List(-4, 5, 7, 1))
  
  
  val data = List("a", "a", "a", "b", "c", "c", "a")
                                                  //> data  : List[String] = List(a, a, a, b, c, c, a)
  
  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 =>
      val (first, rest) = xs span (y => y == x)
      first :: pack(rest)
  }                                               //> pack: [T](xs: List[T])List[List[T]]
  
  pack(data)                                      //> res6: List[List[String]] = List(List(a, a, a), List(b), List(c, c), List(a))
                                                  //| 
     
  def encode[T](xs: List[T]): List[(T, Int)] =
  	pack(xs) map (ys => (ys.head, ys.length)) //> encode: [T](xs: List[T])List[(T, Int)]
  
  encode(data)                                    //> res7: List[(String, Int)] = List((a,3), (b,1), (c,2), (a,1))
  
  
  def sum(xs: List[Int]) = (0 :: xs) reduceLeft ((x, y) => x + y)
                                                  //> sum: (xs: List[Int])Int
  def product(xs: List[Int]) = (1 :: xs) reduceLeft ((_ * _)) // (_ * _) is same as (x, y) => x * y
                                                  //> product: (xs: List[Int])Int
  
  sum(nums)                                       //> res8: Int = 11
  product(nums)                                   //> res9: Int = -280
  
  def sum2(xs: List[Int]) = (xs foldLeft 0) (_ + _)
                                                  //> sum2: (xs: List[Int])Int
  def product2(xs: List[Int]) = (xs foldLeft 1) (_ * _)
                                                  //> product2: (xs: List[Int])Int
  
  sum2(nums)                                      //> res10: Int = 11
  product2(nums)                                  //> res11: Int = -280
  
  def concat[T](xs: List[T], ys: List[T]): List[T] =
    (xs foldRight ys) (_ :: _)                    //> concat: [T](xs: List[T], ys: List[T])List[T]
  
  
  //def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  //  (xs foldRight List[U]())( ??? )

  //def lengthFun[T](xs: List[T]): Int =
  //  (xs foldRight 0)( ??? )
  
  
}