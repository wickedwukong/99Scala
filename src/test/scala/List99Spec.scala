import org.specs2.mutable.Specification
import scala.Predef._
import org.specs2.matcher._
import org.specs2.runner.JUnitRunner

class List99Spec extends Specification {

  "last" should {
    "return the last element in a 2 element list" in {
      List99.last(List(1, 2)) must_== 2
    }

    "return the last element in a 3 element list" in {
      List99.last(List("a", "b", "c")) must_== "c"
    }

    "return the element in a one element list" in {
      List99.last(List(1)) must_== 1
    }

    "throw exception for empty list" in {
      List99.last(List[Any]()) must throwAn[Error]
    }
  }

  "penultimate" should {
    "return the first element in a 2 element list" in {
      List99.penultimate(List(1, 2)) must_== 1
    }

    "return the middle element in a 3 element list" in {
      List99.penultimate(List("a", "b", "c")) must_== "b"
    }

    "throw exception for 1 element list" in {
      List99.penultimate(List(1)) must throwAn[Error]
    }

    "throw exception for empty list" in {
      List99.last(List[Any]()) must throwAn[Error]
    }
  }

  "nth with parameter 0" should {
    "return the first element in a 1 element list" in {
      List99.nth(0, List(1)) must_== 1
    }

    "return the first element in a 2 element list" in {
      List99.nth(0, List("a", "b")) must_== "a"
    }

    "throw exception for 0 element list" in {
      List99.nth(0, List[Any]()) must throwAn[Error]
    }


  }

  "nth with parameter 1" should {
    "return the last element in a 2 element list" in {
      List99.nth(1, List(1, 2)) must_== 2
    }

    "return the second element in a 3 element list" in {
      List99.nth(1, List("a", "b", "c")) must_== "b"
    }

    "throw exception for 1 element list" in {
      List99.nth(1, List(1)) must throwAn[Error]
    }
  }

  "length" should {
    "return the 0 for an empty list" in {
      List99.length(List()) must_== 0
    }

    "return 1 for a 1 element list" in {
      List99.length(List("c")) must_== 1
    }

    "return 2 for a 2 element list" in {
      List99.length(List("a", "c")) must_== 2
    }

    "return 3 for a 3 element list" in {
      List99.length(List("a","b", "c")) must_== 3
    }
  }

  "flatten" should {
    "flatten non nested list" in {
      List99.flatten(List("a", "b")) must_== List("a", "b")
    }

    "flatten one level nested list" in {
      List99.flatten(List(List("a"), "b")) must_== List("a", "b")
    }
  }

}
