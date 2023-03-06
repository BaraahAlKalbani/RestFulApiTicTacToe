package com.TicTacToeBot.TicTacToeBot.app.Model;

public class Board {
  private char[][] grid;
  private Bot bot1Symbol;
  private Bot bot2Symbol;
  private Boolean Win=false;
  private String winner;

  /**
   * Constructor for Board object that takes in a 2D char array as the game grid, and initializes
   * bot1Symbol and bot2Symbol with 'X' and 'O' respectively.
   * @param grid a 2D char array representing the game grid
   */
  public Board(char[][] grid) {
    this.grid = grid;
    this.bot1Symbol = new Bot('X');
    this.bot2Symbol = new Bot('O');
    this.winner="None";
  }

  /**
   * Checks if the game has ended in a draw by iterating through each cell of the game grid. If any cell
   * is empty, the game is not a draw and the method returns false. Otherwise, the game is a draw and the
   * winner is set to "it's A Draw !!!".
   * @return true if the game is a draw, false otherwise
   */
  public boolean checkDraw() {
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (grid[row][col] == ' ') {
          return false;
        }
      }
    }
    setWinner("it's A Draw !!!");
    return true;
  }
  /**
   * Checks if the game has ended in a draw by iterating through each cell of the game grid. If any cell
   * is empty, the game is not a draw and the method returns false. Otherwise, the game is a draw and the
   * winner is set to "it's A Draw !!!".
   * @return true if the game is a draw, false otherwise
   */
  public boolean checkIfFull() {
    checkWinner();
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (grid[row][col] == ' ') {
          return false;
        }
      }
    }
    return true;
  }

  /**
   * Checks if the board contains any invalid characters.
   * @return true if the board contains an invalid character, false otherwise
   */
  public  boolean containsInvalidChar() {
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        char symbol = grid[row][col];
        if (symbol != bot1Symbol.getSymbol() && symbol != bot2Symbol.getSymbol() && symbol != ' ') {
          return true; // found an invalid character
        }
      }
    }
    return false; // no invalid characters found
  }

  /**
   * Checks if there is a winner in the TicTacToe game by checking all the rows and columns of the grid.
   * If a winning pattern is found, the winner is set and the win flag is set to true.
   * @return boolean indicating if there is a winner or not
   */
  public boolean checkWinner() {
    // Check rows
    for (int row = 0; row < 3; row++) {
      if (grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2]) {
        if (grid[row][0] != ' ') {
          setWinner(String.valueOf(grid[row][0])); // set the winner to the symbol found in the winning row
          setWin(true); // set the win flag to true
          return getWin(); // return the win flag
        }
      }
    }
    // Check columns
    for (int col = 0; col < 3; col++) {
      if (grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]) {
        if (grid[0][col] != ' ') {
          setWinner(String.valueOf(grid[0][col])); // set the winner to the symbol found in the winning column
          setWin(true); // set the win flag to true
          return getWin(); // return the win flag
        }
      }
    }
    // no winner found, return false
    return false;
  }
  //Setters and getters
  public char[][] getGrid() {
    return grid;
  }

  public void setGrid(char[][] grid) {
    this.grid = grid;
  }

  public Bot getBot1Symbol() {
    return bot1Symbol;
  }

  public Bot getBot2Symbol() {
    return bot2Symbol;
  }

  public Boolean getWin() {
    return Win;
  }

  public void setWin(Boolean win) {
    Win = win;
  }
  public void setWinner(String winner) {
    this.winner = winner;
  }
  public String getWinner() {
    return winner;
  }

}
