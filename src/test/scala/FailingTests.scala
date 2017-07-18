import NumberToLongShort.{english, french, langTest}
import org.scalatest.{FlatSpec, Matchers}

class FailingTests extends FlatSpec with Matchers {

  "hello" should "output error message" in {
    langTest("hello", english) shouldBe "Enter a valid positive number"
  }

  "1234e" should "output error message" in {
    langTest("1234e", french) shouldBe "Enter a valid positive number"
  }

  "5747836578364529623586345786342562356029345" should "output error message" in {
    langTest("5747836578364529623586345786342562356029345", english) shouldBe "Enter a valid positive number"
  }

  "-1234" should "output error message" in {
    langTest("-1234", french) shouldBe "Enter a valid positive number"
  }

}
