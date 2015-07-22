package gui

import mocks.MockIO
import base._
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TConsolePresenterSpec extends FunSpec{
  val presenter = new TConsolePresenter
 
  it("constructs more than one size"){
      val gameboard2 = new GameBoard(4)
      val game2 = new Game(gameboard2.board)
      
      val board = (1 to 16).toArray map { x => x.toString }
      var result = board(0) + "  | " + board(1) + "  | " + board(2) + "  | " + board(3) + "\n" + 
                   board(4) + "  | " + board(5) + "  | " + board(6) + "  | " + board(7) + "\n" + 
                   board(8) + "  | " + board(9) + " | " + board(10) + " | " + board(11) + "\n" + 
                   board(12) + " | " + board(13) + " | " + board(14) + " | " + board(15) + "\n"  
      
      assert(presenter.construct(gameboard2.board)== result)
    }
}