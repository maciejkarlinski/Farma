package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
 * The type Admin wyswietl klientow.
 */
public class AdminWyswietlKlientow implements Initializable{

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
    /**
     * The Tabela.
     */
    @FXML
    public TableView tabela;
    /**
     * The Id column.
     */
    @FXML
    public TableColumn idColumn;
    /**
     * The Idosoby column.
     */
    @FXML
    public TableColumn idosobyColumn;
    /**
     * The Mail column.
     */
    @FXML
    public TableColumn mailColumn;
    /**
     * The Telefon column.
     */
    @FXML
    public TableColumn telefonColumn;
    /**
     * The Imie column.
     */
    @FXML
    public TableColumn imieColumn;
    /**
     * The Nazwisko column.
     */
    @FXML
    public TableColumn nazwiskoColumn;
    /**
     * The Nip column.
     */
    @FXML
    public TableColumn nipColumn;


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
    public void refresh(ActionEvent actionEvent) throws IOException {
        List<String> lista=new ArrayList<String>();
        lista = MainApp.client.wyswietlklientow();
        tabela.setItems(getKlienci(lista));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("idklienta"));
        idosobyColumn.setCellValueFactory(new PropertyValueFactory<>("idosoby"));
        imieColumn.setCellValueFactory(new PropertyValueFactory<>("imie"));
        nazwiskoColumn.setCellValueFactory(new PropertyValueFactory<>("nazwisko"));
        mailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        telefonColumn.setCellValueFactory(new  PropertyValueFactory<>("telefon"));
        nipColumn.setCellValueFactory(new PropertyValueFactory<>("nip"));

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
     * Gets klienci.
     *
     * @param lista the lista
     * @return the klienci
     */
    public ObservableList<KlientFX> getKlienci(List<String> lista) {

        ObservableList<KlientFX> klient = FXCollections.observableArrayList();
        String str = "";
        for(int i=0;i<lista.size();i++) {
            str=(lista.get(i));

            String[] tokens = StringUtils.split(str);

           String idklienta=tokens[0];
           String idosoby=tokens[1];
           String imie=tokens[2];
           String nazwisko=tokens[3];
           String email=tokens[4];
           String telefon=tokens[5];
           String nip=tokens[6];

            klient.add(new KlientFX(idklienta,idosoby,imie,nazwisko,email,telefon,nip));

        }
        return klient;
    }


}
