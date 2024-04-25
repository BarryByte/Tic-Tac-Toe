package com.example.tictactoe.models;

import com.example.tictactoe.enums.BotDifficultyLevel;
import com.example.tictactoe.enums.CellState;
import com.example.tictactoe.enums.PlayerType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Bot extends Player{
   private BotDifficultyLevel botDifficultyLevel;
   public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel){
       super(name, symbol, playerType);
       this.botDifficultyLevel = botDifficultyLevel;
   }

   @Override
    public Move makeMove(Board board){
       for(List<Cell> row : board.getBoard()){
           for(Cell cell : row){
               if(cell.getCellState().equals(CellState.EMPTY)){
                   return new Move(cell, this);
               }
           }
       }
       return null;
   }



}
