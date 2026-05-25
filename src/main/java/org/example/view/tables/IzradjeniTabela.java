package org.example.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.model.IzradjeniDto;

import javafx.scene.control.TableView;

import java.util.Date;
import java.util.List;

public class IzradjeniTabela extends TableView<IzradjeniDto> {
    public IzradjeniTabela(List<IzradjeniDto> izradjeniDtos) {
        super(FXCollections.observableArrayList(izradjeniDtos));

        TableColumn<IzradjeniDto, String> tcNaziv = new TableColumn<>("Naziv Eksperimanta");
        TableColumn<IzradjeniDto, String> tcStatus = new TableColumn<>("Status Eksperimanta");
        TableColumn<IzradjeniDto, Date> tcDatum = new TableColumn<>("Datum Eksperimanta");

        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("eksperimentNazivIzradjeni"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("izvodjenjeStatusIzradjeni"));
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("izvodjenjeDatumIzradjeni"));
        super.getColumns().addAll(tcNaziv, tcStatus, tcDatum);
    }
}
