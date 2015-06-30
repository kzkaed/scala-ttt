package ui

import base.Game
import mocks.MockIO
import org.scalatest._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MTerminalSpec extends FunSpec{
  val board = Array[String]("1","2","3","4","5","6","7","8","9")
  val game = new Game(board)
  val terminal = new MTerminal with MockIO
  val messageList = List("Welcome to Scala Tic Tac Toe",
                         "Goodbye")
  
  describe("terminal"){
    it("displays a welcome message"){
      terminal.prepare()
      assert(terminal.messages.contains(messageList(0)) )
    }
    
    it("displays goodbye") {
      terminal.goodbye()
      assert(terminal.messages.contains(messageList(1)) )
    }
  
    it("displays a formatted board") {
      terminal.displayBoard(board)
      assert(terminal.messages.contains(board(0) + " | " + board(1) + " | " + board(2) + "\n" +
                                        board(3) + " | " + board(4) + " | " + board(5) + "\n" +
                                        board(6) + " | " + board(7) + " | " + board(8) +"\n"))
    }
    
    it("prompts player and reads in a cell number for move selection"){
      terminal.input = 1.toString()
      assert(terminal.readCellNumber() == "1")
    } 
   
  }
}