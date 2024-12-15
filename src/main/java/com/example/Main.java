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
    private UserDao userDao;
    private eventDao eventDao;
    private salleDao salleDao;
    private terrainDao terrainDao;
    private reservationDao reservationDao;

    @Override
    public void start(Stage primaryStage) {
        conn = db.getInstance();
        userDao = new UserImpl(conn);
        eventDao = new eventImpl(conn);
        salleDao = new salleDaoImpl(conn);
        terrainDao = new terrainDaoImpl(conn);
        reservationDao = new reservationDaoImpl(conn);

        // Labels and Fields for User
        Label idLabel = new Label("ID:");
        TextField idField = new TextField();

        Label nomLabel = new Label("Nom:");
        TextField nomField = new TextField();

        Label prenomLabel = new Label("Prenom:");
        TextField prenomField = new TextField();

        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();

        Label typeLabel = new Label("Type (ETUDIANT/PROFESSEUR):");
        ComboBox<String> typeComboBox = new ComboBox<>();
        typeComboBox.getItems().addAll("ETUDIANT", "PROFESSEUR");

        Button addUserButton = new Button("Add User");
        Button viewUsersButton = new Button("View All Users");

        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);

        // GridPane Layout for User
        GridPane userGrid = new GridPane();
        userGrid.setPadding(new Insets(10));
        userGrid.setVgap(5);
        userGrid.setHgap(10);

        userGrid.add(idLabel, 0, 0);
        userGrid.add(idField, 1, 0);

        userGrid.add(nomLabel, 0, 1);
        userGrid.add(nomField, 1, 1);

        userGrid.add(prenomLabel, 0, 2);
        userGrid.add(prenomField, 1, 2);

        userGrid.add(emailLabel, 0, 3);
        userGrid.add(emailField, 1, 3);

        userGrid.add(typeLabel, 0, 4);
        userGrid.add(typeComboBox, 1, 4);

        userGrid.add(addUserButton, 0, 5);
        userGrid.add(viewUsersButton, 1, 5);

        userGrid.add(resultArea, 0, 6, 2, 1);

        // Labels and Fields for Event
        Label eventIdLabel = new Label("Event ID:");
        TextField eventIdField = new TextField();

        Label eventNameLabel = new Label("Event Name:");
        TextField eventNameField = new TextField();

        Label eventDateLabel = new Label("Event Date (YYYY-MM-DD):");
        TextField eventDateField = new TextField();
        Label descriptionLabel = new Label("Description :");
        TextField descriptionField = new TextField();
        Label user_idLabel = new Label("user id:");
        TextField user_idField = new TextField();
        Button addEventButton = new Button("Add Event");
        Button viewEventsButton = new Button("View All Events");

        TextArea eventResultArea = new TextArea();
        eventResultArea.setEditable(false);

        // GridPane Layout for Event
        GridPane eventGrid = new GridPane();
        eventGrid.setPadding(new Insets(10));
        eventGrid.setVgap(5);
        eventGrid.setHgap(10);

        eventGrid.add(eventIdLabel, 0, 0);
        eventGrid.add(eventIdField, 1, 0);

        eventGrid.add(eventNameLabel, 0, 1);
        eventGrid.add(eventNameField, 1, 1);

        eventGrid.add(eventDateLabel, 0, 2);
        eventGrid.add(eventDateField, 1, 2);

        eventGrid.add(descriptionLabel, 0, 3);
        eventGrid.add(descriptionField, 1, 3);

        eventGrid.add(user_idLabel, 0, 4);
        eventGrid.add(user_idField, 1, 4);

        eventGrid.add(addEventButton, 0, 5);
        eventGrid.add(viewEventsButton, 1, 5);

        eventGrid.add(eventResultArea, 0, 6, 2, 1);

        // Labels and Fields for salle
        Label salleIdLabel = new Label("salle ID:");
        TextField salleIdField = new TextField();

        Label salleNameLabel = new Label("salle Name:");
        TextField salleNameField = new TextField();

        Label salleCapaciteLabel = new Label("capacite:");
        TextField salleCapaciteField = new TextField();

        Button addSalleButton = new Button("Add salle");
        Button viewSalleButton = new Button("View All salles");

        TextArea salleResultArea = new TextArea();
        salleResultArea.setEditable(false);

         // Labels and Fields for terrain
         Label TerrainIdLabel = new Label("Terrain ID:");
         TextField TerrainIdField = new TextField();
 
         Label TerrainNameLabel = new Label("Terrain Name:");
         TextField TerrainNameField = new TextField();
 
         Label TerrainTypeLabel = new Label("type:");
         TextField TerrainTypeField = new TextField();
 
         Button addTerrainButton = new Button("Add Terrain");
         Button viewTerrainButton = new Button("View All Terrains");
 
         TextArea TerrainResultArea = new TextArea();
         TerrainResultArea.setEditable(false);

          // Labels and Fields for full reseravtion
          Label ReservationIdLabel = new Label("Reservation ID:");
          TextField ReservationIdField = new TextField();
  
          Label ReservationIdUserLabel = new Label("Reservation ID user:");
          TextField ReservationIdUserField = new TextField();
          Label ReservationIdEventLabel = new Label("Reservation ID event:");
          TextField ReservationIdEventField = new TextField();
          Label ReservationIdSalleLabel = new Label("Reservation ID salle:");
          TextField ReservationIdSalleField = new TextField();
          Label ReservationIdTerrainLabel = new Label("Reservation ID terrain:");
          TextField ReservationIdTerrainField = new TextField();
          Label ReservationDateLabel = new Label("Reservation Date:");
          TextField ReservationDateField = new TextField();
          Button addReservationButton = new Button("Add Reservation");
          Button viewReservationButton = new Button("View All Reservations");
  
          TextArea ReservationResultArea = new TextArea();
          ReservationResultArea.setEditable(false);
 

        // GridPane Layout for salles
        GridPane salleGrid = new GridPane();
        salleGrid.setPadding(new Insets(4));
        salleGrid.setVgap(5);
        salleGrid.setHgap(10);

        salleGrid.add(salleIdLabel, 0, 0);
        salleGrid.add(salleIdField, 1, 0);

        salleGrid.add(salleNameLabel, 0, 1);
        salleGrid.add(salleNameField, 1, 1);

        salleGrid.add(salleCapaciteLabel, 0, 2);
        salleGrid.add(salleCapaciteField, 1, 2);

        salleGrid.add(addSalleButton, 0, 3);
        salleGrid.add(viewSalleButton, 1, 3);

        salleGrid.add(salleResultArea, 0, 4, 2, 1);
 // GridPane Layout for terrains
 GridPane terrainGrid = new GridPane();
 terrainGrid.setPadding(new Insets(5));
 terrainGrid.setVgap(5);
 terrainGrid.setHgap(5);

 terrainGrid.add(TerrainIdLabel, 0, 0);
 terrainGrid.add(TerrainIdField, 1, 0);

 terrainGrid.add(TerrainNameLabel, 0, 1);
 terrainGrid.add(TerrainNameField, 1, 1);

 terrainGrid.add(TerrainTypeLabel, 0, 2);
 terrainGrid.add(TerrainTypeField, 1, 2);

 terrainGrid.add(addTerrainButton, 0, 3);
 terrainGrid.add(viewTerrainButton, 1, 3);

 terrainGrid.add(TerrainResultArea, 0, 4, 2, 1);
 
       // GridPane Layout for reservation
