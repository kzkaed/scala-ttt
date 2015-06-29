package players
import ai._

object PlayerFactory {
  
  def getPlayer(s: String, engine: Intelligence): Player = {
    if(s == "computer") return new Computer(engine)
    else return new Human
  }
}