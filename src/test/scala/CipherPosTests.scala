
import org.scalatest.{FlatSpec, Matchers}

class CipherPosTests extends FlatSpec with Matchers {

  val cipher = new Cipher

  "Input of 'hello'" should "output 'svool'" in {
    cipher.convert("hello") shouldBe "svool"
  }

  "Input of 'HELLO'" should "output 'svool'" in {
    cipher.convert("HELLO") shouldBe "svool"
  }

  "Input of 'James's shoes'" should "output 'qznvh'h hslvh'" in {
    cipher.convert("James's shoes") shouldBe "qznvh'h hslvh"
  }

}
