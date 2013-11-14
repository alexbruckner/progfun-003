package week6

object forexpressions {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  case class Person(val name: String, val age: Int)
  
  val persons = List(Person("p 12", 12), Person("p 21", 21), Person("p 23", 23))
                                                  //> persons  : List[week6.forexpressions.Person] = List(Person(p 12,12), Person(
                                                  //| p 21,21), Person(p 23,23))
  
  persons filter (p => p.age > 20) map (p => p.name)
                                                  //> res0: List[String] = List(p 21, p 23)
  // clearer with for expression:
  for (p <- persons if p.age > 20) yield p.name   //> res1: List[String] = List(p 21, p 23)
  
}