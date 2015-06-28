package base

class Game(val board: List[String]) {
  
   def takeTurn(mark: String, move: String, board: List[String]): List[String] = {
      board.updated(moveNumber(move) , mark)
   }
   
   def end(): Boolean = {
     true
   }
     
   private def moveNumber (move: String): Int = {
     move.toInt - 1
   }
   
   
}