package com.puzzles.view;

import com.puzzles.model.Adviser;
import com.puzzles.model.Game;
import com.puzzles.model.GameStatus;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class GameView {

    private Label statusLabel;
    private Text advise;

    private Game game;
    private Adviser adviser;

    public GameView(Label statusLabel, Text advise, Game game, Adviser adviser) {
        this.statusLabel = statusLabel;
        this.advise = advise;
        this.game = game;
        this.adviser = adviser;
    }

    public void renderAdvice() {
        advise.setText(adviser.advise(game.getStatus()));
    }


    public void renderStatus() {
        if (game.getStatus().equals(GameStatus.COMPLETED)) {
            statusLabel.setText("!!!Completed!!!\n\nSteps count: " + game.getStepsCount());
        } else {
            statusLabel.setText("Steps count: " + game.getStepsCount());
        }
    }
}
