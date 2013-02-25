package object ruzzlesolver {
  type Board = Array[Array[Square]]
  def createBoard(y: Int, x: Int): Board = Array.ofDim[Square](y, x)
}