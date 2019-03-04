package com.puzzles.view;

/**
 * Abstraction over the action:
 * <b>View</b> should know about action but should not know about controller level
 */
public interface MoveAction {

    void doAction(int id);
}
