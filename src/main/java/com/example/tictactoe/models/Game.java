package com.example.tictactoe.models;

import com.example.tictactoe.enums.GameState;

import java.util.List;

public class Game {
    private Board Board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> move;
    private GameState gameState;
}
