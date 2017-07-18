
import NumberToLongShort.{english, french, langTest, langOutput}
import org.scalatest.{FlatSpec, Matchers}

class PositiveTests extends FlatSpec with Matchers {

  "8761234563486534711" should "output correct english result" in {
    langTest("8761234563486534711", english) shouldBe
      "8 quintillion 761 quadrillion 234 trillion 563 billion 486 million 534 thousand and 711 "
  }

  "9" should "output correct english result" in {
    langTest("9", english) shouldBe "9 "
  }

  "8761234563486534711" should "output correct french result" in {
    langTest("8761234563486534711", french) shouldBe
      "8 trillion 761 billiard 234 billion 563 milliard 486 million 534 mille et 711 "
  }

  "1000001" should "output correct english result" in {
    langTest("1000001", english) shouldBe "1 million and 001 "
  }

  "1000001" should "output correct french result" in {
    langTest("1000001", french) shouldBe "1 million and 001 "
  }

  "1100000001" should "output correct french result" in {
    langTest("1100000001", french) shouldBe "1 milliard 100 million and 001 "
  }

  "1001" should "output correct english result" in {
    langTest("1001", english) shouldBe "1 thousand and 001 "
  }

  "8761234563486534711" should "output correct english result via output" in {
    langTest("8761234563486534711", english) shouldBe
      "8 quintillion 761 quadrillion 234 trillion 563 billion 486 million 534 thousand and 711 "
  }

  "9" should "output correct english result via output" in {
    langOutput("9", english) shouldBe "9 "
  }

  "8761234563486534711" should "output correct french result via output" in {
    langOutput("8761234563486534711", french) shouldBe
      "8 trillion 761 billiard 234 billion 563 milliard 486 million 534 mille et 711 "
  }

  "1000001" should "output correct english result via output" in {
    langOutput("1000001", english) shouldBe "1 million and 001 "
  }

  "1000001" should "output correct french result via output" in {
    langOutput("1000001", french) shouldBe "1 million and 001 "
  }

  "1100000001" should "output correct french result via output" in {
    langOutput("1100000001", french) shouldBe "1 milliard 100 million and 001 "
  }

  "1001" should "output correct english result via output" in {
    langOutput("1001", english) shouldBe "1 thousand and 001 "
  }
}
