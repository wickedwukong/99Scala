object ProgFunTelephoneNumberTranslator {
  val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")
  //    val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  val charCode: Map[Char, Char] = {
    mnem.foldLeft(Map[Char, Char]())(
      (seed, elem) => {
        elem._2.foldLeft(seed)((seed, c) => {
          seed + (c -> elem._1);
        })
      }
    )
  }
}

