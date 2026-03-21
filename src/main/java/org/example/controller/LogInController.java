package org.example.controller;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.example.view.LogInView;
import org.example.view.SignUpView;

public class LogInController {
    private LogInView view;

    public LogInController(LogInView view) {
        this.view=view;
        initListeners();
    }

    private void initListeners() {
        view.getBtSignUp().setOnAction(event -> {
            Stage currStage = (Stage) view.getBtSignUp().getScene().getWindow();

            SignUpView signUpView = new SignUpView();
            SignUpController signUpController = new SignUpController(signUpView);
            Scene newScene = new Scene(signUpView,450,350);

            currStage.setScene(newScene);
            currStage.setTitle("Sign Up");
            currStage.show();
        });
        view.getBtLogIn().setOnAction(event -> {
           if(view.getTfUserName().getText().isEmpty() || view.getPfPassworf().getText().isEmpty()){
               Alert errorAlert = new Alert(Alert.AlertType.ERROR);
               errorAlert.setTitle("Greska pri popunjavanju Log In forme");
               errorAlert.setHeaderText("Proveri polja");
               errorAlert.setContentText("Niste dobro popunili sva polja");
               errorAlert.showAndWait();
           }else{
               System.out.println("Dobro popunjena polja: "+view.getTfUserName().getText() + " " + view.getPfPassworf().getText());
           }
        });
    }
}
