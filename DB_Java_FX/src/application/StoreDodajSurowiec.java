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
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The type Store dodaj surowiec.
 */
public class StoreDodajSurowiec implements Initializable {

    /**
     * The Nazwa field.
     */
    @FXML
    public TextField nazwaField;

    /**
     * The Data field.
     */
    @FXML
    public TextField dataField;

    /**
     * The Choice box.
     */
    @FXML
    public ChoiceBox<String> choiceBox;

    /**
     * Doda surowiec button click.
     *
     * @param event the event
     * @throws IOException          the io exception
     * @throws InterruptedException the interrupted exception
     */
    @FXML
    void DodaSurowiecButtonClick(ActionEvent event) throws IOException, InterruptedException {
        String nazwa = nazwaField.getText();
        String data = dataField.getText();
        String dostawca = choiceBox.getValue();
        if (nazwa.equals("")||dostawca==null||data.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            nazwaField.clear();
            dataField.clear();
        } else {
            try{
                DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
                Date date = format.parse(data);
                String wynik = MainApp.client.dodajSurowiec(nazwa, dostawca, data);

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Komunikat");
                alert.setHeaderText(wynik);
                alert.showAndWait();
                nazwaField.clear();
                dataField.clear();
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Niepoprawny typ danych");
                alert.setContentText("Wprowadz dane ponownie!");
                alert.showAndWait();
                nazwaField.clear();
                dataField.clear();
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
        Parent tableview= FXMLLoader.load(getClass().getResource("StoreMain.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> availableChoices= null;
        try {
            availableChoices = FXCollections.observableArrayList(MainApp.client.wyswietlLista1("Dostawcadolisty"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        choiceBox.setItems(availableChoices);

        System.out.println("Otwarto okno biura");
    }
}
