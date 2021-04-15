package application;
import Client.ChatClient;
import Client.Uzytkownik;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * The type Main app.
 */
public class MainApp extends Application {

    /**
     * The constant client.
     */
    public static ChatClient client;
    /**
     * The constant uzytkownik.
     */
    public static Uzytkownik uzytkownik;


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

		client = new ChatClient("localhost",6880);
		uzytkownik = new Uzytkownik("","","");
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
        Parent root = FXMLLoader.load(getClass().getResource("LoginPanel.fxml"));
        Scene scene = new Scene(root, 800, 800);
       
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
		
	}
	
	

}

