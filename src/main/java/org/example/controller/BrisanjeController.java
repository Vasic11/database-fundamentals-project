package org.example.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.model.BrisanjeModel;
import org.example.view.BrisanjeView;
import org.example.view.HomeView;

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
    }
}
