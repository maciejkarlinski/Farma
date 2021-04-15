package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type Admin szczegoly zamowienia.
 */
public class AdminSzczegolyZamowienia implements Initializable {


    /**
     * The Button zatwierdz.
     */
    @FXML
    public Button buttonZatwierdz;
    /**
     * The Wroc.
     */
    @FXML
    public Button wroc;
    /**
     * The Tabela.
     */
    @FXML
    public TableView tabela;
    /**
     * The Zamowienie column.
     */
    @FXML
    public TableColumn ZamowienieColumn;
    /**
     * The Klient column.
     */
    @FXML
    public TableColumn klientColumn;
    /**
     * The Waga column.
     */
    @FXML
    public TableColumn wagaColumn;
    /**
     * The Zloenie column.
     */
    @FXML
    public TableColumn zloenieColumn;
    /**
     * The Realizacjia column.
     */
    @FXML
    public TableColumn realizacjiaColumn;
    /**
     * The Stan column.
     */
    @FXML
    public TableColumn stanColumn;
    /**
     * The Column ilosc.
     */
    @FXML
    public TableColumn columnIlosc;
    /**
     * The Column koszt.
     */
    @FXML
    public TableColumn columnKoszt;
    /**
     * The Column nazwa.
     */
    @FXML
    public TableColumn columnNazwa;
    /**
     * The Column gramatura.
     */
    @FXML
    public TableColumn columnGramatura;
    /**
     * The Idzamowienia field.
     */
    @FXML
    public TextField idzamowieniaField;



    @Override
    public void initialize (URL location, ResourceBundle resources){
        System.out.println("Otwarto okno Wyswietlania Dostawce");
    }

    /**
     * Button zatwierdz click.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void buttonZatwierdzClick(ActionEvent actionEvent) throws IOException {
        String idzamowienia = idzamowieniaField.getText();
        if (idzamowienia.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();
            idzamowieniaField.clear();

        } else {
                String zam = MainApp.client.szczegoloweZamowienie(idzamowienia);
            if(zam.equalsIgnoreCase("Blad")) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Podano bledne dane ");
                alert.setHeaderText("Podano bledne dane");
                alert.setContentText("Podano bledne dane");
                alert.showAndWait();
                idzamowieniaField.clear();
            }else {


                tabela.setItems(getZamowienie(zam));
                ZamowienieColumn.setCellValueFactory(new PropertyValueFactory<>("idzamowienia"));
                klientColumn.setCellValueFactory(new PropertyValueFactory<>("idklienta"));
                wagaColumn.setCellValueFactory(new PropertyValueFactory<>("waga"));
                zloenieColumn.setCellValueFactory(new PropertyValueFactory<>("dataz"));
                realizacjiaColumn.setCellValueFactory(new PropertyValueFactory<>("datar"));
                stanColumn.setCellValueFactory(new PropertyValueFactory<>("stan"));
                columnIlosc.setCellValueFactory(new PropertyValueFactory<>("ilosc"));
                columnKoszt.setCellValueFactory(new PropertyValueFactory<>("koszt"));
                columnNazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
                columnGramatura.setCellValueFactory(new PropertyValueFactory<>("gramatura"));
            }


        }
    }

    /**
     * Wroc.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void wroc(ActionEvent actionEvent) throws IOException{
        ScreenController control = new ScreenController(this.wroc);
        control.switchScene("AdminMain.fxml");
    }

    /**
     * Gets zamowienie.
     *
     * @param temp the temp
     * @return the zamowienie
     */
    public ObservableList<SzczegolyZamowieniaFX> getZamowienie(String temp) {
        ObservableList<SzczegolyZamowieniaFX> zam= FXCollections.observableArrayList();
        String[] tokens = StringUtils.split(temp);
        zam.add(new SzczegolyZamowieniaFX(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6],tokens[7],tokens[8],tokens[9]));
        return zam;
    }


}
