package application;

import javafx.fxml.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import javafx.scene.*;
import javafx.event.*;
import javafx.collections.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.apache.commons.lang.StringUtils;
import java.util.ArrayList;


/**
 * The type Klient main.
 */
public class KlientMain implements Initializable {

    @FXML
    private TextField changePasswordField;

    @FXML
    private Button buttonConfirmPassword;
    /**
     * The Table oferty.
     */
    @FXML
    public TableView<OfertyFX> tableOferty;
    /**
     * The Table id oferty.
     */
    @FXML
    public TableColumn<OfertyFX, String> tableIdOferty;
    /**
     * The Table id leku.
     */
    @FXML
    public TableColumn<OfertyFX, String> tableIdLeku;
    /**
     * The Table cena.
     */
    @FXML
    public TableColumn<OfertyFX, String> tableCena;
    /**
     * The Column nazwa of.
     */
    @FXML
    public TableColumn<OfertyFX, String> columnNazwaOf;
    /**
     * The Button oferty.
     */
    @FXML
    public Button buttonOferty;
    /**
     * The Idleku field.
     */
    @FXML
    public TextField idlekuField;
    /**
     * The Button lek.
     */
    @FXML
    public Button buttonLek;
    /**
     * The Table lek.
     */
    @FXML
    public TableView<LekFx> tableLek;
    /**
     * The Table id lek.
     */
    @FXML
    public TableColumn<LekFx, String> tableIdLek;
    /**
     * The Table nazwa.
     */
    @FXML
    public TableColumn<LekFx, String> tableNazwa;
    /**
     * The Table gramatura.
     */
    @FXML
    public TableColumn<LekFx, String> tableGramatura;
    /**
     * The Table zamowienie.
     */
    @FXML
    public TableView<ZamowieniaKlientaFx> tableZamowienie;
    /**
     * The Table id zamowienia.
     */
    @FXML
    public TableColumn<ZamowieniaKlientaFx, String> tableIdZamowienia;
    /**
     * The Table id klienta.
     */
    @FXML
    public TableColumn<ZamowieniaKlientaFx,String> tableIdKlienta;
    /**
     * The Table id koszyka.
     */
    @FXML
    public TableColumn<ZamowieniaKlientaFx,String> tableIdKoszyka;
    /**
     * The Table waga.
     */
    @FXML
    public TableColumn<ZamowieniaKlientaFx,String> tableWaga;
    /**
     * The Table data z.
     */
    @FXML
    public TableColumn<ZamowieniaKlientaFx,String> tableDataZ;
    /**
     * The Table data r.
     */
    @FXML
    public TableColumn<ZamowieniaKlientaFx,String> tableDataR;
    /**
     * The Table stan.
     */
    @FXML
    public TableColumn<ZamowieniaKlientaFx,String> tableStan;
    /**
     * The Button zamowienie.
     */
    @FXML
    public Button buttonZamowienie;
    /**
     * The Koszyk id oferty field.
     */
    @FXML
    TextField koszykIdOfertyField;
    /**
     * The Koszyk ilosc field.
     */
    @FXML
    TextField koszykIloscField;
    /**
     * The Button dodaj.
     */
    @FXML
    Button buttonDodaj;
    /**
     * The Button loggout.
     */
    @FXML
    Button buttonLoggout;
    /**
     * The Button zatwierdz.
     */
    @FXML
    Button buttonZatwierdz;
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

