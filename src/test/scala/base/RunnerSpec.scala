package base

import mocks._
import ui._
import players._
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RunnerSpec extends FunSpec {
  val board = Array("1","2","3","4","5","6","7","8","9")
  val game = new MockGame(board: Array[String])
  val userInterface = new ui.Terminal with MockUserInterface
  val player1 = new MockPlayer
  val player2 = new MockPlayer
  val runner = new Runner(game, userInterface, player1, player2)
  
  describe("members"){
    it("has a game") {
      assert(runner.game == game)
     
    }
    
    it("has a user interface") {
      assert(runner.userInterface == userInterface)
    }
  }
  
 
    
    
  
  
}
  
