/*
 *No license, free to use.
 */

package grandGUI;

import com.sun.corba.se.spi.orbutil.threadpool.Work;
import electroPackage.ElectricalEquipment;
import electroPackage.ElectricalEquipmentCollection;
import electroPackage.ElectricalEquipmentTypes;
import graphics.CircuitBreaker;
import graphics.SchemePage;
import graphics.Stamps;
import graphics.WorkField;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import static constants.Graphics.HEIGHT_A4;
import static constants.Graphics.WIDTH_A4;

/**
 * Configuring one lined power scheme and suggests circuit breakers
 * for electrical objects.
 * Creating PNG file of power scheme and TXT specs of circuit breakers.
 */
public class Main extends Application {

    //creating GUI
    @Override
    public void start(Stage primaryStage) throws Exception {

        /*FXMLLoader loader = new FXMLLoader( getClass().getResource("grandMainGUI.fxml") );
        Parent root = loader.load();*/

        SchemePage.setWidth(WIDTH_A4);
        SchemePage.setHeight(HEIGHT_A4);
        Stamps.setWidth(WIDTH_A4);
        Stamps.setHeight(HEIGHT_A4);
        Stamps.getMainStamp();
        Stamps.getLeftStamp();

        WorkField.setWidth(WIDTH_A4);
        WorkField.getWorkField();

        CircuitBreaker.getCircuitBreaker();

        Parent root = SchemePage.getSchemePage().getRootPane();

        ScrollPane scrollPane = new ScrollPane(root);
        Scene newScene = new Scene(scrollPane);

        primaryStage.setTitle("Grand Canal");
        primaryStage.setScene(newScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

        ElectricalEquipment trr = new ElectricalEquipment(1800, ElectricalEquipmentTypes.PUMP, "trr", 220);
        ElectricalEquipmentCollection.getElectricalEquipmentCollection().addToCollection(trr);
        ElectricalEquipment hrr = new ElectricalEquipment(1800, ElectricalEquipmentTypes.LIGHT, "hrr", 220);
        ElectricalEquipmentCollection.getElectricalEquipmentCollection().addToCollection(hrr);

        for (ElectricalEquipment x: ElectricalEquipmentCollection.getElectricalEquipmentCollection().getCollection()) {
            System.out.println("Hello, my name is: " + x.getName() + x.getOperatingCurrent());
        }

    }
}
