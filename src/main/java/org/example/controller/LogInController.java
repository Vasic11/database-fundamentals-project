package org.example.controller;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.example.Config;
import org.example.model.LogInModel;
import org.example.view.HomeView;
import org.example.view.LogInView;
import org.example.view.SignUpView;

public class LogInController {
    private LogInView view;
    private LogInModel model;

    public LogInController(LogInView view) {
        this.view=view;
        model=new LogInModel();
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
            String username = view.getTfUserName().getText().trim();
            String passwd = view.getPfPassworf().getText().trim();
           if(username.isEmpty() || passwd.isEmpty()){
               Alert errorAlert = new Alert(Alert.AlertType.ERROR);
               errorAlert.setTitle("Greska pri popunjavanju Log In forme");
               errorAlert.setHeaderText("Proveri polja");
               errorAlert.setContentText("Niste dobro popunili sva polja");
               errorAlert.showAndWait();
           }else{
               System.out.println("Dobro popunjena polja: "+view.getTfUserName().getText() + " " + view.getPfPassworf().getText());
               boolean dobroUnetKorisnik = model.daLiKorisnikPostoji(username, passwd);
               if(dobroUnetKorisnik){
                   Config.connect("localhost", "3306", "projekat_baza", "root", "MikiSQL11");
                   Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
                   errorAlert.setTitle("Cestitamo");
                   errorAlert.setHeaderText("Korisnik postoji");
                   errorAlert.setContentText("Otvra se korinikov prozor");
                   errorAlert.showAndWait();

                   Stage currStage = (Stage) view.getBtLogIn().getScene().getWindow();

                   HomeView homeView = new HomeView();
                   HomeController homeController = new HomeController(homeView);

                   Scene newScene = new Scene(homeView, 800, 600);
                   currStage.setScene(newScene);
                   currStage.setTitle("Home");
                   currStage.show();
               }else{
                   Alert errorAlert = new Alert(Alert.AlertType.ERROR);
                   errorAlert.setTitle("Greska pri popunjavanju Log In forme");
                   errorAlert.setHeaderText("Proveri polja");
                   errorAlert.setContentText("Niste dobro popunili sva polja");
                   errorAlert.showAndWait();
               }
           }
        });
    }
}
