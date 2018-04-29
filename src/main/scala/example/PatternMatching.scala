package example

/**
  * Created by Usuario on 29/04/2018.
  */
abstract class JSON

case class Jseq(elems: List[JSON]) extends JSON

case class JObj(bindings: Map[String, JSON]) extends JSON

case class JNum(num: Double) extends JSON

case class JStr(str: String) extends JSON

case class JBool(b: Boolean) extends JSON

case object JNull extends JSON

class PatternMatching {}

object Principal extends App {

  val data = JObj(Map(
    "name" -> JStr("Kevin"),

    "address" -> JObj(Map(
      "state" -> JStr("Madrid"),
      "postCode" -> JNum(1234)
    )),

    " " -> Jseq(
      List(
        JObj(Map("type" -> JStr("Work"), "number" -> JStr("132-124-123")
        )),
        JObj(Map(
          "type" -> JStr("fax"), "number" -> JStr("546-764-756")
        ))
      ))
  )
  )


  def show(json: JSON): String = json match {
    case Jseq(elems) => "[" + (elems map show mkString ", ") + "]"
    case JObj(bindings) => val assocs = bindings map {
      case (key, value) => "\"" + key + "\": " + show(value)
    }
      "{" + (assocs mkString ", ") + "}"
    case JNum(num) => num.toString
    case JStr(str) => '\"' + str + '\"'
    case JBool(b) => b.toString
    case JNull => "null"
  }

  println(show(data))
}


