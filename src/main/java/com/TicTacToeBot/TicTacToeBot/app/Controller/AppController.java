package com.TicTacToeBot.TicTacToeBot.app.Controller;

import com.TicTacToeBot.TicTacToeBot.app.Model.Board;
import com.TicTacToeBot.TicTacToeBot.app.Model.Bot;

import com.TicTacToeBot.TicTacToeBot.app.Model.ResponseManager;
import org.springframework.web.bind.annotation.*;

/**
 * This class represents the AppController, which handles requests for the TicTacToeBot app.
 */
@RestController
@RequestMapping("/api")
public class AppController {

    /**
     * This method accepts a game board and the bot symbol as input,
     * generates a move for the bot and returns the updated game board.
     * @param grid a 2D char array representing the current state of the game board
     * @return a Board object representing the updated game board
     * @throws Exception if the input game board contains invalid characters
     */
    @PostMapping("/bot")
    public ResponseManager getBoard(@RequestBody char[][] grid) throws Exception {
        try {
            Board board = new Board(grid);
            if (!board.containsInvalidChar()) {
                ResponseManager responseManager = new ResponseManager(Bot.makeMove(board));
                return responseManager ;
            }
            System.out.println("\n\t\t\t@@@@@@@@@@@  Invalid Grid !!  @@@@@@@@@@@");
        } catch (Exception e) {
            System.out.println("An error occurred while processing the request: " + e.getMessage());
        }
        return null;
    }

    /**
     * This method creates a new, empty game board.
     * @return a Board object representing a new, empty game board
     * @throws Exception if an error occurs while creating the game board
     */
    @PostMapping("/grid")
    public Board getNewGrid() throws Exception {
        try {
            char[][] grid = new char[3][3];
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    grid[row][col] = ' ';
                }
            }
            Board board = new Board(grid);
            return board;
        } catch (Exception e) {
            System.out.println("An error occurred while processing the request: " + e.getMessage());
        }
        return null;
    }

    /**
     * This method is a simple endpoint used for testing the server is working.
     * @return a String "Working!!"
     */
    @GetMapping("/bot")
    public String test() {
        return "Working!!";
    }
}