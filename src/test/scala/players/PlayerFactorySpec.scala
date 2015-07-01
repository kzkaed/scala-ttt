package players

import base.Game
import gui._
import mocks.MockUserInterface
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner


@RunWith(classOf[JUnitRunner])
class PlayerFactorySpec extends FunSpec {
  
  
 it("gets a human player") {
   val engine = new ai.Minimax
   val userInterface = new TConsole
   val player1 = PlayerFactory.getPlayer("human", "x", engine, userInterface)   
   val expected1 = new players.Human("x", userInterface)
   
   assert(player1.getClass === expected1.getClass)   
  }
 
  it("get a computer player"){
   val engine = new ai.Minimax
   val userInterface = new TConsole
   val player2 = PlayerFactory.getPlayer("computer", "o", engine, userInterface) 
   val expected2 = new players.Computer("o", engine)
  
   assert(player2.getClass === expected2.getClass)
  }
}