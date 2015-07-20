package base

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GameBoardSpec extends FunSpec {
  val expectedBoard = Array("1","2","3",
                            "4","5","6",
                            "7","8","9")
  val board = new GameBoard(3)
  
  describe("game board"){
    it("should have a board") {      
      assert(board.board === expectedBoard) 
    }
  }
  
}
  