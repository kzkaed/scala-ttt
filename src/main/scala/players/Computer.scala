package players
import base.GameRules
import ai._

class Computer(playerMark: String, engine: Intelligence) extends Player {
  
  def selectMove(game: GameRules): String = {
    val move = engine.getBestMove(game, playerMark)
    move
  }
  
  def getPlayerMark() : String = {
    playerMark
  }
 
  
}