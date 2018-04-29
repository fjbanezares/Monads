package example

/**
  * Created by Usuario on 29/04/2018.
  */
class Collections {

}

abstract class List[+T] extends scala.collection.immutable.List[+T] {

  def flatMap2[U](f: T => List[U]): List[U] = this match {

    case x::xs => f(x) ++ xs.flatMap2(f)
    case Nil => Nil

  }
}
