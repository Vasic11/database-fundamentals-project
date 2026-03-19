package org.example.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class LogInView extends GridPane {
    private Label lbUserName,lbPassworf;
    private TextField tfUserName;
    private PasswordField pfPassworf;
    private Button btLogIn;
    private Button btSignUp;

    
    
    
    public LogInView() {
        initElements();
        addElemets();
        
    }

    private void addElemets() {
        this.addColumn(0,lbUserName,lbPassworf,btLogIn);
        this.addColumn(1,tfUserName,pfPassworf,btSignUp);
        this.setVgap(10);
        this.setHgap(10);
        this.setAlignment(Pos.CENTER);


    }

    private void initElements() {
        lbUserName = new Label("Username");
        lbPassworf = new Label("Password");
        tfUserName = new TextField();
        pfPassworf = new PasswordField();
        btLogIn = new Button("LogIn");
        btSignUp = new Button("SignUp");

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

    public Button getBtLogIn() {
        return btLogIn;
    }

    public void setBtLogIn(Button btLogIn) {
        this.btLogIn = btLogIn;
    }

    public Button getBtSignUp() {
        return btSignUp;
    }

    public void setBtSignUp(Button btSignUp) {
        this.btSignUp = btSignUp;
    }
}
