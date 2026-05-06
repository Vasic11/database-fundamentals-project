package org.example.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.view.BrisanjeView;
import org.example.view.HomeView;
import org.example.view.PromenaView;

public class HomeController {
    private HomeView view;

    public HomeController(HomeView view){
        this.view=view;
        initListeners();
    }

    private void initListeners() {
        view.getBtnPromena().setOnAction(event -> {
            Stage currStage = (Stage) view.getBtnPromena().getScene().getWindow();
            PromenaView promenaView = new PromenaView();
            PromenaController promenaController = new PromenaController(promenaView);
            Scene scene = new Scene(promenaView,800,600);
            currStage.setScene(scene);
            currStage.setTitle("Promena stanja");
            currStage.show();
        });



        view.getBtnBrisanje().setOnAction(event -> {
           Stage currStage = (Stage) view.getBtnBrisanje().getScene().getWindow();
            BrisanjeView brisanjeView = new BrisanjeView();
            BrisanjeController brisanjeController = new BrisanjeController(brisanjeView);
            Scene scene = new Scene(brisanjeView, 800,600);
            currStage.setScene(scene);
            currStage.setTitle("Brisanje stanja");
            currStage.show();
        });
    }
}
