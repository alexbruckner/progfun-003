package week6

object minidatabase {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val books: List[Book] = List(
  	Book(title   = "Structure and Interpretation of Computer Programs",
  			 authors = List("Abelson, Harald", "Sussman, Gerald Jr.")),
  	Book(title   = "Introduction to Functional Programming",
  			 authors = List("Bird, Richard", "Wadler, Phil")),
  	Book(title   = "Effective Java",
  			 authors = List("Bloch, Joshua")),
    Book(title   = "Effective Java 2",
  			 authors = List("Bloch, Joshua")),
  	Book(title   = "Java Puzzlers",
  			 authors = List("Bloch, Joshua", "Gafter, Neil")),
  	Book(title   = "Programming in Scala",
  			 authors = List("Odersky, Martin", "Spoon, Lex", "Venners, Bill"))
  )                                               //> books  : List[week6.Book] = List(Book(Structure and Interpretation of Comput
                                                  //| er Programs,List(Abelson, Harald, Sussman, Gerald Jr.)), Book(Introduction t
                                                  //| o Functional Programming,List(Bird, Richard, Wadler, Phil)), Book(Effective 
                                                  //| Java,List(Bloch, Joshua)), Book(Effective Java 2,List(Bloch, Joshua)), Book(
                                                  //| Java Puzzlers,List(Bloch, Joshua, Gafter, Neil)), Book(Programming in Scala,
                                                  //| List(Odersky, Martin, Spoon, Lex, Venners, Bill)))
  for (b <- books; a <- b.authors if a startsWith "Bird,")
  yield b.title                                   //> res0: List[String] = List(Introduction to Functional Programming)
  
  for (b <- books if (b.title indexOf "Program") >= 0)
  yield b.title                                   //> res1: List[String] = List(Structure and Interpretation of Computer Programs,
                                                  //|  Introduction to Functional Programming, Programming in Scala)
                                
  for (b <- books if b.authors contains "Bloch, Joshua")
  yield b.title                                   //> res2: List[String] = List(Effective Java, Effective Java 2, Java Puzzlers)
                                
   
  //names of authors with at least two books
	 (for {
	  	b1 <- books
	  	b2 <- books
	  	if b1.title < b2.title
	  	a1 <- b1.authors
	  	a2 <- b2.authors
	  	if a1 == a2
	  } yield a1
   ).distinct                                     //> res3: List[String] = List(Bloch, Joshua)
   // or make books a Set
   
   // below as higher order functions:
   for (b <- books; a <- b.authors if a startsWith "Bird")
   yield b.title                                  //> res4: List[String] = List(Introduction to Functional Programming)
  
   // would be
   
   //step 1
   books flatMap (b =>
   	for (a <- b.authors if a startsWith "Bird") yield b.title
   )                                              //> res5: List[String] = List(Introduction to Functional Programming)
     
   //step 2
   books flatMap (b =>
   	for (a <- b.authors withFilter(a => a startsWith "Bird")) yield b.title
   )                                              //> res6: List[String] = List(Introduction to Functional Programming)
   
   //step 3 ???
   //books flatMap (b =>
   //	b.authors withFilter(a => a startsWith "Bird") map (y => y.title))
   
   // can have custom types in for expressions as long as they define flatMap, withFilter and map
   // see ScalaQuery or Slik for actual database access
   
   
}

case class Book(title: String, authors: List[String])