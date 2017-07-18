
import main.langOutput
import org.scalatest.{FlatSpec, Matchers}

class positiveResults extends FlatSpec with Matchers{

  lazy val english: List[String] = List(" ", " thousand and ", " million ", " billion ", " trillion ", " quadrillion ", " quintillion ", " sextillion ")
  lazy val french: List[String] = List(" ", " mille et ", " million ", " milliard ", " billion ", " billiard ", " trillion ", " triliard ")

  "87612345634865347651111" should "output correct short result" in {
    langOutput("87612345634865347651111", english) shouldBe
      "87 sextillion 612 quintillion 345 quadrillion 634 trillion 865 billion 347 million 651 thousand and 111 "
  }

  "87612345634865347651111" should "output correct long result" in {
    langOutput("87612345634865347651111", french) shouldBe "87 triliard 612 trillion 345 billiard 634 billion 865 milliard 347 million 651 mille et 111 "
  }
}
