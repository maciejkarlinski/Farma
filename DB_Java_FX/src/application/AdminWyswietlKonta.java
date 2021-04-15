package application;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * The type Admin wyswietl konta.
 */
public class AdminWyswietlKonta  implements Initializable {


    /**
     * The Text field.
     */
    @FXML
    public Label TextField;
    /**
     * The Tabela.
     */
    @FXML
    public TableView<OsobaFX> tabela;

    /**
     * The Id column.
     */
    @FXML
    public TableColumn<OsobaFX, String> idColumn;
    /**
     * The Name column.
     */
    @FXML
    public TableColumn<OsobaFX, String> nameColumn;
    /**
     * The Lastname column.
     */
    @FXML
    public TableColumn<OsobaFX, String> lastnameColumn;
    /**
     * The Mail column.
     */
    @FXML
    public TableColumn<OsobaFX, String> mailColumn;
    /**
     * The Tel column.
     */
    @FXML
    public TableColumn<OsobaFX, String> telColumn;
    /**
     * The Pesel column.
     */
    @FXML
    public TableColumn<OsobaFX, String> peselColumn;
    /**
     * The Haslo column.
     */
    @FXML
    public TableColumn<OsobaFX, String> hasloColumn;
    /**
     * The Status column.
     */
    @FXML
    public TableColumn<OsobaFX, String> statusColumn;
    /**
     * The Refresh.
     */
    @FXML
    public Button refresh;
    /**
     * The Wroc.
     */
    @FXML
    public Button wroc;


    @Override
    public void initialize (URL location, ResourceBundle resources){
        System.out.println("Otwarto okno Wyswietlania Konta");

    }

    /**
     * Refresh.
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    @FXML
    public void refresh(ActionEvent actionEvent) throws IOException{
        List<String> lista=new ArrayList<String>();
        lista = MainApp.client.wyswietlLista("Osoba");
        tabela.setItems(getKonta(lista));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id_osoby"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("imie"));
        lastnameColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<>("e_mail"));
        telColumn.setCellValueFactory(new PropertyValueFactory<>("nr_tel"));
        peselColumn.setCellValueFactory(new PropertyValueFactory<>("pesel"));
        hasloColumn.setCellValueFactory(new PropertyValueFactory<>("haslo"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status_konta"));
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
     * Gets konta.
     *
     * @param lista the lista
     * @return the konta
     */
    public ObservableList<OsobaFX> getKonta(List<String> lista) {

        ObservableList<OsobaFX> konta = FXCollections.observableArrayList();
       String str = "";
        for(int i=0;i<lista.size();i++) {
            str=(lista.get(i));

            String[] tokens = StringUtils.split(str);

            String id=tokens[0];
            String imie=tokens[1];
            String nazwisko=tokens[2];
            String e_mail=tokens[3];
            String nr_tel=tokens[4];
            String pesel=tokens[5];
            String haslo=tokens[6];
            String status_konta=tokens[7];

            konta.add(new OsobaFX(id,imie,nazwisko,e_mail,nr_tel,pesel,haslo,status_konta));

        }
        return konta;
    }


}
