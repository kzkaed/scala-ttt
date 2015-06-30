package players
import base._
import ai._

trait Player{
  
  def selectMove(game: GameRules): String 
  def getPlayerMark():String
}