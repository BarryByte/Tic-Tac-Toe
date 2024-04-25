package com.example.tictactoe.models;

import com.example.tictactoe.enums.CellState;
import com.example.tictactoe.enums.GameState;
import com.example.tictactoe.exceptions.InvalidMoveException;
import com.example.tictactoe.strategies.WinningAlgorithm;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> moves;
    private GameState gameState;
    private WinningAlgorithm winningAlgorithm;

    // what things are required to start the game?
    public Game(int dimension, List<Player> players){
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerMoveIndex = 0;
        this.winningAlgorithm = new WinningAlgorithm();
       // this.winning
    }
    public void printBoard(){
        this.board.printBoard();
    }


    private boolean validateMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row<0 || row >= board.getSize() || col<0 || col >= board.getSize() ) return false;

        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }
    public void makeMove() throws InvalidMoveException {

        Player currentPlayer = players.get(nextPlayerMoveIndex);
        try {

            System.out.println(currentPlayer.getName() + "Play your move !");

            //move that current player made (not validated till now);
            Move move = currentPlayer.makeMove(board);

            //Validation of move by Game
            if (!validateMove(move)) {
                throw new InvalidMoveException("Invalid move made by " + currentPlayer.getName());
            }

            int row = move.getCell().getRow();
            int col = move.getCell().getCol();

            Cell cellToChange = board.getBoard().get(row).get(col);
            cellToChange.setPlayer(currentPlayer);
            cellToChange.setCellState(CellState.FILLED);

            Move finalMove = new Move(cellToChange, currentPlayer);
            // Here, moves is list of move(s).
            moves.add(finalMove);
            nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();

            //Check winner
            if (winningAlgorithm.checkWinner(board, finalMove)) {
                gameState = GameState.ENDED;
                winner = currentPlayer;
            }
        } catch (InvalidMoveException e) {
            System.out.println("Invalid ahsdhasdhasd move made by " + currentPlayer.getName());
        }

    }

}
