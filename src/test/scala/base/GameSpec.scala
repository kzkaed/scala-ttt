package base

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GameSpec extends FunSpec {
  val board = Array("1","2","3",
                    "4","5","6",
                    "7","8","9")
  val game = new Game(board: Array[String])
  
  describe("game board"){
    it("should have a board") {
      val defaultBoard = Array("1","2","3","4","5","6","7","8","9")
      
      assert(game.board === defaultBoard) 
    }
  }
  
  describe("game rules"){
    it("should take a turn with an x"){
      val boardBeforTurn = Array("1","2","3","4","5","6","7","8","9")
      val moveSelection = "1"
      val playerMark = "x"
      val boardAfterTurn = Array("x","2","3","4","5","6","7","8","9")
      
      assert(game.takeTurn(moveSelection, playerMark) === boardAfterTurn )
    }
    
    it("should take another turn with an o"){
      val boardBeforeTurn = Array("x","2","3","4","5","6","7","8","9")
      val moveSelection = "2"
      val playerMark = "o"
      val boardAfterTurn = Array("x","o","3","4","5","6","7","8","9")
       
      assert(game.takeTurn(moveSelection, playerMark) === boardAfterTurn )
    }
  
    it("should end if winner"){
       game.board = Array("x","o","x",          
                         "o","x","o",
                         "o","x","x")
      assert(game.isEnd == true)
    }
  
    it("should be a draw if no win"){
      game.board = Array("x","o","x",
                         "o","x","o",
                         "o","x","9") 
      assert(game.isDraw() == false)
      
      game.board = Array("x","o","x",
                         "o","x","o",
                         "o","x","o") 
      assert(game.isDraw() == true)
    }

    
    it("should not be a win"){
      game.board = Array("x","x","o",
                         "o","x","o",
                         "x","o","9") 
      assert(game.isWin() == false)
    } 
    
    it("should be win"){
      game.board = Array("x","o","x",          
                         "o","x","o",
                         "o","x","x") 
      assert(game.isWin()==true)
    }
   
    
    it("has available moves") {
      game.board = Array("x","o","x","o","5","6","7","8","9")
      assert(game.availableCells.sorted === List("5", "6", "7", "8", "9"))
      assert(game.board === Array("x","o","x","o","5","6","7","8","9"))
    }
    
    it("has 3 across") {
       game.board = Array("x","x","x","o","5","6","7","8","9")
      assert(game.isWinAcross == true)   
    }
    
    it("has 3 down") {
       game.board = Array( "x","o","o",
                           "x","5","6",
                           "x","8","9" )
       assert(game.isWinDown == true) 
    }
    
    it("has 3 on diagonals") {
       game.board = Array( "x","o","o",
                           "o","x","6",
                           "o","8","x" )
       assert(game.isWinDiagonal == true) 
    }
    
    it("clears the board"){
      game.board = Array("x","o","x",          
                         "o","x","o",
                         "o","x","x") 
      game.clearBoard()
      assert(game.board === Array("1","2","3",          
                                  "4","5","6",
                                  "7","8","9"))
    }
    
    it("gets a winner mark on win") {
      game.board = Array("x","o","x",          
                         "o","x","o",
                         "o","x","x") 
      assert(game.winnerMark() == "x")
    }
    
    it("clears a cell") {
      game.board = Array("1","2","3",          
                         "4","5","6",
                         "7","8","x") 
      var cell = "9"
      game.clearAt(cell)
      assert(game.board === Array("1","2","3",          
                                  "4","5","6",
                                  "7","8","9"))
    }

  }
  
}