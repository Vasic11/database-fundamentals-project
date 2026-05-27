package org.example.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.model.PromenaStatusaDto;
import javafx.scene.control.TableView;
import org.example.model.SviStatusiDto;

import java.util.Date;
import java.util.List;

public class PromenaStatusaTabela extends TableView<PromenaStatusaDto> {
    public PromenaStatusaTabela(List<PromenaStatusaDto> promenaStatusaDtos) {
        super(FXCollections.observableArrayList(promenaStatusaDtos));
        TableColumn<PromenaStatusaDto, String> tcNaziv = new TableColumn<>("Naziv Eksperimanta");
        TableColumn<PromenaStatusaDto, String> tcStatus = new TableColumn<>("Status Eksperimanta");
        TableColumn<PromenaStatusaDto, Date> tcDatum = new TableColumn<>("Datum Eksperimanta");

        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("eksperimentNazivSviStatusi"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("izvodjenjeStatusSviStatusi"));
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("izvodjenjeDatumSviStatusi"));
        super.getColumns().addAll(tcNaziv, tcStatus, tcDatum);
    }
}
