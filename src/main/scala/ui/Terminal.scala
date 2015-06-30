package ui

class Terminal extends UserInterface with OutputInput {
  val messageList = List("Welcome to Scala Tic Tac Toe",
                         "Goodbye")
  
  def prepare(): Unit = {
    print(messageList(0))
  }
  
  def displayBoard(board: Array[String]) = {
    print(board.toString())
  }
  
  def goodbye(): Unit = {
    print(messageList(1))
  }
  
  def readCellNumber(): String = {
    val in = readLine()
    in
  }
  
  
  
}