package grind

import grind.DecodeResult.{NotFound, Failure, Success}

sealed trait DecodeResult[+A] {
  def isSuccess: Boolean
  def isFailure: Boolean = !isSuccess

  def get: A = this match {
    case Success(a) => a
    case _          => sys.error("get on non-success")
  }

  def map[B](f: A => B): DecodeResult[B] = this match {
    case Success(a) => Success(f(a))
    case Failure    => Failure
    case NotFound   => NotFound
  }

  def flatMap[B](f: A => DecodeResult[B]): DecodeResult[B] = this match {
    case Success(a) => f(a)
    case Failure    => Failure
    case NotFound   => NotFound
  }
}

object DecodeResult {
  def apply[A](a: => A): DecodeResult[A] =
    try {
      val actual = a
      if(actual == null) NotFound
      else               Success(a)
    }
    catch { case _: Exception => Failure }

  final case class Success[A](value: A) extends DecodeResult[A] {
    override def isSuccess: Boolean = true
  }

  case object Failure extends DecodeResult[Nothing] {
    override def isSuccess: Boolean = false
  }

  case object NotFound extends DecodeResult[Nothing] {
    override def isSuccess: Boolean = false
  }
}