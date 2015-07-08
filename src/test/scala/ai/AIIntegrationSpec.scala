package ai

import base._
import gui._
import players._
import mocks._

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class AIIntegration extends FunSpec {
    
  describe("Integration Test") {
    it ("plays a game with 2 ai engines and should be a draw") {
      val userInterface = new MockUserInterface
      val board = Array[String]("1","2","3","4","5","6","7","8","9")
      val game = new Game(board)
      val engine = new Negamax
      val xMark = "x"
      val oMark = "o"
      var player1 = PlayerFactory.getPlayer("computer", xMark, engine, userInterface)
      var player2 = PlayerFactory.getPlayer("computer", oMark, engine, userInterface)
      new Runner(game, userInterface, player1, player2).run()
      
      assert(game.isWin == false)
      assert(game.isDraw == true)
    }
  }

}