    /**
     * Change password click.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void changePasswordClick(ActionEvent event) throws IOException{
        String haslo=changePasswordField.getText();
        if (haslo.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();
            changePasswordField.clear();
        }
        else {
            try {
        String wynik=MainApp.client.zmienHasloKlienta(haslo);
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Niepoprawny typ danych");
                alert.setContentText("Wprowadz dane ponownie");
                alert.showAndWait();
                changePasswordField.clear();
            }

        }
    }

    /**
     * Button oferty cllick.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void buttonOfertyCllick(ActionEvent event) throws IOException{
        List<String> lista=new ArrayList<String>();
        lista=MainApp.client.oferta();
        tableOferty.setItems(getOferty(lista));
        tableIdOferty.setCellValueFactory(new PropertyValueFactory<>("idoferty"));
        tableIdLeku.setCellValueFactory(new PropertyValueFactory<>("idleku"));
        columnNazwaOf.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        tableCena.setCellValueFactory(new PropertyValueFactory<>("cena"));



    }

    /**
     * Button lek click.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void buttonLekClick(ActionEvent event) throws  IOException{
        String idlek = idlekuField.getText();
        if (idlek.equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();
            idlekuField.clear();
        }
        else {
            try {
        int idleku=Integer.parseInt(idlek);
        String lek=MainApp.client.wyswietlLek(idleku);
        tableLek.setItems(getLek(lek));
        tableIdLek.setCellValueFactory(new PropertyValueFactory<>("idleku"));
        tableNazwa.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        tableGramatura.setCellValueFactory(new PropertyValueFactory<>("gramatura"));
            }catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setHeaderText("Niepoprawny typ danych");
                alert.setContentText("Wprowadz dane ponownie");
                alert.showAndWait();
                idlekuField.clear();
            }

        }
    }

    /**
     * Button zamowienie click.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void buttonZamowienieClick(ActionEvent event) throws IOException{
        List<String> lista=MainApp.client.wyswietlZamowienia();
        tableZamowienie.setItems((getZamowienia(lista)));
        tableIdZamowienia.setCellValueFactory(new PropertyValueFactory<>("idzamowienia"));
        tableIdKlienta.setCellValueFactory(new PropertyValueFactory<>("idklienta"));
        tableIdKoszyka.setCellValueFactory(new PropertyValueFactory<>("idkoszyka"));
        tableWaga.setCellValueFactory(new PropertyValueFactory<>("waga"));
        tableDataZ.setCellValueFactory(new PropertyValueFactory<>("dataz"));
        tableDataR.setCellValueFactory(new PropertyValueFactory<>("datar"));
        tableStan.setCellValueFactory(new PropertyValueFactory<>("stan"));

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
                if(zam.equalsIgnoreCase("Blad"))
                {
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
     * Button dodaj click.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void buttonDodajClick(ActionEvent event) throws IOException{
        String idoferty=koszykIdOfertyField.getText();
        String ilosc=koszykIloscField.getText();
        if (idoferty.equals("") || ilosc.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Dane nie moga byc puste");
            alert.setContentText("Wprowadz dane");
            alert.showAndWait();

            koszykIdOfertyField.clear();
            koszykIloscField.clear();
        } else {

            String response = MainApp.client.dodajKoszyk(idoferty, ilosc);


            if (response.equalsIgnoreCase("Dodano")) {
                ScreenController control = new ScreenController(this.buttonDodaj);
                control.switchScene("KlientDodajZamowienie.fxml");
            } else if (response.equalsIgnoreCase("NieDodano")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Podano bledne dane ");
                alert.setHeaderText("Podano bledne dane");
                alert.setContentText("Podano bledne dane");
                alert.showAndWait();
                koszykIdOfertyField.clear();
                koszykIloscField.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Podano bledne dane ");
                alert.setHeaderText("Podano bledne dane");
                alert.setContentText("Podano bledne dane");
                alert.showAndWait();
                koszykIdOfertyField.clear();
                koszykIloscField.clear();
            }


        }
    }

    /**
     * Button loggout click.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void buttonLoggoutClick(ActionEvent event) throws IOException{
        Parent tableview= FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
        Scene tableviewscene=new Scene(tableview,800,800);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableviewscene);
        window.show();
        MainApp.client.logoff();
    }

    /**
     * Get oferty observable list.
     *
     * @param lista the lista
     * @return the observable list
     */
    public  ObservableList<OfertyFX> getOferty(List<String> lista){
        ObservableList<OfertyFX> oferty = FXCollections.observableArrayList();
        String temp="";
        for(int i=0;i<lista.size();i++){
            temp = lista.get(i);
            String[] tokens = StringUtils.split(temp);
            oferty.add(new OfertyFX(tokens[0],tokens[1],tokens[3],tokens[2]));
        }
        return oferty;
    }

    /**
     * Get zamowienia observable list.
     *
     * @param lista the lista
     * @return the observable list
     */
    public  ObservableList<ZamowieniaKlientaFx> getZamowienia(List<String> lista){
        ObservableList<ZamowieniaKlientaFx> zamowienia = FXCollections.observableArrayList();
        String temp="";
        for(int i=0;i<lista.size();i++){
            temp = lista.get(i);
            String[] tokens = StringUtils.split(temp);
            zamowienia.add(new ZamowieniaKlientaFx(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5],tokens[6]));
        }
        return zamowienia;
    }

    /**
     * Get lek observable list.
     *
     * @param temp the temp
     * @return the observable list
     */
    public  ObservableList<LekFx> getLek(String temp){
        ObservableList<LekFx> lek = FXCollections.observableArrayList();
        String[] tokens = StringUtils.split(temp);
        lek.add(new LekFx(tokens[0],tokens[1],tokens[2]));
        return lek;
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        /*  ;*/

        System.out.println("Otwarto okno klienta");
    }

}
