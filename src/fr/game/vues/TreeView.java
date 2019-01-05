package fr.game.vues;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeView extends Application {

    Stage window;
    Scene scene;
    javafx.scene.control.TreeView<String> tree;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("TreeView");

        //Tree
        TreeItem<String> root, rooot, brancheFermee, comptesSuspects, comptesDécouverts, resultByUser, comptes1, comptes2, comptes3, contribuable1, contribuable2, contribuable3, societes1, societes2, societes3;

        //root
        root = new TreeItem<>();
        root.setExpanded(false);

        rooot = makeBranch("Carnet de route", root);
        rooot.setExpanded(true);
        //brancheFermee = makeBranch("", root);

        //Comptes suspects
        comptesSuspects = makeBranch("Compte Suspects", rooot);
        makeBranch("Compte1", comptesSuspects);
        makeBranch("Compte2", comptesSuspects);
        makeBranch("Compte3", comptesSuspects);
        makeBranch("Compte4", comptesSuspects);


        //Comptes Découverts
        comptesDécouverts = makeBranch("Compte Découverts", rooot);
        makeBranch("Compte1", comptesDécouverts);
        makeBranch("Compte2", comptesDécouverts);

        //Résultats par enquêteurs
        resultByUser = makeBranch("Carnet de route enquêteur", rooot);
        TreeItem<String> user1 = makeBranch("user1", resultByUser);
        TreeItem<String> user2 = makeBranch("user2", resultByUser);
        TreeItem<String> user3 = makeBranch("user3", resultByUser);
        resultByUser.setExpanded(true);

        //Comptes/enqueteurs
        comptes1 = makeBranch("Comptes",user1);
        makeBranch("liste de comptes",comptes1);
        comptes2 = makeBranch("Comptes",user2);
        makeBranch("liste de comptes",comptes2);
        comptes3 = makeBranch("Comptes",user3);
        makeBranch("liste de comptes",comptes3);

        //Sociétés/enqueteurs
        societes1 = makeBranch("Sociétés",user1);
        makeBranch("liste de sociétés",societes1);
        societes2 = makeBranch("Sociétés",user2);
        makeBranch("liste de sociétés",societes2);
        societes3 = makeBranch("Sociétés",user3);
        makeBranch("liste de sociétés",societes3);

        //Contribuables/enqueteurs
        contribuable1 = makeBranch("Contribuable",user1);
        makeBranch("liste de contribuables",contribuable1);
        contribuable2 = makeBranch("Contribuable",user2);
        makeBranch("liste de contribuables",contribuable2);
        contribuable3 = makeBranch("Contribuable",user3);
        makeBranch("liste de contribuables",contribuable3);

        //Create tree
        tree = new javafx.scene.control.TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue != null){
                        System.out.println(newValue.getValue());
                    }
                });

        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        scene = new Scene(layout, 300,250);
        window.setScene(scene);
        window.show();
    }

    //Create branch
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){

        TreeItem<String> item = new TreeItem<>(title);

        item.setExpanded(false);
        parent.getChildren().add(item);

        return item;

    }

}
