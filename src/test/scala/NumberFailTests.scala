
import org.scalatest.{FlatSpec, Matchers}

class NumberFailTests extends FlatSpec with Matchers {

  val num = new NumberToLongShort

  "hello" should "output error message" in {
    num.checkIfNumber("hello", num.english) shouldBe "Enter a valid positive number"
  }

  "1234e" should "output error message" in {
    num.checkIfNumber("1234e", num.french) shouldBe "Enter a valid positive number"
  }

  "5747836578364529623586345786342562356029345" should "output error message" in {
    num.checkIfNumber("5747836578364529623586345786342562356029345", num.english) shouldBe "Enter a valid positive number"
  }

  "" should "output nothing" in {
    num.langOutput("", num.english) shouldBe ""
  }

  "000" should "output nothing" in {
    num.langOutput("000", num.english) shouldBe ""
  }

  "-000" should "output nothing" in {
    num.langOutput("-000", num.english) shouldBe "- "
  }

}
