package ruzzlesolver
import org.scalatest.FunSuite
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import java.util.Arrays
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class SquareTest extends FunSuite with ShouldMatchers {
  
  val board = {
    val arrays = createBoard(4, 4)
    
    for {
      y <- 0 until arrays.size
      x <- 0 until arrays(y).size
    } yield {
      arrays(y)(x) = new Square('a', arrays, y, x)
    }

    arrays
  }
  
  test("up down left right") {
    board(0)(0).up should equal (None)
    board(3)(3).up should equal (Some(board(2)(3)))

    board(1)(0).left should equal (None)
    board(0)(1).left should equal (Some(board(0)(0)))
    
    board(3)(3).right should equal (None)
    board(1)(1).right should equal (Some(board(1)(2)))
    
    board(3)(2).down should equal (None)
    board(2)(2).down should equal (Some(board(3)(2)))
  }
  
  test("diagonals") {
    board(0)(3).upleft should equal (None)
    board(3)(0).upleft should equal (None)
    board(2)(1).upleft should equal (Some(board(1)(0)))
    
    board(0)(0).upright should equal (None)
    board(2)(3).upright should equal (None)
    board(2)(0).upright should equal (Some(board(1)(1)))
    
    board(1)(1).downleft should equal (Some(board(2)(0)))
    board(3)(1).downleft should equal (None)
    board(1)(0).downleft should equal (None)
    
    board(3)(2).downright should equal (None)
    board(1)(3).downright should equal (None)
    board(0)(2).downright should equal (Some(board(1)(3)))
  }
}