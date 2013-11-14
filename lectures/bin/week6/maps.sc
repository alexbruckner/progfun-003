package week6

object maps {
  

	val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
                                                  //> romanNumerals  : scala.collection.immutable.Map[String,Int] = Map(I -> 1, V -
                                                  //| > 5, X -> 10)
  val capitalOfCountry = Map("US" -> "Washington", "Switzerland" -> "Bern")
                                                  //> capitalOfCountry  : scala.collection.immutable.Map[String,String] = Map(US -
                                                  //| > Washington, Switzerland -> Bern)
  
  //maps are functions Key => Value
  capitalOfCountry("US")                          //> res0: String = Washington
  //capitalOfCountry("XXX") // throws Exception

	
	capitalOfCountry get "US"                 //> res1: Option[String] = Some(Washington)
	capitalOfCountry get "XXX"                //> res2: Option[String] = None
	

	def showCapital(country: String) = capitalOfCountry get country match {
			case Some(captial) => captial
			case None => "missing data"
	}                                         //> showCapital: (country: String)String

	//showCaptial("US") ???
	//showCaptial("XXX") ???
	
	val fruit = List("apple", "pear", "orange", "pineapple")
                                                  //> fruit  : List[String] = List(apple, pear, orange, pineapple)
	fruit sortWith (_.length < _.length)      //> res3: List[String] = List(pear, apple, orange, pineapple)
	fruit sorted                              //> res4: List[String] = List(apple, orange, pear, pineapple)
	
	fruit groupBy (_.head)                    //> res5: scala.collection.immutable.Map[Char,List[String]] = Map(p -> List(pear
                                                  //| , pineapple), a -> List(apple), o -> List(orange))
	
}