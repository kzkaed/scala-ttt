package ai
import base.GameRules

trait Intelligence {
  def getBestMove(game: GameRules, playerMark: String): String 
}