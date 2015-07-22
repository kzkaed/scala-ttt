package players

import base.Game
import ai._
import gui._
import players._
import mocks.MockUserInterface
import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PlayerFactorySpec extends FunSpec {
    
 it("gets a human player") {
   val engine = new Negamax
   val userInterface = new CLInterface
   val player1 = PlayerFactory.getPlayer("human", "x", engine, userInterface)   
   val expected1 = new Human("x", userInterface)
   
   assert(player1.getClass == expected1.getClass)   
  }
 
  it("get a computer player"){
   val engine = new Negamax
   val userInterface = new CLInterface
   val player2 = PlayerFactory.getPlayer("computer", "o", engine, userInterface) 
   val expected2 = new Computer("o", engine)
  
   assert(player2.getClass == expected2.getClass)
  }
}