import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application 
{ 
  
@Override
  public void start(Stage primaryStage) {
      // Create the BorderPane layout
      BorderPane borderPane = new BorderPane();

      // Create the UI components for the mortgage calculator
      VBox leftPanel = createLeftPanel();
      borderPane.setLeft(leftPanel);

      // Create a Canvas object for the house
      Canvas houseCanvas = new Canvas(150, 150);
      drawHouseOnCanvas(houseCanvas.getGraphicsContext2D());
      borderPane.setRight(houseCanvas);

      // Set the scene and stage
      Scene scene = new Scene(borderPane, 700, 400);
      primaryStage.setTitle("Mortgage Calculator");
      primaryStage.setScene(scene);
      primaryStage.show();
  }

  private VBox createLeftPanel() {
      VBox leftPanel = new VBox(10);
      leftPanel.setPadding(new Insets(15));

      // Form elements
      Label titleLabel = new Label("Jason Doty's Mortgage Rate Calculator");
      Label loanAmountLabel = new Label("Loan Amount:");
    TextField loanAmountField = new TextField();
            Label annualInterestRateLabel = new Label("Annual Interest Rate");
            TextField annualInterestRateField = new TextField();
            Label loanTermLabel = new Label("No of Years (Loan Term)");
            TextField loanTermField = new TextField();
            Label paymentsPerYearLabel = new Label("Payments Per Year");
            TextField paymentsPerYearField = new TextField();
            Button calculateButton = new Button("Calculate");

            // Layout for the form elements
            GridPane formLayout = new GridPane();
            formLayout.setVgap(10);
            formLayout.setHgap(10);

            // Adding form elements to the layout
            formLayout.add(titleLabel, 0, 0, 2, 1);
            formLayout.add(loanAmountLabel, 0, 1);
            formLayout.add(loanAmountField, 1, 1);
            formLayout.add(annualInterestRateLabel, 0, 2);
            formLayout.add(annualInterestRateField, 1, 2);
            formLayout.add(loanTermLabel, 0, 3);
            formLayout.add(loanTermField, 1, 3);
            formLayout.add(paymentsPerYearLabel, 0, 4);
            formLayout.add(paymentsPerYearField, 1, 4);
            formLayout.add(calculateButton, 0, 5, 2, 1);

            // Add form layout to the left panel VBox
            leftPanel.getChildren().add(formLayout);

            // Add event handler for the Calculate button (functionality to be implemented as per requirement)
            calculateButton.setOnAction(event -> {
                // TODO: Calculate mortgage payments
            });

            return leftPanel;
        }

        private void drawHouseOnCanvas(GraphicsContext gc) {
            // Draw the house body
            gc.setFill(Color.BEIGE);
            gc.fillRect(50, 60, 50, 40);

            // Draw the roof
            gc.setFill(Color.GRAY);
            gc.fillPolygon(new double[]{45, 75, 105}, new double[]{60, 30, 60}, 3);

            // Draw the chimney
            gc.setFill(Color.ORANGE);
            gc.fillRect(95, 35, 10, 15);

            // Draw the door
            gc.setFill(Color.SADDLEBROWN);
            gc.fillRect(70, 80, 15, 20);
            gc.setFill(Color.ORANGE);
            gc.fillOval(83, 95, 5, 5); // door knob

            // Draw windows
            drawWindow(gc, 55, 65);
            drawWindow(gc, 90, 65);
            drawWindow(gc, 55, 85);
            drawWindow(gc, 90, 85);
            drawWindow(gc, 75, 45); // Attic window
        }

        private void drawWindow(GraphicsContext gc, double x, double y) {
            gc.setFill(Color.LIGHTBLUE);
            gc.fillRect(x, y, 10, 10);
        }

        public static void main(String[] args) {
            launch(args);
        }
    }
