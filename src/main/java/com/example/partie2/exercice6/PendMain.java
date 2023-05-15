package com.example.partie2.exercice6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PendMain extends Application {

    private final Dico dico = new Dico();
    private String mot;
    private int vies;
    private char[] motCache;

    private TextField lettreTextField;
    private Label viesLabel;
    private Label motCacheLabel;

    @Override
    public void start(Stage primaryStage) {
        // Choisit un mot aléatoire à partir du dictionnaire
        mot = dico.getMot();

        // Initialise le nombre de vies
        vies = 6;

        // Initialise la représentation cachée du mot
        motCache = new char[mot.length()];
        for (int i = 0; i < mot.length(); i++) {
            motCache[i] = '_';
        }

        // Crée les éléments de l'interface graphique
        lettreTextField = new TextField();
        Button proposerButton = new Button("Proposer");
        viesLabel = new Label("Vies restantes : " + vies);
        motCacheLabel = new Label(new String(motCache));
        HBox propositionBox = new HBox(lettreTextField, proposerButton);
        VBox root = new VBox(propositionBox, viesLabel, motCacheLabel);
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Ajoute un gestionnaire d'événements au bouton de proposition
        proposerButton.setOnAction(event -> proposerLettre());

        // Affiche la scène
        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void proposerLettre() {
        // Récupère la lettre proposée par l'utilisateur
        char lettre = lettreTextField.getText().toUpperCase().charAt(0);
        lettreTextField.setText("");

        // Trouve les positions de la lettre proposée dans le mot
        ArrayList<Integer> positions = dico.getPositions(lettre, mot);

        if (positions.isEmpty()) {
            // La lettre proposée n'est pas dans le mot
            vies--;
            viesLabel.setText("Vies restantes : " + vies);

            if (vies == 0) {
                // Le joueur a perdu
                motCacheLabel.setText(mot);
                lettreTextField.setDisable(true);
            }

        } else {
            // La lettre proposée est dans le mot
            for (int position : positions) {
                motCache[position] = lettre;
            }
            motCacheLabel.setText(new String(motCache));

            if (new String(motCache).equals(mot)) {
                // Le joueur a gagné
                viesLabel.setText("Bravo, vous avez gagné !");
                lettreTextField.setDisable(true);
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}