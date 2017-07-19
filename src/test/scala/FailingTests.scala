import NumberToLongShort.{english, french, checkIfNumber, langOutput}
import org.scalatest.{FlatSpec, Matchers}

class FailingTests extends FlatSpec with Matchers {

  "hello" should "output error message" in {
    checkIfNumber("hello", english) shouldBe "Enter a valid positive number"
  }

  "1234e" should "output error message" in {
    checkIfNumber("1234e", french) shouldBe "Enter a valid positive number"
  }

  "5747836578364529623586345786342562356029345" should "output error message" in {
    checkIfNumber("5747836578364529623586345786342562356029345", english) shouldBe "Enter a valid positive number"
  }

  "" should "output nothing" in {
    langOutput("", english) shouldBe ""
  }

}
