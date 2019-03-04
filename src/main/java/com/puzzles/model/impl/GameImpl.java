package com.puzzles.model.impl;

import com.puzzles.model.Adviser;
import com.puzzles.model.Game;
import com.puzzles.model.GameStatus;

public class GameImpl implements Game {

    private GameStatus currentStatus;
    private int steps = 0;
    private Adviser adviser;

    public GameImpl(Adviser adviser) {
        this.adviser = adviser;
        this.currentStatus = GameStatus.NEW;
    }

    @Override
    public Adviser getAdviser() {
        return adviser;
    }

    @Override
    public GameStatus getStatus() {
        return currentStatus;
    }

    @Override
    public void setStatus(GameStatus status) {
        currentStatus = status;
    }

    @Override
    public void startNew() {
        this.currentStatus = GameStatus.NEW;
    }

    @Override
    public int getStepsCount() {
        return steps;
    }

    @Override
    public void logStep() {
        steps++;
    }
}
