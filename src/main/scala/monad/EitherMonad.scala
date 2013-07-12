package monad

case class EitherMonad[L, A](either: Either[L, A]) {
  def map[B](f: A => B): Either[L, B] = {
    either match {
      case Right(r) => Right(f(r))
      case Left(l) => Left(l)
    }
  }
  def flatMap[B](f: A => Either[L, B]): Either[L, B] = {
    either match {
      case Right(r) => f(r)
      case Left(l) => Left(l)
    }
  }
}

object EitherMonad {
  implicit def toEitherMonad[A, B](a: Either[A, B]): EitherMonad[A, B] = EitherMonad(a)

  def sequence[A, B](eithers: Seq[Either[A, B]]): Either[A, Seq[B]] = {
//    val s1: Either[A, Seq[B]] = for {
//      r0 <- eithers(0)
//    } yield Seq(r0)
//
//    val s2: Either[A, Seq[B]] = for {
//      rights <- s1
//      r1 <- eithers(1)
//    } yield rights :+ r1
//
//    val s3: Either[A, Seq[B]] = for {
//      rights <- s2
//      r2 <- eithers(2)
//    } yield rights :+ r2


    eithers.foldLeft(Right(Seq()): Either[A, Seq[B]]){
      (acc: Either[A, Seq[B]], elem: Either[A, B]) =>
        for {
          rights <- acc
          right <- elem
        } yield rights :+ right
    }
  }
}
