package com.puzzles.model.impl;

import com.puzzles.model.GameBoard;
import com.puzzles.model.Tile;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class TileImpl implements Tile {

    private GameBoard gameBoard;

    private int id;

    private Pair<Integer, Integer> position;

    public TileImpl(GameBoard gameBoard, int id, Pair<Integer, Integer> position) {
        this.gameBoard = gameBoard;
        this.id = id;
        this.position = position;
    }

    @Override
    public boolean isOnRightPace() {
        int column = (id - 1) % 4;
        int row = (id - 1) / 4;
        return position.getKey().equals(column)
                && position.getValue().equals(row);
    }

    @Override
    public boolean isMovable() {
        return !getPossibleMoves().isEmpty();
    }

    @Override
    public Set<Tile> getPossibleMoves() {
        List<Tile> possibleMoves = new ArrayList<>();
        //up
        possibleMoves.add(gameBoard.getTile(position.getKey(), position.getValue() - 1));
        //down
        possibleMoves.add(gameBoard.getTile(position.getKey(), position.getValue() + 1));
        //left
        possibleMoves.add(gameBoard.getTile(position.getKey() - 1, position.getValue()));
        //right
        possibleMoves.add(gameBoard.getTile(position.getKey() + 1, position.getValue()));

        return possibleMoves.stream()
                .filter(Objects::nonNull)
                .filter(tile -> tile.isEmptyTile() || gameBoard.isInSuperHeroMode())
                .collect(Collectors.toSet());
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    @Override
    public void setPosition(Pair<Integer, Integer> newPosition) {
        position = newPosition;
    }

}
