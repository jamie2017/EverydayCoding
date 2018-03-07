object Solution {
  def anagramMappings(A: Array[Int], B: Array[Int]): Array[Int] = {
    val indexMap = B.zipWithIndex.toMap
    A.map{indexMap.get(_).get.asInstanceOf[Int]}
  }

  def main(args: Array[String]){
    val A = Array(12, 28, 46, 32, 50)
    val B = Array(50, 12, 32, 46, 28)
    anagramMappings(A,B).foreach{println(_)}
  }

}


