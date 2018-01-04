package com.github.liamsharp;

import java.util.Locale;
import java.util.Optional;

import de.codecentric.centerdevice.MenuToolkit;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
        setMenu();
        primaryStage.setOnCloseRequest(event -> handleOnCloseRequest(event));
        
        primaryStage.setTitle("Hello World!");
        final Label label = new Label("Hello World!");
        final StackPane root = new StackPane();
        root.getChildren().add(label);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    private void setMenu()
    {
        final MenuToolkit tk = MenuToolkit.toolkit(Locale.getDefault());
        if (tk != null)
        {
            final Menu applicationMenu = tk.createDefaultApplicationMenu("HelloWorld");
            tk.setApplicationMenu(applicationMenu);
        }
        else
        {
            System.err.println("Unable to get access to menu bar, will leave unmodified");
        }
    }

    private void handleOnCloseRequest(
        final WindowEvent event)
    {
        System.out.println("onCloseRequest called " + event);

        final Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Are you sure you want to exit?");
        
        final Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            System.out.println("User said OK to exit");
        }
        else
        {
            System.out.println("User CANCEL to exit, consuming event");
            event.consume();
        }
    }
    
}
