package org.example.view;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class SignUpView extends GridPane {
    private Label lbUserName,lbRole,lbPassworf, lbPassword2;
    private TextField tfUserName;
    private PasswordField pfPassworf,pfPassword2;
    private ComboBox<String> cbRole;
    private Button create,back;




    public SignUpView() {
        initElements();
        addElemets();

    }

    private void addElemets() {
        this.addColumn(0,lbUserName,lbPassworf,lbPassword2,create);
        this.addColumn(1,tfUserName,pfPassworf,pfPassword2,back);
        this.setVgap(10);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);


    }

    private void initElements() {
        lbUserName = new Label("Username");
        lbPassworf = new Label("Password");
        lbPassword2 = new Label("Confirm Password");
        tfUserName = new TextField();
        pfPassworf = new PasswordField();
        pfPassword2 = new PasswordField();
        create = new Button("Create");
        back = new Button("Back");

    }

    public TextField getTfUserName() {
        return tfUserName;
    }

    public void setTfUserName(TextField tfUserName) {
        this.tfUserName = tfUserName;
    }

    public PasswordField getPfPassworf() {
        return pfPassworf;
    }

    public void setPfPassworf(PasswordField pfPassworf) {
        this.pfPassworf = pfPassworf;
    }

    public PasswordField getPfPassword2() {
        return pfPassword2;
    }

    public void setPfPassword2(PasswordField pfPassword2) {
        this.pfPassword2 = pfPassword2;
    }

    public Button getCreate() {
        return create;
    }

    public void setCreate(Button create) {
        this.create = create;
    }

    public ComboBox<String> getCbRole() {
        return cbRole;
    }

    public void setCbRole(ComboBox<String> cbRole) {
        this.cbRole = cbRole;
    }

    public Button getBack() {
        return back;
    }

    public void setBack(Button back) {
        this.back = back;
    }
}
