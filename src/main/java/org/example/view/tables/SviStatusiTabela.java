package org.example.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.model.PlaniraniDto;
import org.example.model.SviStatusiDto;
import javafx.scene.control.TableView;
import java.util.Date;
import java.util.List;

public class SviStatusiTabela  extends TableView<SviStatusiDto>{
    public SviStatusiTabela(List<SviStatusiDto> sviDtos) {
        super(FXCollections.observableArrayList(sviDtos));

        TableColumn<SviStatusiDto, String> tcNaziv = new TableColumn<>("Naziv Eksperimanta");
        TableColumn<SviStatusiDto, String> tcStatus = new TableColumn<>("Status Eksperimanta");
        TableColumn<SviStatusiDto, Date> tcDatum = new TableColumn<>("Datum Eksperimanta");

        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("eksperimentNazivSvi"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("izvodjenjeStatusSvi"));
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("izvodjenjeDatumSvi"));
        super.getColumns().addAll(tcNaziv, tcStatus, tcDatum);
    }
}
