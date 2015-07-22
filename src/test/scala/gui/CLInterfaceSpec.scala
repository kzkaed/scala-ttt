package gui

import base._
import mocks.MockIO

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CLInterfaceSpec extends FunSpec{
  
  val cli = new CLInterface with MockIO
 
  describe("terminal"){
    it("displays a welcome message"){
      cli.prepare()
      assert(cli.outputs.contains(Communication.messages('welcome)) )
    }
    
    it("displays goodbye") {
      cli.goodbye()
      assert(cli.outputs.contains(Communication.messages('goodbye)) )
    }
 
     it("displays a formatted board") {
       val gameboard = new GameBoard(3)
       val game = new Game(gameboard.board)
       cli.displayBoard(gameboard.board)
       val board = (1 to 9).toArray map { x => x.toString }
       assert(cli.outputs.contains(board(0) + " | " + board(1) + " | " + board(2) + "\n" +
                                   board(3) + " | " + board(4) + " | " + board(5) + "\n" +
                                   board(6) + " | " + board(7) + " | " + board(8) + "\n"))
     }
       
     it("prompts player and reads in a cell number for move selection"){
       cli.input = 1.toString()
       val availableCells = List("1","2","3","4","5","6","7","8","9")
       assert(cli.readCellNumber(availableCells) == "1")
    } 
    
     it("displays game result") {
       val board = Array[String]("x","o","3",
                                 "o","x","6",
                                 "7","8","x")
       val game2 = new Game(board)
       cli.displayGameResult("x", "o", game2)
       assert(cli.outputs.contains("x" + Communication.messages('win)))
     }

  }
}