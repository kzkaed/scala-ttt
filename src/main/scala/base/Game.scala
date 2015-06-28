package base

class Game(val board: Array[String]) {
  
   def takeTurn(mark: String, move: String): Array[String] = {
     val selection = moveNumber(move)
     board.update(selection, mark)
     board
   }
   
   def end(): Boolean = {
     true
   }
     
   private def moveNumber (move: String): Int = {
     move.toInt - 1
   }
   
   
}