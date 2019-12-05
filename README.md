# Project5
 For this Project, I implemented two classes, Main and Mesonet. With in the Mesonet class I first created the readFile() method which
calls the read method to read in the "Mesonet.txt" file. It uses a try/catch to throw an IOException if there is an error when
reading in the the data from the file. My read(String filename) method takes in the file name to read in. The Method saves the lines 
of String stationIDs by using a while loop which loops through the file, saving each value into an ArrayList called stationArray. 
There is also the getStationArray() method wich is a getter mthod that returns the ArrayList stationArray. 

I then implemented my Main class, extending it from Application to be able to use various methods from the Application base class. 
Within this class I have two methods, my Main method, and start(Stage primaryStage) method. The purpose of the main method is to launch
the stage method. Within the Stage() method is where I implemented the code to create the window and all of it components, events, and 
calculations. Within this Method I initially called the Mesonet.readFile() method to read in the Mesonet.txt file and created a private
ArrayList variable called stationArray, which is assigned the Mesonet.getStationArray() method call to get the station array from the 
Mesonet class. I Then create the various Labels, Buttons, Listview, and sliders to later add onto my window. To calculate the hamming 
distance I implemented an event Handler that, when the Show stations Button was pressed, would get the slider value and ComboBox station
value and us adouble for loop to iterate through the stationArray, comparing every station to the selected stations and finding their 
Hamming Distances. If the distance was equal to the chosen distance, then the station would be displayed inthe ListView box. For the 
calculate HD button, the event implemneted a double for loop similar to the one mentioned, this time it used if, else if statements to 
count the number of stations that hav distances 0, 1, 2, 3, and 4. My add station button implemnets a simple method which adds the 
addStationFields value to the comboBox list. 

For my creative part, I decided to implemnt a MadLib, ince I wanted to add alittle bit of entertainment while the user calculates the 
stations hamming distances. I create labels and associated TextFields which prompt the user to enter certain words. The user then presses 
the button which triggers the event. In the event, a string paragraoh is created which uses the values entereds by the user. The event 
crates a Popup window which contains the MadLib paragraph with the user inputs. 
