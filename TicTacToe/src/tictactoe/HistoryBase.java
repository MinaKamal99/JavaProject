package tictactoe;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class HistoryBase extends Pane {

    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label winsLabel;
    protected final Label lossesLabel;
    protected final TableView tableView;
    protected final TableColumn tableColumn;
    protected final TableColumn winnerTableColumn;
    protected final TableColumn videoTableColumn;
    protected final Button backBtn;
    protected final MenuItem menuItem;
    protected final MenuItem menuItem0;
    protected final MenuItem menuItem1;
    Stage stage;

    public HistoryBase(Stage s) {
        stage = s;
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        winsLabel = new Label();
        lossesLabel = new Label();
        tableView = new TableView();
        tableColumn = new TableColumn();
        winnerTableColumn = new TableColumn();
        videoTableColumn = new TableColumn();
        backBtn = new Button();
        menuItem = new MenuItem();
        menuItem0 = new MenuItem();
        menuItem1 = new MenuItem();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        label.setLayoutX(224.0);
        label.setLayoutY(14.0);
        label.setText("Tic Tac Toe");
        label.setFont(new Font(31.0));

        label0.setLayoutX(75.0);
        label0.setLayoutY(75.0);
        label0.setText("Wins: ");
        label0.setFont(new Font(20.0));

        label1.setLayoutX(399.0);
        label1.setLayoutY(75.0);
        label1.setText("Losses:");
        label1.setFont(new Font(20.0));

        winsLabel.setLayoutX(128.0);
        winsLabel.setLayoutY(77.0);
        winsLabel.setText("0");
        winsLabel.setFont(new Font(17.0));

        lossesLabel.setLayoutX(467.0);
        lossesLabel.setLayoutY(77.0);
        lossesLabel.setText("0");
        lossesLabel.setFont(new Font(17.0));

        tableView.setLayoutX(64.0);
        tableView.setLayoutY(134.0);
        tableView.setPrefHeight(226.0);
        tableView.setPrefWidth(453.0);

        tableColumn.setPrefWidth(251.0);
        tableColumn.setText("Players");

        winnerTableColumn.setPrefWidth(71.0);
        winnerTableColumn.setText("Winner");

        videoTableColumn.setPrefWidth(130.0);
        videoTableColumn.setText("Video");

        backBtn.setLayoutX(22.0);
        backBtn.setLayoutY(16.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");

        menuItem.setText("Choice 1");

        menuItem0.setText("Choice 2");

        menuItem1.setText("Choice 3");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(winsLabel);
        getChildren().add(lossesLabel);
        tableView.getColumns().add(tableColumn);
        tableView.getColumns().add(winnerTableColumn);
        tableView.getColumns().add(videoTableColumn);
        getChildren().add(tableView);
        getChildren().add(backBtn);

        backBtn.setOnAction((event) -> {
            Parent newRoot = new FirstScreenBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });

    }
}
