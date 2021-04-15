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
 * The type Admin wyswietl zamowienia.
 */
public class AdminWyswietlZamowienia implements Initializable {
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
     * The Koszyk column.
     */
    @FXML
    public TableColumn koszykColumn;
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
     * The Wroc.
     */
    @FXML
    public Button wroc;
    /**
     * The Refresh 1.
     */
    @FXML
    public Button refresh1;
    /**
     * The Tabela.
     */
    @FXML
    public TableView tabela;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Otwarto okno Wyswietlania Zamowien");

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
        lista = MainApp.client.wyswietlLista("Zamowienie");
        tabela.setItems(getZamowienia(lista));
        ZamowienieColumn.setCellValueFactory(new PropertyValueFactory<>("id_zamowienia"));
        klientColumn.setCellValueFactory(new PropertyValueFactory<>("id_klienta"));
        koszykColumn.setCellValueFactory(new PropertyValueFactory<>("id_koszyka"));
        wagaColumn.setCellValueFactory(new PropertyValueFactory<>("waga"));
        zloenieColumn.setCellValueFactory(new PropertyValueFactory<>("data_zlozenia"));
        realizacjiaColumn.setCellValueFactory(new PropertyValueFactory<>("data_realizacji"));
        stanColumn.setCellValueFactory(new PropertyValueFactory<>("stan"));

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
     * Gets zamowienia.
     *
     * @param lista the lista
     * @return the zamowienia
     */
    public ObservableList<ZamowienieFX> getZamowienia(List<String> lista) {

        ObservableList<ZamowienieFX> zamowienia = FXCollections.observableArrayList();
        String str = "";
        for(int i=0;i<lista.size();i++) {
            str=(lista.get(i));

            String[] tokens = StringUtils.split(str);

            String id_zamowienia=tokens[0];
            String id_klienta=tokens[1];
            String id_koszyka=tokens[2];
            String waga=tokens[3];
            String data_zlozenia=tokens[4];
            String data_realizacji=tokens[5];
            String stan=tokens[6];

            zamowienia.add(new ZamowienieFX(id_zamowienia, id_klienta, id_koszyka, waga, data_zlozenia, data_realizacji, stan));

        }
        return zamowienia;
    }
}
