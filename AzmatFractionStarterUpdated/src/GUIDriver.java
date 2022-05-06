import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Fraction reduction, addition, and multiplication interface
 * 
 * @author G. Hutchison
 * @version 1.0
 */
public class GUIDriver extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Font font = new Font("TIMES NEW ROMAN", 24);
		Label title = new Label("Fraction Fun");
		title.setFont(font);

		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);
		BackgroundFill bf = new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY);

		// Background creation
		Background bg = new Background(bf);

		// set background
		vbox.setBackground(bg);

		Label numerator = new Label("Numerator");
		Label denom = new Label("Denominator");

		numerator.setFont(font);
		numerator.setMinWidth(80);
		denom.setFont(font);
		denom.setMinWidth(80);

		//Vertical box for the first fraction
		VBox input1 = new VBox(10);
		input1.setAlignment(Pos.CENTER);
		TextField txtNumerator = new TextField();
		txtNumerator.setMaxWidth(150);
		txtNumerator.setAlignment(Pos.CENTER);
		TextField txtDenom = new TextField();
		txtDenom.setMaxWidth(150);
		txtDenom.setAlignment(Pos.CENTER);
		input1.getChildren().add(txtNumerator);
		input1.getChildren().add(txtDenom);

		//Vertical box for the second fraction
		VBox input2 = new VBox(10);
		input2.setAlignment(Pos.CENTER);
		TextField txtNumerator2 = new TextField();
		txtNumerator2.setMaxWidth(150);
		txtNumerator2.setAlignment(Pos.CENTER);
		TextField txtDenom2 = new TextField();
		txtDenom2.setMaxWidth(150);
		txtDenom2.setAlignment(Pos.CENTER);
		input2.getChildren().add(txtNumerator2);
		input2.getChildren().add(txtDenom2);

		//Placing both VBoxes into a horizontal box
		HBox inputs = new HBox(10);
		inputs.setAlignment(Pos.CENTER);
		inputs.getChildren().addAll(input1, input2);

		txtNumerator.setFont(font);
		txtDenom.setFont(font);
		txtNumerator2.setFont(font);
		txtDenom2.setFont(font);

		//Creating the buttons
		Button btnReduce = new Button("Reduce");
		Button btnAdd = new Button("Add");
		Button btnMulti = new Button("Multiply");
		btnReduce.setFont(font);
		btnAdd.setFont(font);
		btnMulti.setFont(font);

		//Putting the buttons in a horizontal box
		HBox buttons = new HBox(10);
		buttons.setAlignment(Pos.CENTER);
		buttons.setPadding(new Insets(10));
		buttons.getChildren().add(btnReduce);
		buttons.getChildren().add(btnAdd);
		buttons.getChildren().add(btnMulti);

		TextField txtNume3 = new TextField();
		txtNume3.setAlignment(Pos.CENTER);
		txtNume3.setPrefWidth(200);
		txtNume3.setMaxWidth(200);
		TextField txtDenom3 = new TextField();
		txtDenom3.setAlignment(Pos.CENTER);
		txtDenom3.setPrefWidth(200);
		txtDenom3.setMaxWidth(200);

		
		
		Label line = new Label("--");
		line.setFont(font);
		line.setAlignment(Pos.CENTER);
		
		//Placing the elements into the overall VBox/interface
		vbox.getChildren().add(title);
		vbox.getChildren().add(inputs);
		vbox.getChildren().add(buttons);
		vbox.getChildren().add(txtNume3);
		vbox.getChildren().add(line);
		vbox.getChildren().add(txtDenom3);

		Scene scene = new Scene(vbox, 400, 400);
		stage.setScene(scene);
		stage.show();

		btnReduce.setOnAction(e -> {
			try {
				int n = Integer.valueOf(txtNume3.getText());
				int d = Integer.valueOf(txtDenom3.getText());
				Fraction reducedFrac;
				reducedFrac = new Fraction(n, d);
				if (reducedFrac.isReduced()) {
					txtNume3.setText("");
					txtDenom3.setText("");
					line.setText("Fraction is already reduced");
				} else {
					reducedFrac.reduce();
					line.setText("--");
					txtNume3.setText(String.valueOf(reducedFrac.getNumerator()));
					txtDenom3.setText(String.valueOf(reducedFrac.getDenominator()));
				}
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		
		btnAdd.setOnAction(e -> {
			try {
				int n = Integer.valueOf(txtNumerator.getText());
				int d = Integer.valueOf(txtDenom.getText());
				int n2 = Integer.valueOf(txtNumerator2.getText());
				int d2 = Integer.valueOf(txtDenom2.getText());
				Fraction frac = new Fraction(n, d);
				Fraction frac2 = new Fraction(n2, d2);
				
				Fraction sum = frac.add(frac2);
				line.setText("--");
				txtNume3.setText(String.valueOf(sum.getNumerator()));
				txtDenom3.setText(String.valueOf(sum.getDenominator()));
				
			} catch (Exception f) {
				txtNume3.setText("Denominator cannot be Zero");
			}
		});
		
		btnMulti.setOnAction(e -> {
			try {
				Fraction frac1 = new Fraction(Integer.valueOf(txtNumerator.getText()), 
											Integer.valueOf(txtDenom.getText()));
				Fraction frac2 = new Fraction(Integer.valueOf(txtNumerator2.getText()), 
						Integer.valueOf(txtDenom2.getText()));
				Fraction product = frac1.multiply(frac2);
				line.setText("--");
				txtNume3.setText(String.valueOf(product.getNumerator()));
				txtDenom3.setText(String.valueOf(product.getDenominator()));
			} catch(Exception f) {
				txtNume3.setText("Denominator cannot be Zero");
			}
		});
	}

	public static void main(String[] args) {
		launch(args);
	}
}
