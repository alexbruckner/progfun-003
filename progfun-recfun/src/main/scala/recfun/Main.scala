package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {

    def getValueAboveLeft(): Int = {
      if (r > 0 && c > 0) pascal(c - 1, r - 1) else 0
    }

    def getValueAboveRight(): Int = {
      if (r > 1 && c < r) pascal(c, r - 1) else 0
    }

    if (r > 1) getValueAboveLeft() + getValueAboveRight() else 1

  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def count(acc: Int, chars: List[Char]): Int = {
      if (chars.length == 0) acc
      else if (acc < 0) -1
      else if (chars.head == '(') count(acc + 1, chars.tail)
      else if (chars.head == ')') count(acc - 1, chars.tail)
      else count(acc, chars.tail)
    }

    count(0, chars) == 0

  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {

    def loop(money: Int, lcoins: List[Int], count: Int): Int = {
      if (lcoins.isEmpty || money < 0) 0
      else if (money == 0) count + 1
      else loop(money, lcoins.tail, count) + loop(money - lcoins.head, lcoins, count)
    }

    loop(money, coins, 0)

  }
}
