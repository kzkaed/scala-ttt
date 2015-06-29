package base


trait GameRules {

  def getCurrentBoard(): Array[String]
  def takeTurn(mark: String, move: String): Array[String]
  def isDraw(): Boolean
  def isWin(): Boolean
  def isEnd(): Boolean
  def clearBoard() : Unit
}