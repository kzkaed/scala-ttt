package players
import base.Game
import ai._

class Computer(engine: Intelligence) extends Player {
  
  def determineMove(game: Game): String = {
    val move = engine.getBestMove(game)
    move
  }
 
  
}