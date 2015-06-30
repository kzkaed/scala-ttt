package ui

class TConsole extends UserInterface with OutputInput {
  val messageList = List("Welcome to Scala Tic Tac Toe",
                         "Goodbye")
  
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
  
  def readCellNumber(): String = {
    val in = readLine()
    in
  }
  
  def construct(board: Array[String]): String = {
    val b = board(0) + " | " + board(1) + " | " + board(2) + "\n" +
            board(3) + " | " + board(4) + " | " + board(5) + "\n" +
            board(6) + " | " + board(7) + " | " + board(8) + "\n"
    b
  }
  
  
}