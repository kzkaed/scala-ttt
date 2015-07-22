package gui
import base._
class CLInterfacePresenter {
  
  def construct(board: Array[String]): String = {
    
     var result = board(0) + " | " + board(1) + " | " + board(2) + "\n" +
                  board(3) + " | " + board(4) + " | " + board(5) + "\n" +
                  board(6) + " | " + board(7) + " | " + board(8) + "\n"
     if(board.size == 16){
       
       result = board(0) + "  | " + board(1) + "  | " + board(2) + "  | " + board(3) + "\n" + 
                board(4) + "  | " + board(5) + "  | " + board(6) + "  | " + board(7) + "\n" + 
                board(8) + "  | " + board(9) + " | " + board(10) + " | " + board(11) + "\n" + 
                board(12) + " | " + board(13) + " | " + board(14) + " | " + board(15) + "\n"  
     }
     result
  }
  
  
   def gameResult(playerMark1: String, playerMark2: String, game: GameRules): String = {
    if (game.isWin) game.winnerMark() + Communication.messages('win)
    else Communication.messages('draw)
  }
  
}