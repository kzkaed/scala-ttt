package gui

class TConsole extends UserInterface with OutputInput {
  val messageList = List("Welcome to Scala Tic Tac Toe",
                         "Goodbye")
  val cells = List("1","2","3","4","5","6","7","8","9")
  
  
  def prepare(): Unit = {
    print(messageList(0))
  }
  
  def displayBoard(board: Array[String]) = {
    val formatted = construct(board)
    print(formatted)
  }
  
  def goodbye(): Unit = {
    print(messageList(1))
  }
  
  def readCellNumber(availableCells: List[String]): String = {
    askForCellNumber
    val cell = readLine()
    validate(cell, availableCells)   
  }
  
  def construct(board: Array[String]): String = {
   board(0) + " | " + board(1) + " | " + board(2) + "\n" +
   board(3) + " | " + board(4) + " | " + board(5) + "\n" +
   board(6) + " | " + board(7) + " | " + board(8) + "\n"
  }
  
  private def askForCellNumber() = { print("Enter cell number: ") }
 
  private def isValid(cell: String, availableCells: List[String]): Boolean = {
    availableCells.contains(cell)
  }
  
  private def askForCellNumberAgain(availableCells: List[String]) = {
    print("Incorrect input, try again: ")
    readCellNumber(availableCells: List[String])   
  }
  
  private def validate(cell: String, availableCells: List[String]):String = {
    if(isValid(cell,availableCells)) cell
    else askForCellNumberAgain(availableCells: List[String])  
  }
  
}