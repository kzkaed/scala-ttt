package mocks
import ui.UserInterface

trait MockUserInterface extends UserInterface {
  
  var messages: Seq[String] = Seq()
  
  override def print(s: String) = messages = messages :+ s
 
}