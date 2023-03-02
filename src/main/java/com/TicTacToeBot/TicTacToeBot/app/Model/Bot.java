package com.TicTacToeBot.TicTacToeBot.app.Model;

import java.util.Random;

public class Bot {
    private Character symbol;

    /**
     * Generates a move for the bot in the Tic Tac Toe game.
     * @return a new board with the bot's move added
     */
    public static Board makeMove(Board board) {
        char symbol = board.getBot1Symbol().getSymbol();
        char[][] grid= board.getGrid();
        for (int turn = 0;turn<9;turn++) {
            // Generate a random row and column index
            Random random = new Random();
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            // Check if the chosen cell is empty
            while (grid[row][col] != ' ') {
                row = random.nextInt(3);
                col = random.nextInt(3);
            }
            // Add the symbol to the chosen cell
            grid[row][col]=symbol;
            board.setGrid(grid);
            // Check if there is a winner or draw
            if(board.checkWinner())
            {
                System.out.println("\n\t\t\t@@@@@@@@@@@  The Winner is: "+symbol+" !!  @@@@@@@@@@@");
                return board;
            }
            else if (board.checkDraw())
            {
                System.out.println("\n\t\t\t@@@@@@@@@@@  Draw !!  @@@@@@@@@@@");
                return board;
            }
            //change the turn symbol
            if (symbol==board.getBot1Symbol().getSymbol())
            {
                symbol= board.getBot2Symbol().getSymbol();
            }
            else
            {
                symbol= board.getBot1Symbol().getSymbol();
            }
        }
        return board;
    }

    /**
     * Creates a new bot with the specified symbol.
     * @param symbol the bot's symbol ('X' or 'O')
     */
    public Bot(char symbol) {
        this.symbol = symbol;
    }
    //Setters and getters
    public char getSymbol() {
        return symbol;
    }
}