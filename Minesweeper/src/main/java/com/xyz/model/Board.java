package com.xyz.model;

import com.xyz.exception.CannotFlagException;
import com.xyz.exception.OpenedMineException;
import com.xyz.helper.Displayable;
import com.xyz.helper.Displayer;

/**
 * Created by raj on 21/4/16.
 */
public class Board implements Displayable {
	private Row[] rows;

	public int getOpenPendingCount() {
		return openPendingCount;
	}

	public int getFlagsAvailableCount() {
		return flagsAvailableCount;
	}

	private int openPendingCount = 0;
	private int flagsAvailableCount;
	private int flaggedCellCount = 0;
	private int totalCells = 0;

	public Board(String layout) {
		this.rows = createRows(layout);
        openPendingCount = totalCells - flagsAvailableCount;
	}

	private Row[] createRows(String layout) {
		String[] rowsInput = layout.split(",");
		Row[] rows = new Row[rowsInput.length];
		for (int i = 0; i < rowsInput.length; i++) {
			Row row = new Row(i);
			Cell[] cellsInRow = getCellsInRow(i, rowsInput[i]);
			row.setCell(cellsInRow);
			rows[i] = row;
		}
		return rows;
	}

	private Cell[] getCellsInRow(int i, String row) {
		char[] cells = row.toCharArray();
		Cell[] cellsInRow = new Cell[cells.length];
		for (int j = 0; j < cells.length; j++) {
			Cell cell = new Cell(i, j, cells[j]);
			if (cell.isMine) {
				++flagsAvailableCount;
			}
			++totalCells;
			cellsInRow[j] = cell;
		}
		return cellsInRow;
	}

    @Override
    public void display(Displayer displayer) {
        String boardString = getDisplayString();
        displayer.display(boardString);
    }

    @Override
	public String getDisplayString() {
		StringBuilder boardString = new StringBuilder();
		for (Row row : rows) {
			boardString.append(getRowString(row));
			boardString.append("\n");
		}
		return boardString.substring(0, boardString.length() - 1);// Stripping
																	// the last
																	// \n
	}

	private String getRowString(Row row) {
		StringBuilder rowString = new StringBuilder();
		for (Cell cell : row.getCell()) {
			rowString.append(cell.getState());
		}
		return rowString.toString();
	}

	public void open(int rowIndex, int columnIndex) throws OpenedMineException {
		Row row = getRow(rowIndex);
		row.open(columnIndex);
		openPendingCount--;
	}

	private Row getRow(int rowIndex) {
		return rows[rowIndex];
	}

	public void flag(int rowIndex, int columnIndex) throws CannotFlagException {
		Row row = getRow(rowIndex);
		if (flaggedCellCount < flagsAvailableCount) {
			row.flag(columnIndex);
			flaggedCellCount++;
		} else {
			throw new CannotFlagException("No more flags available");
		}
	}
}
