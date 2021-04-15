package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type Produkcja main.
 */
public class ProdukcjaMain implements Initializable {

    /**
     * The Wyswietl konta field.
     */
    @FXML
    public Button wyswietlKontaField;
    /**
     * The Zmien haslo field.
     */
    @FXML
    public Button zmienHasloField;
    /**
     * The Wyloguj field.
     */
    @FXML
    public Button wylogujField;
    /**
     * The Edycja zamowien field.
     */
    @FXML
    public Button edycjaZamowienField;
    /**
     * The Wyswietl zamowienia field.
     */
    @FXML
    public Button wyswietlZamowieniaField;


    /**
     * Zmiana hasla button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void ZmianaHaslaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.zmienHasloField);
        control.switchScene("ProdukcjaZmianaHasla.fxml");
    }

    /**
     * Wyloguj button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML//TODO ogarnac
    public void WylogujButtonClick(ActionEvent actionEvent) throws IOException {
        Parent tableview= FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
        MainApp.client.logoff();

    }

    /**
     * Edycja zamowienia button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void EdycjaZamowieniaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.edycjaZamowienField);
        control.switchScene("ProdukcjaZmianaZamowienia.fxml");
    }

    /**
     * Wyswietl zamowienia button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void WyswietlZamowieniaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlZamowieniaField);
        control.switchScene("ProdukcjaWyswietlZamowienia.fxml");
    }



    @Override
    public void initialize (URL location, ResourceBundle resources){
        System.out.println("Otwarto okno admina");
    }
}