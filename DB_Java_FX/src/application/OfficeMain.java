package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Office main.
 */
public class OfficeMain implements Initializable {
    /**
     * Wyswietl faktury button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void WyswietlFakturyButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeWyswietlFaktury.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Wystaw fakture button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void WystawFaktureButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeWystawFakture.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Wyswietl leki button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void WyswietlLekiButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeWyswietlLeki.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Dodaj lek button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void DodajLekButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeDodajLek.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Usun lek button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void UsunLekButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeUsun.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Wyswietl oferty button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void WyswietlOfertyButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeWyswietlOferte.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Dodaj oferte button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void DodajOferteButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeDodajOferte.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Usun oferte button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void UsunOferteButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeUsun.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Wyswietl surowce button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void WyswietlSurowceButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeWyswietlSurowce.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Dodaj surowiec button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void DodajSurowiecButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeDodajSurowiec.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Usun surowiec button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void UsunSurowiecButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeUsun.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Zmien haslo office button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void ZmienHasloOfficeButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeZmianaHasla.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    /**
     * Wyloguj office button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void WylogujOfficeButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
        MainApp.client.logoff();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Otwarto okno biura");
    }
}
