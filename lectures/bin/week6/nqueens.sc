package week6

object nqueens {

	def queens(n: Int): Set[List[Int]] = {
	
		def placeQueens(k: Int): Set[List[Int]] =
			if (k == 0) Set(List())
			else
				for {
					queens <- placeQueens(k - 1)
					col <- 0 until n
					if isSafe(col, queens)
				} yield col :: queens
		placeQueens(n)
	}                                         //> queens: (n: Int)Set[List[Int]]
	
	def isSafe(col: Int, queens: List[Int]): Boolean = {
	  val rows = queens.length
	  val queensWithRow = (rows - 1 to 0 by -1) zip queens
		queensWithRow forall {
			case (r, c) => col != c && math.abs(col - c) != rows - r
		}
	}                                         //> isSafe: (col: Int, queens: List[Int])Boolean
	
	
	def show(queens: List[Int]) = {
	
	  val lines =
	  	for (col <- queens.reverse)
	  	yield Vector.fill(queens.length)("* ").updated(col, "X ").mkString
	  "\n" + (lines mkString  "\n")
	}                                         //> show: (queens: List[Int])String
	
	
	queens(4)                                 //> res0: Set[List[Int]] = Set(List(1, 3, 0, 2), List(2, 0, 3, 1))
	
	(queens(8) take 3 map show) mkString "\n" //> res1: String = "
                                                  //| * * * * * X * * 
                                                  //| * * * X * * * * 
                                                  //| * X * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| 
                                                  //| * * * * X * * * 
                                                  //| * * * * * * X * 
                                                  //| * X * * * * * * 
                                                  //| * * * X * * * * 
                                                  //| * * * * * * * X 
                                                  //| X * * * * * * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * X * * 
                                                  //| 
                                                  //| * * * * * X * * 
                                                  //| * * X * * * * * 
                                                  //| * * * * * * X * 
                                                  //| * * * X * * * * 
                                                  //| X * * * * * * * 
                                                  //| * * * * * * * X 
                                                  //| * X * * * * * * 
                                                  //| * * * * X * * * "
	
}