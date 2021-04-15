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
 * The type Office wyswietl leki.
 */
public class OfficeWyswietlLeki implements Initializable {
    /**
     * The Idleku column.
     */
    public TableColumn idlekuColumn;
    /**
     * The Nazwa column.
     */
    public TableColumn nazwaColumn;
    /**
     * The Gramatura column.
     */
    public TableColumn gramaturaColumn;
    /**
     * The Wroc.
     */
    public Button wroc;
    /**
     * The Refresh 1.
     */
    public Button refresh1;
    /**
     * The Tabela.
     */
    public TableView tabela;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            List<String> lista = new ArrayList<String>();
            lista = MainApp.client.wyswietlLista("Lek");
            tabela.setItems(getZamowienia(lista));
            idlekuColumn.setCellValueFactory(new PropertyValueFactory<>("id_leku"));
            nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
            gramaturaColumn.setCellValueFactory(new PropertyValueFactory<>("gramatura"));
        }catch(Exception e){

        }
        System.out.println("Otwarto okno Wyswietlania Leków");

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
        lista = MainApp.client.wyswietlLista("Lek");
        tabela.setItems(getZamowienia(lista));
        idlekuColumn.setCellValueFactory(new PropertyValueFactory<>("id_leku"));
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        gramaturaColumn.setCellValueFactory(new PropertyValueFactory<>("gramatura"));
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
        control.switchScene("OfficeMain.fxml");
    }

    /**
     * Gets zamowienia.
     *
     * @param lista the lista
     * @return the zamowienia
     */
    public ObservableList<LekFX1> getZamowienia(List<String> lista) {

        ObservableList<LekFX1> magazyn = FXCollections.observableArrayList();
        String str = "";
        for(int i=0;i<lista.size();i++) {
            str=(lista.get(i));

            String[] tokens = StringUtils.split(str);

            String idleku=tokens[0];
            String nazwa=tokens[1];
            String gramatura=tokens[2];
            magazyn.add(new LekFX1(idleku, gramatura, nazwa));
        }
        return magazyn;
    }
}
