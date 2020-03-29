/*
 *No license, free to use.
 *
 * Made for learning purpose.
 *
 */

package grandGUI;

import electricalEquipmentFactory.ElectricalEquipment;
import electricalEquipmentFactory.ElectricalEquipmentFactory;
import electricalEquipmentFactory.ElectricalEquipmentTypes;
import grandConfigurator.GrandCollection;
import grandConfigurator.GrandConfigurator;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.PrintWriter;

/**Controller of main configuration page.
 *
 * @version             1.0 02 Feb 2020
 * @author              A.G.D.
 */
public class GrandMainGUIController {

    /**Particular object of factory to create electrical equipments.*/
    ElectricalEquipmentFactory factory = new ElectricalEquipmentFactory();

    /**Enum, defines electrical equipment types for factory.*/
    ElectricalEquipmentTypes type;

    /**Particular electrical equipment object creating in session*/
    ElectricalEquipment electricalObject;

    /**Main fields of Electrical equipment*/
    public String name;
    public String collectionDataString;
    public int voltage;
    public double operatingCurrent;
    public double power;

    /**
     * Storing length and high to create objects.
     * Constants to set new coordinates.
     */
    public double counterX;
    public double counterY;
    public double counterXtext;
    public double counterYtext;
    /**
     * Storing counter for QF (circuit breakers).
     */
    public int i = 1;


    @FXML
    TextField nameTextField;

    @FXML
    TextField powerTextField;

    @FXML
    TextField operatingCurrentTextField;

    @FXML
    TextField voltageTextField;

    @FXML
    SplitMenuButton grandSplitMenuButton;

    @FXML
    MenuItem pumpMenuItem;

    @FXML
    MenuItem heaterMenuItem;

    @FXML
    Button createObject;

    @FXML
    Button nextObject;

    @FXML
    Button finish;

    @FXML
    Button getPictureButton;

    @FXML
    Button getSpecsButton;

    @FXML
    TextArea grandTextArea;

    @FXML
    Canvas canvas;

