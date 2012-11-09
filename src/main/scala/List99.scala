object List99 {
 def last[T](list: List[T]): T = {
   list match {
     case head :: Nil => head
     case head :: tail => last(tail)
     case Nil => throw new Error("last elemenet of empty list")
   }
 }
}
