package week3

trait List[+T] {	//type variance - week 4
	def isEmpty: Boolean
	def head: T
	def tail: List[T]
	def prepend [U >: T] (elem: U) : List[U] = new Cons(elem, this) //week 4
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

object Nil extends List[Nothing] {
  def isEmpty = true
  def head = throw new NoSuchElementException("Nil.head")
  def tail = throw new NoSuchElementException("Nil.tail")
}

// week 4:
object List {
  //List(1, 2) = List.apply(1, 2)
  def apply[T](x1: T, x2: T) = new Cons(x1, new Cons(x2, Nil))
  def apply[T]() = Nil
}