package HashMap

object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    //    nums.combinations(2).find(_.sum == target).get.map(nums.indexOf) // can't handle [3,3] 6
    val map = scala.collection.mutable.Map[Int, Int] ()
    var i = 0
    for(i <- nums.indices) {
      map.get(target - nums(i)) match {
        case None => {map.put(nums(i),i)}
        case Some(index) => return Array(index,i)
      }
    }
    Array(0,0)
  }
  def main(args: Array[String]){
    println("Hello Two Sum")
    val nums = Array(2, 7, 11, 15)
    val target = 9
    twoSum(nums,target).foreach(println)
  }
}

