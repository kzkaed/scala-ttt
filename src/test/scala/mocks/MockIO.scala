package mocks
import ui._

trait MockIO extends OutputInput {
  var messages: Seq[String] = Seq()
  var output = ""
  var input = ""
  
  override def println(s: String): Unit = {
    output = s
  }
  
  override def readLine(): String = {
    input
  }
  
  def prepare(): Unit 
  def displayBoard(board: Array[String]): Unit
  def goodbye(): Unit
  def readCellNumber(): String
  
  override def print(s: String) = messages = messages :+ s
  
}