
import org.scalatest.{FlatSpec, Matchers}

class CipherPosTests extends FlatSpec with Matchers {

  val cipher = new Cipher

  "hello" should "output the correct cipher" in {
    cipher.convert("hello") shouldBe "svool"
  }

  "HELLO" should "output the correct cipher" in {
    cipher.convert("HELLO") shouldBe "svool"
  }

  "James's shoes" should "output the correct cipher" in {
    cipher.convert("James's shoes") shouldBe "qznvh'h hslvh"
  }

}
