import scala.util.{Failure, Success, Try}

object NumberToLongShort extends App {

  lazy val english: List[String] = List(" ", " thousand and ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion ", " sextillion ")
  lazy val french: List[String] = List(" ", " mille et ", " million ", " milliard ", " billion ", " billiard ", " trillion ", " triliard ")

  def longAndShort(input: String): Unit = {
    Try {
      val numberTest = input.toLong
    } match {
      case Success(a) => {
        println(langOutput(input, english))
        println(langOutput(input, french))
      }
      case Failure(a) => println("Enter a valid number")
    }
  }

  def langOutput(input: String, lang: List[String]): String = {
    val in = input.replaceFirst("^0*", "").reverse.grouped(3).toList.map(_.reverse.toList.mkString)
    val out = for (i <- in.indices) yield {
      i match {
        case _ if i > lang.length => in(i) + " "
        case _ if in(i) != "000" => in(i) + lang(i)
        case _ if in(0) != "000" && in(1) == "000" => "and "
        case _ => ""
      }
    }
    out.reverse.mkString
  }
}
