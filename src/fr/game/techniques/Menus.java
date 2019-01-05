package fr.game.techniques;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Menus extends Application {

    Stage window;
    Scene scene;
    BorderPane layout;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        window.setTitle("MENUS");

        //File menu
        Menu fileMenu = new Menu("File");

        //Menu items
        fileMenu.getItems().add(new MenuItem("New Project.."));
        fileMenu.getItems().addAll(new MenuItem("Open.."), new MenuItem("New Project.."));

    }
}
