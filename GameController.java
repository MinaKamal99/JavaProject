/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Nada
 */
public class GameController {

    boolean isGameEnds;
    boolean isFirstPlayerTurn = true;
    int XOCounter = 0;
    Color xForeground = Color.BLUE;
    Color oForeground = Color.RED;
    static LinkedHashMap<String, Label> labelMap = new LinkedHashMap<String, Label>();
    Stage s;

    GameController(Stage stage) {
        for (int i = 1; i <= 9; i++) {
            String thelabel = "label" + i;
            Label l = new Label();
            l.setText("");
            labelMap.put(thelabel, l);
            s = stage;
        }

    }

    public void setCurrentPlayerSymbol(Label label, String labelname) {
        label.setOpacity(1);
        label.setFont(Font.font(50));
        if (isFirstPlayerTurn == true) {
            label.setText("X");
            label.setTextFill(xForeground);
            System.out.println(label);
            isFirstPlayerTurn = false;
            XOCounter++;
        } else {
            label.setText("O");
            label.setTextFill(oForeground);
            isFirstPlayerTurn = true;
            XOCounter++;
        }

        labelMap.put(labelname, label);
        checkIfGameEnds(labelMap);
        label.setDisable(true);
    }

    private void colorBackgroundWinner(Label l1, Label l2, Label l3) {
        l1.setStyle("-fx-background-color: yellow;");
        l2.setStyle("-fx-background-color: yellow;");
        l3.setStyle("-fx-background-color: yellow;");
    }

    public void checkIfGameEnds(LinkedHashMap<String, Label> labelmap) {

        String t00 = labelmap.get("label1").getText();
        String t01 = labelmap.get("label2").getText();
        String t02 = labelmap.get("label3").getText();
        String t10 = labelmap.get("label4").getText();
        String t11 = labelmap.get("label5").getText();
        String t12 = labelmap.get("label6").getText();
        String t20 = labelmap.get("label7").getText();
        String t21 = labelmap.get("label8").getText();
        String t22 = labelmap.get("label9").getText();

        if (t00.equals(t01) && t00.equals(t02) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label1"), labelmap.get("label2"), labelmap.get("label3"));
        }

        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label4"), labelmap.get("label5"), labelmap.get("label6"));
        }

        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label7"), labelmap.get("label8"), labelmap.get("label9"));
        }

        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label1"), labelmap.get("label4"), labelmap.get("label7"));
        }

        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label2"), labelmap.get("label5"), labelmap.get("label8"));
        }

        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label3"), labelmap.get("label6"), labelmap.get("label9"));
        }

        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label1"), labelmap.get("label5"), labelmap.get("label9"));
        }

        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label3"), labelmap.get("label5"), labelmap.get("label7"));
        }

        if (XOCounter >= 9) {
            isFirstPlayerTurn = true;
            XOCounter = 0;
            Alert alert = new Alert(AlertType.INFORMATION, "No one Wins !!", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    Parent newRoot = new MultiOfflineBase(s);
                    Scene scene = new Scene(newRoot);
                    s.setScene(scene);
                }

        }

        if (isGameEnds == true) {
            
            if (!isFirstPlayerTurn) {

                Alert alert = new Alert(AlertType.INFORMATION, "Player 1 Wins !!", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    Parent newRoot = new MultiOfflineBase(s);
                    Scene scene = new Scene(newRoot);
                    s.setScene(scene);
                }
            } else {
                Alert alert = new Alert(AlertType.INFORMATION, "Player 2 Wins !!", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    Parent newRoot = new MultiOfflineBase(s);
                    Scene scene = new Scene(newRoot);
                    s.setScene(scene);
                }
            }

            XOCounter = 0;
        }

    }

}
