package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Office zmiana hasla.
 */
public class OfficeZmianaHasla implements Initializable {
    /**
     * The Pass text field.
     */
    @FXML
    public TextField passTextField;
    /**
     * The Wroc button.
     */
    @FXML
    public Button wrocButton;
    /**
     * The Zmienhaslo button.
     */
    @FXML
    public Button zmienhasloButton;
    /**
     * The Confpass text field.
     */
    public TextField confpassTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Otwarto okno Zablokuj/Odblokuj");
    }

    /**
     * Wroc button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void wrocButtonClick(ActionEvent actionEvent)  throws IOException {
        ScreenController control = new ScreenController(this.wrocButton);
        control.switchScene("OfficeMain.fxml");
    }

    /**
     * Zmienhaslo button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void zmienhasloButtonClick(ActionEvent actionEvent) throws IOException {
        String password = passTextField.getText();
        String confirmPassword = confpassTextField.getText();
        if (password.equals("") ||confirmPassword.equals("") ) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moge byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            passTextField.clear();
            confpassTextField.clear();

        } else{
            if (!password.equals(confirmPassword)) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Hasla musza byc takie same");
                alert.setContentText("Wprowadz haslo jeszcze raz");
                alert.showAndWait();

                passTextField.clear();
                confpassTextField.clear();
            } else {
                String response = MainApp.client.zmienhaslo(MainApp.uzytkownik.email, password);
                if (response.equalsIgnoreCase("Tak")) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Haslo zmienione");
                    alert.setHeaderText("Haslo zmienione");
                    alert.setContentText("Haslo zmienione");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Blad przy zmianie hasla");
                    alert.setHeaderText("Blad przy zmianie hasla");
                    alert.setContentText("Blad przy zmianie hasla");
                    alert.showAndWait();
                }
            }
        }
    }
}
