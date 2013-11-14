package week2

object rationals {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val r = new Rational(1, 2)                      //> r  : week2.Rational = 1/2

  r.numer                                         //> res0: Int = 1

  val p = r.add(r)                                //> p  : week2.Rational = 1/1

  p.numer                                         //> res1: Int = 1
  p.denom                                         //> res2: Int = 1

  new Rational(2)                                 //> res3: week2.Rational = 2/1
  
  val q = r add r                                 //> q  : week2.Rational = 1/1

	val w = r + r                             //> w  : week2.Rational = 1/1
}

class Rational(x: Int, y: Int) {

  require(y != 0, "Denominator must not be zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  def add(that: Rational) =
    new Rational(
      numer * that.denom + denom * that.numer,
      denom * that.denom)
      
  def + (that: Rational) = add(that)

  override def toString() = numer + "/" + denom

}