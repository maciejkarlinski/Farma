package application;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;


/**
 * The type Screen controller.
 */
public class ScreenController {
	
	private Button button;
	private Hyperlink hyperlink;

    /**
     * Instantiates a new Screen controller.
     *
     * @param button the button
     */
    public ScreenController(Button button)
	{
		this.button=button;
		this.hyperlink=null;
	}

    /**
     * Instantiates a new Screen controller.
     *
     * @param hyperlink the hyperlink
     */
    public ScreenController(Hyperlink hyperlink)
	{
		this.hyperlink=hyperlink;
		this.button=null;
	}

    /**
     * Switch scene.
     *
     * @param nameOfPage the name of page
     * @throws IOException the io exception
     */
    public void switchScene(String nameOfPage) throws IOException
	{
		Stage stage;
		FXMLLoader loader = new FXMLLoader(getClass().getResource(nameOfPage));
		if(button == null)
	        stage = (Stage) hyperlink.getScene().getWindow();
		else
	        stage = (Stage) button.getScene().getWindow();
		
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);

	}

}
