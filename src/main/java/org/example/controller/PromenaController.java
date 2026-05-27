package org.example.controller;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.example.Config;
import org.example.model.PromenaModel;
import org.example.model.PromenaStatusaDto;
import org.example.view.HomeView;
import org.example.view.PromenaView;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PromenaController {
    private PromenaView view;
    private PromenaModel model;
    public PromenaController(PromenaView promenaView) {
        this.view = promenaView;
        this.model = new PromenaModel();
        initListeners();
    }

    private void initListeners() {
        view.getBtnBack().setOnAction(ActionEvent -> {
            Stage stage = (Stage) view.getBtnBack().getScene().getWindow();

            HomeView homeView = new HomeView();
            HomeController homeController = new HomeController(homeView);
            Scene scene = new Scene(homeView,800,600);
            stage.setTitle("Home");
            stage.setScene(scene);
        });

        view.getBtnPromeni().setOnAction(ActionEvent -> {
            String noviStatus = view.getComboStatusi().getSelectionModel().getSelectedItem();
            PromenaStatusaDto promenaStatusaDto = view.getTabela().getSelectionModel().getSelectedItem();
            if(promenaStatusaDto == null || noviStatus==null){
                System.out.println("Nisi selektovao nista");
                Alert errorAlert = new Alert(Alert.AlertType.WARNING);
                errorAlert.setTitle("Pokusajte ponovo");
                errorAlert.setHeaderText("Niste selektovali ili promenili lepo status");
                errorAlert.setContentText("Obratite paznju");
                errorAlert.showAndWait();
            }else{
                System.out.println("Izabrao si: " + promenaStatusaDto.getIdSviStatusi());
                System.out.println("Novi Status: " + noviStatus);
                this.runQuery(Config.getConnection(), noviStatus, promenaStatusaDto.getIdSviStatusi());
                view.getTabela().getItems().setAll(PromenaStatusaDto.readPromenaStatusaTabela(Config.getConnection()));
                Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
                errorAlert.setTitle("Uspesno promenje status");
                errorAlert.setHeaderText("Promenjen status u: " + noviStatus);
                errorAlert.setContentText("Cestitamo");
                errorAlert.showAndWait();
            }
        });
    }
    private void runQuery(Connection connection, String status, int id){
        String query = "update izvodjenje set izvodjenje_status = ? where izvodjenje_id = ?";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,status);
            preparedStatement.setInt(2,id);
            preparedStatement.execute();
        }catch(Exception e){
            throw  new RuntimeException(e);
        }
    }
}
