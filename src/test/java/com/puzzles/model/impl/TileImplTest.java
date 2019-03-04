package com.puzzles.model.impl;

import com.puzzles.model.GameBoard;
import com.puzzles.model.GameStatus;
import com.puzzles.model.Tile;
import javafx.util.Pair;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TileImplTest {

    @Test
    public void isOnRightPace() {
        assertTrue((new TileImpl(null, 1, new Pair<>(0, 0))).isOnRightPace());
        assertTrue((new TileImpl(null, 6, new Pair<>(1, 1))).isOnRightPace());
        assertTrue((new TileImpl(null, 11, new Pair<>(2, 2))).isOnRightPace());
        assertTrue((new TileImpl(null, 15, new Pair<>(2, 3))).isOnRightPace());
        assertTrue((new TileImpl(null, 12, new Pair<>(3, 2))).isOnRightPace());

        assertFalse((new TileImpl(null, 2, new Pair<>(0, 0))).isOnRightPace());
        assertFalse((new TileImpl(null, 5, new Pair<>(1, 1))).isOnRightPace());
        assertFalse((new TileImpl(null, 12, new Pair<>(2, 2))).isOnRightPace());
        assertFalse((new TileImpl(null, 13, new Pair<>(2, 3))).isOnRightPace());
        assertFalse((new TileImpl(null, 14, new Pair<>(3, 2))).isOnRightPace());
    }


    @Test
    public void getPossibleMoves() {
        //put 5 tiles on the board, and all other 11 tiles are "empty" tiles
        GameImpl game = new GameImpl(new AdviserImpl());
        GameBoard gameBoard = new GameBoardImpl(game);

        TileImpl emtpyTile1 = new TileImpl(gameBoard, 16, new Pair<>(0, 0));
        TileImpl leftTile5 = new TileImpl(gameBoard, 5, new Pair<>(0, 1));
        TileImpl emtpyTile9 = new TileImpl(gameBoard, 16, new Pair<>(0, 2));
        TileImpl emtpyTile13 = new TileImpl(gameBoard, 16, new Pair<>(0, 3));
        TileImpl upTile2 = new TileImpl(gameBoard, 2, new Pair<>(1, 0));
        TileImpl centreTile6 = new TileImpl(gameBoard, 6, new Pair<>(1, 1));
        TileImpl downTile10 = new TileImpl(gameBoard, 10, new Pair<>(1, 2));
        TileImpl emtpyTile14 = new TileImpl(gameBoard, 16, new Pair<>(1, 3));
        TileImpl emtpyTile3 = new TileImpl(gameBoard, 16, new Pair<>(2, 0));
        TileImpl rightTile7 = new TileImpl(gameBoard, 7, new Pair<>(2, 1));
        TileImpl emtpyTile11 = new TileImpl(gameBoard, 16, new Pair<>(2, 2));
        TileImpl emtpyTile15 = new TileImpl(gameBoard, 16, new Pair<>(2, 3));
        TileImpl emtpyTile4 = new TileImpl(gameBoard, 16, new Pair<>(3, 0));
        TileImpl emtpyTile8 = new TileImpl(gameBoard, 16, new Pair<>(3, 1));
        TileImpl emtpyTile12 = new TileImpl(gameBoard, 16, new Pair<>(3, 2));
        TileImpl emtpyTile16 = new TileImpl(gameBoard, 16, new Pair<>(3, 3));

        Set<Tile> tileSet = new HashSet<>();
        tileSet.add(emtpyTile1);
        tileSet.add(upTile2);
        tileSet.add(emtpyTile3);
        tileSet.add(emtpyTile4);
        tileSet.add(leftTile5);
        tileSet.add(centreTile6);
        tileSet.add(rightTile7);
        tileSet.add(emtpyTile8);
        tileSet.add(emtpyTile9);
        tileSet.add(downTile10);
        tileSet.add(emtpyTile11);
        tileSet.add(emtpyTile12);
        tileSet.add(emtpyTile13);
        tileSet.add(emtpyTile14);
        tileSet.add(emtpyTile15);
        tileSet.add(emtpyTile16);


        gameBoard.setTiles(tileSet);

        assertTrue(centreTile6.getPossibleMoves().size() == 0);
        assertTrue(upTile2.getPossibleMoves().size() == 2);
        assertTrue(leftTile5.getPossibleMoves().size() == 2);
        assertTrue(rightTile7.getPossibleMoves().size() == 3);
        assertTrue(downTile10.getPossibleMoves().size() == 3);

        assertFalse(centreTile6.isMovable());
        assertTrue(upTile2.isMovable());
        assertTrue(leftTile5.isMovable());
        assertTrue(rightTile7.isMovable());
        assertTrue(downTile10.isMovable());

        game.setStatus(GameStatus.SUPER_HERO_MOD);

        assertTrue(centreTile6.isMovable());
        assertTrue(upTile2.isMovable());
        assertTrue(leftTile5.isMovable());
        assertTrue(rightTile7.isMovable());
        assertTrue(centreTile6.isMovable());
        assertTrue(downTile10.isMovable());
    }

}