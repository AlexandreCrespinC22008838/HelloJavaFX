package com.example.partie1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.Random;

public class Exercice2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //Create the GridPane
        GridPane root = new GridPane();
        root.getColumnConstraints().add(new ColumnConstraints(50));
        root.getColumnConstraints().add(new ColumnConstraints(50));

        //Create the labels with the images
        for(int i=0;i<3;++i){
            for(int j=0;j<3;++j){
                Random random = new Random();
                int nombre = random.nextInt(3);
                if (nombre==0){
                    Label label1 = new Label("croix");
                    GridPane.setConstraints(label1,i,j);
                    root.getChildren().addAll(label1);
                }
                if (nombre==1){
                    Label label2 = new Label("rond");
                    GridPane.setConstraints(label2,i,j);
                    root.getChildren().addAll(label2);
                }
                if (nombre==2){
                    Label label3 = new Label("vide");
                    GridPane.setConstraints(label3,i,j);
                    root.getChildren().addAll(label3);
            }

            }

        }

        // set the scene
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
    }
}
