package graphics;

import constants.Graphics;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static constants.Graphics.mmToPixels;

/**
 * Class storing main scheme page.
 * Creating Pane with particular size.
 * Singleton.
 * Not synchronized for multi threads.
 * By default size = A3, if you need to change it,
 * before first call set width and height by
 * included there methods.
 */
public class SchemePage {
    /** The only object of this class */
    private static SchemePage schemePage;
    /** Pane where all scheme going to live */
    private static Pane rootPane;
    /** Width for this Pane */
    private static double width = Graphics.WIDTH_A3;
    /** Height for this Pane */
    private static double height = Graphics.HEIGHT_A3;

    /** Constructor. Declaring memory for main root layout and
     *  setting it's parameters.
     */
    private SchemePage() {
        rootPane = new Pane();
        rootPane.setPrefWidth(width);
        rootPane.setPrefHeight(height);
        rootPane.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));

        //main frame
        Rectangle mainFrame = new Rectangle(mmToPixels(20), mmToPixels(5),
                width - mmToPixels(25), height - mmToPixels(10));
        mainFrame.setFill(Color.WHITE);
        mainFrame.setStroke(Color.BLACK);
        mainFrame.setStrokeWidth(mmToPixels(0.5));

        rootPane.getChildren().addAll(mainFrame);
    }

    /** getting this singleton object of class SchemePage */
    public static SchemePage getSchemePage() {
        if(schemePage == null) {
            schemePage = new SchemePage();
        }
        System.out.println("Take your scheme!");
        return schemePage;
    }
    /** Setting width to Pane. By default = WIDTH_A3 */
    public static void setWidth(double width) {
        SchemePage.width = width;
    }

    /** Setting height to Pane. By default = HEIGHT_A3 */
    public static void setHeight(double height) {
        SchemePage.height = height;
    }

    /** getting this SchemePage Pane */
    public Pane getRootPane() {
        return rootPane;
    }

    /** Adding nodes to this rootPane to show them on it */
    public void addToRootPane(Node ... shape) { //variable number of arguments
        rootPane.getChildren().addAll(shape);
    }
}

