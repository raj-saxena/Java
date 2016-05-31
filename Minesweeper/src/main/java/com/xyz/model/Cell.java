package com.xyz.model;

import com.xyz.exception.OpenedMineException;

/**
 * This class represents every cell in the minefield. Created by raj on 21/4/16.
 */
public class Cell {

    int row;
    int column;
    boolean isFlagged = false;
    boolean isOpen = false;
    boolean isMine = false;

    public Cell(int row, int column, char value) {
        this.row = row;
        this.column = column;
        if ("m".equals(String.valueOf(value))) {
            this.isMine = true;
        }
    }


    @Override
    public String toString() {
        return "Cell{" + "row=" + row + ", column=" + column + '}';
    }

    public String getState() {
        if (isOpen) {
            return "0";
        } else if (isFlagged) {
            return "f";
        } else
            return "x";
    }

    public void open() throws OpenedMineException {
        isOpen = true;
        if (isMine) {
            throw new OpenedMineException("Opened a Mine.!");
        }
    }

    public void flag() {
        isFlagged = true;
    }
}
