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
 * The type Admin main.
 */
public class AdminMain implements Initializable {

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
     * The Dodaj dostawce field.
     */
    @FXML
    public Button dodajDostawceField;
    /**
     * The Wyswietl dostawcow field.
     */
    @FXML
    public Button wyswietlDostawcowField;
    /**
     * The Usun dostawce field.
     */
    @FXML
    public Button usunDostawceField;
    /**
     * The Wyswietl pracownikow field.
     */
    @FXML
    public Button wyswietlPracownikowField;
    /**
     * The Usun pracownika field.
     */
    @FXML
    public Button usunPracownikaField;
    /**
     * The Zmiana wyplaty field.
     */
    @FXML
    public Button zmianaWyplatyField;
    /**
     * The Dodaj pracownika field.
     */
    @FXML
    public Button dodajPracownikaField;
    /**
     * The Edycja zamowien field.
     */
    @FXML
    public Button edycjaZamowienField;
    /**
     * The Anuluj zamowienia field.
     */
    @FXML
    public Button anulujZamowieniaField;
    /**
     * The Wyswietl zamowienia field.
     */
    @FXML
    public Button wyswietlZamowieniaField;
    /**
     * The Odblokuj konto field.
     */
    @FXML
    public Button odblokujKontoField;
    /**
     * The Zablokuj konto field.
     */
    @FXML
    public Button zablokujKontoField;
    /**
     * The Wyswietl label.
     */
    @FXML
    public Label wyswietlLabel;
    /**
     * The Szczegoly zamowienia.
     */
    @FXML
    public Button szczegolyZamowienia;
    /**
     * The Wyswietl klientow button.
     */
    @FXML
    public Button wyswietlKlientowButton;

    /**
     * Zmiana hasla button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void ZmianaHaslaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminZmianaHasla.fxml");
    }

    /**
     * Wyloguj button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void WylogujButtonClick(ActionEvent actionEvent) throws IOException {
        Parent tableview= FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
        MainApp.client.logoff();

    }

    /**
     * Szczegoly zamowienia click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void szczegolyZamowieniaClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.szczegolyZamowienia);
        control.switchScene("AdminSzczegolyZamowienia.fxml");
    }

    /**
     * Dodaj dostawce click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void DodajDostawceClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminDodajDostawce.fxml");
    }

    /**
     * Wyswietl dostawce button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void WyswietlDostawceButtonClick(ActionEvent actionEvent) throws IOException { //TODO sprawdzic czy dziala
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminWyswietlDostawce.fxml");
    }

    /**
     * Usun dostawce button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void UsunDostawceButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminUsunDostawce.fxml");
    }

    /**
     * Wyswietl pracownika button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void WyswietlPracownikaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminWyswietlPracownikow.fxml");
    }

    /**
     * Usun pracownika click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void UsunPracownikaClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminUsunPracownika.fxml");
    }

    /**
     * Wyswietl klientow button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void wyswietlKlientowButtonClick(ActionEvent actionEvent) throws IOException{
        ScreenController control = new ScreenController(this.wyswietlKlientowButton);
        control.switchScene("AdminWyswietlKlientow.fxml");
    }

    /**
     * Zmiana wyplaty pracownika button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void ZmianaWyplatyPracownikaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminZmienWyplate.fxml");

    }

    /**
     * Dodaj pracownika button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void DodajPracownikaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminDodajPracownika.fxml");
    }

    /**
     * Edycja zamowienia button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void EdycjaZamowieniaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminZmianaZamowienia.fxml");
    }

    /**
     * Anuluj zamowienia button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void AnulujZamowieniaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminAnulujZamowienia.fxml");
    }

    /**
     * Wyswietl zamowienia button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void WyswietlZamowieniaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminWyswietlZamowienia.fxml");
    }

    /**
     * Odblokuj konta button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void OdblokujKontaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminZablokujOdblokuj.fxml");
    }

    /**
     * Zablokuj konta button click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void ZablokujKontaButtonClick(ActionEvent actionEvent) throws IOException {
        ScreenController control = new ScreenController(this.wyswietlKontaField);
        control.switchScene("AdminZablokujOdblokuj.fxml");
    }

    /**
     * Wyswietl konta button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void WyswietlKontaButtonClick(ActionEvent event) throws IOException, InterruptedException {
       ScreenController control = new ScreenController(this.wyswietlKontaField);
       control.switchScene("AdminWyswietlKonta.fxml");

    }


    @Override
    public void initialize (URL location, ResourceBundle resources){
        System.out.println("Otwarto okno admina");
    }
}