package application;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


//import javafx.scene.input.ContextMenuEvent;


/**
 * The type Register controller.
 */
public class RegisterController implements Initializable{


    /**
     * The Tel label.
     */
    public Label telLabel;
    /**
     * The Pesel label.
     */
    public Label PeselLabel;
    /**
     * The Nip label.
     */
    public Label NipLabel;

	@FXML
    private Label nameLabel; 
    
    @FXML
    private Label lastNameLabel; 
    
    @FXML
    private Label emailLabel;  
    
    @FXML
    private Label passwordLabel;
    
    @FXML
    private Label confirmPasswordLabel;
    

	@FXML
    private Pane registerMainPane;
	
	@FXML
	private Pane registerPane;
	
    @FXML
    private TextField firstNameField;
    
    @FXML
    private TextField lastNameField;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    /**
     * The Nr tel field.
     */
    @FXML
	public TextField NrTelField;

    /**
     * The Nip field.
     */
    @FXML
	public TextField NipField;

    /**
     * The Pesel field.
     */
    @FXML
	public TextField PeselField;
    
    @FXML
    private Button registerButton;
    
    @FXML
    private Button backButton;
    
    @FXML
    private TextArea descriptionOfHouse;
    
    @FXML
    private ImageView imageOfHouse;
    
    @FXML
    private ComboBox<String> choiceHouse = new ComboBox<>();

    /**
     * Back button click.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void backButtonClick(ActionEvent event) throws IOException {
    	ScreenController control = new ScreenController(this.backButton);
    	control.switchScene("LoginPanel.fxml");
    }

    /**
     * Register button click.
     *
     * @param event the event
     * @throws IOException the io exception
     */
    @FXML
    void registerButtonClick(ActionEvent event) throws IOException {
    	
    	if(firstNameField.equals("") || lastNameField.equals("") || emailField.equals("") || passwordField.equals("") || confirmPasswordField.equals("") || NipField.equals("") || NrTelField.equals("") || PeselField.equals(""))
    	{
        	Alert alert = new Alert(AlertType.WARNING);
        	alert.setTitle("Warning Dialog");
        	alert.setHeaderText("Dane nie moga byc puste");
        	alert.setContentText("Wprowadz dane");
        	alert.showAndWait();
    	}
    	else
    	{
    		String name=firstNameField.getText();
    		String lastName=lastNameField.getText();
    		String email=emailField.getText();
    		String password=passwordField.getText();
			String nrtel=NrTelField.getText();
			String pesel=PeselField.getText();
			String nip=NipField.getText();
			String confirmPassword=confirmPasswordField.getText();

    		if(!password.equals(confirmPassword))
    		{
            	Alert alert = new Alert(AlertType.WARNING);
            	alert.setTitle("Warning Dialog");
            	alert.setHeaderText("Hasla musza byc takie same");
            	alert.setContentText("Wprowadz haslo jeszcze raz");
            	alert.showAndWait();
            	
            	passwordField.clear();
            	confirmPasswordField.clear();
    		}
    		else
    		{
                if (!MainApp.client.connect())
                    System.err.println("Polaczenie zakonczone niepowodzeniem");
                else
                    System.out.println("Polaczenie zakonczone powodzeniem");
                
    			String response=MainApp.client.register(name, lastName, email, nrtel, pesel, nip, password);
    			
    			if(response.equals("TAK"))
    			{
    				Alert alert = new Alert(AlertType.INFORMATION);
    				alert.setTitle("Information Dialog");
    				alert.setHeaderText(null);
    				alert.setContentText("Rejestracja przebiegla pomylsnie, twój login");
    				alert.showAndWait();
    				
    		    	ScreenController control = new ScreenController(this.backButton);
    		    	control.switchScene("LoginPanel.fxml");
    			}
    					
    			if(response.equals("NIE"))
    			{
                	Alert alert = new Alert(AlertType.WARNING);
                	alert.setTitle("Warning Dialog");
                	alert.setHeaderText("Email zajety");
                	alert.setContentText("Uzytkownik " + email + " juz istnieje, wprowadz inny email");
                	alert.showAndWait();
                	
                	emailField.clear();
                	passwordField.clear();
                	confirmPasswordField.clear();
    			}		
    		}
    	}
    }



	@Override
	public void initialize(URL location, ResourceBundle resources) {

		System.out.println("Okno rejstracji");

	}

}

