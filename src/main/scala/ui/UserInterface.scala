package ui

trait UserInterface {
  
  def print(s: String) = Predef.println()
  
  def goodbye(): Unit 
  
}