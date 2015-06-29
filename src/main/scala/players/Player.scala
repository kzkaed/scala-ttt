package players
import base.Game
import ai._

trait Player{
  
  def determineMove(game: Game): String 
  
}