import scala.collection.mutable.ListBuffer
object FizzBuzz {
  def fizzBuzz(n: Int): List[String] = {
    var result = new ListBuffer[String]()
    for( i <- 1 to n) {
      (i % 3 , i % 5) match {
        case (0,0) => result += "FizzBuzz"
        case (0,_) => result += "Fizz"
        case (_,0) => result += "Buzz"
        case _ => result += ("" + i)
      }
    }
    result.toList
  }

  def main(args: Array[String]): Unit = {
    fizzBuzz(15).foreach(println)
  }
}