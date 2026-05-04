package org.example.view;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import org.example.model.Eksperiment;

public class IstrazivacView extends BorderPane {

    private TableView<Eksperiment> tvEksperimenti;

    // Polja za EKSPERIMENT i TEORIJA
    private TextField tfNazivEksperimenta, tfTeorijaNaziv, tfTeorijaID_Podaci;
    private TextArea taCiljevi;

    // Polja za BIOLOŠKI RESURS i TAKSONOMIJU
    private TextField tfResursNaziv, tfLatinskiVrsta, tfNarodniVrsta, tfLatinskiRod;

    private Button btnSnimiSve, btnObrisiSesiju;

    public IstrazivacView() {
        initElements();
        addElements();
    }

    private void initElements() {
        tvEksperimenti = new TableView<>();

        TableColumn<Eksperiment, String> colNaziv = new TableColumn<>("Naziv");
        colNaziv.setCellValueFactory(cd -> cd.getValue().nazivProperty());

        TableColumn<Eksperiment, String> colTeorija = new TableColumn<>("Teorija");
        colTeorija.setCellValueFactory(cd -> cd.getValue().teorijaNazivProperty());

        tvEksperimenti.getColumns().add(colNaziv);
        tvEksperimenti.getColumns().add(colTeorija);

        // Inicijalizacija polja za unos prema šemi
        tfNazivEksperimenta = new TextField();
        taCiljevi = new TextArea(); taCiljevi.setPrefRowCount(2);

        tfTeorijaNaziv = new TextField();
        tfTeorijaID_Podaci = new TextField(); // IdentifikacioniPodaci iz tabele TEORIJA

        tfResursNaziv = new TextField();
        tfLatinskiVrsta = new TextField(); // Za tabelu VRSTA
        tfLatinskiRod = new TextField();   // Za tabelu ROD

        btnSnimiSve = new Button("DODAJ EKSPERIMENT I RESURSE");
        btnSnimiSve.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white;");

        btnObrisiSesiju = new Button("Obriši Sesiju");
    }

    private void addElements() {
        VBox forma = new VBox(10);
        forma.setPadding(new Insets(15));
        forma.setPrefWidth(350);
        forma.setStyle("-fx-background-color: #ecf0f1;");

        // Grupisanje unosa
        forma.getChildren().addAll(
                new Label("1. EKSPERIMENT & TEORIJA"),
                new Label("Naziv:"), tfNazivEksperimenta,
                new Label("Ciljevi:"), taCiljevi,
                new Label("Teorija:"), tfTeorijaNaziv,
                new Separator(),
                new Label("2. BIOLOŠKI RESURS (TAKSONOMIJA)"),
                new Label("Naziv resursa:"), tfResursNaziv,
                new Label("Latinski naziv vrste:"), tfLatinskiVrsta,
                new Label("Latinski naziv roda:"), tfLatinskiRod,
                new Separator(),
                btnSnimiSve
        );

        VBox desno = new VBox(10, new Label("Lista eksperimenata"), tvEksperimenti, btnObrisiSesiju);
        desno.setPadding(new Insets(15));
        HBox.setHgrow(tvEksperimenti, Priority.ALWAYS);

        this.setLeft(forma);
        this.setCenter(desno);
    }

    // Getteri za kontroler
    public TextField getTfNazivEksperimenta() { return tfNazivEksperimenta; }
    public TextField getTfTeorijaNaziv() { return tfTeorijaNaziv; }
    public Button getBtnSnimiSve() { return btnSnimiSve; }
    public TableView<Eksperiment> getTvEksperimenti() { return tvEksperimenti; }
}