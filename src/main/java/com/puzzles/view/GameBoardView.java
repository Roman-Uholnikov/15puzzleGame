package com.puzzles.view;

import com.puzzles.model.GameBoard;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class GameBoardView {

    private GameBoard gameBoard;
    private GridPane gridPane;
    private TileView tileView;

    public GameBoardView(GameBoard gameBoard, GridPane gridPane, TileView tileView) {
        this.gameBoard = gameBoard;
        this.gridPane = gridPane;
        this.tileView = tileView;
    }

    public void renderBoard(MoveAction moveAction) {
        ObservableList<Node> children = gridPane.getChildren();
        children.clear();

        gameBoard.getTiles().forEach(tile -> {

            Pair<Integer, Integer> position = tile.getPosition();
            Button tileButton = tileView.renderTile(tile);
            if (tileButton != null) {
                tileButton.setOnAction(event -> moveAction.doAction(tile.getId()));
                gridPane.add(tileButton, position.getKey(), position.getValue());
            }
        });
    }
}
