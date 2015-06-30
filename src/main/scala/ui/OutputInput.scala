package ui

trait OutputInput {
  def print(s: String) = Console.println(s)
  def println(s: String) = Predef.println(s)
  def readLine() = scala.io.StdIn.readLine()  
}