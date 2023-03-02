package com.TicTacToeBot.TicTacToeBot.app.Model;

import org.springframework.http.HttpStatus;

public class ResponseManager {
    Board boardStatus;
    String responseStatus;

    public ResponseManager(Board boardStatus) {
        this.boardStatus = boardStatus;
        responseStatus = String.valueOf(HttpStatus.OK.value())+" OK ";
    }

    public Board getBoardStatus() {
        return boardStatus;
    }

    public void setBoardStatus(Board boardStatus) {
        this.boardStatus = boardStatus;
    }
    public String getResponseStatus() {
        return responseStatus;
    }

}
