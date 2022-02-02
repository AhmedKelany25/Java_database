





/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
//package labten;


import java.util.Vector;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import labten.ContactPerson;
import labten.testCon;

/**
 *
 * @author labshop
 */
public class Labten extends Application {
    Vector<ContactPerson> MyContactPersonVector;
    

    
public static int counter = 0;
    Label id;
    Label firstName;
    Label middleName;
    Label address;
    Label email;
    Label phone;
    TextField idTextField;
    TextField firstNameTextField;
    TextField addressField;
    TextField emailTextField;
    TextField phoneTextField;
    Button newButton;
    Button update;
    Button delete;
    Button first;
    Button prev;
    Button next;
    Button last;
    
    
    @Override
    public void init() throws Exception {
       id= new Label("ID");
       firstName= new Label("first name");
       address= new Label("Address");
       email= new Label("email");
       phone= new Label("phone");
       
   idTextField=new TextField("");
   idTextField.setEditable(false);
   firstNameTextField=new TextField("");
    addressField=new TextField("");
    emailTextField=new TextField("");
    phoneTextField=new TextField("");
    
   newButton = new Button("new");
   update = new Button("Update");
   delete = new Button("Delete");
   first = new Button("First");
   prev = new Button("Previous");
   next = new Button("next");
   last = new Button("Last");
       
        
    }
    
    

    @Override
    public void start(Stage primaryStage) throws Exception {
         testCon.connect();
        MyContactPersonVector = testCon.get_all();
       GridPane grid = new GridPane();
       
grid.setAlignment(Pos.CENTER);
grid.setHgap(10);
grid.setVgap(10);
grid.setPadding(new Insets(25, 25, 25, 25));

grid.add(new Text("person Info"),0,0,2,1);
grid.add(id, 0, 1);
grid.add(idTextField, 1, 1);

grid.add(firstName, 0, 2);
grid.add(firstNameTextField, 1, 2);



grid.add(address, 0, 4);
grid.add(addressField, 1, 4);


grid.add(email, 0, 5);
grid.add(emailTextField, 1, 5);


grid.add(phone, 0, 6);
grid.add(phoneTextField, 1, 6);
Labten that = this;
/*---------------------methods--------------------*/        
                first.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                counter = 0;
                that.refresh();
        }});
   /**------------------------*/
//   prev
           
           
           next.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
            if(counter < MyContactPersonVector.size()-1){
                counter++;
                that.refresh();
            }}});
        

        prev.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
            if(counter > 0){
                counter--;
                that.refresh();
            }}});

        last.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                counter = MyContactPersonVector.size()-1;
                that.refresh();
            }});
/*------------------------------------------------------*/
FlowPane flowPane = new FlowPane();
flowPane.setVgap(10);
flowPane.getChildren().addAll(newButton, update,delete,first,prev,next);
grid.add(flowPane, 0, 7);

        Scene scene = new Scene(grid,500,500);
         
        primaryStage.setTitle("lab10 Advanced");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
//public static testCon n = new testCon();
 // public static String nam = n.copyon.get(0).getName();
    public void refresh(){
    if(MyContactPersonVector.size()==counter){
    counter--;
    this.refresh();
    }
    idTextField.setText(String.valueOf(MyContactPersonVector.get(counter).getId()));
    firstNameTextField.setText(MyContactPersonVector.get(counter).getName());
    phoneTextField.setText(MyContactPersonVector.get(counter).getHome_phone());
    emailTextField.setText(MyContactPersonVector.get(counter).getemail());
    addressField.setText(MyContactPersonVector.get(counter).getaddress());
}
public static void main (String[] args)
{

Application.launch(args);
//System.out.println();


//System.out.println(n.copyon.getName());

}

}

























