
import NumberToLongShort.langOutput
import org.scalatest.{FlatSpec, Matchers}

class PositiveTest extends FlatSpec with Matchers{

  lazy val english: List[String] = List(" ", " thousand and ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion ", " sextillion ")
  lazy val french: List[String] = List(" ", " mille et ", " million ", " milliard ", " billion ", " billiard ", " trillion ", " triliard ")

  "87612345634865347651111" should "output correct english result" in {
    langOutput("87612345634865347651111", english) shouldBe
      "87 sextillion 612 quintillion 345 quadrillion 634 trillion 865 billion 347 million 651 thousand and 111 "
  }

  "87612345634865347651111" should "output correct french result" in {
    langOutput("87612345634865347651111", french) shouldBe
      "87 triliard 612 trillion 345 billiard 634 billion 865 milliard 347 million 651 mille et 111 "
  }

  "1000001" should "output correct english result" in {
    langOutput("1000001", english) shouldBe "1 million and 001 "
  }

  "1000001" should "output correct french result" in {
    langOutput("1000001", french) shouldBe "1 million and 001 "
  }

  "1100000001" should "output correct french result" in {
    langOutput("1100000001", french) shouldBe "1 milliard 100 million and 001 "
  }
}
