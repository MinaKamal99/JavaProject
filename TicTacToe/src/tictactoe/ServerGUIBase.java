package tictactoe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class ServerGUIBase extends Pane {

    protected final ToggleButton serverStartBtn;
    protected final ToggleButton serverStopBtn;
    protected final Label label;
    protected final ListView serverUsersList;
    protected final Button graphsBtn;
    protected final Button backBtn;

    public ServerGUIBase() {

        serverStartBtn = new ToggleButton();
        serverStopBtn = new ToggleButton();
        label = new Label();
        serverUsersList = new ListView();
        graphsBtn = new Button();
        backBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        serverStartBtn.setLayoutX(198.0);
        serverStartBtn.setLayoutY(41.0);
        serverStartBtn.setMnemonicParsing(false);
        serverStartBtn.setPrefHeight(31.0);
        serverStartBtn.setPrefWidth(93.0);
        serverStartBtn.setText("Start");

        serverStopBtn.setLayoutX(291.0);
        serverStopBtn.setLayoutY(41.0);
        serverStopBtn.setMnemonicParsing(false);
        serverStopBtn.setPrefHeight(31.0);
        serverStopBtn.setPrefWidth(93.0);
        serverStopBtn.setText("Stop");

        label.setLayoutX(196.0);
        label.setLayoutY(103.0);
        label.setText("Online users:");
        label.setFont(new Font(17.0));

        serverUsersList.setLayoutX(192.0);
        serverUsersList.setLayoutY(129.0);
        serverUsersList.setPrefHeight(200.0);
        serverUsersList.setPrefWidth(200.0);

        graphsBtn.setLayoutX(198.0);
        graphsBtn.setLayoutY(355.0);
        graphsBtn.setMnemonicParsing(false);
        graphsBtn.setPrefHeight(31.0);
        graphsBtn.setPrefWidth(200.0);
        graphsBtn.setText("Graphs");

        backBtn.setLayoutX(23.0);
        backBtn.setLayoutY(14.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");

        getChildren().add(serverStartBtn);
        getChildren().add(serverStopBtn);
        getChildren().add(label);
        getChildren().add(serverUsersList);
        getChildren().add(graphsBtn);
        getChildren().add(backBtn);

    }
}
