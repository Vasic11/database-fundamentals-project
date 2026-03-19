package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.controller.LogInController;
import org.example.controller.SignUpController;
import org.example.view.DeleteAccView;
import org.example.view.LogInView;
import org.example.view.SignUpView;
import org.example.view.UpdateInformationView;

public class App extends Application {
    public static void main(String[] args) {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        //Scene scene = new Scene(new SignUpView(),400,400);
        // 1. Pravimo View
        LogInView view = new LogInView();
        // 2. Pravimo Kontroler i dajemo mu View da njime upravlja
        LogInController controller = new LogInController(view);

        // 3. Stavljamo View u scenu
        Scene scene = new Scene(view, 450, 350);
        stage.setTitle("Log In");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
