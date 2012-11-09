object List99 {
 def last[T](list: List[T]): T = {
   list match {
     case head :: Nil => head
     case head :: tail => last(tail)
     case Nil => throw new Error("last elemenet of empty list")
   }
 }

  def penultimate[T](list: List[T]): T = {
    list match {
      case List(a, b) => a
      case head :: tail => penultimate(tail)
      case _ => throw new Error("Empty list")
    }
  }

  def nth[T](index: Int, list: List[T]): T = {
    (index, list) match {
      case (0, h :: _) => h
      case (n, h :: tail) => nth(n - 1, tail)
      case (_, Nil) => throw new Error("Empty list")
    }
  }

  def length[T](list: List[T]): Int = {
    list.foldLeft(0)((count, elem) => count + 1)

  }
}
