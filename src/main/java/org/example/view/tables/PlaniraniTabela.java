package org.example.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.model.PlaniraniDto;

import javafx.scene.control.TableView;

import java.util.Date;
import java.util.List;

public class PlaniraniTabela extends TableView<PlaniraniDto> {

    public PlaniraniTabela(List<PlaniraniDto> planiraniDtos) {
        super(FXCollections.observableArrayList(planiraniDtos));

        TableColumn<PlaniraniDto, String> tcNaziv = new TableColumn<>("Naziv Eksperimanta");
        TableColumn<PlaniraniDto, String> tcStatus = new TableColumn<>("Status Eksperimanta");
        TableColumn<PlaniraniDto, Date> tcDatum = new TableColumn<>("Datum Eksperimanta");

        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("eksperimentNaziv"));
        tcStatus.setCellValueFactory(new PropertyValueFactory<>("izvodjenjeStatus"));
        tcDatum.setCellValueFactory(new PropertyValueFactory<>("date"));
        super.getColumns().addAll(tcNaziv, tcStatus, tcDatum);
    }
}
