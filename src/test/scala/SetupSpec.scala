import players._
import ai._
import users._
import base._

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SetupSpec extends FunSpec {
    val setup = new Setup() 
    val userInterface = new CLInterface
    val gameboard = new GameBoard(3)
    val game = new Game(gameboard.board)
    val engine = new Negamax
    val defaultPlayer1 = new Human(Mark.x, userInterface) 
    val defaultPlayer2 = new Human(Mark.o, userInterface) 
  
    describe("Setup") {
      it ("has default players") {     
        
        assert(setup.defaultPlayer1.getClass == defaultPlayer1.getClass)
        assert(setup.defaultPlayer2.getClass == defaultPlayer2.getClass)     
      }
    
      it ("has game") {  
        assert(setup.game.getClass == game.getClass)    
      }
      
      it("has an intelligence engine") {
        assert(setup.engine.getClass == engine.getClass)
      }
      
      it("has a userInteface"){
        assert(setup.userInterface.getClass == userInterface.getClass)
      }
    }
    
    describe("Arguments Matcher"){
      it("assigns human computer players"){
        val expected = new Human(Mark.x, userInterface) :: new Computer(Mark.o, engine) :: List()
        val players = setup.matchArgs("HC")       
        assert(players.head.getClass == expected.head.getClass)
        assert(players.last.getClass == expected.last.getClass)
      }
      
      it("assigns computer human players"){
        val expected = new Computer(Mark.x, engine):: new Human(Mark.o, userInterface) :: List()
        val players = setup.matchArgs("CH")       
        assert(players.head.getClass == expected.head.getClass)
        assert(players.last.getClass == expected.last.getClass)
      }
      
       it("assigns computer computer players"){
        val expected = new Computer(Mark.x, engine):: new Computer(Mark.o, engine) :: List()
        val players = setup.matchArgs("CC")       
        assert(players.head.getClass == expected.head.getClass)
        assert(players.last.getClass == expected.last.getClass)
      }
       
       it("assigns default case of players"){
        val expected = defaultPlayer1 :: defaultPlayer2 :: List()
        val players = setup.matchArgs("aldjfljlj")       
        assert(players.head.getClass == expected.head.getClass)
        assert(players.last.getClass == expected.last.getClass)
      }
    }

}