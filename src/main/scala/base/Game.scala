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
   
   def isWinAcross: Boolean = {
     isDistinctSizeOne(rows(board.toList)).contains(true)
   }
   
   def isDistinctSizeOne(groups: List[List[String]]): List[Boolean] = {
   val result = groups flatMap { group =>
     if ((group.distinct).size == 1) Seq(true)
     else Seq(false)}
   result.toList
   }
   
   def rows(b: List[String]): List[List[String]] = {
     b.grouped(winSize(b)).toList
   }
   
   def isWinDown: Boolean = {   
    isDistinctSizeOne(columns(board.toList)).contains(true)
   }
   
   def columns(b: List[String]): List[List[String]] = {
     b.grouped(winSize(b)).toList.transpose
   }
    
   def diaganols(b: List[String]) = {
     List(b(0), b(4), b(8))::
     List(b(2), b(4), b(6)):: List()
   }
   def isWinDiagonal: Boolean = {
    isDistinctSizeOne(diaganols(board.toList)).contains(true)
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
   
   def winSize(b: List[String]): Int = {
     scala.math.sqrt(b.size).toInt
   }
    
}