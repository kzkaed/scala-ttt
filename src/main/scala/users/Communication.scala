package users

object Communication {
  val messages = Map ('welcome   -> "Welcome to Scala Tic Tac Toe",
                      'enter     -> "Enter cell number: ",
                      'incorrect -> "Incorrect input, try again.",
                      'win       -> " Wins!", 
                      'draw      -> "It is a draw.",
                      'goodbye   -> "Goodbye")
}