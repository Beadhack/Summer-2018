package mini_project;

/*************************************************************************
 *
 *      Patricia Renee Taylor
 *      CIST 2372 
 *      Summer 2018
 *      Assignment Mini Project
 *      7/23/18
 *                              === Client ===
 * Build a Chat program. Two programs - client "ChatClient.java" and server
 * "ChatServer.java". Each will have a TextField at the bottom and a send 
 * button, and a TextArea at the top. When client user types in some text
 * in the TextField and hits Send, the text will be delivered to the TextArea
 * in the server TextArea. Server will respond the same. Programs use
 * Sockets, Streams, GUI components and events, and Threads.
 **************************************************************************/


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import java.net.*;

public class ChatClient extends Application implements EventHandler<ActionEvent>, Runnable {
    
    //Label id's and Fields
        Label enterT;
        TextField enterField;
        TextArea textarea;
        Button sendBtn;
        
    //Lable socket, stream connections    
        Socket s1;
        InputStream is;
        InputStreamReader isr;
        BufferedReader br;       
        PrintStream pout;
        
    //Other variables
        String str = null;
        
//-------------------MAIN AND START METHODS-------------------------
    public static void main(String[] args) {
        launch(args);
    }//end main
         
    @Override
    public void start(Stage primaryStage) {

//---------------------GUI SETUP------------------------------
    //format top part of BorderPane - object p1 is hbox, put object title in
        Text title = new Text("CHAT CLIENT");
        title.setStyle("-fx-font-size: 25px;");
        HBox hb1 = new HBox();
        hb1.setAlignment(Pos.BOTTOM_CENTER);
        hb1.getChildren().add(title);
        hb1.setStyle("-fx-background-color: #a3e4d7;");

    //format middle part of BorderPane with VBox to hold TextArea
        textarea = new TextArea();
        textarea.setWrapText(true);
        textarea.setEditable(false);
        //textarea.appendText("this is appended text");
        
        VBox vbox = new VBox();
        vbox.getChildren().add(textarea);
        vbox.setAlignment(Pos.CENTER);
        
    //Format bottom part of BorderPane to hold TextField and send button
        //enterField.setColumns(60);
        enterT = new Label("Enter Text");
        enterField = new TextField();
        sendBtn = new Button("Send");
        HBox hb2 = new HBox(8);
        //hb2.setAlignment(Pos.CENTER);
        hb2.getChildren().addAll(enterT, enterField, sendBtn);
        hb2.setPadding(new Insets(10,10,0,10));
        
    //add functionality
        sendBtn.setOnAction(this);
        
    //Define BorderPane root, place children p1, grid, p3 into panels
        BorderPane root = new BorderPane();
        root.setTop(hb1);
        root.setCenter(vbox);
        root.setBottom(hb2);
        root.setStyle("-fx-padding: 10;" +
                  "-fx-border-style: solid inside;" +
                  "-fx-border-width: 2;" +
                  "-fx-border-insets: 10;" +
                  "-fx-border-radius: 5;" +
                  "-fx-border-color: #222222;");
        
    //Place root onto scene
        Scene scene = new Scene(root, 550, 450);

    //Put scene onto stage, display
        primaryStage.setTitle("Chat Client");
        primaryStage.setScene(scene);
        primaryStage.show();
        
   
//------------------SOCKET AND STREAM SETUP-----------------

        try {    
            //output pipe
            s1   = new Socket("localhost",8000);
            pout = new PrintStream(s1.getOutputStream());
            is = s1.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            Thread t1 = new Thread(this);
            t1.start();
            
        } catch (IOException ex) {
                System.out.println(ex);
        }
    }//close start
    
//---------------Run Method for Thread for listening----------
     @Override
    public void run(){
        while(true){
            try {
                
                str = br.readLine();
            } catch (IOException ex) {
                System.out.println(ex);
            }
            textarea.appendText( "You: "+str + "\n");
        }
    }
//---------------------ACTION EVENTS---------------------
    @Override
    public void handle(ActionEvent event){
        
        if (event.getSource()==sendBtn){
            String data = enterField.getText();
            textarea.appendText( "Me: "+ data + "\n"); 
            enterField.clear();
            pout.println(data);
        }
        
    }//end handle
}//end class
