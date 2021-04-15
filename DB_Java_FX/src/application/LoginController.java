package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

/**
 * The type Login controller.
 */
public class LoginController implements Initializable{

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;

   @FXML
    private Button loginButton;

    @FXML
    private Hyperlink registerHyperlink;

    /**
     * Login button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void loginButtonClick(ActionEvent event) throws IOException, InterruptedException {

        String email;
        String haslo;
        String stanowisko;
        
        email=emailField.getText();
        haslo=passwordField.getText();

        if (!MainApp.client.connect()) {
            System.err.println("Polaczenie zakonczone niepowodzeniem");
        }else {
            System.out.println("Polaczenie zakonczone powodzeniem");
            if (email.equals("") || haslo.equals("")) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Email/haslo nie moze byc puste");
                alert.setContentText("Wprowadz dane");
                alert.showAndWait();

                emailField.clear();
                passwordField.clear();
            } else {
                if ("Zalogowano".equalsIgnoreCase(MainApp.client.login(email, haslo))) {

                    System.out.println("Zalogowano");

                    MainApp.uzytkownik.email = email;
                    MainApp.uzytkownik.password = haslo;
                    stanowisko = MainApp.client.getStanowisko(email);
                    System.out.println("Email: " + MainApp.uzytkownik.email);
                    System.out.println("Haslo: " + MainApp.uzytkownik.password);
                    if (stanowisko.equalsIgnoreCase("klient")) {
                        ScreenController control = new ScreenController(this.loginButton);
                        control.switchScene("KlientMain.fxml");
                    } else if (stanowisko.equalsIgnoreCase("admin")) {
                        ScreenController control = new ScreenController(this.loginButton);
                        control.switchScene("AdminMain.fxml");

                    } else if (stanowisko.equalsIgnoreCase("pracownik_biurowy")) {
                        ScreenController control = new ScreenController(this.loginButton);
                        control.switchScene("OfficeMain.fxml");
                    } else if (stanowisko.equalsIgnoreCase("pracownik_magazynu")) {
                        ScreenController control = new ScreenController(this.loginButton);
                        control.switchScene("StoreMain.fxml");
                    } else if (stanowisko.equalsIgnoreCase("pracownik_produkcji")) {
                        ScreenController control = new ScreenController(this.loginButton);
                        control.switchScene("ProdukcjaMain.fxml");
                    }

                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Blad poczas logowania");
                    alert.setHeaderText("Zly email/haslo");
                    alert.setContentText("Wprowadz jeszcze raz");
                    alert.showAndWait();

                    emailField.clear();
                    passwordField.clear();
                }
            }
        }
        }


    /**
     * Register hyperlink click.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void registerHyperlinkClick(ActionEvent event) throws IOException {
        ScreenController control = new ScreenController(this.registerHyperlink);
        control.switchScene("RegisterPanel.fxml");
    }

    /**
     * Recovery hyperlink click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void recoveryHyperlinkClick(ActionEvent actionEvent) throws IOException{
        ScreenController control = new ScreenController(this.registerHyperlink);
        control.switchScene("RecoverPasswordPanel.fxml");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Otwarto okno logowania");
    }


}


