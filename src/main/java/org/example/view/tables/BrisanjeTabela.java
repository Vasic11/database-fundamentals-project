package org.example.view.tables;

import javafx.collections.FXCollections;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.model.BrisanjeDto;

import javafx.scene.control.TableView;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public class BrisanjeTabela extends TableView<BrisanjeDto> {
    public BrisanjeTabela(List<BrisanjeDto> brisanjeDtos) {
        super(FXCollections.observableArrayList(brisanjeDtos));

        TableColumn<BrisanjeDto, String> tcNaziv = new TableColumn<>("Naziv eksperimanta");
        TableColumn<BrisanjeDto, String> tcLabNaziv = new TableColumn<>("Laboratorija naziv");
        TableColumn<BrisanjeDto, Date> tcDatumSesije = new TableColumn<>("Datum sesije");
        TableColumn<BrisanjeDto, Time> tcDatumPocetka = new TableColumn<>("Vreme pocetka sesije");
        TableColumn<BrisanjeDto, Time> tcDatumZavrsetka = new TableColumn<>("Vreme zavrsetka sesije");

        tcNaziv.setCellValueFactory(new PropertyValueFactory<>("nazivEksperimenta"));
        tcLabNaziv.setCellValueFactory(new PropertyValueFactory<>("nazivLab"));
        tcDatumSesije.setCellValueFactory(new PropertyValueFactory<>("datumSesije"));
        tcDatumPocetka.setCellValueFactory(new PropertyValueFactory<>("vremePocetkaSesije"));
        tcDatumZavrsetka.setCellValueFactory(new PropertyValueFactory<>("vremeZavrsetkaSesije"));
        super.getColumns().addAll(tcNaziv, tcLabNaziv, tcDatumSesije,tcDatumPocetka,tcDatumZavrsetka);
    }
}
