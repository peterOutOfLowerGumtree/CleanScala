
import scala.util.{Failure, Success, Try}

class NumberToLongShort {

  lazy val english: List[String] = List(" ", " thousand and ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion ", " sextillion ")
  lazy val french: List[String] = List(" ", " mille et ", " million ", " milliard ", " billion ", " billiard ", " trillion ", " triliard ")

  def checkIfNumber(input: String, lang: List[String]): String = {
    Try {
      input.toLong
    } match {
      case Success(a) => langOutput(input, lang)
      case Failure(a) => "Enter a valid positive number"
    }
  }

  def langOutput(input: String, lang: List[String]): String = {
    if (input.contains('-')) {
      langNeg(input, lang)
    }
    else {
      langPos(input, lang)
    }
  }

  def langPos(input: String, lang: List[String]): String = {
    val in = input.replaceFirst("^0*", "").reverse.grouped(3).toList.map(_.reverse.toList.mkString)
    val out = calculation(in, lang)
    out.reverse.mkString
  }

  def langNeg(input: String, lang: List[String]): String = {
    val in = input.tail.replaceFirst("^0*", "").reverse.grouped(3).toList.map(_.reverse.toList.mkString)
    val out = calculation(in, lang)
    "- " + out.reverse.mkString
  }

  def calculation(input: List[String], lang: List[String]): IndexedSeq[String] = {
    for (i <- 0 until input.length) yield {
      i match {
        case _ if input(i) != "000" => input(i) + lang(i)
        case _ if input(0) != "000" && input(1) == "000" => "and "
      }
    }
  }

}
