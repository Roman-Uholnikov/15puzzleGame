package com.puzzles.model;

/**
 * This is companion/adviser/interlocutor that might:
 * - helps you to win
 * - misleads you
 * - entertain you while you are playing
 */
public interface Adviser {

    /**
     * Provide some advice/joke/quotation, depending on the game state
     */
    String advise(GameStatus gameStatus);
}
