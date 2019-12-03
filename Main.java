package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	
	private ArrayList <String> stationArray;
	
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
			stationArray = Mesonet.getStationArray();
			
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
			ListView<String> stationList = new ListView<String>();
			stationList.setEditable(false);
			
			//Dropdown Box & Label
			Label dropBoxLabel = new Label("Compare with:");
			ComboBox<String> dropBox = new ComboBox<String>(FXCollections.observableArrayList(stationArray));
			
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
			
			//Add Station Button
			Button addStationButton = new Button("Add Station");
			
			//Add Station TextField
			TextField addStationField = new TextField();
			addStationField.setEditable(true);
			
			//Made it do stuff*****************************************************
			
			//Slider and TextField
			enterHamSlider.valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
					enterHamField.textProperty().setValue(String.valueOf(newValue.intValue()));
				}
			});
			
			// ListView List from Combobox Station & SliderValue
			
			// Show Station Button action event 
	        EventHandler<ActionEvent> showStationEvent = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	String stationChosen = dropBox.getValue();
	    			int hamDistChosen = enterHamSlider.valueProperty().intValue();
	    			stationList.getItems().clear();
	    			
	    			//ArrayList <String> ListViewList = new ArrayList<String>();
	    				
	    			for (int j = 0; j < stationArray.size(); j++) {
	    				int stationHamDist = 0;
	    				for (int i = 0; i < 4; i++) {
	    					if (stationChosen.charAt(i) != stationArray.get(j).charAt(i)) {
	   							stationHamDist++;
	   					    }
	   				    }
	   					if (stationHamDist == hamDistChosen) {
	   						System.out.println(stationArray.get(j));
	    					stationList.getItems().add(stationArray.get(j));
	    				}
	    	        }	
	            } 
	        };
	       
	        showStationButton.setOnAction(showStationEvent);
			
	        //Add Calculate HD Event
	        EventHandler<ActionEvent> calculateHDEvent = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            {
	            	String stationChosen = dropBox.getValue();
	    			int Dist0 = 0;
	    			int Dist1 = 0;
	    			int Dist2 = 0;
	    			int Dist3 = 0;
	    			int Dist4 = 0;
	    				
	    			for (int j = 0; j < stationArray.size(); j++) {
	    				int stationHamDist = 0;
	    				for (int i = 0; i < 4; i++) {
	    					if (stationChosen.charAt(i) != stationArray.get(j).charAt(i)) {
	   							stationHamDist++;
	   					    }
	   				    }
	   					
	    				if (stationHamDist == 0) {
	   						++Dist0;
	    				}
	   					else if (stationHamDist == 1) {
	   						++Dist1;
	   					}
	   					else if (stationHamDist == 2) {
	   						++Dist2;
	   					}
	   					else if (stationHamDist == 3) {
	   						++Dist3;
	   					}
	   					else {
	   						++Dist4;
	   					}
	    	        }
	    			Distance0Field.setText(Integer.toString(Dist0));
	            }
	        };
	        
	        CalculateHDButton.setOnAction(calculateHDEvent);
	        
	        //Add Station Button Event
	        EventHandler<ActionEvent> addStationEvent = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            {
	            	String stationToAdd = addStationField.getText();
	            	dropBox.getItems().add(stationToAdd);
	            	addStationField.clear();
	            }
	        };
	        
	        addStationButton.setOnAction(addStationEvent);
	        
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
			grid.add(addStationButton, 0, 12);
			grid.add(addStationField, 1, 12);
			
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
