package com.xyz.model;

import com.xyz.exception.OpenedMineException;

/**
 * Created by raj on 21/4/16.
 */
public class Row {
    public Cell[] getCell() {
        return cell;
    }

    public int getRowLocation() {
        return rowLocation;
    }

    public void setCell(Cell[] cell) {
        this.cell = cell;
    }

    private Cell[] cell;
    private int rowLocation;

    public Row(int rowLocation) {
        this.rowLocation = rowLocation;
    }

    public void open(int column) throws OpenedMineException {
        cell[column].open();
    }

    public void flag(int columnIndex) {
        cell[columnIndex].flag();
    }
}
