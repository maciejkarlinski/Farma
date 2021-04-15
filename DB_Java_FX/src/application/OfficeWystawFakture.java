package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * The type Office wystaw fakture.
 */
public class OfficeWystawFakture implements Initializable {

    /**
     * The Numer field.
     */
    @FXML
    public TextField numerField;

    /**
     * The Choice box.
     */
    @FXML
    public ComboBox<String> choiceBox;

    /**
     * The Choice box 1.
     */
    @FXML
    public ChoiceBox<String> choiceBox1;

    /**
     * Wystaw fakture button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void WystawFaktureButtonClick(ActionEvent event) throws IOException, InterruptedException {
        String klient=choiceBox.getValue();
        String numer=numerField.getText();
        String idklienta[]=null;
        String idzamowienia=choiceBox1.getValue();
        if (numer.equals("")||klient==null||idzamowienia==null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            numerField.clear();
        } else {
            try{
                idzamowienia=idzamowienia.replaceAll(" ","");
                idklienta=klient.split(" ");
                Integer.parseInt(idklienta[0]);
                Integer.parseInt(idzamowienia);
                String wynik = MainApp.client.wystawFakture(numer, idklienta[0], idzamowienia);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Komunikat");
                alert.setHeaderText(wynik);
                alert.showAndWait();
                numerField.clear();
            }catch (Exception e){
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Niepoprawny typ danych");
                alert.setContentText("Wprowadz dane ponownie");
                alert.showAndWait();

                numerField.clear();
            }
        }
    }

    /**
     * Powrot button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void PowrotButtonClick(ActionEvent event) throws IOException, InterruptedException {
        Parent tableview= FXMLLoader.load(getClass().getResource("OfficeMain.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> availableChoices= null;
        try {
            availableChoices = FXCollections.observableArrayList(MainApp.client.wyswietlLista1("Klientdolisty"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        choiceBox.setItems(availableChoices);



        choiceBox.setOnAction(e->{//inicjalizacja choicebox gramatura
            ObservableList<String> availableChoices1= null;
            try {
                String s[]=choiceBox.getValue().split(" ");
                availableChoices1 = FXCollections.observableArrayList(MainApp.client.wyswietldanedoListy("Zamowienie",s[0]));
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            choiceBox1.setItems(availableChoices1);
            if(availableChoices1.size()==0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Komunikat");
                alert.setHeaderText("Wybrany klient nie ma aktualnie zadnych zamowien");
                alert.showAndWait();
            }
        });
    }
}
