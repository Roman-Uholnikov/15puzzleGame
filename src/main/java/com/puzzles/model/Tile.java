package com.puzzles.model;


import javafx.util.Pair;

import java.util.Set;

/**
 * Single tile. State, logic of movement, might be places here
 */
public interface Tile {

    int EMPTY_TILE_ID = 16;

    boolean isOnRightPace();

    /**
     * is possible to make a move considering current state of the board and tile
     */
    boolean isMovable();

    /**
     * Returns the tiles where it is possible to move.
     */
    Set<Tile> getPossibleMoves();

    /**
     * Number of the tile. 1-16. 16 is special one - empty.
     */
    int getId();

    /**
     * column/row position of the tile on the board
     */
    Pair<Integer, Integer> getPosition();

    /**
     * move to column/row
     */
    void setPosition(Pair<Integer, Integer> position);

    default boolean isEmptyTile() {
        return getId() == EMPTY_TILE_ID;
    }


}
