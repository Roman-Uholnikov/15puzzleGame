package com.puzzles.model;

/**
 * Interface that represent a single game. This interface might be used in case
 * you want to save/export/import a single game
 */
public interface Game {

    Adviser getAdviser();

    GameStatus getStatus();

    void setStatus(GameStatus status);

    void startNew();

    int getStepsCount();

    void logStep();

}
