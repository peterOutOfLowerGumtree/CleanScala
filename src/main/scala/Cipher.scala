
class Cipher {

  val cipherCode = Map(
  "a" -> "z", "b" -> "y", "c" -> "x", "d" -> "w", "e" -> "v", "f" -> "u", "g" -> "t", "h" -> "s",
  "i" -> "r", "j" -> "q", "k" -> "p", "l" -> "o", "m" -> "n", "n" -> "m", "o" -> "l", "p" -> "k",
  "q" -> "j", "r" -> "i", "s" -> "h", "t" -> "g", "u" -> "f", "v" -> "e", "w" -> "d", "x" -> "c",
  "y" -> "b", "z" -> "a")

  def convert(input: String): String = {
    val in = input.toLowerCase.split("")
    val out = for (i <- in.indices) yield {
      i match {
        case _ if cipherCode.contains(in(i)) => cipherCode(in(i))
        case _ => in(i)
      }
    }
    out.mkString
  }

}
