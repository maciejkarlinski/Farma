package application;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Admin zablokuj odblokuj.
 */
public class AdminZablokujOdblokuj implements Initializable {
    /**
     * The Text field.
     */
    public TextField textField;
    /**
     * The Zablokuj button.
     */
    public Button ZablokujButton;
    /**
     * The Odblokuj button.
     */
    public Button odblokujButton;
    /**
     * The Wroc button.
     */
    public Button wrocButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Otwarto okno Zablokuj/Odblokuj");
    }

    /**
     * Zablokuj button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void zablokujButtonClick(ActionEvent actionEvent) throws IOException {
        String email = textField.getText();

        if (email.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moge byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            textField.clear();

        } else{
            try {
            String x = MainApp.client.zablokuj(email);
        if (x.equalsIgnoreCase("Konto uaktualnione")) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Konto uaktualnione");
            alert.setHeaderText("Konto uaktualnione");
            alert.setContentText("Konto Zablokowane");
            alert.showAndWait();
            textField.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Konto nie uaktualnione");
            alert.setHeaderText("Konto nie  uaktualnione");
            alert.setContentText("Blad przy blokowaniu konta");
            alert.showAndWait();
            textField.clear();
        }
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Bledne id zamowienia");
                alert.setContentText("Wprowadz dane ponownie");
                alert.showAndWait();
                textField.clear();
            }
    }

}

    /**
     * Odblokuj.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void odblokuj(ActionEvent actionEvent) throws IOException {
        String email = textField.getText();
        if (email.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moge byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            textField.clear();

        } else {
            String x = MainApp.client.odblokuj(email);
            if (x.equalsIgnoreCase("Konto uaktualnione")) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Konto uaktualnione");
                alert.setHeaderText("Konto uaktualnione");
                alert.setContentText("Konto odblokowane");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Konto nie uaktualnione");
                alert.setHeaderText("Konto nie  uaktualnione");
                alert.setContentText("Blad przy oblokowaniu konta");
                alert.showAndWait();
            }
        }
    }

    /**
     * Wroc button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void wrocButtonClick(ActionEvent actionEvent) throws IOException{
        ScreenController control = new ScreenController(this.wrocButton);
        control.switchScene("AdminMain.fxml");
    }
}
