package com.xyz.model;

import com.xyz.helper.Displayer;

/**
 * Created by raj on 21/4/16.
 */
public class MinesweeperConsoleWriter implements Displayer {
    @Override
    public void display(String text) {
        System.out.println(text);
    }
}
