package base

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GameSpec extends FunSpec {
  val board = Array("1","2","3","4","5","6","7","8","9")
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
      assert(game.isEnd == true)
    }
    
    it("should be a draw if no win"){
      assert(game.isDraw() == false)
    }
    
    it("should be a win if 3 in a row"){
      assert(game.isWin()==true)
    }
    
       
    
  
  
}
  
}