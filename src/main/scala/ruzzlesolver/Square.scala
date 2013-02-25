package ruzzlesolver

case class Square(letter: Char, board: Board, y: Int, x: Int) {

  def up = move(-1, 0)
  def down = move(1, 0)
  def left = move(0, -1)
  def right = move(0, 1)
  
  def upleft = move(-1, -1)
  def upright = move(-1, 1)
  def downleft = move(1, -1)
  def downright = move(1, 1)

  def move(dy: Int, dx: Int): Option[Square] = {
    val _y = y + dy
    val _x = x + dx

    if (_y >= 0 && _y < board.size && _x >= 0 && _x < board(_y).size) Some(board(_y)(_x))
    else None
  }
  
  def getAdjacentSquares() : List[Square] = {
    List(upleft, left, downleft, down, downright, right, upright, up).filter {
      case Some(s) => true
      case _ => false
    }.map(option => option.get)
  }
  
  override def toString = letter.toString()
}