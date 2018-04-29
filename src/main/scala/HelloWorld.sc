val pepe = "Hello World"
println(pepe)

val f: String => (String => String) = {
  case "ping" => {
    case "pong" => "pepi"
    case _ => "pito"
  }
  case _ => {
    case "pipi" => "gorgfo"
    case _ => "resto"
  }
}

f("pin")("k")

val g: PartialFunction[String, String] = {
  case "ping" => "ping"
  case _ => "popo"
}
g.isDefinedAt("pieeng")