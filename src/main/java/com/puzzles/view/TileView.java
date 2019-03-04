package com.puzzles.view;

import com.puzzles.model.Game;
import com.puzzles.model.GameStatus;
import com.puzzles.model.Tile;
import javafx.scene.control.Button;

public class TileView {

    private Game game;

    public TileView(Game game) {
        this.game = game;
    }

    public Button renderTile(Tile tile) {
        Button tileComponent = new Button(String.valueOf(tile.getId()));
        tileComponent.setMaxWidth(Double.MAX_VALUE);
        tileComponent.setPrefWidth(Double.MAX_VALUE);
        tileComponent.setMaxHeight(Double.MAX_VALUE);
        tileComponent.setPrefHeight(Double.MAX_VALUE);
        tileComponent.setStyle(" -fx-font-size: 30");
        tileComponent.setDisable(true);
        if (tile.isMovable() || game.getStatus().equals(GameStatus.SUPER_HERO_MOD)) {
            tileComponent.setDisable(false);
        }
        if (tile.getId() == Tile.EMPTY_TILE_ID) {
            //we do not render empty tile
            return null;
        }
        return tileComponent;
    }
}
