package String

object ReverseString extends App{
  def reverseString(s: String): String = {
    (for(i<-s.length-1 to 0 by -1) yield s(i)).mkString
  }


  def test(): Unit = {
    reverseString("LEETCODE").foreach(print)
  }
  test()
}