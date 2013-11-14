package week2

object HigherOrderFunctions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def product (f: Int => Int) (a: Int, b: Int) : Int = {
  	if (a > b) 1
  	else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x * x)(3, 4)                       //> res0: Int = 144
  Math.pow(3,2)*Math.pow(4,2)                     //> res1: Double = 144.0


  def factorial(n: Int) = product(x => x)(1, n)   //> factorial: (n: Int)Int
  
  factorial(5)                                    //> res2: Int = 120
  
  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int) : Int = {
  
  	if (a > b) zero
    else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int
          
  def product2(f: Int => Int) (a: Int, b: Int) : Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
  product2(x => x * x)(3, 4)                      //> res3: Int = 144
          
  def sum2(f: Int => Int) (a: Int, b: Int) : Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
                                                  //> sum2: (f: Int => Int)(a: Int, b: Int)Int
  sum2(x => x * x)(3, 4)                          //> res4: Int = 25
          
          
}