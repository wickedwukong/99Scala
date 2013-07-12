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
    eithers.foldLeft(Right(Seq()): Either[A, Seq[B]]){
      (acc: Either[A, Seq[B]], elem: Either[A, B]) =>
        for {
          rights <- acc
          right <- elem
        } yield rights :+ right
    }
  }
}
