package com.github.liamsharp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application
{
    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    @Override
    public void start(
        final Stage primaryStage) 
    {
        primaryStage.setOnCloseRequest(event -> 
        {
            System.out.println("onCloseRequest called " + event);
        });
        
        primaryStage.setTitle("Hello World!");
        final Label label = new Label("Hello World!");
        
        final StackPane root = new StackPane();
        root.getChildren().add(label);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
}
