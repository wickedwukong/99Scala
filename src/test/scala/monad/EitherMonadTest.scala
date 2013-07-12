package monad

import org.scalatest.FunSuite
import org.scalatest.matchers.ShouldMatchers

class EitherMonadTest extends FunSuite with ShouldMatchers{

  import EitherMonad._

  test("map") {
    Right(2).map((_: Int) * 2) should be(Right(4))
    Left[Int, Int](2).map((_: Int) * 2) should be(Left[Int, Int](2))
  }

  test("flatMap") {
    Right(2).flatMap{ (x: Int) => Right(x * 2) } should be (Right(4))
    Left[Int, Int](2).flatMap{ (x: Int) => Right(x * 2) } should be (Left(2))
    (Right(2): Either[Int, Int]).flatMap{ (x: Int) => Left(x * 2) } should be (Left(4))
  }

  test("for comprehension") {
    val result1 = for {
      a <- Right[Int, Int](2)
      b <- Right[Int, Int]((a: Int) * 2)
    } yield b

    result1 should be(Right(4))

    val result2 = for {
      a <- Left[Int, Int](2)
      b <- Right[Int, Int]((a: Int) * 2)
    } yield b

    result2 should be(Left(2))
  }

  test("sequence") {
    sequence(Seq(Right(2))) should be(Right(Seq(2)))
    sequence(Seq(Left("foo"))) should be(Left("foo"))
    sequence(Seq(Right(2), Right(1), Right(4))) should be(Right(Seq(2, 1, 4)))
    sequence(Seq(Right(2), Left("foo"), Right(4))) should be(Left("foo"))
    sequence(Seq(Right(2), Left("foo"), Left("bar"))) should be(Left("foo"))
  }

}
