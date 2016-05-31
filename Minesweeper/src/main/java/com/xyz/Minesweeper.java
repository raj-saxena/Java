package com.xyz;

import static java.lang.Integer.parseInt;

import com.xyz.exception.CannotFlagException;
import com.xyz.exception.OpenedMineException;
import com.xyz.model.Board;
import com.xyz.model.MinesweeperConsoleWriter;

import java.util.Objects;
import java.util.Scanner;

/**
 * Created by raj on 21/4/16.
 */
public class Minesweeper {
	private Board board;
	String regexDigit = "\\%d";

	public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
        String inputLayout = "xxm,xmx,xxx";
        minesweeper.createMinefield(inputLayout);
        minesweeper.startGame();
	}

    private void startGame() {
        while (!Objects.equals(board.getOpenPendingCount(), 0)) {
            System.out.println("Input operation:");
            String userInput = new Scanner(System.in).nextLine();
            process(userInput);
            show();
        }
        System.out.println("Wow, you cleared the minefield! Game Over !");
    }

    private void flag(String location) {
        int row = getFirstDigit(location);
        int column = getSecondDigit(location);
        try {
            board.flag(row, column);
        } catch (CannotFlagException e) {
            System.out.println("No more flags available, try again.");
        }
	}

	private void open(String location) {
		int row = getFirstDigit(location);
		int column = getSecondDigit(location);
		try {
			board.open(row, column);
		} catch (OpenedMineException e) {
			System.out.println("Oops, you stepped on a mine! Game Over !");
			System.exit(0);
		}
	}

	public String show() {
		String output = board.getDisplayString();
        board.display(new MinesweeperConsoleWriter());
		return output;
	}

	public void createMinefield(String layout) {
		this.board = new Board(layout);
	}

	private int getSecondDigit(String location) {
		return parseInt(location.substring(location.indexOf(",") + 1, location.indexOf(")")));
	}

	private int getFirstDigit(String location) {
		return parseInt(location.substring(2, location.indexOf(",")));
	}

	public void process(String input) {
		if (input.startsWith("o")) {
			open(input);
		} else if (input.startsWith("f")) {
			flag(input);
		}
	}
}
