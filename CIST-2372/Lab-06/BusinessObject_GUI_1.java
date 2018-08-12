package businessobject_gui;
import businessobject_gui.Student2.*;
/*************************************************************************
 *
 *      Patricia Renee Taylor
 *      CIST 2372 Summer 2018
 *      Assignment #1
 *      6/6/18
 *
 * 1.)  Create a simple Java FX Form to Display Student Data.
 * Form top: "Student Information”.  Middle part: labels &
 * textFields; one each for ID, FirstName, LastName, Email and GPA.
 * Bottom: Buttons - “Find”, “Insert”, “Delete”, “Update” and “Exit”.
 *
 * 2.)  Create events on the buttons. Connect these events to the
 * Students class which access the database.  
 **************************************************************************/

import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.WindowEvent;

public class BusinessObject_GUI_1 extends Application implements EventHandler<ActionEvent> {
   
    
    //Label id's and Fields for middle panel
        Label id    = new Label("ID:");
        Label fName = new Label("First Name:");
        Label lName = new Label("Last Name:");
        Label email = new Label("Email:");
        Label gpa   = new Label("GPA:");
        TextField idField    = new TextField();
        TextField fNameField = new TextField();
        TextField lNameField = new TextField();
        TextField emailField = new TextField();
        TextField gpaField   = new TextField();
        
    
    //create buttons for bottom panel
        Button findBtn   = new Button("Find");
        Button insertBtn = new Button("Insert");
        Button deleteBtn = new Button("Delete");
        Button updateBtn = new Button("Update");
        Button exitBtn   = new Button("Exit");
        
    public static void main(String[] args) {
        launch(args);
    }//end main
         
