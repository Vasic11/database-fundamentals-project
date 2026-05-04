package org.example.model;

import javafx.beans.property.*;

public class Eksperiment {
    private final IntegerProperty id;
    private final StringProperty naziv;
    private final StringProperty ciljevi;
    private final StringProperty teorijaNaziv; // Iz tabele TEORIJA

    public Eksperiment(int id, String naziv, String ciljevi, String teorijaNaziv) {
        this.id = new SimpleIntegerProperty(id);
        this.naziv = new SimpleStringProperty(naziv);
        this.ciljevi = new SimpleStringProperty(ciljevi);
        this.teorijaNaziv = new SimpleStringProperty(teorijaNaziv);
    }

    // Propertiji za TableView
    public StringProperty nazivProperty() { return naziv; }
    public StringProperty ciljeviProperty() { return ciljevi; }
    public StringProperty teorijaNazivProperty() { return teorijaNaziv; }

    public int getId() { return id.get(); }
}