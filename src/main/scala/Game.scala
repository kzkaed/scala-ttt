package main.scala

/**
 * @author kristin-8thlight
 */
class Game {
  
  def main(args: Array[String]) {
    
  }
  
  def change1(strings: String*): Seq[String] = {
    strings.map((s:String) => s.toLowerCase())
  }
  
  def change2(string: String) = {
    string.toLowerCase()
  }
  
}