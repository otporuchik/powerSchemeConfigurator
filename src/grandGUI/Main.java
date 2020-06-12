/*
 *No license, free to use.
 */

package grandGUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
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

        FXMLLoader loader = new FXMLLoader( getClass().getResource("grandMainGUI.fxml") );
        Parent root = loader.load();

       /* SchemePage.setWidth(WIDTH_A4);
        SchemePage.setHeight(HEIGHT_A4);
        Stamps.setWidth(WIDTH_A4);
        Stamps.setHeight(HEIGHT_A4);
        Stamps.getMainStamp();
        Stamps.getLeftStamp();

        WorkField.setWidth(WIDTH_A4);
        WorkField.getWorkField();

        CircuitBreaker.getCircuitBreaker(14, 15.2, "N01.01");
        CircuitBreaker.getCircuitBreaker(201, 109, "P10.10/11");
        CircuitBreaker.getCircuitBreaker(15, 15, "ngjht\n15554");

        Parent root = SchemePage.getSchemePage().getRootPane();*/

        ScrollPane scrollPane = new ScrollPane(root);
        Scene newScene = new Scene(scrollPane);

        primaryStage.setTitle("Hello world! Meow!");
        primaryStage.setScene(newScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
/*

        //trying creating different types of objects
        ElectricalEquipment trr = new ElectricalEquipment(2000, ElectricalEquipmentTypes.PUMP,
                "trr", 380);
        trr.setCircuitBreaker(CircuitBreakerStore.getCircuitBreaker(trr.getType(), trr.getOperatingCurrent()));
        ElectricalEquipmentCollection.getElectricalEquipmentCollection().addToCollection(trr);

        ElectricalEquipment hrr = new ElectricalEquipment(2000, ElectricalEquipmentTypes.LIGHT,
                "hrr", 220);
        hrr.setCircuitBreaker(CircuitBreakerStore.getCircuitBreaker(hrr.getType(), hrr.getOperatingCurrent()));
        ElectricalEquipmentCollection.getElectricalEquipmentCollection().addToCollection(hrr);

        for (ElectricalEquipment x:
                ElectricalEquipmentCollection.getElectricalEquipmentCollection().getCollection()) {
            System.out.println("Hello, my name is: " + x.getName() +
                    "\nand I'm protected by: " + x.getCircuitBreaker() +
                    "\nbecause my operating current is: " + x.getOperatingCurrent() + "\n");
        }
*/

    }
}
