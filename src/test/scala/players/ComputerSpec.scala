package players

import base.Game
import mocks._
import ai._

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ComputerSpec extends FunSpec {
  val engine = new MockIntelligence
  val playerMark = "o"
  val computerPlayer = new Computer(playerMark: String, engine: Intelligence)
  val board = Array[String]("1","2","3","4","5","6","7","8","9")
  val game = new Game(board)
  
  it ("should determine move from ai") {
    val expectedSelection = "1"         
    assertResult(expectedSelection)(computerPlayer.selectMove(game))
  }
  
}