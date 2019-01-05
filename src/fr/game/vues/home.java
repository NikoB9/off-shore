package fr.game.vues;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class home extends Application {

    Stage window;
    Scene scene1, scene2, scene3, scene4;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        //UTILISATEUR

        window.setTitle("Home : Utilisateur 1");

        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        root.setCenter(grid);


        //Name label
        Label name1Label = new Label("Username");
        GridPane.setConstraints(name1Label , 0, 0);

        //Name input
        TextField name1Input = new TextField("");
        GridPane.setConstraints(name1Input,1,0);

        //Pays label
        Label pays1Field = new Label("Pays : ");
        GridPane.setConstraints(pays1Field , 0, 1);

        //ComboBox
        javafx.scene.control.ComboBox<String> pays1 = new javafx.scene.control.ComboBox<>();

        //GetItems return the ObservableList object which you can add items to
        pays1.getItems().addAll("France", "Californie", "Portugal", "Grande Bretagne", "Espagne");

        //Set a default value
        pays1.setValue("France");

        //Add "TextField"
        pays1.setEditable(true);

        GridPane.setConstraints(pays1,1,1);


        Button btnUser2 = new Button("Utilisateur 2");
        GridPane.setConstraints(btnUser2,0,2);

        /*Button user2 = new Button("User 2");
        GridPane.setConstraints(loginButton,3,0);*/

        btnUser2.setOnAction(e -> {

            window.setTitle("Home : Utilisateur 2");

            /*if(nameInput.getText().trim().equals("nico") && passwordField.getText().trim().equals("nico")){
                AlertBox.display("Bienvenue", "Welcome");
            }
            else if (nameInput.getText().trim().equals("nico")){
                AlertBox.display("Erreur", "Mot de passe incorrect");
            }
            else if(passwordField.getText().trim().equals("nico")){
                AlertBox.display("Erreur", "Login incorrect");
            }
            else{
                AlertBox.display("Erreur", "Login et mot de passe incorrect");
            }*/

            window.setScene(scene2);

        });

        String style = "-fx-background-color: rgba(100, 100, 140, 0.5 );";
        grid.setStyle(style);

        grid.getChildren().addAll(name1Label, name1Input, pays1,pays1Field, btnUser2);
        //layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(root , 300,150);



        //UTILISATEUR/SCENE 2






        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10,10,10,10));
        grid2.setVgap(8);
        grid2.setHgap(10);

        //Name label
        Label name2Label = new Label("Username : ");
        GridPane.setConstraints(name2Label , 0, 0);

        //Name input
        TextField name2Input = new TextField("");
        GridPane.setConstraints(name2Input,1,0);

        //Pays label
        Label pays2Field = new Label("Pays : ");
        GridPane.setConstraints(pays2Field , 0, 1);

        //ComboBox
        javafx.scene.control.ComboBox<String> pays2 = new javafx.scene.control.ComboBox<>();

        //GetItems return the ObservableList object which you can add items to
        pays2.getItems().addAll("France", "Californie", "Portugal", "Grande Bretagne", "Espagne");

        //Set a default value
        pays2.setValue("France");

        //Add "TextField"
        pays2.setEditable(true);

        GridPane.setConstraints(pays2,1,1);


        Button btnUser3 = new Button("Utilisateur 3");
        GridPane.setConstraints(btnUser3,0,2);

        /*Button user2 = new Button("User 2");
        GridPane.setConstraints(loginButton,3,0);*/

        btnUser3.setOnAction(e -> {

            /*if(nameInput.getText().trim().equals("nico") && passwordField.getText().trim().equals("nico")){
                AlertBox.display("Bienvenue", "Welcome");
            }
            else if (nameInput.getText().trim().equals("nico")){
                AlertBox.display("Erreur", "Mot de passe incorrect");
            }
            else if(passwordField.getText().trim().equals("nico")){
                AlertBox.display("Erreur", "Login incorrect");
            }
            else{
                AlertBox.display("Erreur", "Login et mot de passe incorrect");
            }*/

            window.setScene(scene3);
            window.setTitle("Home : Utilisateur 3");

        });


        grid2.getChildren().addAll(name2Label, name2Input, pays2,pays2Field, btnUser3);
        //layout1.getChildren().addAll(label1, button1);

        scene2 = new Scene(grid2, 300,150);









        //UTILISATEUR/SCENE 3






        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(10,10,10,10));
        grid3.setVgap(8);
        grid3.setHgap(10);

        //Name label
        Label name3Label = new Label("Username : ");
        GridPane.setConstraints(name3Label , 0, 0);

        //Name input
        TextField name3Input = new TextField("");
        GridPane.setConstraints(name3Input,1,0);

        //Pays label
        Label pays3Field = new Label("Pays : ");
        GridPane.setConstraints(pays3Field , 0, 1);

        //ComboBox
        javafx.scene.control.ComboBox<String> pays3 = new javafx.scene.control.ComboBox<>();

        //GetItems return the ObservableList object which you can add items to
        pays3.getItems().addAll("France", "Californie", "Portugal", "Grande Bretagne", "Espagne");

        //Set a default value
        pays3.setValue("France");

        //Add "TextField"
        pays3.setEditable(true);

        GridPane.setConstraints(pays3,1,1);


        Button btnUser4 = new Button("Utilisateur 4");
        GridPane.setConstraints(btnUser4,0,2);

        /*Button user2 = new Button("User 2");
        GridPane.setConstraints(loginButton,3,0);*/

        btnUser3.setOnAction(e -> {

            /*if(nameInput.getText().trim().equals("nico") && passwordField.getText().trim().equals("nico")){
                AlertBox.display("Bienvenue", "Welcome");
            }
            else if (nameInput.getText().trim().equals("nico")){
                AlertBox.display("Erreur", "Mot de passe incorrect");
            }
            else if(passwordField.getText().trim().equals("nico")){
                AlertBox.display("Erreur", "Login incorrect");
            }
            else{
                AlertBox.display("Erreur", "Login et mot de passe incorrect");
            }*/

            window.setScene(scene4);
            window.setTitle("Home : Utilisateur 4");

        });

        grid3.getChildren().addAll(name3Label, name3Input, pays3,pays3Field, btnUser4);
        //layout1.getChildren().addAll(label1, button1);

        scene3 = new Scene(grid3, 300,150);







        //UTILISATEUR/SCENE 4






        GridPane grid4 = new GridPane();
        grid4.setPadding(new Insets(10,10,10,10));
        grid4.setVgap(8);
        grid4.setHgap(10);

        //Name label
        Label name4Label = new Label("Username : ");
        GridPane.setConstraints(name4Label , 0, 0);

        //Name input
        TextField name4Input = new TextField("");
        GridPane.setConstraints(name4Input,1,0);

        //Pays label
        Label pays4Field = new Label("Pays : ");
        GridPane.setConstraints(pays4Field , 0, 1);

        //ComboBox
        javafx.scene.control.ComboBox<String> pays4 = new javafx.scene.control.ComboBox<>();

        //GetItems return the ObservableList object which you can add items to
        pays4.getItems().addAll("France", "Californie", "Portugal", "Grande Bretagne", "Espagne");

        //Set a default value
        pays4.setValue("France");

        //Add "TextField"
        pays4.setEditable(true);

        GridPane.setConstraints(pays4,1,1);


        Button btnJouer = new Button("JOUER");
        GridPane.setConstraints(btnUser4,0,2);

        /*Button user2 = new Button("User 2");
        GridPane.setConstraints(loginButton,3,0);*/

        btnJouer.setOnAction(e -> {

            /*if(nameInput.getText().trim().equals("nico") && passwordField.getText().trim().equals("nico")){
                AlertBox.display("Bienvenue", "Welcome");
            }
            else if (nameInput.getText().trim().equals("nico")){
                AlertBox.display("Erreur", "Mot de passe incorrect");
            }
            else if(passwordField.getText().trim().equals("nico")){
                AlertBox.display("Erreur", "Login incorrect");
            }
            else{
                AlertBox.display("Erreur", "Login et mot de passe incorrect");
            }*/


        });

        grid4.getChildren().addAll(name4Label, name4Input, pays4,pays4Field, btnJouer);
        //layout1.getChildren().addAll(label1, button1);

        scene4 = new Scene(grid4, 300,150);

        window.setScene(scene1);
        window.show();
    }

}
