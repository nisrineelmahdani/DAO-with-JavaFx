
package com.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {
    private db conn;
    private studentDao userDao;
    private eventDao eventDao;

    @Override
    public void start(Stage primaryStage) {
      
        conn = db.getInstance();
        userDao = new studentImpl(conn);

     
        Label idLabel = new Label("ID:");
        TextField idField = new TextField();

        Label nomLabel = new Label("Nom:");
        TextField nomField = new TextField();

        Label prenomLabel = new Label("Prenom:");
        TextField prenomField = new TextField();

        Button addButton = new Button("Add Student");
        Button viewButton = new Button("View All Students");

        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);

        Label idEvent = new Label("ID Event:");
        TextField idEvField = new TextField();

        Label nomEvent = new Label("Nom Event:");
        TextField nomEvField = new TextField();

        Label DateEvent = new Label("Date Event:");
        TextField DateEvField = new TextField();
        
        Label DescriptionEvent = new Label("Description Event:");
        TextField DesciptionEvFiled = new TextField();

        Button addButtonEvent = new Button("Add Event");
        Button viewButtonEvent = new Button("View All events");

        TextArea resultAreaEvent = new TextArea();
        resultArea.setEditable(false);


        
        GridPane grid = new GridPane();
        VBox root = new VBox();
        grid.setPadding(new Insets(10));
       

        grid.add(idLabel, 0, 0);
        grid.add(idField, 1, 0);

        grid.add(nomLabel, 0, 1);
        grid.add(nomField, 1, 1);

        grid.add(prenomLabel, 0, 2);
        grid.add(prenomField, 1, 2);

        grid.add(addButton, 0, 3);
        grid.add(viewButton, 1, 3);

        grid.add(resultArea, 0, 4, 2, 1);
        root.getChildren().addAll(grid,idEvent, idEvField, nomEvent,nomEvField,DateEvent, DateEvField,DescriptionEvent, DesciptionEvFiled, resultAreaEvent, addButtonEvent, viewButtonEvent);
      

      
        addButton.setOnAction(event -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String nom = nomField.getText();
                String prenom = prenomField.getText();

                student newStudent = new student(id, nom, prenom);
                userDao.addUser(newStudent);

                resultArea.setText("Student added: " + newStudent);
                idField.clear();
                nomField.clear();
                prenomField.clear();
            } catch (Exception e) {
                resultArea.setText("Error: " + e.getMessage());
            }
        });
        addButtonEvent.setOnAction(event->{
            try {
                int id =  Integer.parseInt(idEvField.getText()) ;
                String nom = nomEvField.getText();
                String date = DateEvField.getText();
                String description = DesciptionEvFiled.getText();
               event newEvent= new event(id, nom, date, description);
                eventDao.addEvent(newEvent);
            } catch (Exception e) {
              e.printStackTrace();
            }
        
        });
        viewButtonEvent.setOnAction(event->{
            try {
                List<event> events = eventDao.getAllEvents();
                StringBuilder result = new StringBuilder("list of events:");
                for (event event2 : events) {
                    result.append(event2).append("\n");
    
                }
                resultAreaEvent.setText(result.toString());
            } catch (Exception e) {
              e.printStackTrace();
            }
          
        });

        
        viewButton.setOnAction(event -> {
            List<student> students = userDao.getAllUsers();
            StringBuilder result = new StringBuilder("List of Students:");
            for (student s : students) {
                result.append(s).append("\n");
            }
            resultArea.setText(result.toString());
        });

   
        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("Student Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() throws Exception {
      
        if (conn != null) {
            conn.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}


/*package com.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        db conn = db.getInstance();
       

        studentDao userDao = new studentImpl(conn);

        //student student = new student(4, "yanis", "Elmahdani");
       // userDao.addUser(student);

        student student2 = userDao.getUserById(1);
        System.out.println("User : " + student2.getNom() + " " + student2.getPrenom());

        List<student> listUsers = userDao.getAllUsers();
        System.out.println("List of users:");
        for (student user : listUsers) {
            System.out.println(user);
        }

        conn.close();
    }
}*/
