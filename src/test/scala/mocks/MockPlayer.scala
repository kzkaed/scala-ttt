package mocks
import players.Player
import base.GameRules

class MockPlayer extends Player{
  var moves = List[String]()
  var selectMoveCalled = false
  var playerMark = "x"
  var getPlayerMarkCalled = false
  
   override def selectMove(game: GameRules): String = {
    selectMoveCalled = true 
    if (moves.isEmpty) "" else moves.head
  }
  
  def getPlayerMark(): String = {
    getPlayerMarkCalled = true
    playerMark
  }
 
  
  //expectations
  def isSelectMoveCalled(): Boolean = {
    selectMoveCalled
  }
  
  def isGetPlayerMarkCalled() : Boolean = {
    getPlayerMarkCalled 
  }
  
}