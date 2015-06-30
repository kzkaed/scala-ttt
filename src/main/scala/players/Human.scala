package players
import base.GameRules

class Human (playerMark: String) extends Player {
  
  def selectMove(game: GameRules): String = {
    "1"
  }
  def getPlayerMark(): String = {
    playerMark
  }
  
}