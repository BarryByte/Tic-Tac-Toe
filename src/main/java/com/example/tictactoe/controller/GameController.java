package com.example.tictactoe.controller;

import com.example.tictactoe.enums.GameState;
import com.example.tictactoe.exceptions.InvalidMoveException;
import com.example.tictactoe.models.Game;
import com.example.tictactoe.models.Player;

import java.util.List;

public class GameController {
    //all the methods will be there for running the game using abstraction
    public Game startGame(int dimension , List<Player> players){
        //Todo
        // Validate if 2 players have the same symbol or not?
        // if 2 players have same symbol, throw some exception.
        return new Game(dimension,players);
    }

    public void makeMove(Game game) throws InvalidMoveException{
        game.makeMove();
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public Player getWinner(Game game){
        return game.getWinner();
    }

    public void printBoard(Game game){
        game.printBoard();
    }



}
