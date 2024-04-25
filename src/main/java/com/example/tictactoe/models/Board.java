package com.example.tictactoe.models;

import com.example.tictactoe.enums.CellState;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Board {
    private List<List<Cell>> board;
    private int size;

    public Board(int size){
        this.size =size;
        board = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            board.add(new ArrayList<>());

            for (int j = 0; j < size; j++) {
                board.get(i).add(new Cell(i, j));
            }

        }
    }

    public void printBoard(){
        for(List<Cell> row : board){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    System.out.print("| -- |");
                }
                else {
                    System.out.print("| " + cell.getPlayer().getSymbol().getAChar() + " |");
                }
            }
            System.out.println();
        }
    }



}
