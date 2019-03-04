package com.puzzles.model.impl;

import com.puzzles.model.Tile;
import javafx.util.Pair;
import org.junit.Test;

import static org.junit.Assert.*;

public class TileImplTest {

    @Test
    public void isOnRightPace() {
        assertTrue((new TileImpl(null, 1, new Pair<>(0,0))).isOnRightPace());
        assertTrue((new TileImpl(null, 6, new Pair<>(1,1))).isOnRightPace());
        assertTrue((new TileImpl(null, 11, new Pair<>(2,2))).isOnRightPace());
        assertTrue((new TileImpl(null, 15, new Pair<>(2,3))).isOnRightPace());
        assertTrue((new TileImpl(null, 12, new Pair<>(3,2))).isOnRightPace());

        assertFalse((new TileImpl(null, 2, new Pair<>(0,0))).isOnRightPace());
        assertFalse((new TileImpl(null, 5, new Pair<>(1,1))).isOnRightPace());
        assertFalse((new TileImpl(null, 12, new Pair<>(2,2))).isOnRightPace());
        assertFalse((new TileImpl(null, 13, new Pair<>(2,3))).isOnRightPace());
        assertFalse((new TileImpl(null, 14, new Pair<>(3,2))).isOnRightPace());
    }

    @Test
    public void isMovable() {
    }

    @Test
    public void getPossibleMoves() {
    }

    @Test
    public void getId() {
    }

    @Test
    public void getPosition() {
    }

    @Test
    public void setPosition() {
    }
}