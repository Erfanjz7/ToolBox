package com.company.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import java.util.regex.*;

import java.io.IOException;

public class CalculatorController {

    private Stage Calculator;

    @FXML
    private Label AnswerLBL;

    @FXML
    private Button CalculateBTN;

    @FXML
    private TextField FirdtOpTXTField;

    @FXML
    private TextField OpTXTField;

    @FXML
    private TextField SecondOpTXTField;

    @FXML
    private Label StartTheOperationLBL;

    @FXML
    private Label ErrorLBL;

    @FXML
    private Button BackcalculatorBTN;

    // passkari stage

    public void initFunction2(Stage Calculator){
        this.setCalculator(Calculator);
    }


    // anjam mohasebat , aval 2 regez baraye vared karadn vorrodi b soorate adad ta saghfe 5 ragham
    @FXML
    private void CalculateHandler(ActionEvent event){
        String str = FirdtOpTXTField.getText();
        boolean check = Pattern.matches("[0-9]{1,5}" , str);
        String str2 = SecondOpTXTField.getText();
        boolean check2 = Pattern.matches("[0-9]{1,5}" , str2);
        boolean check3;
        check3 = OpTXTField.getText().equals("+") || OpTXTField.getText().equals("-") || OpTXTField.getText().equals("*") || OpTXTField.getText().equals("/"); // mptabeghat dadane voroodi dovom ba operand ha

        // pas az oboor az regex ha b anjame amalit mipardazim
        if(check && check2 && check3)
        {
            double op1 = Integer.parseInt(FirdtOpTXTField.getText());
            double op2 = Integer.parseInt(SecondOpTXTField.getText());
            double plus = op1 + op2;
            double minus = op1 - op2;
            double X = op1 * op2;
            double division = op1 / op2;
            String answerPlus = Double.toString(plus);
            String answerMinus = Double.toString(minus);
            String answerX = Double.toString(X);
            String answerDivision = Double.toString(division);
            if(OpTXTField.getText().equals("+"))

            {
                AnswerLBL.setText(FirdtOpTXTField.getText() + " " + OpTXTField.getText() + " " + SecondOpTXTField.getText() + " = " + answerPlus);
            }

            else if(OpTXTField.getText().equals("-"))
            {
                AnswerLBL.setText(FirdtOpTXTField.getText() + " " + OpTXTField.getText() + " " + SecondOpTXTField.getText() + " = " + answerMinus);
            }

            else if(OpTXTField.getText().equals("*"))
            {
                AnswerLBL.setText(FirdtOpTXTField.getText() + " " + OpTXTField.getText() + " " + SecondOpTXTField.getText() + " = " + answerX);
            }

            else if(OpTXTField.getText().equals("/"))
            {
                AnswerLBL.setText(FirdtOpTXTField.getText() + " " + OpTXTField.getText() + " " + SecondOpTXTField.getText() + " = " + answerDivision);
            }
        }

        else
            ErrorLBL.setText("Wrong Input Format");



    }

    // return to main menu
    @FXML
    private void BackcalculatorHandler(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("..\\View\\MainPage.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        MainPageController controller = loader.getController();
        controller.initFunction(getCalculator());

        Calculator.setScene(new Scene(loader.getRoot()));
    }

    public Stage getCalculator() {
        return Calculator;
    }

    public void setCalculator(Stage calculator) {
        Calculator = calculator;
    }
}
