package application;
	
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Main extends Application {
	
	private ArrayList <String> stationArray;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
			
			GridPane grid = new GridPane();
			Scene scene = new Scene(grid);
			
			Mesonet.readFile(); // Method call to read in "Mesonet.txt"
			stationArray = Mesonet.getStationArray(); // Method call to populate the stationArray with the read in values
			
			//Create all the components********************************************
			
			Label enterHamLabel = new Label("Enter Hamming Dist:");	// Enter Hamming Dist Label 
			TextField enterHamField = new TextField(); // TextField
			enterHamField.setEditable(false);
		
			Slider enterHamSlider = new Slider(1, 4, 1); // Slider
			enterHamSlider.setShowTickLabels(true);
			enterHamSlider.setMinorTickCount(0);
			enterHamSlider.setMajorTickUnit(1);
			enterHamSlider.setBlockIncrement(1);
			enterHamSlider.setSnapToTicks(true);
			
			
			Button showStationButton = new Button("Show Station"); // Show Station Button
		
			ListView<String> stationList = new ListView<String>(); // ListView
			stationList.setEditable(false);
			
			Label dropBoxLabel = new Label("Compare with:"); // Drop down Box Label
			ComboBox<String> dropBox = new ComboBox<String>(FXCollections.observableArrayList(stationArray)); //Drop down Box
			
			Button CalculateHDButton = new Button("Calculate HD"); // Calculate HD Button
			
			//Distance Text Fields
			Label Distance0Label = new Label("Distance 0");	// Distance 0
			TextField Distance0Field = new TextField();
			Distance0Field.setEditable(false);
			
			Label Distance1Label = new Label("Distance 1");	// Distance 1
			TextField Distance1Field = new TextField();
			Distance1Field.setEditable(false);
			
			Label Distance2Label = new Label("Distance 2");	// Distance 2
			TextField Distance2Field = new TextField();
			Distance2Field.setEditable(false);
			
			Label Distance3Label = new Label("Distance 3");	// Distance 3
			TextField Distance3Field = new TextField();
			Distance3Field.setEditable(false);
			
			Label Distance4Label = new Label("Distance 4");	// Distance 4
			TextField Distance4Field = new TextField();
			Distance4Field.setEditable(false);
			
			Button addStationButton = new Button("Add Station"); // Add Station Button
			
			TextField addStationField = new TextField(); // Add Station TextField
			addStationField.setEditable(true);
			
			//Creative Part
			Label firstQLabel = new Label("Enter a Term of Enderment");	// Term of Enderment Label & TextField
			TextField firstQField = new TextField();
			firstQField.setEditable(true);
			
			Label secondQLabel = new Label("Enter First Name");	// First Name Label & TextField
			TextField secondQField = new TextField();
			secondQField.setEditable(true);
			
			Label thirdQLabel = new Label("Enter First and Last Name");	// First and Last Name Label & TextField
			TextField thirdQField = new TextField();
			thirdQField.setEditable(true);
			
			Label fourthQLabel = new Label("Enter a Place");	// Place Label & TextField
			TextField fourthQField = new TextField();
			fourthQField.setEditable(true);
			
			Label fifthQLabel = new Label("Enter a Day of Week");	// Day of the Week Label & TextField
			TextField fifthQField = new TextField();
			fifthQField.setEditable(true);
			
			Label sixthQLabel = new Label("Enter an Adjective");	// Adjective Label & TextField
			TextField sixthQField = new TextField();
			sixthQField.setEditable(true);
			
			Label seventhQLabel = new Label("Enter a Color");	// Color Label & TextField
			TextField seventhQField = new TextField();
			seventhQField.setEditable(true);
			
			Label eigthQLabel = new Label("Enter an Item of Clothing");	// Item of Clothing Label & TextField
			TextField eigthQField = new TextField();
			eigthQField.setEditable(true);
			
			Slider numberSlider = new Slider(1, 100, 1); // number Slider 
			enterHamSlider.setShowTickLabels(true);
			enterHamSlider.setMinorTickCount(0);
			enterHamSlider.setMajorTickUnit(1);
			enterHamSlider.setBlockIncrement(1);
			enterHamSlider.setSnapToTicks(true);
			
			TextField numberField = new TextField(); // number TextField
			numberField.setEditable(false);
			
			Label ninthQLabel = new Label("Enter 4 Verbs");	// Verb Label & TextFields
			TextField verb1Field = new TextField();
			verb1Field.setEditable(true);
			TextField verb2Field = new TextField();
			verb2Field.setEditable(true);
			TextField verb3Field = new TextField();
			verb3Field.setEditable(true);
			TextField verb4Field = new TextField();
			verb4Field.setEditable(true);
			
			Button madLibButton = new Button("Get the MadLib!"); // MadLib Button
			
			Popup storyPop = new Popup(); // MadLib Popup window
			
			//Made it do stuff*****************************************************
			
			//Slider and TextField Listener
			enterHamSlider.valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
					enterHamField.textProperty().setValue(String.valueOf(newValue.intValue()));
				}
			});
			
			// Show Station Button event 
	        EventHandler<ActionEvent> showStationEvent = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            { 
	            	String stationChosen = dropBox.getValue();
	    			int hamDistChosen = enterHamSlider.valueProperty().intValue();
	    			stationList.getItems().clear();
	    				
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
			
	        // Calculate HD Event
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
	    			Distance1Field.setText(Integer.toString(Dist1));
	    			Distance2Field.setText(Integer.toString(Dist2));
	    			Distance3Field.setText(Integer.toString(Dist3));
	    			Distance4Field.setText(Integer.toString(Dist4));
	            }
	        };
	        
	        CalculateHDButton.setOnAction(calculateHDEvent);
	        
	        // Add Station Button Event
	        EventHandler<ActionEvent> addStationEvent = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            {
	            	String stationToAdd = addStationField.getText();
	            	dropBox.getItems().add(stationToAdd);
	            	addStationField.clear();
	            }
	        };
	        
	        addStationButton.setOnAction(addStationEvent);
	        
	        // numberSlider Event
	        numberSlider.valueProperty().addListener(new ChangeListener<Number>() {
				public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
					numberField.textProperty().setValue(String.valueOf(newValue.intValue()));
				}
			});
	        
	        // Get the MadLib Button Event
	        EventHandler<ActionEvent> madLibEvent = new EventHandler<ActionEvent>() { 
	            public void handle(ActionEvent e) 
	            {
	            	String term = firstQField.getText().toUpperCase();
	            	String firstName = secondQField.getText().toUpperCase();
	            	String firstLastName = thirdQField.getText().toUpperCase();
	            	String place = fourthQField.getText().toUpperCase();
	            	String day = fifthQField.getText().toUpperCase();
	            	String adj = sixthQField.getText().toUpperCase();
	            	String color = seventhQField.getText().toUpperCase();
	            	String cloth = eigthQField.getText().toUpperCase();
	            	String number = numberField.getText();
	            	String verb1 = verb1Field.getText().toUpperCase();
	            	String verb2 = verb2Field.getText().toUpperCase();
	            	String verb3 = verb3Field.getText().toUpperCase();
	            	String verb4 = verb4Field.getText().toUpperCase();
	            	
	            	String story = "Hey, " + term + ". It's me. What's up? You know, \n"
	            			+ firstName + ". " + firstLastName + ". From the\n" + 
	            			place + ". Two " + day + "s ago. I was the " + adj + " guy\nin the " +
	            			color + " skin tight " + cloth + ". I paid the bus boy\n" 
	            			+ number + " dollars to " + verb1 + " me your information. I was\n" + 
	            			"wondering if maybe you'd like to " + verb2 + " out with me.\nPlease dont " + 
	            			"call the " + verb3 + " department. Alright, I'll " + verb4 + ".\nSo, thats a no, right?";
	            	
	            	Label storyLabel = new Label(story);
	            	storyLabel.setStyle(" -fx-background-color: white;"); 
	           
	                // add the label 
	                storyPop.getContent().add(storyLabel); 
	                
	                if (!storyPop.isShowing()) 
	                    storyPop.show(primaryStage); 
	                else
	                    storyPop.hide(); 
	            }
	        };
	        
	        madLibButton.setOnAction(madLibEvent);
	        
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
			
			grid.add(madLibButton, 3, 0);
			grid.add(firstQLabel, 2, 1);
			grid.add(firstQField, 3, 1);
			grid.add(secondQLabel, 2, 2);
			grid.add(secondQField, 3, 2);
			grid.add(thirdQLabel, 2, 3);
			grid.add(thirdQField, 3, 3);
			grid.add(fourthQLabel, 2, 4);
			grid.add(fourthQField, 3, 4);
			grid.add(fifthQLabel, 2, 5);
			grid.add(fifthQField, 3, 5);
			grid.add(sixthQLabel, 2, 6);
			grid.add(sixthQField, 3, 6);
			grid.add(seventhQLabel, 2, 7);
			grid.add(seventhQField, 3, 7);
			grid.add(eigthQLabel, 2, 8);
			grid.add(eigthQField, 3, 8);
			grid.add(numberSlider, 2, 9);
			grid.add(numberField, 3, 9);
			grid.add(ninthQLabel, 2, 10);
			grid.add(verb1Field, 3, 11);
			grid.add(verb2Field, 3, 12);
			grid.add(verb3Field, 3, 13);
			grid.add(verb4Field, 3, 14);
			
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
