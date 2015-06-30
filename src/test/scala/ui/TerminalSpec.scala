package ui

import base.Game
import mocks.MockIO
import org.scalatest._

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TerminalSpec extends FunSpec{
  val board = Array("")
  val game = new Game(board)
  val terminal = new Terminal with MockIO
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
  
    it("displays a board unformatted") {
      terminal.displayBoard(board)
      assert(terminal.messages.contains(board.toString))
    }
    
    it("prompts player and reads in a cell number for move selection"){
      terminal.input = 1.toString()
      assert(terminal.readLine() == "1")
    } 
    
  }
}