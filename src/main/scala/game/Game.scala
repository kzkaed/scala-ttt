package game

class Game {

   def board: List[String] = {
     List("1","2","3","4","5","6","7","8","9")
   }
   
   def takeTurn(mark: String, move: String, board: List[String]): List[String] = {
      board.updated(moveNumber(move) , mark)
   }
     
   private def moveNumber (move: String): Int = {
     move.toInt - 1
   }
   
   
}