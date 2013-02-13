import annotation.tailrec

object TailRecursionExample {

  def updateOrAddNewElementToList(newValue: Int, oldList: List[Int]): List[Int] = {
    @tailrec
    def recursivelyAddUpdateOrAddNewValueToList(newValue: Int, acc: List[Int], oldList: List[Int]): List[Int] = {
      oldList match {
        case head :: tail => {
          if (head == newValue) {
            (((head + 1) :: tail).reverse ++ acc).reverse
          } else {
            recursivelyAddUpdateOrAddNewValueToList(newValue, head :: acc, tail)
          }
        }
        case Nil => (newValue :: acc).reverse
      }
    }
    recursivelyAddUpdateOrAddNewValueToList(newValue, List(), oldList)
  }

}
