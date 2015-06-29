package players

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import players.Human;

@RunWith(classOf[JUnitRunner])
class HumanSpec extends FunSpec {
  val human = new Human
  
 it("should have player 1 move from user interface") {
    val board = Array[String]("1","2","3","4","5","6","7","8","9")
    val game = new base.Game(board)
    val move = "1"
    val userInterface = new ui.Terminal with mocks.MockUserInterface
    
  }
  
  
  
  
}