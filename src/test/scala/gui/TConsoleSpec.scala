package gui

import base._
import mocks.MockIO

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TConsoleSpec extends FunSpec{
  
  val tconsole = new TConsole with MockIO
 
  describe("terminal"){
    it("displays a welcome message"){
      tconsole.prepare()
      assert(tconsole.outputs.contains(Communication.messages('welcome)) )
    }
    
    it("displays goodbye") {
      tconsole.goodbye()
      assert(tconsole.outputs.contains(Communication.messages('goodbye)) )
    }
  
   
    
    it("constructs more than one size"){
      val gameboard2 = new GameBoard(4)
      val game2 = new Game(gameboard2.board)
      val boardString = tconsole.construct(gameboard2.board)
      println("here" + gameboard2.board.size)
      println(boardString)
      val board = (1 to 16).toArray map { x => x.toString }
      var result = board(0) + "  | " + board(1) + "  | " + board(2) + "  | " + board(3) + "\n" + 
                board(4) + "  | " + board(5) + "  | " + board(6) + "  | " + board(7) + "\n" + 
                board(8) + "  | " + board(9) + " | " + board(10) + " | " + board(11) + "\n" + 
                board(12) + " | " + board(13) + " | " + board(14) + " | " + board(15) + "\n"  
      assert(tconsole.construct(gameboard2.board)== result)
    }
     it("displays a formatted board") {
      val gameboard = new GameBoard(3)
      val game = new Game(gameboard.board)
      tconsole.displayBoard(gameboard.board)
      val board = (1 to 9).toArray map { x => x.toString }
      assert(tconsole.outputs.contains(board(0) + " | " + board(1) + " | " + board(2) + "\n" +
                                       board(3) + " | " + board(4) + " | " + board(5) + "\n" +
                                       board(6) + " | " + board(7) + " | " + board(8) + "\n"))
    }
    
    
    it("prompts player and reads in a cell number for move selection"){
      tconsole.input = 1.toString()
      val availableCells = List("1","2","3","4","5","6","7","8","9")
      assert(tconsole.readCellNumber(availableCells) == "1")
    } 
    
    it("displays game result") {
      val board = Array[String]("x","o","3",
                                "o","x","6",
                                "7","8","x")
      val game2 = new Game(board)
      tconsole.displayGameResult("x", "o", game2)
      assert(tconsole.outputs.contains("x" + Communication.messages('win)))
    }

  }
}