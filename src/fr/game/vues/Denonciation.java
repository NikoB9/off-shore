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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Denonciation extends Application {
    Stage window;
    Scene scene;
    Button button;
    Label reponse;
    Label LabelPays;
    TextField IDPays;
    Label LabelPersonne;
    TextField IDPersonne;
    Label LabelIBanque;
    TextField IDBanque;
    Label LabelICompte;
    TextField IDCompte;


    public static void main(String[] args){
        Model m = new Model();
        // System.out.println(Model.getIDsBanque());

        Model.peupler();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("Formulaire de denonciation");
        button = new Button("Denoncer !");


        LabelPays = new Label("A quel pays voulez dennoncer une fraude ?");
        IDPays = new TextField("");


        LabelPersonne = new Label("A quelle personne physique apartient se compte ? (La personne finale)");
        IDPersonne = new TextField("");

        LabelIBanque = new Label("quelle est le numero de banque ?");
        IDBanque = new TextField("");

        LabelICompte = new Label("quelle est le numero de compte ?");
        IDCompte = new TextField("");



        //Label
        reponse = new Label();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        //layout.getChildren().addAll(listView,button,newValue,oldValue);
        layout.getChildren().addAll(LabelPays, IDPays, LabelPersonne, IDPersonne, LabelIBanque, IDBanque,  LabelICompte, IDCompte, button, reponse);

        scene = new Scene(layout, 400, 320);

        window.setScene(scene);

        window.show();

        button.setOnAction(e -> getchoices());

    }

    //To get the value of the selected item
    private void getchoices() {
        reponse.setText (Model.denoncer(Integer.parseInt(IDPays.getText()),Integer.parseInt(IDPersonne.getText()),Integer.parseInt(IDBanque.getText()),Integer.parseInt(IDCompte.getText())));

    }


}
