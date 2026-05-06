package org.example.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.model.PromenaModel;
import org.example.view.HomeView;
import org.example.view.PromenaView;

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
    }
}
