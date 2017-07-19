
import scala.util.{Failure, Success, Try}

class NumberToLongShort {

  lazy val english: List[String] = List(" ", " thousand and ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion ", " sextillion ")
  lazy val french: List[String] = List(" ", " mille et ", " million ", " milliard ", " billion ", " billiard ", " trillion ", " triliard ")

  def checkIfNumber(input: String, language: List[String]): String = {
    Try {
      input.toLong
    } match {
      case Success(a) => langOutput(input, language)
      case Failure(a) => "Enter a valid positive number"
    }
  }

  def langOutput(input: String, language: List[String]): String = {
    if (input.contains('-')) {
      langNeg(input, language)
    }
    else {
      langPos(input, language)
    }
  }

  def langPos(input: String, language: List[String]): String = {
    val in = input.replaceFirst("^0*", "").reverse.grouped(3).toList.map(_.reverse.toList.mkString)
    val out = calculation(in, language)
    out.reverse.mkString
  }

  def langNeg(input: String, language: List[String]): String = {
    val in = input.tail.replaceFirst("^0*", "").reverse.grouped(3).toList.map(_.reverse.toList.mkString)
    val out = calculation(in, language)
    "- " + out.reverse.mkString
  }

  def calculation(input: List[String], language: List[String]): IndexedSeq[String] = {
    for (i <- 0 until input.length) yield {
      i match {
        case _ if input(i) != "000" => input(i) + language(i)
        case _ if input(0) != "000" && input(1) == "000" => "and "
      }
    }
  }

}
