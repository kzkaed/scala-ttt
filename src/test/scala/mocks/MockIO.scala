package mocks
import gui._

trait MockIO extends OutputInput {
  var messages: Seq[String] = Seq()
  var output = ""
  var input = ""
  
  override def println(s: String): Unit = { output = s }
  
  override def readLine(): String = { input }
  
  def prepare(): Unit 
  def displayBoard(board: Array[String]): Unit
  def goodbye(): Unit
  def readCellNumber(availableCells: List[String]): String
  
  override def print(s: String) = messages = messages :+ s
  
}