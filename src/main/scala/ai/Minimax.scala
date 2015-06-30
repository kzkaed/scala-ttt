package ai
import base.GameRules

class Minimax extends Intelligence {
  
  def getBestMove(game: GameRules, playerMark: String): String = {
    "9"
  }
  
  def switchPlayerMark(playerMark: String): String = {
    if (playerMark.contentEquals("x")) "o" else "x"
  }
 
}