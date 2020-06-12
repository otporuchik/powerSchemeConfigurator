
package grandGUI;

import electroPackage.ElectricalEquipment;
import electroPackage.ElectricalEquipmentCollection;
import electroPackage.ElectricalEquipmentTypes;
import graphics.CircuitBreaker;
import graphics.SchemePage;
import graphics.Stamps;
import graphics.WorkField;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;

/**Controller of main configuration page.
 *
 * @version             1.0 02 Feb 2020
 * @author              A.G.D.
 */
public class GrandMainGUIController {
    /** Type of electrical equipment (from enum) */
    ElectricalEquipmentTypes type;
    /** Name of electrical equipment */
    String name;
    /** Electrical power of electrical equipment (Watts) */
    double power;
    /** Working current of electrical equipment (Ampere) */
    double current;
    /** Working voltage of electrical equipment (Volt) */
    int voltage;

    /** Uniting voltage radio buttons in main view into one toggle group */
    ToggleGroup voltageRadioButtons = new ToggleGroup();

    //Getting data from user with this GUI elements
    /** SplitMenuButton on main configurator page to choose type of electrical object */
    @FXML SplitMenuButton mainSplitMenuButton;
    /** Name textField on main configurator page to get name of electrical object */
    @FXML TextField nameTextField;
    /** Power textField on main configurator page to get electrical power of electrical object */
    @FXML TextField powerTextField;
    /** Current textField on main configurator page to get working current of electrical object */
    @FXML TextField currentTextField;
    /** Voltage select radiobutton on main configurator page to get working voltage of electrical object */
    @FXML RadioButton radioButton220V;
    @FXML RadioButton radioButton380V;

    /** Showing text preview of created electrical equipment collection */
    @FXML TextArea mainTextArea;

    /** Button to get scheme. */
    @FXML Button getSchemeButton;


    public void initialize() {
        //setting voltage radio buttons into one toggle group
        radioButton220V.setToggleGroup(voltageRadioButtons);
        radioButton380V.setToggleGroup(voltageRadioButtons);

        //setting default type of electrical equipment
        mainSplitMenuButton.setText("Насос");
        type = ElectricalEquipmentTypes.PUMP;
    }

    /** Setting type of electrical object = pump */
    public void pumpMenuItem() {
        mainSplitMenuButton.setText("Насос");
        type = ElectricalEquipmentTypes.PUMP;
    }
    /** Setting type of electrical object = ventilator */
    public void ventMenuItem() {
        mainSplitMenuButton.setText("Вентилятор");
        type = ElectricalEquipmentTypes.VENTILATOR;
    }
    /** Setting type of electrical object = heater */
    public void heaterMenuItem() {
        mainSplitMenuButton.setText("Нагреватель");
        type = ElectricalEquipmentTypes.HEATER;
    }
    /** Setting type of electrical object = light */
    public void lightMenuItem() {
        mainSplitMenuButton.setText("Освещение");
        type = ElectricalEquipmentTypes.LIGHT;
    }
    /** Getting users data, creating object and adding it to collection */
    public void createElectricalObject() {
        String collectionDataString = "";

        //getting data from name textField
        name = nameTextField.getText();


        //TODO - methods to check power and current from textFields!


        //getting power from String from powerTextField
        power = Double.parseDouble(powerTextField.getText());

        //getting current from String from currentTextField
        current = Double.parseDouble(currentTextField.getText());




        //getting data from voltage radio buttons
        if (voltageRadioButtons.getSelectedToggle().equals(radioButton220V)) {
            voltage = 220;
        }
        if (voltageRadioButtons.getSelectedToggle().equals(radioButton380V)) {
            voltage = 380;
        }


        ElectricalEquipment electricalEquipment = new ElectricalEquipment(power, type, name, voltage, current);
        ElectricalEquipmentCollection.getElectricalEquipmentCollection().addToCollection(electricalEquipment);

        //sending data to main view text area
        for (ElectricalEquipment eachElectricalEquipment :
                ElectricalEquipmentCollection.getElectricalEquipmentCollection().getCollection()) {
            collectionDataString += "Type: " + eachElectricalEquipment.getType() + "\nname: " +
                    eachElectricalEquipment.getName() + "\npower: " + eachElectricalEquipment.getPower() +
                    "\ncurrent: " + eachElectricalEquipment.getOperatingCurrent() +
                    "\nvoltage: " + eachElectricalEquipment.getVoltage() +
                    "\nmy circuit breaker: " + eachElectricalEquipment.getCircuitBreaker() +
                    "\nmy cable: " + eachElectricalEquipment.getCable() + "\n\n";
        }
        mainTextArea.setText("");
        mainTextArea.setText(collectionDataString);
    }

    /** Getting power scheme as png image */
    public void getScheme(ActionEvent event) {
        //Setting page stamps and work field with default sizes (A3)
        Stamps.getMainStamp();
        Stamps.getLeftStamp();
        WorkField.getWorkField();

        //Getting circuitBreakers on scheme
        for (ElectricalEquipment eachElectricalEquipment :
        ElectricalEquipmentCollection.getElectricalEquipmentCollection().getCollection()) {
            CircuitBreaker.getCircuitBreakerScheme(eachElectricalEquipment.getPower(),
                    eachElectricalEquipment.getOperatingCurrent(), eachElectricalEquipment.getName(),
                    eachElectricalEquipment.getVoltage(), eachElectricalEquipment.getCircuitBreaker(),
                    eachElectricalEquipment.getCable());
        }

        //Calling File Chooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save scheme");
        fileChooser.setInitialFileName("Scheme");
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png");
        fileChooser.getExtensionFilters().add(extensionFilter);
//        fileChooser.setInitialDirectory();
        //getting stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        alternative way of setting stage for fileChooser:
//        Window stage = getSchemeButton.getScene().getWindow();
        //open save file window
        File file = fileChooser.showSaveDialog(window);

        //Making snapshot in png
        try {
            SnapshotParameters snapshotParameters = new SnapshotParameters();
            Image snapshot = SchemePage.getSchemePage().getRootPane().snapshot(snapshotParameters, null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot, null), "png", file);
        } catch (Exception e) {
            System.out.println("Failed to save image: " + e);
            e.printStackTrace();
        }

    }
}
