package base

class Game(val board: Array[String]) extends GameRules {
  
  def getCurrentBoard(): Array[String] = {
    board
  }
  
   def takeTurn(moveSelection: String, playerMark: String): Array[String] = {
     val selection = getNumber(moveSelection)
     board.update(selection, playerMark)
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
   
   private def getNumber (moveSelection: String): Int = {
     moveSelection.toInt - 1
   }
   
   
   
   
}