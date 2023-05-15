package com.example.partie2.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    private static ArrayList<Obstacle> obstacle;

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        //on positionne les obstacle
        obstacle = new ArrayList<Obstacle>();
        obstacle.add(new Obstacle(50,50,100,200));
        obstacle.add(new Obstacle(100,100,100,50));

        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);
        for (int i=0; i< obstacle.size();++i){
            jeu.getChildren().add(obstacle.get(i));
        }
        root.setCenter(jeu);
        Timer tm = new Timer();
        tm.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.exit();
                System.out.println("fantom a gagné");
            }
        },10000);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
            double x1 = j1.getLayoutX();
            double y1 = j1.getLayoutY();
            double x2 = j2.getLayoutX();
            double y2 = j2.getLayoutY();
            switch (event.getCode()) {
                case LEFT:
                    j1.deplacerAGauche();
                    break;
                case RIGHT:
                    j1.deplacerADroite(scene.getWidth());
                    break;
                case UP:
                    j1.deplacerEnHaut();
                    break;
                case DOWN:
                    j1.deplacerEnBas(scene.getHeight());
                    break;
                case Z:
                    j2.deplacerEnHaut();
                    break;
                case D:
                    j2.deplacerADroite(scene.getWidth());
                    break;
                case S:
                    j2.deplacerEnBas(scene.getHeight());
                    break;
                case Q:
                    j2.deplacerAGauche();
                    break;

            }
            for (int i = 0;i< obstacle.size(); ++i){
                if(obstacle.get(i).estEnCollision(j1)){
                    j1.setLayoutX(x1);
                    j1.setLayoutY(y1);
                }
                if(obstacle.get(i).estEnCollision(j2)){
                    j2.setLayoutX(x2);
                    j2.setLayoutY(y2);
                }
            }
            if (j1.estEnCollision(j2)){
                Label PacFin = new Label("Pac Man a gagné");
                root.setCenter(PacFin);
            }
        });
    }


}
