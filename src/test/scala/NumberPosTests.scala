
import org.scalatest.{FlatSpec, Matchers}

class NumberPosTests extends FlatSpec with Matchers {

  val num = new NumberToLongShort

  "Input of '8761234563486534711'" should "output correct english result" in {
    num.checkIfNumber("8761234563486534711", num.english) shouldBe
      "8 quintillion 761 quadrillion 234 trillion 563 billion 486 million 534 thousand and 711 "
  }

  "Input of '9'" should "output correct english result" in {
    num.checkIfNumber("9", num.english) shouldBe "9 "
  }

  "Input of '8761234563486534711'" should "output correct french result" in {
    num.checkIfNumber("8761234563486534711", num.french) shouldBe
      "8 trillion 761 billiard 234 billion 563 milliard 486 million 534 mille et 711 "
  }

  "Input of '1000001'" should "output correct english result" in {
    num.checkIfNumber("1000001", num.english) shouldBe "1 million and 001 "
  }

  "Input of '1000001'" should "output correct french result" in {
    num.checkIfNumber("1000001", num.french) shouldBe "1 million and 001 "
  }

  "Input of '1100000001'" should "output correct french result" in {
    num.checkIfNumber("1100000001", num.french) shouldBe "1 milliard 100 million and 001 "
  }

  "Input of '1001'" should "output correct english result" in {
    num.checkIfNumber("1001", num.english) shouldBe "1 thousand and 001 "
  }

  "Input of '8761234563486534711'" should "output correct english result via output" in {
    num.checkIfNumber("8761234563486534711", num.english) shouldBe
      "8 quintillion 761 quadrillion 234 trillion 563 billion 486 million 534 thousand and 711 "
  }

  "Input of '-1234'" should "output correct negative result" in {
    num.checkIfNumber("-1234", num.french) shouldBe "- 1 mille et 234 "
  }

  "Input of '-1000001'" should "output correct negative result" in {
    num.checkIfNumber("-1000001", num.english) shouldBe "- 1 million and 001 "
  }

  "Input of '-123450678984875'" should "output correct negative result" in {
    num.checkIfNumber("-123450678984875", num.english) shouldBe "- 123 trillion 450 billion 678 million 984 thousand and 875 "
  }
}
