package org.example.controller;

import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.example.Config;
import org.example.model.BrisanjeDto;
import org.example.model.BrisanjeModel;
import org.example.view.BrisanjeView;
import org.example.view.HomeView;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BrisanjeController {
    private BrisanjeView view;
    private BrisanjeModel model;
    public BrisanjeController(BrisanjeView brisanjeView) {
        this.view = brisanjeView;
        this.model = new BrisanjeModel();
        initListeners();
    }

    private void initListeners() {
        view.getBtnBack().setOnAction(ActionEvent -> {
            Stage currStage = (Stage) view.getBtnBack().getScene().getWindow();
            HomeView homeView = new HomeView();
            HomeController homeController = new HomeController(homeView);
            Scene scene = new Scene(homeView,800,600);
            currStage.setScene(scene);
            currStage.setTitle("Home");
            currStage.show();
        });

        view.getBtnObrisi().setOnAction(ActionEvent -> {
            BrisanjeDto brisanjeDto = view.getTabelaSesija().getSelectionModel().getSelectedItem();
            if(brisanjeDto==null){
                System.out.println("Niste selektovao nista");
                Alert errorAlert = new Alert(Alert.AlertType.WARNING);
                errorAlert.setTitle("Pokusajte ponovo");
                errorAlert.setHeaderText("Niste selektovali");
                errorAlert.setContentText("Obratite paznju");
                errorAlert.showAndWait();
            }else{
                int idSes = brisanjeDto.getId();
                int idIstr = brisanjeDto.istrazivacIdZaSesiju(Config.getConnection(),idSes);
                if(idIstr!=-1){
                    runQuery(Config.getConnection(),idSes,idIstr);
                    System.out.println("Obrisan: " + view.getTabelaSesija().getSelectionModel().getSelectedItem().getId());
                    view.getTabelaSesija().getItems().setAll(BrisanjeDto.readAllDto(Config.getConnection()));
                    Alert errorAlert = new Alert(Alert.AlertType.INFORMATION);
                    errorAlert.setTitle("Uspesno obrisan");
                    errorAlert.setHeaderText("Obrisana je sesija");
                    errorAlert.setContentText("Uspesno obrisana sesija");
                    errorAlert.showAndWait();
                }else{
                    System.out.println("Ne moze da se obrise");
                }

            }
        });
    }
    private void runQuery(Connection connection, int idSesije, int idIstrazivac){
        String query = "call obrisi(?, ?);";
        try{
            PreparedStatement preparedStatement= connection.prepareStatement(query);
            preparedStatement.setInt(1, idSesije);
            preparedStatement.setInt(2, idIstrazivac);
            preparedStatement.execute();

            //preparedStatement.executeQuery();
        }catch (Exception e){
            throw  new RuntimeException(e);
        }

    }
}
