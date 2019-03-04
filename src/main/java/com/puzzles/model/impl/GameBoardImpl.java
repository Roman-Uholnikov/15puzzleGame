package com.puzzles.model.impl;

import com.puzzles.model.Game;
import com.puzzles.model.GameBoard;
import com.puzzles.model.GameStatus;
import com.puzzles.model.Tile;
import javafx.util.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameBoardImpl implements GameBoard {

    private static final int SHUFFLE_COMPLEXITY = 100;
    private static final int TILES_COUNT = 16;

    private Set<Tile> tiles = new HashSet<>();

    private Game game;

    public GameBoardImpl(Game game) {
        this.game = game;
    }

    @Override
    public void initInOrder() {
        tiles.clear();
        IntStream.range(0, TILES_COUNT).forEach(i -> {
            Pair<Integer, Integer> position = new Pair<>(i % 4, i / 4);
            tiles.add(new TileImpl(this, i + 1, position));
        });
    }

    @Override
    public void shuffle() {
        Tile emptyTile = getEmptyTile();
        IntStream.range(0, SHUFFLE_COMPLEXITY).forEach(i -> move(emptyTile, getNextRandomMovableTile()));
    }

    private Tile getEmptyTile() {
        Optional<Tile> first = tiles.stream().filter(Tile::isEmptyTile).findFirst();
        if(!first.isPresent()){
            throw new IllegalStateException("We must have empty tile on the board");
        }
        return first.get();
    }

    @Override
    public void move(Tile tileFrom, Tile tileTo) {
        if (tileFrom == null || tileTo == null) {
            return;
        }

        Pair<Integer, Integer> tempPosition = tileFrom.getPosition();
        tileFrom.setPosition(tileTo.getPosition());
        tileTo.setPosition(tempPosition);
    }

    @Override
    public void move(int tileId) {
        Tile tileTo = tiles.stream().filter(tile -> tile.getId() == tileId).findFirst().orElse(null);
        move(getEmptyTile(), tileTo);
    }

    @Override
    public boolean isInOrder() {
        return tiles.stream().allMatch(Tile::isOnRightPace);
    }

    @Override
    public Set<Tile> getTiles() {
        return tiles;
    }

    @Override
    public void setTiles(Set<Tile> tiles) {
        this.tiles = tiles;
    }

    private Tile getNextRandomMovableTile() {
        List<Tile> movable = tiles.stream().filter(Tile::isMovable).collect(Collectors.toList());
        Random ran = new Random();
        int nextTileId = ran.nextInt(movable.size());
        return movable.get(nextTileId);
    }

    @Override
    public Tile getTile(Integer cal, Integer row) {
        return getTile(new Pair<>(cal, row));
    }

    @Override
    public Tile getTile(Pair<Integer, Integer> position) {
        return tiles.stream()
                .filter(tile -> tile.getPosition().equals(position))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean isInSuperHeroMode() {
        return game.getStatus().equals(GameStatus.SUPER_HERO_MOD);
    }
}