GridPane reservationGrid = new GridPane();
reservationGrid.setPadding(new Insets(5));
reservationGrid.setVgap(5);
reservationGrid.setHgap(5);

// Placing components in a logical order without overlaps
reservationGrid.add(ReservationIdLabel, 0, 0);
reservationGrid.add(ReservationIdField, 1, 0);

reservationGrid.add(ReservationIdUserLabel, 0, 1);
reservationGrid.add(ReservationIdUserField, 1, 1);

reservationGrid.add(ReservationIdSalleLabel, 0, 2);
reservationGrid.add(ReservationIdSalleField, 1, 2);

reservationGrid.add(ReservationIdEventLabel, 0, 3);
reservationGrid.add(ReservationIdEventField, 1, 3);

reservationGrid.add(ReservationIdTerrainLabel, 0, 4);
reservationGrid.add(ReservationIdTerrainField, 1, 4);

reservationGrid.add(ReservationDateLabel, 0, 5);
reservationGrid.add(ReservationDateField, 1, 5);

reservationGrid.add(addReservationButton, 0, 6);
reservationGrid.add(viewReservationButton, 1, 6);

// Spanning the result area across two columns
reservationGrid.add(ReservationResultArea, 0, 7, 2, 1);
        // VBox Root Layout
        VBox root = new VBox(20, userGrid, eventGrid, salleGrid, terrainGrid, reservationGrid);
        root.setPadding(new Insets(5));

        // Add User Button Action
        addUserButton.setOnAction(event -> {
            try {
                int id = Integer.parseInt(idField.getText());
                String nom = nomField.getText();
                String prenom = prenomField.getText();
                String email = emailField.getText();
                String type = typeComboBox.getValue();

                if (type == null || (!type.equals("ETUDIANT") && !type.equals("PROFESSEUR"))) {
                    resultArea.setText("Invalid user type. Please select 'ETUDIANT' or 'PROFESSEUR'.");
                    return;
                }

                User newUser = new User(id, nom, prenom, email, type);
                userDao.addUser(newUser);

                resultArea.setText("User added: " + newUser);
                idField.clear();
                nomField.clear();
                prenomField.clear();
                emailField.clear();
                typeComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                resultArea.setText("Error: " + e.getMessage());
            }
        });

        // View All Users Button Action
        viewUsersButton.setOnAction(event -> {
            List<User> users = userDao.getAllUsers();
            StringBuilder result = new StringBuilder("List of Users:\n");
            for (User user : users) {
                result.append(user).append("\n");
            }
            resultArea.setText(result.toString());
        });

        // Add Event Button Action
        addEventButton.setOnAction(event -> {
            try {
                int eventId = Integer.parseInt(eventIdField.getText());
                String eventName = eventNameField.getText();
                String eventDate = eventDateField.getText();
                String description = descriptionField.getText();
                int User_id = Integer.parseInt(user_idField.getText());

                event newEvent = new event(eventId, eventName, eventDate, description, User_id);
                eventDao.addEvent(newEvent);

                eventResultArea.setText("Event added: " + newEvent);
                eventIdField.clear();
                eventNameField.clear();
                eventDateField.clear();
            } catch (Exception e) {
                eventResultArea.setText("Error: " + e.getMessage());
            }
        });

        // View All Events Button Action
        viewEventsButton.setOnAction(event -> {
            List<event> events = eventDao.getAllEvents();
            StringBuilder result = new StringBuilder("List of Events:\n");
            for (event eventItem : events) {
                result.append(eventItem).append("\n");
            }
            eventResultArea.setText(result.toString());
        });

        // Add salle Button Action
        addSalleButton.setOnAction(e -> {
            try {
                int id = Integer.parseInt(salleIdField.getText());
                String nomSalle = salleNameField.getText();
                int capacite = Integer.parseInt(salleCapaciteField.getText());
                salle salle = new salle(id, nomSalle, capacite);
                salleDao.addSalle(salle);
                salleResultArea.setText("Salle added: " + salle);
                salleIdField.clear();
                salleNameField.clear();
                salleCapaciteField.clear();
            } catch (Exception ee) {
                salleResultArea.setText("Error: " + ee.getMessage());
            }
        });

        // View All salles Button Action
        viewSalleButton.setOnAction(event -> {
            List<salle> salles = salleDao.getAllSalles();
            StringBuilder result = new StringBuilder("List of salles:\n");
            for (salle salleItem : salles) {
                result.append(salleItem).append("\n");
            }
            salleResultArea.setText(result.toString());
        });
        addTerrainButton.setOnAction(e->{
            try {
                int id = Integer.parseInt(TerrainIdField.getText());
                String nomTerrain = TerrainNameField.getText();
               String type = TerrainTypeField.getText();
              terrain terrain= new terrain(id, nomTerrain, type);
                terrainDao.addTerrain(terrain);
                TerrainResultArea.setText("terrain added: " + terrain);
                TerrainIdField.clear();
                TerrainNameField.clear();
                TerrainTypeField.clear();
            } catch (Exception ee) {
                TerrainResultArea.setText("Error: " + ee.getMessage());
            }
        });
        viewTerrainButton.setOnAction(event -> {
            List<terrain> Terrains = terrainDao.getAllTerrains();
            StringBuilder result = new StringBuilder("List of Terrains:\n");
            for (terrain TerrainItem : Terrains) {
                result.append(TerrainItem).append("\n");
            }
            TerrainResultArea.setText(result.toString());
        });

        addReservationButton.setOnAction(event -> {
            try {
                int id = Integer.parseInt(ReservationIdField.getText());
                int id_user = Integer.parseInt(ReservationIdUserField.getText());
                int id_event = Integer.parseInt(ReservationIdEventField.getText());
                int id_salle = Integer.parseInt(ReservationIdSalleField.getText());
                int id_terrain = Integer.parseInt(ReservationIdTerrainField.getText());
                String date_reservation= ReservationDateField.getText();
              

                reservation newReservation = new reservation(id, id_user, id_event, id_salle, id_terrain, date_reservation);
                reservationDao.addReservation(newReservation);

                ReservationResultArea.setText("Reservation added: " + newReservation);
                ReservationIdField.clear();
                ReservationIdEventField.clear();
                ReservationIdSalleField.clear();
                ReservationIdTerrainField.clear();
                ReservationIdUserField.clear();
                ReservationDateField.clear();
                typeComboBox.getSelectionModel().clearSelection();
            } catch (Exception e) {
                ReservationResultArea.setText("Error: " + e.getMessage());
            }
        });
        viewReservationButton.setOnAction(event -> {
            List<reservation> reservations = reservationDao.getAllReservations();
            StringBuilder result = new StringBuilder("List of reservations:\n");
            for (reservation reservationItem : reservations) {
                result.append(reservationItem).append("\n");
            }
            ReservationResultArea.setText(result.toString());
        });
        
       /* ScrollPane terrainScrollPane = new ScrollPane(terrainGrid);
        terrainScrollPane.setFitToWidth(true);
        terrainScrollPane.setFitToHeight(true); */
        
     
        
        TitledPane userPane = new TitledPane("User", userGrid);
        TitledPane eventPane = new TitledPane("Event", eventGrid);
        TitledPane sallePane = new TitledPane("Salle", salleGrid);
        TitledPane terrainPane = new TitledPane("Terrain", terrainGrid);
        TitledPane reservationPane = new TitledPane("Reservation" , reservationGrid);
        
        Accordion accordion = new Accordion(userPane, eventPane, sallePane, terrainPane, reservationPane);
        
        Scene scene = new Scene(accordion, 800, 600);
        primaryStage.setScene(scene);
        
                primaryStage.setWidth(800); 
                primaryStage.setHeight(900);
                primaryStage.setResizable(false);
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
