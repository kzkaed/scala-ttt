package players

import base.Game
import mocks.MockUserInterface
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class HumanSpec extends FunSpec {
  val playerMark = "x"
  val userInterface = new MockUserInterface()
  val player1 = new Human("x",userInterface)
  val player2 = new Human("o",userInterface)
  
  it("can have a player mark x") {
    player1.playerMark = "x"
    assert(player1.getPlayerMark() == "x")
  }
  
  it("can have a player mark o") {
    player2.playerMark = "o"
    assert(player2.getPlayerMark() == "o")
  }
  
  
 it("receives player1 move selection from user interface") {
    val board = Array[String]("1","2","3","4","5","6","7","8","9")
    val game = new Game(board)
    userInterface.cellSelection = "1"
    assert(player1.selectMove(game) == "1")
    assert(userInterface.isReadCellNumberCalled() == true)
  }
 
 it("receives player2 move selection from user interface") {
    val board = Array[String]("1","2","3","4","5","6","7","8","9")
    val game = new Game(board)
    userInterface.cellSelection = "2"
    assert(player1.selectMove(game) == "2")
  }
}