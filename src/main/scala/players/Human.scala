package players
import base.GameRules

class Human (playerMark: String) extends Player {
  
  def selectMove(game: GameRules): String = {
    ""
  }
  def getPlayerMark(): String = {
    playerMark
  }
  
}