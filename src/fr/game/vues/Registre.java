package fr.game.vues;

import fr.game.entites.*;
import fr.game.model.Model;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Registre extends Application {

    Stage window;
    Scene scene, sceneQ;

    Button goInfos = new Button("Informations");
    Button goHistoriqueQuestions = new Button("Questions");
    Button goHistoriqueDeclaration = new Button("Déclarations");

    Model model = new Model();
    ArrayList<CompteBancaire> l_compteSuspects = model.getListeCompteFrauduleux();
    HashMap<Integer, ArrayList<CompteBancaire>> l_compteFrauduleuxParEnqueteur = model.getListeCompteFrauduleuxParEnqueteur();
    HashMap<Integer, Banque> l_banques = model.getListeBanque();
    HashMap<Integer, Societe> l_societes = model.getListeSociete();
    HashMap<Integer, CompteBancaire> l_comptes = model.getListeCompte();
    ArrayList<Enqeteur> l_joeurs = model.getListeJoueur();
    HashMap<Integer, Contribuable> l_contribuables = model.getLesContribuable();
    HashMap<Integer, Pays> l_pays = model.getLesPays();



    javafx.scene.control.TreeView<String> tree;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        window.setTitle("Registre");


        goInfos.setOnAction(e -> {
            window.setScene(scene);
            window.show();
        });

        goHistoriqueQuestions.setOnAction(e -> {
            window.setScene(sceneQ);
            window.show();
        });

        StackPane menu1 = new StackPane();
        menu1.getChildren().add(goInfos);

        StackPane menu2 = new StackPane();
        menu2.getChildren().add(goHistoriqueQuestions);



        /***********Infos**********/


        //Tree
        TreeItem<String> root, title, pays, banques, comptes, contribuables, societes, comptesSuspects, comptesDécouverts;

        //root
        root = new TreeItem<>();
        root.setExpanded(false);

        title = makeBranch("Carnet de route", root);
        title.setExpanded(true);
        //brancheFermee = makeBranch("", root);

        //Pays
        pays = makeBranch("Liste des pays", title);
        if (l_pays.size() == 0){
            makeBranch("Aucun pays", pays);
        }
        else {
            for (Map.Entry<Integer, Pays> e : l_pays.entrySet()) {
                Integer key = e.getKey();
                Pays s_pays = e.getValue();
                makeBranch(s_pays.toString(), pays);
            }
        }


        //banques
        banques = makeBranch("Liste des banques", title);
        if (l_banques.size() == 0){
            makeBranch("Aucune banque", banques);
        }
        else {
            for (Map.Entry<Integer, Banque> e : l_banques.entrySet()) {
                makeBranch(e.getValue().toString(), banques);
            }
        }

        //comptes
        comptes = makeBranch("Liste des comptes bancaire", title);
        if (l_comptes.size() == 0){
            makeBranch("Aucun compte bancaire", comptes);
        }
        else {
            for (Map.Entry<Integer, CompteBancaire> e : l_comptes.entrySet()) {
                makeBranch(e.getValue().toString(), comptes);
            }
        }

        //contribuables
        contribuables = makeBranch("Liste des contribuables", title);
        if (l_contribuables.size() == 0){
            makeBranch("Aucun contribuable", contribuables);
        }
        else {
            for (Map.Entry<Integer, Contribuable> e : l_contribuables.entrySet()) {
                makeBranch(e.getValue().toString(), contribuables);
            }
        }


        //societes
        societes = makeBranch("Liste des sociétés", title);
        if (l_societes.size() == 0){
            makeBranch("Aucune société", societes);
        }
        else {
            for (Map.Entry<Integer, Societe> e : l_societes.entrySet()) {
                makeBranch(e.getValue().toString(), societes);
            }
        }


        //Comptes suspects
        comptesSuspects = makeBranch("Compte Suspects", title);
        if (l_compteSuspects.size() == 0){
            makeBranch("Aucun compte suspect", comptesSuspects);
        }
        else {
            for (CompteBancaire e : l_compteSuspects) {
                makeBranch(e.toString(), comptesSuspects);
            }
        }


        //Comptes Découverts  //Résultats par enquêteurs

        comptesDécouverts = makeBranch("Compte Découverts", title);

        if (l_compteFrauduleuxParEnqueteur.size() == 0 || l_joeurs.size() == 0){
            makeBranch("Aucun compte frauduleux découvert", comptesDécouverts);
        }
        else {
            ArrayList<TreeItem<String>> user = new ArrayList<>();
            user.add(makeBranch(l_joeurs.get(0).getPseudo(), comptesDécouverts));
            user.add(makeBranch(l_joeurs.get(1).getPseudo(), comptesDécouverts));
            user.add(makeBranch(l_joeurs.get(2).getPseudo(), comptesDécouverts));
            user.add(makeBranch(l_joeurs.get(3).getPseudo(), comptesDécouverts));
            for (Map.Entry<Integer, ArrayList<CompteBancaire>> e : l_compteFrauduleuxParEnqueteur.entrySet()) {

                for (CompteBancaire c : e.getValue()){
                    makeBranch(c.toString(), user.get(e.getKey()));
                }

            }
        }

        //resultByUserQ.setExpanded(true);


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

        BorderPane cadre = new BorderPane();
        cadre.setPadding(new Insets(10,10,10,10));
        cadre.setCenter(layout);
        cadre.setTop(menu2);

        scene = new Scene(cadre, 300,250);






        /***********QUESTIONS**********/





        //Tree
        TreeItem<String> rootQ, titleQ, resultByUserQ, comptes1, comptes2, comptes3, contribuable1, contribuable2, contribuable3, societes1, societes2, societes3;

        //rootQ
        rootQ = new TreeItem<>();
        rootQ.setExpanded(false);

        titleQ = makeBranch("Carnet de route", rootQ);
        titleQ.setExpanded(true);
        //brancheFermee = makeBranch("", rootQ);


        //Résultats par enquêteurs
        resultByUserQ = makeBranch("Carnet de route enquêteur", titleQ);
        TreeItem<String> user1 = makeBranch("user1", resultByUserQ);
        TreeItem<String> user2 = makeBranch("user2", resultByUserQ);
        TreeItem<String> user3 = makeBranch("user3", resultByUserQ);
        resultByUserQ.setExpanded(true);

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
        tree = new javafx.scene.control.TreeView<>(rootQ);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue != null){
                        System.out.println(newValue.getValue());
                    }
                });

        //Layout
        StackPane layoutQ = new StackPane();
        layoutQ.getChildren().add(tree);

        BorderPane cadreQ = new BorderPane();
        cadreQ.setPadding(new Insets(10,10,10,10));
        cadreQ.setCenter(layoutQ);
        cadreQ.setTop(menu1);

        sceneQ = new Scene(cadreQ, 300,250);



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
