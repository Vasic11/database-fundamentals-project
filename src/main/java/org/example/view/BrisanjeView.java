package org.example.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BrisanjeView extends GridPane {

    private TableView<Object> tabelaSesija;
    private Button btnObrisi;
    private Button btnBack;
    private Label lblInfo;

    public BrisanjeView() {
        // Podešavanje layout-a
        this.setPadding(new Insets(20));
        this.setHgap(15);
        this.setVgap(15);
        this.setAlignment(Pos.CENTER);

        // 1. Naslov forme
        Label lblNaslov = new Label("Brisanje zakazane sesije");
        lblNaslov.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        this.add(lblNaslov, 0, 0, 2, 1);

        // 2. Tabela sa sesijama
        tabelaSesija = new TableView<>();

        // Kolone prema tekstu zadatka
        TableColumn<Object, String> colEksperiment = new TableColumn<>("Eksperiment");
        TableColumn<Object, String> colLaboratorija = new TableColumn<>("Laboratorija");
        TableColumn<Object, String> colDatum = new TableColumn<>("Datum");
        TableColumn<Object, String> colPocetak = new TableColumn<>("Početak");
        TableColumn<Object, String> colKraj = new TableColumn<>("Kraj");

        // Postavljanje širina (opciono)
        colEksperiment.setPrefWidth(150);
        colDatum.setPrefWidth(100);

        tabelaSesija.getColumns().addAll(colEksperiment, colLaboratorija, colDatum, colPocetak, colKraj);
        tabelaSesija.setPlaceholder(new Label("Nema zakazanih sesija za prikaz."));

        // Dodavanje tabele u grid
        this.add(tabelaSesija, 0, 1, 2, 1);

        // 3. Info labela (za poruke o grešci ili upozorenja)
        lblInfo = new Label("Napomena: Možete brisati samo sesije u kojima učestvujete.");
        lblInfo.setStyle("-fx-text-fill: gray; -fx-font-style: italic;");
        this.add(lblInfo, 0, 2, 2, 1);

        // 4. Dugmići
        btnObrisi = new Button("Obriši selektovanu sesiju");
        btnObrisi.setStyle("-fx-background-color: #d9534f; -fx-text-fill: white; -fx-font-weight: bold;");

        btnBack = new Button("← Nazad");

        // Raspored dugmića
        VBox desniLayout = new VBox(10, btnObrisi, btnBack);
        desniLayout.setAlignment(Pos.TOP_RIGHT);
        this.add(desniLayout, 1, 2);
    }

    // Getteri za Controller
    public TableView<Object> getTabelaSesija() {
        return tabelaSesija;
    }

    public Button getBtnObrisi() {
        return btnObrisi;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public Label getLblInfo() {
        return lblInfo;
    }
}