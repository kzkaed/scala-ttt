package base

class GameBoard (val size: Int){ 
  val cells = 1 to (size * size)
  var board = cells.toArray map { x => x.toString()}
}