package org.example.controller;

import javafx.scene.Scene;
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
    }
}
