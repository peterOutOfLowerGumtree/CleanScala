import scala.util.{Failure, Success, Try}

object NumberToLongShort extends App {

  lazy val english: List[String] = List(" ", " thousand and ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion ", " sextillion ")
  lazy val french: List[String] = List(" ", " mille et ", " million ", " milliard ", " billion ", " billiard ", " trillion ", " triliard ")

  def langTest(input: String, lang: List[String]): String = {
    Try {
      val posInput = input.replaceAll("[-]", "minus ")
      posInput.toLong
    } match {
      case Success(a) => langOutput(input, lang)
      case Failure(a) => "Enter a valid positive number"
    }
  }

  def langOutput(input: String, lang: List[String]): String = {
    val in = input.replaceFirst("^0*", "").reverse.grouped(3).toList.map(_.reverse.toList.mkString)
    val out = for (i <- in.indices) yield {
      i match {
        case _ if in(i) != "000" => in(i) + lang(i)
        case _ if in(0) != "000" && in(1) == "000" => "and "
        case _ => ""
      }
    }
    out.reverse.mkString
  }
}
