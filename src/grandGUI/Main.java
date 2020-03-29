/*
 *No license, free to use.
 */

package grandGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Configuring one lined power scheme and suggests circuit breakers
 * for electrical objects.
 * Creating PNG file of power scheme and TXT specs of circuit breakers.
 */
public class Main extends Application {

    //creating GUI
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("grandMainGUI.fxml"));

        /*
        FXMLLoader loader = new FXMLLoader( getClass().getResource("client.fxml") );
        loader.setController( this );
        Parent root = loader.load();
         */

        primaryStage.setTitle("Grand Canal");
        primaryStage.setScene(new Scene(root, 1184, 620));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
