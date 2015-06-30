package mocks
import ui.UserInterface

class MockUserInterface extends UserInterface {
  var prepareCalled: Boolean = false
  var displayBoardCalled: Boolean = false
  var cellNumberCalled: Boolean = false
  var cellSelection = "1"
  
  
  def goodbye(): Unit = {  
  }
  
  def displayBoard(board: Array[String]): Unit = {
    displayBoardCalled = true
  }
  
  def prepare(): Unit = {
    prepareCalled = true
  }
  
   def readCellNumber(): String = {
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
  
 
 
}