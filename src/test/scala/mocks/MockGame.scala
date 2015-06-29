package mocks
import base._


class MockGame (val board: Array[String]) extends GameRules {

  def getCurrentBoard(): Array[String] = {
    board
  }
  def clearBoard(): Unit = ???
  def isDraw(): Boolean = ???
  def isEnd(): Boolean = ???
  def isWin(): Boolean = ???
  def takeTurn(mark: String,move: String): Array[String] = ???
  
}