import org.specs2.mutable.Specification
import TailRecursionExample._

class TailRecursionExampleSpec extends Specification {

  "updateOrAddNewElementToList" should {
    "add new element to the end of list" in {
      updateOrAddNewElementToList(5, List(1, 2, 3)) must_== List(1, 2, 3, 5)
    }
  }

  "updateOrAddNewElementToList" should {
    "update the existing element and keep the original order" in {
      updateOrAddNewElementToList(2, List(1, 2, 3)) must_== List(1, 3, 3)
      updateOrAddNewElementToList(3, List(1, 2, 3)) must_== List(1, 2, 4)
      updateOrAddNewElementToList(1, List(1, 2, 3)) must_== List(2, 2, 3)
    }
  }
}
