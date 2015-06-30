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
   
   def availableMoves(): Array[String] = {
   val result = board.clone().toSeq flatMap { cell => 
     if (cell != "x" && cell != "o") Seq(cell)
     else Seq()}
   result.toArray
   }
   
   private def getNumber (moveSelection: String): Int = {
     moveSelection.toInt - 1
   }
   
   
   
   
   
}