/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
//package labten;
//
////package contact;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Vector;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Orientation;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextArea;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.FlowPane;
//import javafx.scene.layout.StackPane;
//import javafx.stage.FileChooser;
//import javafx.stage.Stage;
//
///**
// *
// * @author labshop
// */
//
//public class Labten extends Application {
//public static int counter = 0;
//TextField ID;
//TextField Name;
//TextField Phone;
//Vector<ContactPerson> MyContactPersonVector;
//    
//    @Override
//    public void start(Stage primaryStage) throws SQLException, ClassNotFoundException {
//        testCon.connect();
//        MyContactPersonVector = testCon.get_all();
//        Label for_ID = new Label("ID: ");
//        ID = new TextField();
//        FlowPane ID_pane = new FlowPane();
//        ID_pane.getChildren().addAll(for_ID, ID);
//        ID.setEditable(false);
////---------------------------------------------------------
//        Label for_name = new Label("Name: ");
//        Name = new TextField();
//        FlowPane Name_pane = new FlowPane();
//        Name_pane.getChildren().addAll(for_name, Name);
////---------------------------------------------------------
//        Label for_Phone = new Label("Phone: ");
//        Phone  = new TextField();
//        
//        FlowPane Phone_pane = new FlowPane();
//        Phone_pane.getChildren().addAll(for_Phone,Phone);
////------------------------------------------------------
//        ID.setText(String.valueOf(MyContactPersonVector.get(counter).getId()));
//        Name.setText(MyContactPersonVector.get(counter).getName());
//        Phone.setText(MyContactPersonVector.get(counter).getHome_phone());
////------------------------Buttons-----------------------
//        Labten that = this;
////------------------------ First
//        Button First = new Button("First");
//        First.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event){
//                counter = 0;
//                that.refresh();
//        }});
////------------------------ Next
//        Button Next = new Button("Next");
//        Next.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event){
//            if(counter < MyContactPersonVector.size()-1){
//                counter++;
//                that.refresh();
//            }}});
//        
//               
//        Button Prev = new Button("Prev");
//        Prev.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event){
//            if(counter > 0){
//                counter--;
//                that.refresh();
//            }}});
//        Button Last = new Button("Last");
//        Last.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event){
//                counter = MyContactPersonVector.size()-1;
//                that.refresh();
//            }});
////---------------------------New
//        Button New = new Button("New");
//        New.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>(){
//        @Override
//        public void handle(ActionEvent event){
//        
//        try{
//            testCon.connect();
//            ContactPerson inserted = new ContactPerson(MyContactPersonVector.size(), Name.getText(), Phone.getText());
//            testCon.Insert(inserted);
//            MyContactPersonVector = testCon.get_all();
//            that.refresh();
//            testCon.exit();
//        }catch(SQLException e){} catch (ClassNotFoundException ex) {
//                Logger.getLogger(Labten.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }});
//
//
////---------------------------Update
//       Button Update = new Button("Update");
//
//
////---------------------------Delete
//        Button Delete = new Button("Delete");
//
//            FlowPane Buttons = new FlowPane(New, Update, Delete, First, Next, Prev, Last);
////---------------------------------------------------------
//        testCon.exit();
//        FlowPane root = new FlowPane();
//        root.setOrientation(Orientation.VERTICAL);
//
//        root.getChildren().addAll(ID_pane,Name_pane,Phone_pane, Buttons);
//        root.setVgap(10);
//        Scene scene = new Scene(root, 300, 250);
//        primaryStage.setTitle("Hello World!");
//        primaryStage.setScene(scene);
//        primaryStage.show();
//    }
//
//public void refresh(){
//    if(MyContactPersonVector.size()==counter){
//    counter--;
//    this.refresh();
//    }
//    ID.setText(String.valueOf(MyContactPersonVector.get(counter).getId()));
//    Name.setText(MyContactPersonVector.get(counter).getName());
//    Phone.setText(MyContactPersonVector.get(counter).getHome_phone());
//}
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String[] args) {
//        launch(args);
//    }
//    
//}
