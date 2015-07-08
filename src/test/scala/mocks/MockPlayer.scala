package mocks
import players.Player
import base.GameRules

class MockPlayer extends Player{
  var moves = List[String]()
  var selectMoveCalled = false
  var playerMark = "x"
  
   override def selectMove(game: GameRules): String = {
    selectMoveCalled = true 
    if (moves.isEmpty) "" else moves.head
  }

  //expectations
  def isSelectMoveCalled(): Boolean = {
    selectMoveCalled
  }
 
}