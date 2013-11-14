package week6

object forexprandHOfunctions {

	def mapFun[T, U](xs: List[T], f: T => U): List[U] =
	 for (x <- xs) yield f(x)                 //> mapFun: [T, U](xs: List[T], f: T => U)List[U]
	
	def flatMap[T, U](xs: List[T], f: T => Iterable[U]): List[U] =
	 for (x <- xs; y <- f(x)) yield y         //> flatMap: [T, U](xs: List[T], f: T => Iterable[U])List[U]
	
	def filter[T](xs: List[T], p: T => Boolean): List[T] =
	 for (x <- xs if p(x)) yield x            //> filter: [T](xs: List[T], p: T => Boolean)List[T]
	

	// compiler actually translates for expressions into terms of map, flatMap and lazy filter.
	// ie for (x <- e1) yield e2 =====> e1.map(x => e2)
	
	

}