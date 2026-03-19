package org.example.controller;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.example.view.LogInView;
import org.example.view.SignUpView;

public class SignUpController {
    private SignUpView view;

    public SignUpController(SignUpView signUpView) {
        this.view = signUpView;
        initListeners();
    }

    private void initListeners() {
        view.getCreate().setOnAction(event -> {
            String name = view.getCreate().getText();
            String passwd1 = view.getPfPassworf().getText();
            String passwd2 = view.getPfPassword2().getText();
            if (!passwd1.equals(passwd2) || passwd1.isEmpty() || passwd2.isEmpty() || name.isEmpty()) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Greska pri registarciji");
                errorAlert.setHeaderText("Proveri polja");
                errorAlert.setContentText("Niste dobro popunili sva polja");
                errorAlert.showAndWait();
            }else{
                //System.out.println(view.getTfUserName().getText() + " " +view.getPfPassworf().getText() + " " +view.getCbRole().getSelectionModel().getSelectedItem());
                Stage currStage = (Stage) view.getCreate().getScene().getWindow();

                LogInView  logInView = new LogInView();
                LogInController logInController = new LogInController(logInView);

                Scene newScene = new Scene(logInView,450,350);
                currStage.setScene(newScene);
                currStage.setTitle("Log In");
                currStage.show();

            }

        });

        view.getBack().setOnAction(event -> {
            Stage currStage = (Stage) view.getCreate().getScene().getWindow();

            LogInView  logInView = new LogInView();
            LogInController logInController = new LogInController(logInView);

            Scene newScene = new Scene(logInView,450,350);
            currStage.setScene(newScene);
            currStage.setTitle("Log In");
            currStage.show();
        });
    }
}