    /**Calling graphic context in shorter form*/
    public GraphicsContext context() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        return gc;
    }

    /**
     * Creating static picture in canvas.
     * Template of power scheme.
     * Initializing variables counterX, counterY.
     */
    public void initialize() {
        context().setLineWidth(2);
        context().strokeRect(1,1,1182, 398); //outer frame
        context().strokeRect(22,12,1148,376); //inner frame

        context().strokeLine(42,82,82,82); //top fat line (phase) before main circuit breaker
        context().strokeLine(82,82,117,62); //main circuit breaker diagonal
        context().strokeLine(101,71,97,66); //main circuit breaker left line of the top box
        context().strokeLine(97,66,107,60); //main circuit breaker top line of the top box
        context().strokeLine(107,60,111,65); //main circuit breaker right line of the top box
        context().strokeLine(122,82,1158,82); //top fat line (phase) after main circuit breaker
        context().setLineWidth(1);
        context().strokeLine(42,112,1158,112); //middle line (null)
        context().setLineDashes(15,10);
        context().strokeLine(42,142,1158,142); //bottom line (protecting earth)
        context().setLineDashes(0);

        /**
         * test line suppose to be 100mm length
         */
        context().strokeLine(42,155,420,155);

        context().setLineWidth(2);
        context().strokeRect(22,268,164,30); // main name field
        context().strokeRect(22,298,164,30); // main current field
        context().strokeRect(22,328,164,30); // main power field
        context().strokeRect(22,358,164,30); // main circuit breaker field

        context().setFont(Font.font("Arial", FontWeight.EXTRA_LIGHT, 20));
        context().setFill(Color.BLACK);
        context().fillText("Main",27,293); //main name
        context().fillText("QF" + i, 90,55); //QFxx counter.

        counterX = 186; //22 + 164
        counterY = 268;

        counterXtext = 191; //27 + 164
        counterYtext = 293; //268 + 25
    }

    /**Setting type of object = pump.*/
    public void pumpMenuItem() {
        grandSplitMenuButton.setText("pump");
        type = ElectricalEquipmentTypes.PUMP;
    }

    /**Setting type of object = heater.*/
    public void heaterMenuItem() {
        grandSplitMenuButton.setText("heater");
        type = ElectricalEquipmentTypes.HEATER;
    }

    /**Creating object of class ElectricalEquipment with chosen type from factory.*/
    public void createObject() {
        voltage = Integer.parseInt(voltageTextField.getText());
        name = nameTextField.getText();

        if(operatingCurrentTextField.getText().isEmpty()) {
            power = Double.parseDouble(powerTextField.getText());
            electricalObject = factory.getElectricalEquipment(type, voltage, name, power);
        } else if(powerTextField.getText().isEmpty()) {
            operatingCurrent = Double.parseDouble(operatingCurrentTextField.getText());
            electricalObject = factory.getElectricalEquipment(type, voltage, operatingCurrent, name);
        } else {
            operatingCurrent = Double.parseDouble(operatingCurrentTextField.getText());
            power = Double.parseDouble(powerTextField.getText());
            electricalObject = factory.getElectricalEquipment(type, voltage, operatingCurrent, name, power);
        }
        grandTextArea.setText(electricalObject.getData());
    }

    /**Adding created object to collection, clearing forms.*/
    public void nextObject() {
        switch (type) {
            case PUMP:
                GrandCollection.getGrandCollection().totalPumpCurrent += electricalObject.operatingCurrent;
                break;

            case HEATER:
                GrandCollection.getGrandCollection().totalHeaterCurrent += electricalObject.operatingCurrent;
                break;
        }

        GrandCollection.getGrandCollection().addToCollection(electricalObject);

        context().setLineWidth(2);

        //next object
        //line before next circuit breaker
        context().strokeLine(counterX + 82, 82, counterX + 82, 182);
        //line after next circuit breaker
        context().strokeLine(counterX + 82, 222, counterX + 82, 268);
        // next circuit breaker diagonal
        context().strokeLine(counterX + 82, 222, counterX + 62, 187);
        // next circuit breaker right line of the top box
        context().strokeLine(counterX + 60, 197, counterX + 65, 193);
        // next circuit breaker top line of the top box
        context().strokeLine(counterX + 60, 197, counterX + 66, 207);
        // next circuit breaker left line of the top box
        context().strokeLine(counterX + 66, 207, counterX + 71, 203);
        // node on phase line
        context().fillOval(counterX + 79, 79, 6, 6);
        // node on null line
        context().fillOval(counterX + 49, 109, 6, 6);
        context().setLineWidth(1);
        // connection line from null
        context().strokeLine(counterX + 52, 112, counterX + 52, 230);
        context().strokeLine(counterX + 52, 230, counterX + 82, 255);
        // node on protecting earth line
        context().fillOval(counterX + 19, 139, 6, 6);
        // connection line from protecting earth line
        context().setLineDashes(15,10);
        context().strokeLine(counterX + 22, 142, counterX + 22, 235);
        context().strokeLine(counterX + 22, 235, counterX + 82, 255);
        context().setLineDashes(0);
        context().setLineWidth(2);
        // node connecting all lines
        context().fillOval(counterX + 79, 252, 6, 6);

        context().strokeRect(counterX,counterY,164,30); // next name field
        context().strokeRect(counterX,counterY + 30,164,30); // next current field
        context().strokeRect(counterX,counterY + 60,164,30); // next power field
        context().strokeRect(counterX,counterY + 90,164,30); // next circuit breaker field

        context().fillText(electricalObject.name,counterXtext,counterYtext); // next name
        context().fillText(String.format("%.2f",electricalObject.operatingCurrent) + "A",counterXtext,counterYtext + 30); // next current
        context().fillText(String.valueOf(electricalObject.power) + "W.",counterXtext,counterYtext + 60); // next power
        context().fillText(electricalObject.protector,counterXtext,counterYtext + 90); // next circuit breaker

        counterX += 164; //field width
        counterXtext += 164; //also field width

        grandSplitMenuButton.setText("select type");
        nameTextField.setText("");
        powerTextField.setText("");
        operatingCurrentTextField.setText("");
        voltageTextField.setText("");
        grandTextArea.setText("");
    }

    /**
     * Reading data from collection objects.
     * Setting main power, current and protector in picture.
     */
    public void finish() {

        GrandCollection.getGrandCollection().totalCurrent = GrandCollection.getGrandCollection().totalPumpCurrent + GrandCollection.getGrandCollection().totalHeaterCurrent;

        grandTextArea.setText("");
        collectionDataString = "";

        for (ElectricalEquipment electricalObject: GrandCollection.getGrandCollection().getCollection()) {
           collectionDataString += electricalObject.getData();
           collectionDataString += "\n";
        }
        collectionDataString += "Pumps group switcher: \n" +
                GrandConfigurator.getCircuitBreaker(GrandCollection.getGrandCollection().totalPumpCurrent) + "\n" +
                "Heaters group switcher: \n" +
                GrandConfigurator.getCircuitBreaker(GrandCollection.getGrandCollection().totalHeaterCurrent) + "\n" +
                "Main switcher: \n" +
                GrandConfigurator.getCircuitBreaker(GrandCollection.getGrandCollection().totalCurrent);

                grandTextArea.setText(collectionDataString);

        context().fillText((String.format("%.2f",GrandCollection.getGrandCollection().totalCurrent) + "A"),27,323); //main current
        context().fillText("...",27,353); //main power
        context().fillText( GrandConfigurator.getCircuitBreaker(GrandCollection.getGrandCollection().totalCurrent),27,383); //main circuit breaker
    }

    /**Getting picture in PNG from canvas*/
    public void getPicture() {
        try {
            Image snapshot = canvas.snapshot(null,null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapshot,null), "png", new File("powerScheme.png"));
        } catch (Exception e) {
            System.out.println("Failed to save image: " + e);
            e.printStackTrace();
        }

        grandTextArea.setText("Picture created!");
    }

    /**Getting specifications i.e. collectionDataString in txt*/
    public  void getSpecs() {
        try {
            PrintWriter out = new PrintWriter("powerSpecs.txt");
            out.println(collectionDataString);
            out.close();
        } catch (Exception e) {
            System.out.println("Failed to save file: " + e);
            e.printStackTrace();
        }

        grandTextArea.setText("Specs created!");
    }

}
