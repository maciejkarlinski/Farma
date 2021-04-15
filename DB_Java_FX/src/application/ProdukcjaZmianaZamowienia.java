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
 * The type Produkcja zmiana zamowienia.
 */
public class ProdukcjaZmianaZamowienia implements Initializable {
    /**
     * The Wroc button.
     */
    @FXML
    public Button wrocButton;
    /**
     * The Zmien status zamowienia button click.
     */
    @FXML
    public Button zmienStatusZamowieniaButtonClick;
    /**
     * The Data text field.
     */
    @FXML
    public TextField dataTextField;
    /**
     * The Id zamowienia text field.
     */
    @FXML
    public TextField IdZamowieniaTextField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Otwarto okno Zmiany Daty Realizacji");

    }

    /**
     * Wroc button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void wrocButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wrocButton);
        control.switchScene("ProdukcjaMain.fxml");
    }

    /**
     * Zmien status zamowienia button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void zmienStatusZamowieniaButtonClick(ActionEvent actionEvent) throws IOException {
        String data = dataTextField.getText();
        String idZamowienia = IdZamowieniaTextField.getText();
        int i;
        if (data.equals("") || idZamowienia.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            dataTextField.clear();
            IdZamowieniaTextField.clear();
        } else if (data.equals("nowe") || data.equals("oczekujace") || data.equals("w realizacji") || data.equals("zrealizowane") || data.equals("zakonczone")) {

            if (data.equalsIgnoreCase("nowe")) {
                i = 0;
            } else if (data.equalsIgnoreCase("oczekujace")) {
                i = 1;

            } else if (data.equalsIgnoreCase("w realizacji")) {
                i = 2;

            } else if (data.equalsIgnoreCase("zrealizowane")) {
                i = 3;

            } else if (data.equalsIgnoreCase("zakonczone")) {
                i = 4;
            } else {
                i = 5;
            }
            System.out.println(i);
            String response = MainApp.client.zmienStanRealizacjiZamowienia(idZamowienia, i);
            if (response.equalsIgnoreCase("Tak")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Stan realizacji zmieniony");
                alert.setHeaderText("Stan realizacji zmieniony");
                alert.setContentText("Stan realizacji zmieniony");
                alert.showAndWait();
            } else if (response.equalsIgnoreCase("Nie ma")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Nie ma takiego zamowienia");
                alert.setHeaderText("Nie ma takiego zamowienia");
                alert.setContentText("Nie ma takiego zamowienia");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Blad przy zmianie stanu zamowienia");
                alert.setHeaderText("Blad przy zmianie stanu zamowienia");
                alert.setContentText("Blad przy zmianie stanu zamowienia");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Wpisales zly stan zamowienia");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            dataTextField.clear();
        }


    }
}
