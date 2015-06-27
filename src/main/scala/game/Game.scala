package game

class Game {

   def board: List[Char] = {
     List('1','2','3','4','5','6','7','8','9')
   }
   
   def takeTurn(mark: Char, move: Char, board: List[Char]): List[Char] = {
      board.updated(move.toInt - 1 , mark)
     //List('x','2','3','4','5','6','7','8','9')
  
   }
   
   
}