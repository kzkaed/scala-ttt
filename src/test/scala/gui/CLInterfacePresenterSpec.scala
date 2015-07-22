package gui

import mocks.MockIO
import mocks.MockGame
import base._
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CLIPresenterSpec extends FunSpec{
  val presenter = new CLInterfacePresenter
 
 it("constructs a 3x3 board"){
      val gameboard = new GameBoard(3)
      val game = new Game(gameboard.board)
      
      val board = (1 to 9).toArray map { x => x.toString }
      var result = board(0) + " | " + board(1) + " | " + board(2) + "\n" +
                   board(3) + " | " + board(4) + " | " + board(5) + "\n" +
                   board(6) + " | " + board(7) + " | " + board(8) + "\n" 
      
      assert(presenter.construct(gameboard.board)== result)
    }
   
  it("constructs a 4x4 board"){
      val gameboard2 = new GameBoard(4)
      val game2 = new Game(gameboard2.board)
      
      val board = (1 to 16).toArray map { x => x.toString }
      var result = board(0) + "  | " + board(1) + "  | " + board(2) + "  | " + board(3) + "\n" + 
                   board(4) + "  | " + board(5) + "  | " + board(6) + "  | " + board(7) + "\n" + 
                   board(8) + "  | " + board(9) + " | " + board(10) + " | " + board(11) + "\n" + 
                   board(12) + " | " + board(13) + " | " + board(14) + " | " + board(15) + "\n"  
      
      assert(presenter.construct(gameboard2.board)== result)
    }
  
  it("has game results") {
    val gameboard = new GameBoard(3)
    val game = new Game(gameboard.board)
    assert(presenter.gameResult("x", "o", game) == Communication.messages('draw))
  }
  
   it("has game results with win") {
    val gameboard = new GameBoard(3)
    val game = new MockGame(gameboard.board)
    assert(presenter.gameResult("x", "o", game) == "x"+ Communication.messages('win))
  }
}