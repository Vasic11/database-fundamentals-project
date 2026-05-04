package org.example.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.model.Eksperiment;
import org.example.view.IstrazivacView;

public class IstrazivacController {
    private IstrazivacView view;
    private ObservableList<Eksperiment> listaEksperimenata = FXCollections.observableArrayList();

    public IstrazivacController(IstrazivacView view) {
        this.view = view;
        this.view.getTvEksperimenti().setItems(listaEksperimenata);
        initListeners();
    }

    private void initListeners() {
        view.getBtnSnimiSve().setOnAction(e -> {
            String nazivEks = view.getTfNazivEksperimenta().getText();
            String teorija = view.getTfTeorijaNaziv().getText();

            if (!nazivEks.isEmpty()) {
                // Kada povežeš bazu, ovde ćeš prvo uraditi INSERT u TEORIJA,
                // pa u EKSPERIMENT, pa u ROD/VRSTA/RESURS
                Eksperiment novi = new Eksperiment(0, nazivEks, "Ciljevi...", teorija);
                listaEksperimenata.add(novi);

                System.out.println("Sistem: Dodat eksperiment sa resursom: " + view.getTfNazivEksperimenta().getText());
                ocistiPolja();
            }
        });
    }

    private void ocistiPolja() {
        view.getTfNazivEksperimenta().clear();
        view.getTfTeorijaNaziv().clear();
    }
}