    @Override
    public void start(Stage primaryStage) {

    //format top part of BorderPane - object p1 is hbox, put object title in
        Text title = new Text("Student Information");
       // title.setFont(Font.font("Verdana", 25));
        title.setStyle("-fx-font-size: 25px;");
        HBox p1 = new HBox();
        p1.setAlignment(Pos.BOTTOM_CENTER);
        p1.getChildren().add(title);
        p1.setStyle("-fx-background-color: #a3e4d7;");

    //format middle part of BorderPane with GridPane
        //Setting GridPane arrangement
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(5);
        grid.setStyle("-fx-font-size: 14px; -fx-background-color: #d6eaf8;");
        GridPane.setHalignment(id,    HPos.RIGHT);
        GridPane.setHalignment(fName, HPos.RIGHT);
        GridPane.setHalignment(lName, HPos.RIGHT);
        GridPane.setHalignment(email, HPos.RIGHT);
        GridPane.setHalignment(gpa,   HPos.RIGHT);
        
        //Placing labels and textfields on GridPane grid
        grid.add(id,    0, 0);
        grid.add(fName, 0, 1);
        grid.add(lName, 0, 2);
        grid.add(email, 0, 3);
        grid.add(gpa,   0, 4);
        grid.add(idField,    1, 0);
        grid.add(fNameField, 1, 1);
        grid.add(lNameField, 1, 2);
        grid.add(emailField, 1, 3);
        grid.add(gpaField,   1, 4);
        
        
    //Format bottom part of BorderPane 
        HBox p3 = new HBox(8);
        p3.setAlignment(Pos.CENTER);
        p3.getChildren().addAll(findBtn, insertBtn, deleteBtn, updateBtn, exitBtn);
        p3.setPadding(new Insets(10,10,0,10));
        
     //add functionality
        exitBtn.setOnAction(this);
        findBtn.setOnAction(this);
        insertBtn.setOnAction(this);
        deleteBtn.setOnAction(this);
        updateBtn.setOnAction(this);
        
    //Define BorderPane root, place children p1, grid, p3 into panels
        BorderPane root = new BorderPane();
        root.setTop(p1);
        root.setCenter(grid);
        root.setBottom(p3);
        root.setStyle("-fx-padding: 10;" +
                  "-fx-border-style: solid inside;" +
                  "-fx-border-width: 2;" +
                  "-fx-border-insets: 10;" +
                  "-fx-border-radius: 5;" +
                  "-fx-border-color: #222222;");
        
    //Place root onto scene
        Scene scene = new Scene(root, 400, 450);

    //Put scene onto stage, display
        primaryStage.setTitle("Student Info");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }//close start
    
    
    //Add Event code in handle() method - this starts the integration with the
    //business objects programming, using class Student which is in the package.
    //Functionality includes Find, Insert, Update, Delete. 
    @Override
    public void handle(ActionEvent event){
        
        Student2 s1 = new Student2(); //create student object to store data
        
		//exit Button behavior - when pushed, it brings up an alert screen asking
		//if want to exit.
        if (event.getSource()==exitBtn){ 
            Alert alert = new Alert(AlertType.CONFIRMATION, "Are you "
                    + "sure you want to exit?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                   Platform.exit();
                }
        }//end exitBtn handling 
        
	//find button behavior - type student id into id field and hit find. It 
	//goes to database and loads other fields with data associated wit that id.
        if (event.getSource()==findBtn){ 
            //parse id from field string to integer	
            int idValue = Integer.parseInt(idField.getText());
            //if id field isn't null, proceed
            if (idField.getText() != null) {  
		// run selectDB to populate s1 object from database
                s1.selectDB(idValue);
		//load values from s1 object into fields
                fNameField.setText(s1.getFirstName());
                lNameField.setText(s1.getLastName());
                emailField.setText(s1.getEmail());
		//convert double to String
                String gpa = String.valueOf(s1.getGpa());
		//load string into gpa field
                gpaField.setText(gpa);
            }//end if
        }//end find handling
		
	//insert button behavior - type data into fields, with unique student id
	//and hit insert button.
	if (event.getSource()==insertBtn){
            //if id field isn't null, proceed
            if (idField.getText() != null) {
                //call insertDB and pass parameters to populate the database
                //with a unique student id and associated values. Empty fields
                //are because there are more fields in database than addressed
                //in this gui application.
                s1.insertDB(Integer.parseInt(idField.getText()),
                            fNameField.getText(),
                            lNameField.getText(),
                            "", //street,
                            "", //city
                            "", //state
                            0,  //zip
                            emailField.getText(),
                            Double.parseDouble(gpaField.getText())
                );//close insert paramaters
            }//end if
        }//end insert  handling
        
        //update button behavior - Type fields into gui to change, then select 
        //update button. Data from existing record is loaded into s1 object
        //from the id number supplied in the gui. Then the object values are
        //set to the entered values, checking to see which ones are there.
        if (event.getSource()==updateBtn){
            //parse id from field string to integer	
            int idValue = Integer.parseInt(idField.getText());
            //if id field isn't null, proceed
            if (idField.getText() != null) {
                //call select on s1 to populate s1 with existing db values
                s1.selectDB(idValue);
                System.out.println("before update");
                s1.display();
                //check each field to see if new value is there, if so, use it
                if (fNameField != null){  
                    s1.setFirstName(fNameField.getText());  }
                
                if (lNameField != null){
                    s1.setLastName(lNameField.getText());  }
               
                if (emailField != null){
                    s1.setEmail(emailField.getText());  }
                
                if (gpaField != null){
                    s1.setGpa(Double.parseDouble(gpaField.getText()));  }
                    
                System.out.println("after update");
                s1.display();
            }//end if
        }//end update
		
	//delete button behavior - student id to be deleted is entered into gui,
	//then deleteDB is called without arguments.
        if (event.getSource()==deleteBtn){
            System.out.println("the delete button was pressed");
            //parse id from field string to integer
            int idValue = Integer.parseInt(idField.getText()); 
            //if id field isn't null, proceed
            if (idField.getText() != null) {    
                s1.selectDB(idValue);
                s1.deleteDB();
            }//end if
        }//end delete
    }//end handle
}//end class