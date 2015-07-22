package base

import mocks._
import users._
import players._

import org.scalatest._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RunnerSpec extends FunSpec {
  val board = Array("1","2","3","4","5","6","7","8","9")
  val game = new MockGame(board: Array[String])
  val userInterface = new MockUserInterface
  val player1 = new MockPlayer
  val player2 = new MockPlayer
  val runner = new Runner(game, userInterface, player1, player2)

  it("has a game") {
    assert(runner.game == game)  
  }
  
  it("has a user interface") {
    assert(runner.userInterface == userInterface)
  }
  
  it("has players") {
    assert(runner.player1 == player1)
    assert(runner.player2 == player2)
  }
  
  it("displays game introduction with user interface"){
    runner.run
    assert(userInterface.isPrepareCalled == true)
  }
  
  it("displays the board with the user interface"){
    runner.run
    assert(userInterface.isDisplayBoardCalled == true)
  }
  
  it("receives player1 move from user interface"){
    val move = "1"
    player1.moves = move :: player1.moves
    
    runner.run
    
    assert(player1.selectMove(game) == "1")   
    assert(player1.isSelectMoveCalled == true)
  }
  
  it ("receives player2 move from user inteface") {
    val move = "2"
    player2.moves = move :: player2.moves
    
    runner.run
    
    assert(player2.selectMove(game) == "2")
    assert(player2.isSelectMoveCalled == true)
  }
   
  it ("sends move and player to game and gets a board") {
    val moveSelection = "1"
    val playerMark = "x"
    val fakeBoard = Array("x","2","3",
                          "4","5","6",
                          "7","8","9")
    game.boards = fakeBoard :: game.boards
   
    val boardResult = Array("x","2","3",
                            "4","5","6",
                            "7","8","9")
                           
    runner.run
    assert(game.takeTurn(moveSelection, playerMark) === boardResult)
    assert(game.isTakeTurnCalled == true)
  }  
  
  it ("it displays results to user interface") {
    runner.run
    assert(userInterface.isDisplayGameResultCalled == true)
  }
  
  it ("it displays goodbye when game has ended") {
    runner.run
    assert(userInterface.isGoodbyeCalled == true)
  }
  
  describe("playing game") {
  
    it ("it starts game") {
      runner.startGame()
      assert(userInterface.isPrepareCalled() == true)
      assert(userInterface.isDisplayBoardCalled() == true)
    }
  
    it ("it plays player1") {
      runner.makeMove(player1)
      assert(player1.isSelectMoveCalled() == true)
      assert(game.isTakeTurnCalled() == true)
      assert(userInterface.isDisplayBoardCalled() == true)
    }
    
    it ("it plays player2") {
      runner.makeMove(player2)
      assert(player2.isSelectMoveCalled() == true)
      assert(game.isTakeTurnCalled() == true)
      assert(userInterface.isDisplayBoardCalled() == true)
    }
    
    it ("it ends game") {
      runner.endGame()  
      assert(userInterface.isDisplayGameResultCalled() == true)
      assert(userInterface.isGoodbyeCalled() == true)
    }
    
  }
  
}
  
