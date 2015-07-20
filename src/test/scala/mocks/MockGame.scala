package mocks
import base._

class MockGame (val board: Array[String]) extends GameRules {
  var boards = List[Array[String]]()
  var takeTurnCalled = false
  var endCalled = false
  var winCalled = false
  var winnerMarkCalled = false
  var clearAtCalled = false
  var getCurrentBoardCalled = false

  def getCurrentBoard(): Array[String] = {
    board
  }
  def clearBoard(): Unit = ???
  
  def isDraw(): Boolean = {
     false 
  }
  
  def isEnd(): Boolean = {
    endCalled = true
    true
  }
  
  def isWin(): Boolean = {
    winCalled = true
    true
  }
  
  def winnerMark() :String = {
    winnerMarkCalled = true
    "x"
  }
  
  def clearAt(cell: String): Unit = {
    clearAtCalled = true
  }
  
  def availableCells(): List[String] = {
    List("5", "6", "7", "8", "9")
  }
  
  override def takeTurn(moveSelection: String, playerMark: String): Array[String] = {
    takeTurnCalled = true
    if (boards.isEmpty) Array[String]("") else boards.head
  }
  
  def boardSize(): Int = {
    board.size
  }
  
  //expectations
  def isTakeTurnCalled(): Boolean = {
    takeTurnCalled
  }
  
  def isEndCalled(): Boolean = {
    endCalled
  }
  
  def isWinCalled(): Boolean = {
    winCalled
  }
  
  def isWinnerMarkCalled(): Boolean = {
    winnerMarkCalled
  }
  
  def isClearAtCalled(): Boolean = {
    clearAtCalled
  }
  
  
  
}