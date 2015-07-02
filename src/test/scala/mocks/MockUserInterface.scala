package mocks
import gui.UserInterface
import base._

class MockUserInterface extends UserInterface {
  var prepareCalled: Boolean = false
  var displayBoardCalled: Boolean = false
  var cellNumberCalled: Boolean = false
  var cellSelection = "1"
  var displayGameResultCalled = false
  var goodbyeCalled = true
   
  def goodbye(): Unit = {  
    goodbyeCalled = true
  }
  
  def displayBoard(board: Array[String]): Unit = {
    displayBoardCalled = true
  }
  
  def displayGameResult(playerMark1: String, playerMark2: String, game: GameRules): Unit = {
    displayGameResultCalled = true
  }
  
  def prepare(): Unit = {
    prepareCalled = true
  }
  
   def readCellNumber(availableCells: List[String]): String = {
    cellNumberCalled = true
    cellSelection
  }
  
  //expectations
  def isPrepareCalled(): Boolean = {
    prepareCalled
  }
  
  def isDisplayBoardCalled(): Boolean = {
     displayBoardCalled
  }
  
  def isReadCellNumberCalled(): Boolean = {
    cellNumberCalled
  }
  def isDisplayGameResultCalled(): Boolean = {
    displayGameResultCalled
  }
  
  def isGoodbyeCalled(): Boolean = {
    goodbyeCalled
  }
  
  
 
 
}