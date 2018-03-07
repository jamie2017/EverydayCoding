package HashMap
import org.scalatest.FunSuite

/**
  * This class is a test suite for the methods in object TwoSum. To run
  * the test suite, you can either:
  *  - run the "test" command in the SBT console
  */
class TwoSumTest extends FunSuite {
  import TwoSum._
  test("Hello Two Sum") {
    assert(twoSum(Array(2, 7, 11, 15), 9) sameElements Array(0, 1))
  }

}
