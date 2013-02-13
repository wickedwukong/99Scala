package features

import org.specs2.mutable._
import annotation.tailrec

object TailRecursionExample {

  def updateList(newValue: Int, oldList: List[Int]): List[Int] = {
    @tailrec
    def foo(newValue: Int, acc: List[Int], oldList: List[Int]): List[Int] = {
      oldList match {
        case head :: tail => {
          if (head == newValue) {
            (((head + 1) :: tail).reverse ++ acc).reverse
          } else {
            foo(newValue, head :: acc, tail)
          }
        }
        case Nil => (newValue :: acc).reverse
      }
    }
    foo(newValue, List(), oldList)
  }

}
