package com.puzzles.model;

import javafx.util.Pair;

import java.util.Set;

/**
 * Game board.
 */
public interface GameBoard {

    void initInOrder();

    /**
     * Shuffle the game board.
     * In order to guarantee that puzzle is solvable
     * we do not put initially tiles in random order.
     * We put them in proper order and then shuffle.
     */
    void shuffle();

    void move(Tile tileFrom, Tile toTo);

    void move(int tileId);

    /**
     * Check, whether all tiles stays on the proper positions
     */
    boolean isInOrder();

    Set<Tile> getTiles();

    Tile getTile(Integer cal, Integer row);

    Tile getTile(Pair<Integer, Integer> position);

    /**
     * Killing feature: you can move ANY tile to the empty space
     * <b>!!! Attention: it can make solving puzzle impossible </b>
     */
    boolean isInSuperHeroMode();
}
