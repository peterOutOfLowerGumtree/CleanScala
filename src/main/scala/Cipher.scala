
class Cipher {

  val cipherCode: Map[Char, Char] = (('a' to 'z').toList zip ('a' to 'z').reverse).toMap

  def convert(input: String): String = {
    val in = input.toLowerCase.toCharArray
    val out = for (i <- in.indices) yield {
      i match {
        case _ if cipherCode.contains(in(i)) => cipherCode(in(i))
        case _ => in(i)
      }
    }
    out.mkString
  }

}
