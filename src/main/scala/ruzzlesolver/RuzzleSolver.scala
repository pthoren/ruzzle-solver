package ruzzlesolver

import scala.collection.immutable.TreeSet
import scala.collection.mutable.Set
import scala.io.Source

object RuzzleSolver {

  def main(args: Array[String]): Unit = {
    val board = createBoardFromInput(4, 4)
    
    val startTime = System.nanoTime()
    val words = findWords(board)
    val endTime = System.nanoTime()
    
    println("Search took: " + (endTime - startTime) / 1000000 + " ms")
    println("Found " + words.size + " words:")
    println(words.sortWith((s1, s2) => s1.length() > s2.length()))
  }

  /**
   * Word corpus, read into a TreeSet for efficient indexing
   */
  val dictionary = {
    val stream = getClass.getClassLoader().getResourceAsStream("dictionary.txt")

    new TreeSet[String]() ++ {
      for (line <- Source.fromInputStream(stream).getLines()) yield {
        line.toLowerCase()
      }
    }
  }

  /**
   * Note: no input validation at the moment
   */
  def createBoardFromInput(y: Int, x: Int): Board = {
    val board = createBoard(y, x)

    for (y <- 1 to 4) {
      val input = Console.readLine("Enter row " + y + "'s letters: ")
      input.view.zipWithIndex foreach { case (c, x) => board(y - 1)(x) = new Square(c, board, y - 1, x) }
    }

    board
  }

  /**
   * Iterate over every square in a board, and return the list of words which can be formed
   * starting at each square.
   */
  def findWords(board: Board): List[String] = {
    (for (row <- board; square <- row)
      yield findWords("", square, board, List[Square]())).flatten.toList
  }

  /**
   * Recursive breadth-first search from a starting square looking for valid words.
   */
  def findWords(prefix: String, start: Square, board: Board, visited: List[Square]): Set[String] = {
    val currentString = prefix + start.letter
    val words = Set[String]()
    
    if (dictionary.contains(currentString)) words += currentString

    for (square <- newSquaresOnly(start.getAdjacentSquares(), visited)) {
      if (dictionaryContainsPrefix(currentString + square.letter)) //prune search tree
    	  words ++= findWords(currentString, square, board, start :: visited)
    }
    
    words
  }
  
  def newSquaresOnly(available: List[Square], visited: List[Square]): List[Square] = {
    available.filter(!visited.contains(_))
  }
  
  def dictionaryContainsPrefix(prefix: String) : Boolean = {
    val tailset = dictionary.from(prefix)
    val head = tailset.headOption.getOrElse("")
    
    head.startsWith(prefix)
  }
}