package base

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GameSpec extends FunSpec {
  val board = Array("1", "2", "3",
                    "4", "5", "6",
                    "7", "8", "9")
  val game = new Game(board: Array[String])

  describe("game board") {
    it("should have a board") {
      val defaultBoard = Array("1", "2", "3", "4", "5", "6", "7", "8", "9")

      assert(game.board === defaultBoard)
    }
  }

  describe("game rules") {
    it("should take a turn with an x") {
      val boardBeforTurn = Array("1", "2", "3", "4", "5", "6", "7", "8", "9")
      val moveSelection = "1"
      val playerMark = "x"
      val boardAfterTurn = Array("x", "2", "3", "4", "5", "6", "7", "8", "9")

      assert(game.takeTurn(moveSelection, playerMark) === boardAfterTurn)
    }

    it("should take another turnit with an o") {
      val boardBeforeTurn = Array("x", "2", "3", "4", "5", "6", "7", "8", "9")
      val moveSelection = "2"
      val playerMark = "o"
      val boardAfterTurn = Array("x", "o", "3", "4", "5", "6", "7", "8", "9")

      assert(game.takeTurn(moveSelection, playerMark) === boardAfterTurn)
    }

    it("should end if winner") {
      game.board = Array("x", "o", "x",
                         "o", "x", "o",
                         "o", "x", "x")
      assert(game.isEnd == true)
    }

    it("should be a draw if no win") {
      game.board = Array("x", "o", "x",
                         "o", "x", "o",
                         "o", "x", "9")
      assert(game.isDraw() == false)

      game.board = Array("x", "o", "x",
                         "o", "x", "o",
                         "o", "x", "o")
      assert(game.isDraw() == true)
    }

    it("should not be a win") {
      game.board = Array("x", "x", "o",
                         "o", "x", "o",
                         "x", "o", "9")
      assert(game.isWin() == false)
    }

    it("should be win") {
      game.board = Array("x", "o", "x",
                         "o", "x", "o",
                         "o", "x", "x")
      assert(game.isWin() == true)
    }

    it("has available moves") {
      game.board = Array("x", "o", "x", "o", "5", "6", "7", "8", "9")
      assert(game.availableCells.sorted === List("5", "6", "7", "8", "9"))
      assert(game.board === Array("x", "o", "x", "o", "5", "6", "7", "8", "9"))
    }

    it("has 3 across") {
      game.board = Array("x", "x", "x", "o", "5", "6", "7", "8", "9")
      assert(game.isWinAcross == true)
    }

    it("has 3 down") {
      game.board = Array("x", "o", "o",
                         "x", "5", "6",
                         "x", "8", "9")
      assert(game.isWinDown == true)
    }

    it("has 3 on diagonals") {
      game.board = Array("x", "o", "o",
                         "o", "x", "6",
                         "o", "8", "x")
      assert(game.isWinDiagonal == true)
    }

    it("clears the board") {
      game.board = Array("x", "o", "x",
                         "o", "x", "o",
                         "o", "x", "x")
      game.clearBoard()
      assert(game.board === Array("1", "2", "3",
                                  "4", "5", "6",
                                  "7", "8", "9"))
    }

    it("gets a winner mark on win") {
      game.board = Array("x", "o", "x",
                         "o", "x", "o",
                         "o", "x", "x")
      assert(game.winnerMark() == "x")
    }

    it("clears a cell") {
      game.board = Array("1", "2", "3",
                         "4", "5", "6",
                         "7", "8", "x")
      var cell = "9"
      game.clearAt(cell)
      assert(game.board === Array("1", "2", "3",
                                  "4", "5", "6",
                                  "7", "8", "9"))
    }

    it("has board size") {
      val size = game.boardSize()
      assert(size == 9)
    }

    it("can determin row, column or diagnol win size based on board size") {
      assert(game.winSize == 3)
    }

    it("can determine a win of 4 across") {
      game.board = Array("x", "x", "x", "x",
                         "5", "6", "7", "8",
                         "9", "10", "11", "12",
                         "13", "14", "15", "16")
      assert(game.isWinAcross == true)
    }

    it("checks for uniqueness of mark in row where each row is false") {
      game.board = Array("x", "x", "x", "o",
                         "5", "6", "7", "8",
                         "9", "10", "11", "12",
                         "13", "14", "15", "16")
      assert(game.isDistinctSizeOne == List(false, false, false, false))
    }
    
    it("checks for uniqueness of mark in row where a row is true") {
      game.board = Array("x", "x", "x", "x",
                         "5", "6", "7", "8",
                         "9", "10", "11", "12",
                         "13", "14", "15", "16")
      assert(game.isDistinctSizeOne == List(true, false, false, false))
    }
    
    it("makes rows from anysize board") {
      val intb = List(1,2,3,4,5,6,7,8,9)
      val b = game.rows2(intb)               
      assert(b.toList === List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9)))
    }
    
     it("makes rows from board") {
      game.board = Array("1", "1", "1", "1", "1", "1", "1", "1", "1")
      val b = game.rows(game.board) 
      b.foreach { row => assert(row === Array("1", "1", "1")) }
      
    }

  }

}