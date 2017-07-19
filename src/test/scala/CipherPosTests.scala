
import org.scalatest.{FlatSpec, Matchers}

class CipherPosTests extends FlatSpec with Matchers {

  val cipher = new Cipher

  "hello" should "output the correct cipher" in {
    cipher.convertToCipher("hello") shouldBe "svool"
  }

  "HELLO" should "output the correct cipher" in {
    cipher.convertToCipher("HELLO") shouldBe "svool"
  }

  "James's shoes" should "output the correct cipher" in {
    cipher.convertToCipher("James's shoes") shouldBe "qznvh'h hslvh"
  }

}
