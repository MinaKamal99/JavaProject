package tictactoe;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OnlineUsersBase extends Pane {

    protected final Text text;
    protected final Button historyBtn;
    protected final ListView onlineListView;
    protected final Label label;
    protected final Button logoutBtn;
    Stage stage;

    public OnlineUsersBase(Stage s) {
        stage = s;
        text = new Text();
        historyBtn = new Button();
        onlineListView = new ListView();
        label = new Label();
        logoutBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        text.setLayoutX(38.0);
        text.setLayoutY(120.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("online users :");
        text.setFont(new Font(26.0));

        historyBtn.setLayoutX(503.0);
        historyBtn.setLayoutY(353.0);
        historyBtn.setMnemonicParsing(false);
        historyBtn.setOpacity(0.93);
        historyBtn.setPrefHeight(32.0);
        historyBtn.setPrefWidth(81.0);
        historyBtn.setText("History");

        onlineListView.setLayoutX(73.0);
        onlineListView.setLayoutY(143.0);
        onlineListView.setPrefHeight(200.0);
        onlineListView.setPrefWidth(432.0);

        label.setLayoutX(206.0);
        label.setLayoutY(23.0);
        label.setText("Tic Tac Toe");
        label.setFont(new Font(34.0));

        logoutBtn.setLayoutX(497.0);
        logoutBtn.setLayoutY(23.0);
        logoutBtn.setMnemonicParsing(false);
        logoutBtn.setText("LogOut");

        getChildren().add(text);
        getChildren().add(historyBtn);
        getChildren().add(onlineListView);
        getChildren().add(label);
        getChildren().add(logoutBtn);

        logoutBtn.setOnAction((event) -> {
            Parent newRoot = new FirstScreenBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });

    }
}
