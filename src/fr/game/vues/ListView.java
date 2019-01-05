package fr.game.vues;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListView extends Application {

    Stage window;
    Scene scene;
    Button button;
    Label question;
    javafx.scene.control.ListView<String> listView;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("listView - Nico");
        button = new Button("Poser la question");

        //ListView
        listView = new javafx.scene.control.ListView<>();
        //GetItems return the ObservableList object which you can add items to
        listView.getItems().addAll("Connaître les comptes de tel contribuable", "Connaître le propiétaire du compte", "Connaître le propriétaire de la société");

        //Set a default value
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Cadre
        listView.setPadding(new Insets(10,10,10,10));

        //hauteur Max
        listView.setMaxHeight(100);

        //Listener
        button.setOnAction(e -> getchoices());

        //Label
        question = new Label();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        //layout.getChildren().addAll(listView,button,newValue,oldValue);
        layout.getChildren().addAll(listView,button,question);

        scene = new Scene(layout, 400, 250);

        window.setScene(scene);

        window.show();

    }

    //To get the value of the selected item
    private void getchoices() {

        //newValue.setText("Élément séléctionné : " + listView.getValue());
        String message = "Question : ";
        ObservableList<String> questions;
        questions = listView.getSelectionModel().getSelectedItems();

        for (String q : questions){
            message += "\n" + q;
        }

        question.setText(message);

    }
}
