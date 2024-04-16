import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JDotyLab12 extends Application 
{ 
  
  @Override
public void start(Stage primaryStage) {
        // Creating the GridPane layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Creating labels and text fields for inputs
        Label lblLoanAmount = new Label("Loan Amount (P):");
        TextField txtLoanAmount = new TextField();
        Label lblAnnualInterestRate = new Label("Annual Interest Rate (r):");
        TextField txtAnnualInterestRate = new TextField();
        Label lblYears = new Label("Number of Years (t):");
        TextField txtYears = new TextField();
        Label lblPaymentsPerYear = new Label("Payments Per Year (n):");
        TextField txtPaymentsPerYear = new TextField();
        Button btnCalculate = new Button("Calculate");
        Label lblMonthlyPayment = new Label("Monthly Payment:");

        // Adding components to the GridPane
        grid.add(lblLoanAmount, 0, 0);
        grid.add(txtLoanAmount, 1, 0);
        grid.add(lblAnnualInterestRate, 0, 1);
        grid.add(txtAnnualInterestRate, 1, 1);
        grid.add(lblYears, 0, 2);
        grid.add(txtYears, 1, 2);
        grid.add(lblPaymentsPerYear, 0, 3);
        grid.add(txtPaymentsPerYear, 1, 3);
        grid.add(btnCalculate, 1, 4);
        grid.add(lblMonthlyPayment, 0, 5);
        GridPane.setColumnSpan(lblMonthlyPayment, 2);
        grid.setAlignment(Pos.CENTER);

        // Setting up the calculate button event handler
        btnCalculate.setOnAction(e -> {
            double loanAmount = Double.parseDouble(txtLoanAmount.getText());
          double annualInterestRate = Double.parseDouble(txtAnnualInterestRate.getText());

            int years = Integer.parseInt(txtYears.getText());
            int paymentsPerYear = Integer.parseInt(txtPaymentsPerYear.getText());

            double monthlyInterestRate = annualInterestRate / paymentsPerYear;
            double numberOfPayments = years * paymentsPerYear;

            // Calculating the monthly payment
            double monthlyPayment = (loanAmount * monthlyInterestRate * Math.pow((1 + monthlyInterestRate), numberOfPayments))
                                    / (Math.pow((1 + monthlyInterestRate), numberOfPayments) - 1);

            // Displaying the result
            lblMonthlyPayment.setText(String.format("Monthly Payment: %.2f", monthlyPayment));
        });

        // Creating the scene and setting the stage
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setTitle("Mortgage Calculator - CSCI 2011 Lab 12");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
