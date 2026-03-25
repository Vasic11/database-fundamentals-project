package org.example.controller;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.example.model.SignUpModel;
import org.example.view.LogInView;
import org.example.view.SignUpView;

public class SignUpController {
    private SignUpView view;
    private SignUpModel model;

    public SignUpController(SignUpView signUpView) {
        this.view = signUpView;
        this.model = new SignUpModel();
        initListeners();
    }

    private void initListeners() {
        view.getCreate().setOnAction(event -> {
            String name = view.getTfUserName().getText().trim();
            String passwd1 = view.getPfPassworf().getText().trim();
            String passwd2 = view.getPfPassword2().getText().trim();
            if (!passwd1.equals(passwd2) || passwd1.isEmpty() || passwd2.isEmpty() || name.isEmpty()) {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                errorAlert.setTitle("Greska pri registarciji");
                errorAlert.setHeaderText("Proveri polja");
                errorAlert.setContentText("Niste dobro popunili sva polja");
                errorAlert.showAndWait();
            }else{
                //System.out.println(view.getTfUserName().getText() + " " +view.getPfPassworf().getText() + " " +view.getCbRole().getSelectionModel().getSelectedItem());
                boolean vecPostoji = model.daLiKorisnikPostoji(name, passwd1);
                if(vecPostoji) {
                    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                    errorAlert.setTitle("Greska pri registarciji");
                    errorAlert.setHeaderText("Korisnik vec postopji");
                    errorAlert.setContentText("Popunite polja drugacije");
                    errorAlert.showAndWait();
                }else {
                    boolean uspesnoSacuvanKorisnik = model.sacuvajKorisnika(name, passwd1);
                    if (uspesnoSacuvanKorisnik) {
                        Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
                        errorAlert.setTitle("Uspesna registracija");
                        errorAlert.setHeaderText("Uspesno ste se registrovali");
                        errorAlert.setContentText("Cestitamo");
                        errorAlert.showAndWait();
                        Stage currStage = (Stage) view.getCreate().getScene().getWindow();

                        LogInView logInView = new LogInView();
                        LogInController logInController = new LogInController(logInView);

                        Scene newScene = new Scene(logInView, 450, 350);
                        currStage.setScene(newScene);
                        currStage.setTitle("Log In");
                        currStage.show();
                    } else {
                        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                        errorAlert.setTitle("Greska pri registarciji");
                        errorAlert.setHeaderText("Proveri polja");
                        errorAlert.setContentText("Niste dobro popunili sva polja");
                        errorAlert.showAndWait();
                    }
                }


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
