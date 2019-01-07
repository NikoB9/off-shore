package fr.game.vues;

import fr.game.model.Model;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListView extends Application {

    Stage window;
    Scene scene;
    Button button;
    Label question;
    Label LabelID;
    TextField ID;
    Label LabelID2;
    TextField ID2;
    javafx.scene.control.ListView<String> listView;

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("listView - Nico");
        button = new Button("Poser la question");


        LabelID = new Label("id du Compte");
        ID = new TextField("");


        LabelID2 = new Label("id de la Banque");
        ID2 = new TextField("");



        //ListView
        listView = new javafx.scene.control.ListView<>();
        //GetItems return the ObservableList object which you can add items to
        listView.getItems().addAll("A qui est ce compte ?", "Quelles Societes cette persoone a", "Qui possede cette societe");

        //Set a default value
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Cadre
        listView.setPadding(new Insets(10,10,10,10));

        //hauteur Max
        listView.setMaxHeight(100);

        //Listener
        button.setOnAction(e -> getchoices());
        listView.setOnMouseClicked(e -> modifLabelName());

        //Label
        question = new Label();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        //layout.getChildren().addAll(listView,button,newValue,oldValue);
        layout.getChildren().addAll(listView,LabelID,ID,LabelID2,ID2,button,question);

        scene = new Scene(layout, 400, 500);

        window.setScene(scene);

        window.show();

    }

    //To get the value of the selected item
    private void getchoices() {

        //newValue.setText("Élément séléctionné : " + listView.getValue());
        String message = "Reponse : ";
        ObservableList<String> questions;
        questions = listView.getSelectionModel().getSelectedItems();

        for (String q : questions){
            message = "Reponse : ";
           if (q == "A qui est ce compte ?"){
               message += Model.aQuiEstCeCompte(Integer.parseInt(ID.getText()),Integer.parseInt(ID2.getText()));
           }
           else if (q == "Quelles Societes cette persoone a"){
               message += Model.QuelleSocietesCettePersooneA(Integer.parseInt(ID2.getText()),Integer.parseInt(ID.getText()));
           }
           else {
               message += Model.QuiPossedeCetteSociete(Integer.parseInt(ID2.getText()));
           }

        }

        question.setText(message);

    }

    private void modifLabelName(){
        System.out.println("test");
        ObservableList<String> questions;
        questions = listView.getSelectionModel().getSelectedItems();

        for (String q : questions){
            if (q == "A qui est ce compte ?"){
                this.LabelID.setVisible(true);
                this. ID.setVisible(true);
                this.LabelID2.setText("id de la Banque");
                this.LabelID.setText("id du Compte");
            }
            else if (q == "Quelles Societes cette persoone a"){
                this.LabelID.setVisible(true);
                this. ID.setVisible(true);
                this.LabelID2.setText("id de la personne");
                this.LabelID.setText("id du du pays de la personne");
            }
            else {
                this.LabelID2.setText("id de la Societe");
                this.LabelID.setVisible(false);
                this. ID.setVisible(false);
            }

        }
    }
}
