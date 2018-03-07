package String
import org.scalatest.FunSuite

/**
  * This class is a test suite for the methods in object ReverseString. To run
  * the test suite, you can either:
  *  - run the "test" command in the SBT console
  */
class ReverseStringTest extends FunSuite {
  import ReverseString._
  test("ReverseString.reverseString") {
    assert(reverseString("EDOCTEEL") == "LEETCODE")
  }

}
