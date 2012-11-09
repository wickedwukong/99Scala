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

    "must throw exception for empty list" in {
      List99.last(List[Any]()) must throwA[Error]
    }
  }

}
