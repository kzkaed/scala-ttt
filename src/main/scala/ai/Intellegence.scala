package ai
import base.Game

trait Intelligence {
  def getBestMove(game: Game): String 
}