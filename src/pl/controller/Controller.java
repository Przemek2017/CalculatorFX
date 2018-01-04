package pl.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button zero;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button fife;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;
    @FXML
    private Button add;
    @FXML
    private Button minus;
    @FXML
    private Button multi;
    @FXML
    private Button div;
    @FXML
    private Button equal;
    @FXML
    private Button clean;
    @FXML
    private Button close;
    @FXML
    private Label action;
    @FXML
    private TextField input;
    @FXML
    private BorderPane borderPane ;

    private long fnumber;
    private long snumber;
    private String operation = null;

    @FXML
    private void clickOnBackSpace(){
        String oldValue = input.getText();
        String newValue = oldValue.substring(0, oldValue.length() - 1);
        input.setText(newValue);
    }

    @FXML
    private void clickOnClean() {
        input.setText("");
        input.setPromptText("0");
        action.setText("");
        fnumber = 0;
        snumber = 0;
    }

    @FXML
    public void clickOnClose() {
        clickOnClean();
        System.exit(0);
    }

    @FXML
    public void clickOnZero() {
        String oldValue = input.getText();
        String value = "0";
        input.setText(oldValue + value);
    }

    @FXML
    private void clickOnOne() {
        String oldValue = input.getText();
        String value = "1";
        input.setText(oldValue + value);
    }

    @FXML
    private void clickOnTwo() {
        String oldValue = input.getText();
        String value = "2";
        input.setText(oldValue + value);
    }

    @FXML
    private void clickOnThree() {
        String oldValue = input.getText();
        String value = "3";
        input.setText(oldValue + value);
    }

    @FXML
    private void clickOnFour() {
        String oldValue = input.getText();
        String value = "4";
        input.setText(oldValue + value);
    }

    @FXML
    private void clickOnFife() {
        String oldValue = input.getText();
        String value = "5";
        input.setText(oldValue + value);
    }

    @FXML
    private void clickOnSix() {
        String oldValue = input.getText();
        String value = "6";
        input.setText(oldValue + value);
    }

    @FXML
    private void clickOnSeven() {
        String oldValue = input.getText();
        String value = "7";
        input.setText(oldValue + value);
    }

    @FXML
    private void clickOnEight() {
        String oldValue = input.getText();
        String value = "8";
        input.setText(oldValue + value);
    }

    @FXML
    private void clickOnNine() {
        String oldValue = input.getText();
        String value = "9";
        input.setText(oldValue + value);
    }

    @FXML
    private void clickOnAdd() {
        operation = "+";
        String value = input.getText();
        long number = Integer.parseInt(value);
        this.fnumber = number;
        input.setText("");
        action.setText(fnumber + operation);
    }

    @FXML
    private void clickOnMinus() {
        operation = "-";
        String value = input.getText();
        long number = Integer.parseInt(value);
        this.fnumber = number;
        input.setText("");
        action.setText(fnumber + operation);
    }

    @FXML
    private void clickOnMulti() {
        operation = "*";
        String value = input.getText();
        long number = Integer.parseInt(value);
        this.fnumber = number;
        input.setText("");
        action.setText(fnumber + operation);
    }

    @FXML
    private void clickOnDiv() {
        operation = "/";
        String value = input.getText();
        long number = Integer.parseInt(value);
        this.fnumber = number;
        input.setText("");
        action.setText(fnumber + operation);
    }

    @FXML
    private void clickOnEqual() {
        switch (operation) {
            case "+":
                String valueAdd = input.getText();
                this.snumber = Integer.parseInt(valueAdd);
                long resultAdd = this.fnumber + this.snumber;
                input.setText(String.valueOf(resultAdd));
                String oldActionAdd = action.getText();
                action.setText(oldActionAdd + valueAdd);
                break;
            case "-":
                String valueMinus = input.getText();
                this.snumber = Integer.parseInt(valueMinus);
                long resultMinus = this.fnumber - this.snumber;
                input.setText(String.valueOf(resultMinus));
                String oldActionMinus = action.getText();
                action.setText(oldActionMinus + valueMinus);
                break;
            case "*":
                String valueMulti = input.getText();
                this.snumber = Integer.parseInt(valueMulti);
                long resultMulti = this.fnumber * this.snumber;
                input.setText(String.valueOf(resultMulti));
                String oldActionMulti = action.getText();
                action.setText(oldActionMulti + valueMulti);
                break;
            case "/":
                String valueDiv = input.getText();
                if (valueDiv.equals("0")){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle(null);
                    alert.setHeaderText(null);
                    alert.setContentText("Nie dzielimy przez ZERO!");
                    alert.showAndWait();
                } else {
                    this.snumber = Integer.parseInt(valueDiv);
                    long resultDiv = this.fnumber / this.snumber;
                    input.setText(String.valueOf(resultDiv));
                    String oldActionDiv = action.getText();
                    action.setText(oldActionDiv + valueDiv);
                }
                break;
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        borderPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()){
                    case ADD:
                        clickOnAdd();
                        break;
                    case SUBTRACT:
                        clickOnMinus();
                        break;
                    case MULTIPLY:
                        clickOnMulti();
                        break;
                    case DIVIDE:
                        clickOnDiv();
                        break;
                    case ENTER:
                        clickOnEqual();
                        break;
                    case NUMPAD0:
                    case DIGIT0:
                        clickOnZero();
                        break;
                    case NUMPAD1:
                    case DIGIT1:
                        clickOnOne();
                        break;
                    case NUMPAD2:
                    case DIGIT2:
                        clickOnTwo();
                        break;
                    case NUMPAD3:
                    case DIGIT3:
                        clickOnThree();
                        break;
                    case NUMPAD4:
                    case DIGIT4:
                        clickOnFour();
                        break;
                    case NUMPAD5:
                    case DIGIT5:
                        clickOnFife();
                        break;
                    case NUMPAD6:
                    case DIGIT6:
                        clickOnSix();
                        break;
                    case NUMPAD7:
                    case DIGIT7:
                        clickOnSeven();
                        break;
                    case NUMPAD8:
                    case DIGIT8:
                        clickOnEight();
                        break;
                    case NUMPAD9:
                    case DIGIT9:
                        clickOnNine();
                        break;
                    case ESCAPE:
                    case END:
                        clickOnClose();
                        break;
                    case DELETE:
                        clickOnClean();
                        break;
                    case BACK_SPACE:
                        clickOnBackSpace();
                        break;
                }
            }
        });
    }
}
