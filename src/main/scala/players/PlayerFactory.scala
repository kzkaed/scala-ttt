package players

import ai._

object PlayerFactory {
  
  def getPlayer(s: String, playerMark: String, engine: Intelligence): Player = {
    if(s == "computer") return new Computer(playerMark,engine)
    else return new Human(playerMark)
  }
}