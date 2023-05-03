package com.example.partie1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Exercice1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Création du conteneur principal
        VBox vbox = new VBox();

        // Création de la barre de menu
        MenuItem New = new MenuItem("New");
        MenuItem Open = new MenuItem("Open");
        MenuItem Save = new MenuItem("Save");
        MenuItem Close = new MenuItem("Close");
        Menu File = new Menu("File");
        File.getItems().addAll(New,Open,Save,Close);

        MenuItem Cut = new MenuItem("Cut");
        MenuItem Copy = new MenuItem("Copy");
        MenuItem Paste = new MenuItem("Paste");
        Menu Edit = new Menu("Edit");
        Edit.getItems().addAll(Cut,Copy,Paste);

        Menu Help = new Menu("Help");

        MenuBar menuBar = new MenuBar(File,Edit,Help);

        // Création de la barre de bouton
        Label btn = new Label("Boutons :");
        Button btn1 = new Button("Bouton 1");
        Button btn2 = new Button("Bouton 2");
        Button btn3 = new Button("Bouton 3");
        Separator separator = new Separator(Orientation.HORIZONTAL);
        VBox btnBar = new VBox(btn,btn1,btn2,btn3);

        // Création du formulaire
        GridPane formulaire = new GridPane();

        Label name = new Label("Name : ");
        GridPane.setConstraints(name,0,0);
        TextField tfName = new TextField();
        tfName.setPrefColumnCount(12);
        GridPane.setConstraints(tfName,1,0);

        Label email = new Label("Email : ");
        GridPane.setConstraints(email,0,1);
        TextField tfEmail = new TextField();
        tfName.setPrefColumnCount(12);
        GridPane.setConstraints(tfEmail,1,1);

        Label password = new Label("Password : ");
        GridPane.setConstraints(password,0,2);
        TextField tfPassword = new TextField();
        tfName.setPrefColumnCount(12);
        GridPane.setConstraints(tfPassword,1,2);

        formulaire.getChildren().addAll(name,tfName,email,tfEmail,password,tfPassword);

        Button submit = new Button("Submit");
        Button cancel = new Button("Cancel");
        HBox btnSubCan = new HBox(submit,cancel);
        btnSubCan.setAlignment(Pos.CENTER);

        VBox form = new VBox(formulaire,btnSubCan);
        // Création du centre
        HBox center = new HBox(btnBar,form);

        //Création du label de bas de page
        HBox basPage = new HBox();
        basPage.setAlignment(Pos.CENTER);
        Label labelBasPage = new Label("Ceci est un label de bas de page");
        basPage.getChildren().add(labelBasPage);

        // Ajout des contrôleurs au conteneur principal
        VBox.setVgrow(center, Priority.ALWAYS );
        vbox.getChildren().addAll(menuBar,center,basPage);

        // Ajout du conteneur à la scene
        Scene scene = new Scene(vbox);

        // Ajout de la scene à la fenêtre et changement de ses paramètres (dimensions et titre)
        primaryStage.setScene( scene );
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les contenaurs");

        // Affichage de la fenêtre
        primaryStage.show();
    }
}
