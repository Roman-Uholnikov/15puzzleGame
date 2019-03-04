package com.puzzles;

import com.puzzles.model.Game;
import com.puzzles.model.GameBoard;
import com.puzzles.model.GameStatus;
import com.puzzles.model.impl.AdviserImpl;
import com.puzzles.model.impl.GameBoardImpl;
import com.puzzles.model.impl.GameImpl;
import com.puzzles.view.GameBoardView;
import com.puzzles.view.GameView;
import com.puzzles.view.MoveAction;
import com.puzzles.view.TileView;

public class GameController implements MoveAction {

    private MainScene mainScene;
    private Game game;
    private GameBoard gameBoard;

    private GameBoardView gameBoardView;
    private TileView tileView;
    private GameView gameView;

    public GameController(MainScene mainScene) {
        this.mainScene = mainScene;
    }

    public void initNewGame() {
        game = new GameImpl(new AdviserImpl());
        game.startNew();
        gameBoard = new GameBoardImpl(game);
        gameBoard.initInOrder();
        gameBoard.shuffle();

        tileView = new TileView(game);
        gameBoardView = new GameBoardView(gameBoard, mainScene.getBoard(), tileView);
        gameView = new GameView(mainScene.getStatusLabel(), mainScene.getAdvise(), game, game.getAdviser());
        rerenderGame();
    }

    public void makeAMove(int tileId) {
        //process a move on board, tile
        gameBoard.move(tileId);
        game.logStep();
        game.setStatus(GameStatus.STANDARD_MOD);

        rerenderGame();
    }

    public void enableSuperHeroMod() {
        game.setStatus(GameStatus.SUPER_HERO_MOD);

        rerenderGame();
    }

    public void rerenderGame() {
        if (gameBoard.isInOrder() && !game.getStatus().equals(GameStatus.NEW)) {
            game.setStatus(GameStatus.COMPLETED);
        }
        gameBoardView.renderBoard(this);
        gameView.renderAdvice();
        gameView.renderStatus();
    }

    @Override
    public void doAction(int puzzleId) {
        makeAMove(puzzleId);
    }
}
