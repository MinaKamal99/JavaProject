package tictactoe;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public  class MultiOnlineLoginBase extends Pane {

    protected final Text text;
    protected final Text text0;
    protected final TextField userNameTxtField;
    protected final TextField passwordTxtField;
    protected final Button loginBtn;
    protected final Button signupBtn;
    protected final Text text1;
    protected final Button backBtn;
    protected final Label label;
    protected final Label label0;
    Stage stage;
    public MultiOnlineLoginBase(Stage s) {
     stage=s;
        text = new Text();
        text0 = new Text();
        userNameTxtField = new TextField();
        passwordTxtField = new TextField();
        loginBtn = new Button();
        signupBtn = new Button();
        text1 = new Text();
        backBtn = new Button();
        label = new Label();
        label0 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(371.0);
        setPrefWidth(583.0);

        text.setLayoutX(207.0);
        text.setLayoutY(82.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Tic Tac Toe");
        text.setWrappingWidth(166.6708984375);
        text.setFont(new Font(30.0));

        text0.setLayoutX(236.0);
        text0.setLayoutY(124.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Welcome");
        text0.setWrappingWidth(94.99999657273293);
        text0.setFont(new Font(22.0));

        userNameTxtField.setLayoutX(169.0);
        userNameTxtField.setLayoutY(154.0);

        passwordTxtField.setLayoutX(169.0);
        passwordTxtField.setLayoutY(209.0);

        loginBtn.setLayoutX(164.0);
        loginBtn.setLayoutY(299.0);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setPrefHeight(31.0);
        loginBtn.setPrefWidth(95.0);
        loginBtn.setText("Login");

        signupBtn.setLayoutX(309.0);
        signupBtn.setLayoutY(299.0);
        signupBtn.setMnemonicParsing(false);
        signupBtn.setPrefHeight(31.0);
        signupBtn.setPrefWidth(95.0);
        signupBtn.setText("Sign Up");

        text1.setFill(javafx.scene.paint.Color.valueOf("#c93f3f"));
        text1.setLayoutX(176.0);
        text1.setLayoutY(271.0);
        text1.setLineSpacing(2.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("sorry ,invalid email or password");
        text1.setVisible(false);
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(215.00000216066837);
        text1.setFont(new Font(12.0));

        backBtn.setLayoutX(29.0);
        backBtn.setLayoutY(26.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(47.0);
        label.setLayoutY(156.0);
        label.setPrefHeight(29.0);
        label.setPrefWidth(102.0);
        label.setText("UserName");
        label.setFont(new Font(21.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(47.0);
        label0.setLayoutY(209.0);
        label0.setPrefHeight(29.0);
        label0.setPrefWidth(102.0);
        label0.setText("Password");
        label0.setFont(new Font(21.0));

        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(userNameTxtField);
        getChildren().add(passwordTxtField);
        getChildren().add(loginBtn);
        getChildren().add(signupBtn);
        getChildren().add(text1);
        getChildren().add(backBtn);
        getChildren().add(label);
        getChildren().add(label0);
         backBtn.setOnAction((event) -> {
            Parent newRoot = new FirstScreenBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });

        signupBtn.setOnAction((event) -> {
            Parent newRoot = new RegisterationOnlineBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
        
          loginBtn.setOnAction((event) -> {
              boolean found=DataAccessLayer.login(userNameTxtField.getText().toString(), passwordTxtField.getText().toString());
              if (found){
                Parent newRoot = new OnlineUsersBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
              }
              else {
                  text1.setVisible(true);
                  userNameTxtField.clear();
                  passwordTxtField.clear();
              }
              
        });
    }
}
