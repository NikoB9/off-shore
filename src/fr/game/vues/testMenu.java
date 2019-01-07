package fr.game.vues;

import fr.game.model.Model;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class testMenu extends Application {
    Stage window;
    Scene scene;
    Button button;
    Button button2, button3;

    public static void main(String[] args){
        Model m = new Model();
        Model.peupler();
        launch(args);
    }
    public void start(Stage primaryStage) throws Exception {


        window = primaryStage;
        window.setTitle("Test");

        button = new Button("Denoncer !");
        button2 = new Button("Chercher !");
        button3 = new Button("Home !");
        Application a = new Denonciation();
        Application b = new ListView();
        Application c = new home();



        button.setOnAction(e -> {
            try {
                a.start(new Stage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        button2.setOnAction(e -> {
            try {
                b.start(new Stage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });
        button3.setOnAction(e -> {
            try {
                c.start(new Stage());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        //layout.getChildren().addAll(listView,button,newValue,oldValue);
        layout.getChildren().addAll(button, button2,button3);

        scene = new Scene(layout, 400, 500);

        window.setScene(scene);

        window.show();

    }
}
