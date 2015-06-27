package main.scala

/**
 * @author kristin-8thlight
 */
class Game {
  
  def main(args: Array[String]) {
    
  }
  
  def change1(words: String*): Seq[String] = {
    words.map((s:String) => s.toLowerCase())
  }
  
  def change2(letters: String): String = {
    letters.toLowerCase()
  }
  
}