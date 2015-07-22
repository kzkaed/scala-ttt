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
      val gameboard = new GameBoard(3)
      val game = new Game(gameboard.board)
      val engine = new Negamax
      var player1 = new Computer(Mark.x, engine)
      var player2 = new Computer(Mark.o, engine)
      new Runner(game, userInterface, player1, player2).run()
      
      assert(game.isWin == false)
      assert(game.isDraw == true)
    }
  }

}