package com.puzzles.model.impl;

import com.puzzles.model.Tile;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GameBoardImplTest {

    @Test
    public void initInOrder() {
        GameBoardImpl gameBoard = getGameBoard();
        gameBoard.initInOrder();
        assertTrue(gameBoard.isInOrder());
    }

    private GameBoardImpl getGameBoard() {
        return new GameBoardImpl(new GameImpl(new AdviserImpl()));
    }

    @Test
    public void shuffle() {
        GameBoardImpl gameBoard = getGameBoard();
        gameBoard.initInOrder();
        assertTrue(gameBoard.isInOrder());
        gameBoard.shuffle();
        assertFalse(gameBoard.isInOrder());
    }

    @Test
    public void move() {
        GameBoardImpl gameBoard = getGameBoard();
        gameBoard.initInOrder();
        assertTrue(gameBoard.isInOrder());
        Tile empty = gameBoard.getTiles().stream().filter(Tile::isEmptyTile).findFirst().get();
        Tile notEmpty = gameBoard.getTiles().stream().filter(Tile::isMovable).findFirst().get();

        Integer emptyCol = empty.getPosition().getKey();
        Integer emptyRow = empty.getPosition().getValue();
        Integer notEmptyCol = notEmpty.getPosition().getKey();
        Integer notEmptyRow = notEmpty.getPosition().getValue();

        gameBoard.move(empty, notEmpty);

        assertEquals(emptyCol, notEmpty.getPosition().getKey());
        assertEquals(notEmptyCol, empty.getPosition().getKey());
        assertEquals(emptyRow, notEmpty.getPosition().getValue());
        assertEquals(notEmptyRow, empty.getPosition().getValue());
    }


}