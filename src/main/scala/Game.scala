package main.scala

/**
 * @author kristin-8thlight
 */
class Game {
  
  def token(strings: String*): Seq[String] = {
    strings.map((s:String) => s.toLowerCase())
  }
  
  
  
}