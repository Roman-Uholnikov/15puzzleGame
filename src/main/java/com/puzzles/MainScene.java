package com.puzzles;


import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Roman Uholnikov
 */
public class MainScene extends Application {

    @FXML
    private GridPane board;

    @FXML
    private Text advise;

    @FXML
    private Button newGame;

    @FXML
    private Button superHeroMode;

    @FXML
    private Label statusLabel;

    private GameController gameController;

    @Override
    public void start(Stage primaryStage) throws Exception {
        gameController = new GameController(this);

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("scene.fxml")
        );
        loader.setController(this);
        Parent root = (Parent) loader.load();
        primaryStage.setTitle("15 puzzle");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.getIcons().add(new Image("https://images-na.ssl-images-amazon.com/images/I/51BbIRcvu4L.png"));
        primaryStage.show();

        statusLabel.setText("");
        advise.setText("Click \"new game\"");
        newGame.setOnAction(event -> gameController.initNewGame());
        superHeroMode.setOnAction(event -> gameController.enableSuperHeroMod());
    }

    public static void main(String[] args) {
        launch(args);
    }

    public GridPane getBoard() {
        return board;
    }

    public Text getAdvise() {
        return advise;
    }

    public Label getStatusLabel() {
        return statusLabel;
    }
}
