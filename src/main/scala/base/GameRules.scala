package base


trait GameRules {

  def board(): Array[String]
  def takeTurn(moveSelection: String, playerMark: String): Array[String]
  def isDraw(): Boolean
  def isWin(): Boolean
  def isEnd(): Boolean
  def clearBoard(): Unit
  def availableCells(): List[String]
  def winnerMark(): String
  def clearAt(cell: String): Unit
  def boardSize(): Int
}