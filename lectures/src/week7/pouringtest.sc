package week7

object pouringtest {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val problem = new Pouring(Vector(4,9))          //> problem  : week7.Pouring = week7.Pouring@13077c64
  
  
  //problem.moves
  //problem.pathSets.take(3).toList
  problem.solutions(6)                            //> res0: Stream[week7.pouringtest.problem.Path] = Stream(Fill(1) Pour(1,0) Empt
                                                  //| y(0) Pour(1,0) Empty(0) Pour(1,0) Fill(1) Pour(1,0)--> Vector(4, 6), ?)
  
  
  
  
}