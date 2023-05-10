package com.example.partie2;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class Exercice4 extends Application {

    //Compteurs
    AtomicInteger cmpV = new AtomicInteger(0);
    AtomicInteger cmpR = new AtomicInteger(0);
    AtomicInteger cmpB = new AtomicInteger(0);
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Create the BorderPane
        BorderPane root = new BorderPane();
        root.setPrefSize(400,200);

        //Create Label top page
        HBox topHbox = new HBox();
        Label topLabel = new Label("");
        topHbox.getChildren().addAll(topLabel);
        topHbox.setAlignment(Pos.CENTER);
        root.setTop(topHbox);

        //Create Pane center page
        Pane centerPane = new Pane();
        root.setCenter(centerPane);

        //Create HBox bottom page
        HBox bottomHbox = new HBox();
        bottomHbox.setAlignment(Pos.CENTER);
        Button vert = new Button("Vert");
        Button rouge = new Button("Rouge");
        Button bleu = new Button("Bleu");
        bottomHbox.getChildren().addAll(vert,rouge,bleu);
        root.setBottom(bottomHbox);

        // Changement du texte après un clic sur le bouton
        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            centerPane.setStyle( "-fx-background-color:green;" );
            cmpV.addAndGet(1);
            topLabel.setText("Vert choisi "+cmpV+" fois");
        });
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            centerPane.setStyle( "-fx-background-color:red;" );
            cmpR.addAndGet(1);
            topLabel.setText("Rouge choisi "+cmpR+" fois");
        });
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            centerPane.setStyle( "-fx-background-color:blue;" );
            cmpB.addAndGet(1);
            topLabel.setText("Bleu choisi "+cmpB+" fois");
        });

        // Création de la scene
        Scene scene = new Scene( root);

        // Ajout de la scene à la fenêtre
        primaryStage.setScene( scene );

        primaryStage.setTitle("Conteneurs");
        primaryStage.show();
    }
}
