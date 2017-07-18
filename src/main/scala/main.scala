
object main extends App {
  longAndShort("00000000017000000001")

  def longAndShort(input: String): Unit = {
    try {
      val numberTest = input.toLong
      println(langOutput(input, english))
      println(langOutput(input, french))
    } catch {
      case e: Exception => println("Enter a valid number")
    }
  }

  lazy val english: List[String] = List(" ", " thousand and ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion ", " sextillion ")
  lazy val french: List[String] = List(" ", " mille et ", " million ", " milliard ", " billion ", " billiard ", " trillion ", " triliard ")

  def langOutput(input: String, lang: List[String]): String = {
    val in = input.replaceFirst("^0*", "").reverse.grouped(3).toList.map(_.reverse.toList.mkString)
    val out = for (i <- in.indices) yield {
      i match {
        case _ if i > lang.length => in(i) + " "
        case _ if in(i) != "000" => in(i) + lang(i)
        case 0 if in(0) != "000" && in(1) == "000" => " and " + in(i)
        case _ => ""
      }
    }
    out.reverse.mkString
  }
}
