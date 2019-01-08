package fr.game.vues;

import fr.game.entites.Enqeteur;
import fr.game.entites.Pays;
import fr.game.model.Model;
import fr.game.techniques.AlertBox;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Map;

public class home extends Application {

    Stage window;
    Scene scene1, scene2, scene3, scene4;
    boolean user1valid, user2valid, user3valid, user4valid = false;



    ArrayList<String> paysUsed = new ArrayList<String>();

    GridPane grid = new GridPane();
    GridPane grid2 = new GridPane();
    GridPane grid3 = new GridPane();
    GridPane grid4 = new GridPane();

    String style = "-fx-background-color: rgba(100, 100, 140, 0.5 );";
    String styleRed = "-fx-background-color: rgba(205, 92, 92, 0.5 );";
    String styleGreen = "-fx-background-color: rgba(50, 205, 50, 0.5 );";


   /* public static void main(String[] args){
        launch(args);
    }*/

    @Override
    public void start(Stage primaryStage) throws Exception {

        new Model();

        grid.setStyle(style);
        grid2.setStyle(style);
        grid3.setStyle(style);
        grid4.setStyle(style);

        window = primaryStage;

        //UTILISATEUR

        window.setTitle("Home : Utilisateur 1");

        //BorderPane root = new BorderPane();
        //GridPane grid = new GridPane();

        grid.setPadding(new Insets(10,10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        //root.setCenter(grid);


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
        javafx.scene.control.ComboBox<String> pays1 = new javafx.scene.control.ComboBox<String>();

        //GetItems return the ObservableList object which you can add items to
        for (Map.Entry<Integer, Pays> entry : Model.getLesPays().entrySet()) {
            Integer key = entry.getKey();
            Pays pays = entry.getValue();
            pays1.getItems().add(pays.getNom());
        }



        //Set a default value
        //pays1.setValue("");

        //Add "TextField"
        //pays1.setEditable(true);

        GridPane.setConstraints(pays1,1,1);


        Button btnUser2 = new Button("Utilisateur 2");
        GridPane.setConstraints(btnUser2,1,3);

        /*Button user2 = new Button("User 2");
        GridPane.setConstraints(loginButton,3,0);*/

        //radiobouton pour bot
        //ChoiceBox
        //javafx.scene.control.ChoiceBox<String> BOT1 = new javafx.scene.control.ChoiceBox<>();
        javafx.scene.control.ComboBox<String> BOT1 = new javafx.scene.control.ComboBox<String>();

        //GetItems return the ObservableList object which you can add items to
        BOT1.getItems().addAll("Joueur", "Robot");

        //Set a default value
        BOT1.setValue("Joueur");
        GridPane.setConstraints(BOT1,0,3);

        btnUser2.setOnAction(e -> {


             try {
                 String choixPays = pays1.getSelectionModel().selectedItemProperty().getValue().trim();

                 //System.out.println(choixPays);


                 if(name1Input.getText().trim().equals("") || choixPays == ""){
                     user1valid = false;
                     grid.setStyle(styleRed);
                     AlertBox.display("Attention", "Veuillez remplir les champs");
                 }
                 else{

                     boolean bot = false;
                     if (BOT1.getValue() == "Robot"){
                         bot = true;
                     }


                     Model.addToListeJoueur(new Enqeteur("","", Model.getPay(Model.getIdPaysByname(pays1.getValue().trim())), bot, name1Input.getText().trim()));
                     paysUsed.add(pays1.getValue().trim());

                     //System.out.println(choixPays);
                     paysUsed.add(choixPays);

                     Model.addToListeJoueur(new Enqeteur("","", Model.getPay(Model.getIdPaysByname(choixPays)), bot, name1Input.getText().trim()));
                     user1valid = true;
                     window.setTitle("Home : Utilisateur 2");
                     grid.setStyle(styleGreen);
                     window.setScene(scene2);
                 }
             }catch (Exception ex){
                 user1valid = false;
                 grid.setStyle(styleRed);
                 AlertBox.display("Attention", "Veuillez choisir un Pays");
             }




        });

        grid.getChildren().addAll(name1Label, name1Input, pays1,pays1Field, BOT1, btnUser2);
        //layout1.getChildren().addAll(label1, button1);
        scene1 = new Scene(grid , 300,130);



        //UTILISATEUR/SCENE 2
        System.out.println(Model.getListeJoueur());



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
        javafx.scene.control.ComboBox<String> pays2 = new javafx.scene.control.ComboBox<String>();

        //GetItems return the ObservableList object which you can add items to
       // pays2.getItems().addAll("France", "Californie", "Portugal", "Grande Bretagne", "Espagne");
        for (Map.Entry<Integer, Pays> entry : Model.getLesPays().entrySet()) {
            Integer key = entry.getKey();
            Pays pays = entry.getValue();
            pays2.getItems().add(pays.getNom());
        }

        //pays2.setValue("");
        //Add "TextField"
        //pays2.setEditable(true);

        GridPane.setConstraints(pays2,1,1);


        Button btnUser3 = new Button("Utilisateur 3");
        GridPane.setConstraints(btnUser3,1,3);

        javafx.scene.control.ComboBox<String> BOT2 = new javafx.scene.control.ComboBox<String>();

        //GetItems return the ObservableList object which you can add items to
        BOT2.getItems().addAll("Joueur", "Robot");

        //Set a default value
        BOT2.setValue("Joueur");
        GridPane.setConstraints(BOT2,0,3);

        /*Button user2 = new Button("User 2");
        GridPane.setConstraints(loginButton,3,0);*/

        btnUser3.setOnAction(e -> {

            try {
                if(name2Input.getText().trim().equals("") || pays2.getValue().trim().equals("")){
                    user2valid = false;
                    grid2.setStyle(styleRed);
                    AlertBox.display("Attention", "Veuillez remplir les champs");
                }
                else{


                    if (!paysUsed.contains(pays2.getValue().trim())){
                        boolean bot = false;
                        if (BOT2.getValue() == "Robot"){
                            bot = true;
                        }


                        Model.addToListeJoueur(new Enqeteur("","", Model.getPay(Model.getIdPaysByname(pays2.getValue().trim())), bot, name2Input.getText().trim()));
                        paysUsed.add(pays2.getValue().trim());


                        user2valid = true;
                        grid2.setStyle(styleGreen);
                        window.setTitle("Home : Utilisateur 3");
                        window.setScene(scene3);
                    }

                    else {
                        user2valid = false;
                        grid2.setStyle(styleRed);
                        AlertBox.display("Erreur", "Un autre enquêteur se charge déjà de ce pays.");
                    }

                }
            }
            catch (Exception ex){
                user2valid = false;
                grid2.setStyle(styleRed);
                AlertBox.display("Attention", "Veuillez choisir un Pays");
            }


        });


        grid2.getChildren().addAll(name2Label, name2Input, pays2,pays2Field, BOT2, btnUser3);
        //layout1.getChildren().addAll(label1, button1);

        scene2 = new Scene(grid2, 300,130);









        //UTILISATEUR/SCENE 3






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
        javafx.scene.control.ComboBox<String> pays3 = new javafx.scene.control.ComboBox<String>();

        //GetItems return the ObservableList object which you can add items to
        for (Map.Entry<Integer, Pays> entry : Model.getLesPays().entrySet()) {
            Integer key = entry.getKey();
            Pays pays = entry.getValue();
            pays3.getItems().add(pays.getNom());
        }

        //Add "TextField"
        /*pays3.setValue("");
        pays3.setEditable(true);*/

        GridPane.setConstraints(pays3,1,1);


        Button btnUser4 = new Button("Utilisateur 4");
        GridPane.setConstraints(btnUser4,1,3);

        javafx.scene.control.ComboBox<String> BOT3 = new javafx.scene.control.ComboBox<String>();

        //GetItems return the ObservableList object which you can add items to
        BOT3.getItems().addAll("Joueur", "Robot");

        //Set a default value
        BOT3.setValue("Joueur");
        GridPane.setConstraints(BOT3,0,3);

        /*Button user2 = new Button("User 2");
        GridPane.setConstraints(loginButton,3,0);*/

        btnUser4.setOnAction(e -> {

            try {
                if(name3Input.getText().trim().equals("") || pays3.getValue().trim().equals("")){
                    user3valid = false;
                    grid3.setStyle(styleRed);
                    AlertBox.display("Attention", "Veuillez remplir les champs");
                }
                else{

                    if (!paysUsed.contains(pays3.getValue().trim())){

                        boolean bot = false;
                        if (BOT3.getValue() == "Robot"){
                            bot = true;
                        }

                        //System.out.println(choixPays);

                        Model.addToListeJoueur(new Enqeteur("","", Model.getPay(Model.getIdPaysByname(pays3.getValue().trim())), bot, name3Input.getText().trim()));
                        paysUsed.add(pays3.getValue().trim());

                        user3valid = true;
                        grid3.setStyle(styleGreen);
                        window.setTitle("Home : Utilisateur 4");
                        window.setScene(scene4);
                    }
                    else {
                        user3valid = false;
                        grid3.setStyle(styleRed);
                        AlertBox.display("Erreur", "Un autre enquêteur se charge déjà de ce pays.");
                    }

                }
            }
            catch (Exception ex){
                user3valid = false;
                grid3.setStyle(styleRed);
                AlertBox.display("Attention", "Veuillez choisir un Pays");
            }


        });

        grid3.getChildren().addAll(name3Label, name3Input, pays3,pays3Field, BOT3, btnUser4);
        //layout1.getChildren().addAll(label1, button1);

        scene3 = new Scene(grid3, 300,130);







        //UTILISATEUR/SCENE 4






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
        javafx.scene.control.ComboBox<String> pays4 = new javafx.scene.control.ComboBox<String>();

        //GetItems return the ObservableList object which you can add items to
        for (Map.Entry<Integer, Pays> entry : Model.getLesPays().entrySet()) {
            Integer key = entry.getKey();
            Pays pays = entry.getValue();
            pays4.getItems().add(pays.getNom());
        }

        //Add "TextField"
        /*pays4.setEditable(true);
        pays4.setValue("");*/


        GridPane.setConstraints(pays4,1,1);


        Button btnJouer = new Button("JOUER");
        GridPane.setConstraints(btnJouer,1,3);

        javafx.scene.control.ComboBox<String> BOT4 = new javafx.scene.control.ComboBox<String>();

        //GetItems return the ObservableList object which you can add items to
        BOT4.getItems().addAll("Joueur", "Robot");

        //Set a default value
        BOT4.setValue("Joueur");
        GridPane.setConstraints(BOT4,0,3);

        /*Button user2 = new Button("User 2");
        GridPane.setConstraints(loginButton,3,0);*/

        btnJouer.setOnAction(e -> {

            try {
                if(name4Input.getText().trim().equals("") || pays4.getValue().trim().equals("")){
                    user4valid = false;
                    grid4.setStyle(styleRed);
                    AlertBox.display("Attention", "Veuillez remplir les champs");
                }
                else{

                    if (!paysUsed.contains(pays4.getValue().trim())){

                        boolean bot = false;
                        if (BOT4.getValue() == "Robot"){
                            bot = true;
                        }

                        //System.out.println(choixPays);
                        paysUsed.add(pays4.getValue().trim());


                        Model.addToListeJoueur(new Enqeteur("","", Model.getPay(Model.getIdPaysByname(pays4.getValue().trim())), bot, name4Input.getText().trim()));

                        user4valid = true;
                        grid4.setStyle(styleGreen);
                        AlertBox.display("Bienvenue", "Bienvenue chers enquêteurs.\nQue le meilleur gagne ! ");

                        Application a = new Plateau();
                        try {
                            a.start(new Stage());
                        } catch (Exception e1) {
                            e1.printStackTrace();
                        }
                    }
                    else {
                        user4valid = false;
                        grid4.setStyle(styleRed);
                        AlertBox.display("Erreur", "Un autre enquêteur se charge déjà de ce pays.");
                    }


                }
            }
            catch (Exception ex){
                user4valid = false;
                grid4.setStyle(styleRed);
                AlertBox.display("Attention", "Veuillez choisir un Pays");
            }


        });

        grid4.getChildren().addAll(name4Label, name4Input, pays4,pays4Field,BOT4, btnJouer);
        //layout1.getChildren().addAll(label1, button1);

        scene4 = new Scene(grid4, 300,120);

        window.setScene(scene1);
        window.show();
    }

}
