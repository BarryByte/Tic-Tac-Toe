package com.example.tictactoe;

import com.example.tictactoe.controller.GameController;
import com.example.tictactoe.enums.BotDifficultyLevel;
import com.example.tictactoe.enums.GameState;
import com.example.tictactoe.enums.PlayerType;
import com.example.tictactoe.exceptions.InvalidMoveException;
import com.example.tictactoe.models.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {

	public static void main(String[] args) throws InvalidMoveException {
		System.out.println("Best Game in the WORLD!");
		Scanner sc = new  Scanner(System.in);
		GameController gameController = new GameController();
		int dimension = 3;
		List<Player> players = List.of( new Player("Barry" , new Symbol('X'), PlayerType.HUMAN) , new Bot("BotArmy", new Symbol('0'), PlayerType.BOT, BotDifficultyLevel.EASY));
		Game game = gameController.startGame(dimension, players);

		while(game.getGameState().equals(GameState.IN_PROGRESS)){

			gameController.printBoard(game);
			gameController.makeMove(game);
		}
		if(!gameController.checkState(game).equals(GameState.ENDED)){
			game.setGameState((GameState.DRAW));
			System.out.println("Game Draw");
		}
		else{
			gameController.printBoard(game);
			System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");
		}

	}



}
