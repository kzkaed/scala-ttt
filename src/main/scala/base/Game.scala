package base

class Game(var board: Array[String]) extends GameRules {
  
   def takeTurn(moveSelection: String, playerMark: String): Array[String] = {
     board.update(getNumber(moveSelection), playerMark)
     board
   }
   
   def isEnd: Boolean = { 
     isWin || isDraw 
   }
    
   def isWin: Boolean = { 
     isWinDiagonal || isWinDown || isWinAcross
   }
 
   def isDraw: Boolean = { 
     boardSet.size == 2 && !isWin
   }
      
   def availableCells: List[String] = { 
     eliminateTakenCells.toList.sorted
   }
          
   def winnerMark: String = {
     if (numberOfXs > numberOfOs) Mark.x
     else Mark.o
   }
   
   def clearAt(cell: String): Unit = {
     board(cell.toInt - 1) = cell
   }
   
   def clearBoard(): Unit = {  
     board = ((1 to boardSize) map(_.toString)).toArray
   }
   
   def isWinAcross: Boolean = {
     isDistinctSizeOne(rows(board)).contains(true)
   }
   
   def isDistinctSizeOne(groups: List[Array[String]]): List[Boolean] = {
   val result = groups flatMap { group =>
     if ((group.distinct).size == 1) Seq(true)
     else Seq(false)}
   result.toList
   }
   
   def rows(b: Array[String]): List[Array[String]] = {
     b.grouped(winSize(b)).toList
   }
   
   def isWinDown: Boolean = {   
    isDistinctSizeOne(columns(board)).contains(true)
   }
   
   def columns(b: Array[String]) = {
     Array(b(0), b(3), b(6))::
     Array(b(1), b(4), b(7))::
     Array(b(2), b(5), b(8)):: List()
   }
   
   def diaganols(b: Array[String]) = {
     Array(b(0), b(4), b(8))::
     Array(b(2), b(4), b(6)):: List()
   }
   def isWinDiagonal: Boolean = {
    isDistinctSizeOne(diaganols(board)).contains(true)
   }  
   
   private def getNumber (moveSelection: String): Int = {
     moveSelection.toInt - 1
   }
   
    private def numberOfXs: Int = {
     board.filter { cell => cell == Mark.x }.length
   }
   
   private def numberOfOs: Int = {
     board.filter { cell => cell == Mark.o }.length
   }
   
   private def eliminateTakenCells: Set[String] = {
     boardSet.&~(Set( Mark.x, Mark.o ))
   }
   
   private def boardSet: Set[String] = {
     board.toSet
   }
   
   def boardSize(): Int = {
     board.size
   }
   
   def winSize(b: Array[String]): Int = {
     scala.math.sqrt(b.size).toInt
   }
    
}