package ai

class Minimax extends Intelligence {
  
  def getBestMove(game: base.Game): String = {
    "9"
  }
  
  def switchPlayerMark(playerMark: String): String = {
    if (playerMark.contentEquals("x")) "o" else "x"
  }
 
}