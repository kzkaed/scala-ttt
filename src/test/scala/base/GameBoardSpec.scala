package base

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GameBoardSpec extends FunSpec {
  
  
  describe("game board"){
   
    it("can have a board of 3 x 3") {     
      val expectedBoard = Array("1","2","3",
                               "4","5","6",
                               "7","8","9")
      val gameboard = new GameBoard(3)
      assert(gameboard.board === expectedBoard) 
    }
  
    it("can have a board of 4 x 4") {      
      val expectedBoard = Array("1","2","3","4",
                                "5","6","7","8",
                                "9","10","11","12",
                                "13","14","15","16")
      val gameboard = new GameBoard(4)
      assert(gameboard.board === expectedBoard) 
    }
  }
  
}
  