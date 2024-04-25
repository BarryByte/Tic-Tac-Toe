package com.example.tictactoe.models;

import com.example.tictactoe.enums.PlayerType;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType playerType;
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType){
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        System.out.println("Please enter the row number where you want to make a move ?");
        int row = scanner.nextInt();

        System.out.println(("Please enter the col number where you want to make a move ?"));
        int col = scanner.nextInt();

        return new Move(new Cell(row,col), this);
    }

}
