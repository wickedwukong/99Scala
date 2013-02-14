import org.junit.runner.RunWith
import org.specs2.mutable.Specification
import scala.Predef._
import org.specs2.matcher._
import org.specs2.runner.JUnitRunner

import ProgFunTelephoneNumberTranslator._

@RunWith(classOf[JUnitRunner])
class ProgFunTelephoneNumberTranslatorSpec extends Specification {

  "charCodeFoldLeft" should {
    "give char to number char mapping" in {
      charCodeFoldLeft must_== Map('A' -> '2', 'B' -> '2', 'C' -> '2', 'D' -> '3', 'E' -> '3', 'F' -> '3', 'G' -> '4', 'H' -> '4', 'I' -> '4', 'J' -> '5', 'K' -> '5', 'L' -> '5', 'M' -> '6', 'N' -> '6', 'O' -> '6',
      'P' -> '7', 'Q' -> '7', 'R' -> '7', 'S' -> '7', 'T' -> '8', 'U' -> '8', 'V' -> '8', 'W' -> '9', 'X' -> '9', 'Y' -> '9', 'Z' -> '9')

    }
  }

  "charCodeFor" should {
    "give char to number char mapping" in {
      charCodeFor must_== Map('A' -> '2', 'B' -> '2', 'C' -> '2', 'D' -> '3', 'E' -> '3', 'F' -> '3', 'G' -> '4', 'H' -> '4', 'I' -> '4', 'J' -> '5', 'K' -> '5', 'L' -> '5', 'M' -> '6', 'N' -> '6', 'O' -> '6',
      'P' -> '7', 'Q' -> '7', 'R' -> '7', 'S' -> '7', 'T' -> '8', 'U' -> '8', 'V' -> '8', 'W' -> '9', 'X' -> '9', 'Y' -> '9', 'Z' -> '9')

    }
  }

  "wordCodeFoldleft" should {
    "map a word to a number" in {
      wordCodeFoldleft("Java") must_== 5282
    }
  }

  "wordCode" should {
    "map a word to a number" in {
      wordCode("Java") must_== 5282
    }
  }

}
