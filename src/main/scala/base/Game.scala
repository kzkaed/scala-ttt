package base


class Game(var board: Array[String]) extends GameRules {
  
  def getCurrentBoard(): Array[String] = {
    board
  }
  
   def takeTurn(moveSelection: String, playerMark: String): Array[String] = {
     val selection = getNumber(moveSelection)
     board.update(selection, playerMark)
     board
   }
   
   def isEnd(): Boolean = {
     isWin || isDraw 
   }
   
   def isWin(): Boolean = {
     isDiagonal || isDown || isAcross
   }
   
   def isDraw(): Boolean = {
     board.toSet.size == 2 && !isWin
   }
   
   def clearBoard(): Unit = {
     val result = (1 to 9) map { _.toString }   
     board = result.toArray
   }
   
   def availableMoves(): Array[String] = {
     val result = board.toSet.&~(Set("x","o"))
     result.toArray
   }
   
   def isAcross(): Boolean = {
     val row1 = (List(board(0), board(1),board(2)).distinct).size == 1
     val row2 = (List(board(3), board(4),board(5)).distinct).size == 1
     val row3 = (List(board(6), board(7),board(8)).distinct).size == 1
     row1 || row2 || row3
   }
   
   def isDown(): Boolean = {
    val col1 = (List(board(0), board(3),board(6)).distinct).size == 1
    val col2 = (List(board(1), board(4),board(7)).distinct).size == 1
    val col3 = (List(board(2), board(5),board(8)).distinct).size == 1
    col1 || col2 || col3
   }
   
   def isDiagonal(): Boolean = {
    (List(board(0), board(4),board(8)).distinct).size == 1 ||
    (List(board(2), board(4),board(6)).distinct).size == 1
   }  
   
   private def getNumber (moveSelection: String): Int = {
     moveSelection.toInt - 1
   }
   
   
}