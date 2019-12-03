package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
//import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		
//			BorderPane root = new BorderPane();
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//			primaryStage.setScene(scene);
//			primaryStage.show();
			
			GridPane grid = new GridPane();
			Scene scene = new Scene(grid);
			
			Mesonet.readFile();
			ArrayList <String> stationArray = Mesonet.getStationArray();
			
			//Create all the components********************************************
			
			//"Enter Hamming Dist" Label & textField
			Label enterHamLabel = new Label("Enter Hamming Dist:");		
			TextField enterHamField = new TextField();
			enterHamField.setEditable(false);

			//Slider
			Slider enterHamSlider = new Slider(1, 4, 1);
			enterHamSlider.setShowTickLabels(true);
			enterHamSlider.setMinorTickCount(0);
			enterHamSlider.setMajorTickUnit(1);
			enterHamSlider.setBlockIncrement(1);
			enterHamSlider.setSnapToTicks(true);
			
			// SHow Station Button
			Button showStationButton = new Button("Show Station");
		
			//ListView
			ListView stationList = new ListView();
			
			//Dropdown Box & Label
			Label dropBoxLabel = new Label("Compare with:");
			ComboBox dropBox = new ComboBox<String>(FXCollections.observableArrayList(stationArray));
			
			//Calculate HD Button
			Button CalculateHDButton = new Button("Calculate HD");
			
			//Distance Text Fields
			Label Distance0Label = new Label("Distance 0");		
			TextField Distance0Field = new TextField();
			Distance0Field.setEditable(false);
			
			Label Distance1Label = new Label("Distance 1");		
			TextField Distance1Field = new TextField();
			Distance1Field.setEditable(false);
			
			Label Distance2Label = new Label("Distance 2");		
			TextField Distance2Field = new TextField();
			Distance2Field.setEditable(false);
			
			Label Distance3Label = new Label("Distance 3");		
			TextField Distance3Field = new TextField();
			Distance3Field.setEditable(false);
			
			Label Distance4Label = new Label("Distance 4");		
			TextField Distance4Field = new TextField();
			Distance4Field.setEditable(false);
			
			//Made it do stuff*****************************************************
			
			//Slider and TextField
			enterHamField.textProperty().bind(enterHamSlider.valueProperty().asString());
			
			//Add List to Choice box
			
			
			//Add Stuff to the Grid************************************************
			
			//add components to the grid
			grid.add(enterHamLabel, 0, 0);
			grid.add(enterHamField, 1, 0);
			grid.add(enterHamSlider, 0, 2);
			grid.add(showStationButton, 0, 3);
			grid.add(stationList, 0, 4);
			grid.add(dropBoxLabel, 0, 5);
			grid.add(dropBox, 1, 5);
			grid.add(CalculateHDButton, 0, 6);
			grid.add(Distance0Label, 0, 7);
			grid.add(Distance0Field, 1, 7);
			grid.add(Distance1Label, 0, 8);
			grid.add(Distance1Field, 1, 8);
			grid.add(Distance2Label, 0, 9);
			grid.add(Distance2Field, 1, 9);
			grid.add(Distance3Label, 0, 10);
			grid.add(Distance3Field, 1, 10);
			grid.add(Distance4Label, 0, 11);
			grid.add(Distance4Field, 1, 11);

			grid.setHgap(10);
		    grid.setVgap(10);
		    grid.setPadding(new Insets(10, 10, 10, 10));
		    
		    scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		    
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
