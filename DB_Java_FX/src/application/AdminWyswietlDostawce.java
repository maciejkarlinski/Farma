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
 * The type Admin wyswietl dostawce.
 */
public class AdminWyswietlDostawce implements Initializable {


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
     * The Name column.
     */
    @FXML
    public TableColumn nameColumn;
    /**
     * The County column.
     */
    @FXML
    public TableColumn CountyColumn;
    /**
     * The Nip column.
     */
    @FXML
    public TableColumn NipColumn;
    /**
     * The Adres column.
     */
    @FXML
    public TableColumn adresColumn;


    @Override
        public void initialize (URL location, ResourceBundle resources){
            System.out.println("Otwarto okno Wyswietlania Dostawce");
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
            lista = MainApp.client.wyswietlLista("Dostawca");
            tabela.setItems(getDostawca(lista));
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id_dostawcy"));
            nameColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
            CountyColumn.setCellValueFactory(new PropertyValueFactory<>("kraj"));
            NipColumn.setCellValueFactory(new PropertyValueFactory<>("nip"));
            adresColumn.setCellValueFactory(new PropertyValueFactory<>("adres"));
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
     * Gets dostawca.
     *
     * @param lista the lista
     * @return the dostawca
     */
    public ObservableList<DostawcaFX> getDostawca(List<String> lista) {

            ObservableList<DostawcaFX> dostawca = FXCollections.observableArrayList();
            String str = "";
            for(int i=0;i<lista.size();i++) {
                str=(lista.get(i));

                String[] tokens = StringUtils.split(str);

                String id_dostawcy=tokens[0];
                String nazwa=tokens[1];
                String nip=tokens[2];
                String kraj=tokens[3];
                String adres=tokens[4];

                dostawca.add(new DostawcaFX(id_dostawcy, nazwa, nip, kraj, adres));

            }
            return dostawca;
        }


    }
