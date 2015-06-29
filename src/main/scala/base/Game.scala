package base

class Game(val board: Array[String]) extends GameRules {
  
  def getCurrentBoard(): Array[String] = {
    board
  }
  
   def takeTurn(mark: String, move: String): Array[String] = {
     val selection = moveNumber(move)
     board.update(selection, mark)
     board
   }
   
   def isEnd(): Boolean = {
     true
   }
   
   def isWin(): Boolean = {
     true
   }
   
   def isDraw(): Boolean = {
     false
   }
   
   def clearBoard(): Unit = {
     
   }
   
   private def moveNumber (move: String): Int = {
     move.toInt - 1
   }
   
   
   
   
}