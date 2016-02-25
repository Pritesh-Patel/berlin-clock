import scala.util.{Success, Try}

/**
  * Created by pritesh on 25/02/16.
  */
object BerlinClock {

  def convertToBerlinTime(timeAsString:String,delimiter:String = ":"): BerlinTime ={

    val time = timeAsString.split(delimiter).map(_.toInt)

    val seconds = time(2)
    val mins = time(1)
    val hours= time(0)

    val firstRow = berlinFirstRow(seconds)
    val secondRow = berlinSecondRow(hours)
    val thirdRow = berlinThirdRow(hours)
    val fourthRow = berlinFourthRow(mins)
    val fifthRow = berlinFifthRow(mins)

    BerlinTime(firstRow,secondRow,thirdRow,fourthRow,fifthRow)
  }

  def berlinFirstRow(seconds:Int) : String = {
    if(seconds % 2 == 0) "Y" else "0"
  }

  def berlinSecondRow(hours:Int) : String = {
    lightUp(hours / 5, 4,"R")

  }

  def berlinThirdRow(hours:Int) : String ={
      lightUp(hours % 5, 4, "R")
  }

  def berlinFourthRow(minutes:Int) : String ={
    lightUp(minutes / 5,11,"Y").replaceAll("YYY","YYR")

  }

  def berlinFifthRow(minutes:Int) : String ={
    lightUp(minutes % 5, 4, "Y")
  }

  private def lightUp(lightUpAmount:Int, maxLights:Int, lampType:String): String  = {
    lampType * lightUpAmount  + "0" *(maxLights - lightUpAmount )
  }






}

case class BerlinTime( firstRow:String, secondRow:String, thirdRow:String, fourthRow:String, fifthRow:String){
  override def toString: String = {
    firstRow + "\n" +
    secondRow + "\n" +
    thirdRow + "\n" +
    fourthRow + "\n" +
    fifthRow
  }
}