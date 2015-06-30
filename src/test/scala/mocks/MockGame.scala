package mocks
import base._


class MockGame (val board: Array[String]) extends GameRules {
var boards = List[Array[String]]()
var takeTurnCalled = false

  def getCurrentBoard(): Array[String] = {
    board
  }
  def clearBoard(): Unit = ???
  def isDraw(): Boolean = {
      false 
  }
  def isEnd(): Boolean = {
    true
  }
  def isWin(): Boolean = {
    true
  }
  override def takeTurn(moveSelection: String, playerMark: String): Array[String] = {
    takeTurnCalled = true
    if (boards.isEmpty) Array[String]("") else boards.head
  }
  
  //expectations
  def isTakeTurnCalled(): Boolean = {
    takeTurnCalled
  }
  
  
}