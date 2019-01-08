package fr.game.vues;

import fr.game.model.Model;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Plateau extends Application {
    Stage window;
    Scene scene;
    Button button;
    Button button2, button3,button4;

    public void start(Stage primaryStage) throws Exception {


        window = primaryStage;
        window.setTitle("Plateau");

        Label joueur = new Label();
        joueur.setText(Model.getListeJoueur().get(Model.getJoueurCourant()).getPseudo()+" : A vous de jouez\n\n\n");

        button = new Button("Denoncer !");
        button2 = new Button("Chercher !");
        button4 = new Button("Registre");
        Application a = new Denonciation();

        Application d = new Registre();



        button.setOnAction(e -> {
            try {
                a.start(new Stage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        button2.setOnAction(e -> {
            Application b = new Question();
            try {
                b.start(new Stage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        button4.setOnAction(e -> {
            try {
                d.start(new Stage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        //layout.getChildren().addAll(listView,button,newValue,oldValue);
        layout.getChildren().addAll(joueur, button, button2,button4);

        scene = new Scene(layout, 400, 500);

        window.setScene(scene);

        window.show();

    }
}
