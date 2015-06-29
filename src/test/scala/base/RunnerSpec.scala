package base

import mocks._
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RunnerSpec extends FunSpec {
  val board = Array("1","2","3","4","5","6","7","8","9")
  val game = new MockGame(board: Array[String])
  //val userInterface = new MockUserInteface
  //val player1 = new MockPlayer
  //val player2 = new MockPlayer
  //val runner = new Runner(game, userInterface, player1, player2)
  
  describe("run"){
    it("has a game") {
      
     
    }
  }
  
 
    
    
  
  
}
  
