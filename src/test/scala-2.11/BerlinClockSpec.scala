import org.scalatest.{Matchers, FlatSpec}

/**
  * Created by pritesh on 25/02/16.
  */
class BerlinClockSpec extends FlatSpec with Matchers {

  "Berlin clock" should "have a top lamp (yellow) that blinks every 2 seconds" in {

    BerlinClock.berlinFirstRow(0) shouldBe "Y"
    BerlinClock.berlinFirstRow(2) shouldBe "Y"
    BerlinClock.berlinFirstRow(5) shouldBe "0"
    BerlinClock.berlinFirstRow(30) shouldBe "Y"
    BerlinClock.berlinFirstRow(45) shouldBe "0"
  }

  it should "have a second row (red) that represents 5 hours" in {
    BerlinClock.berlinSecondRow(24) shouldBe "RRRR"
    BerlinClock.berlinSecondRow(12) shouldBe "RR00"
    BerlinClock.berlinSecondRow(16) shouldBe "RRR0"
    BerlinClock.berlinSecondRow(0) shouldBe "0000"

  }

  it should "have a third row (red) that represents 1 hour" in {

    BerlinClock.berlinThirdRow(5) shouldBe "0000"
    BerlinClock.berlinThirdRow(17) shouldBe "RR00"
    BerlinClock.berlinThirdRow(0) shouldBe "0000"

  }

  it should "have a fourth row (yellow & red) that represents minutes and 15 minute intervals" in {
    BerlinClock.berlinFourthRow(15) shouldBe "YYR00000000"
    BerlinClock.berlinFourthRow(59) shouldBe "YYRYYRYYRYY"
    BerlinClock.berlinFourthRow(41) shouldBe "YYRYYRYY000"
  }

  it should "have a fifth row (yellow) that represents single minutes" in {
    BerlinClock.berlinFifthRow(5) shouldBe "0000"
    BerlinClock.berlinFifthRow(1) shouldBe "Y000"
    BerlinClock.berlinFifthRow(0) shouldBe "0000"
  }

  it should "convert time correctly" in {
    BerlinClock.convertToBerlinTime("09:40:01") shouldBe BerlinTime("0","R000","RRRR","YYRYYRYY000","0000")
    BerlinClock.convertToBerlinTime("16:00:00") shouldBe BerlinTime("Y","RRR0","R000","00000000000","0000")
    BerlinClock.convertToBerlinTime("20:30:56") shouldBe BerlinTime("Y","RRRR","0000","YYRYYR00000","0000")
  }



}
