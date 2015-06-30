package mocks
import ui.UserInterface

class MockUserInterface extends UserInterface {
  var prepareCalled: Boolean = false
  var displayBoardCalled: Boolean = false
  
  def goodbye(): Unit = {
    
  }
  def displayBoard(board: Array[String]): Unit = {
    displayBoardCalled = true
  }
  
  def prepare(): Unit = {
    prepareCalled = true
  }
  
  //expectations
  def isPrepareCalled(): Boolean = {
    prepareCalled
  }
  
  def isDisplayBoardCalled(): Boolean = {
     displayBoardCalled
  }
 
}