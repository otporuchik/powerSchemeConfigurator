package constants;

import javafx.stage.Screen;

/** Contain standard widths and heights,
 * method to convert pixels to millimeters
 */
public class Graphics {
    //Getting screens dpi
    private static final Screen screen = Screen.getPrimary();
    private static final double dpi = screen.getDpi();

    /** Converting millimeters to pixels with particular system dpi */
    public static double mmToPixels(double millimeters) {
        return dpi * millimeters / 25.4; //where 25.4 is number of mm in one inch.
    }

    //standard page sizes
    //A4
    public static final int WIDTH_A4 = (int) mmToPixels(210); //A4 is vertical oriented
    public static final int HEIGHT_A4 = (int) mmToPixels(297);
    //A3
    public static final int WIDTH_A3 = (int) mmToPixels(420); //A3 is horizontal oriented
    public static final int HEIGHT_A3 = (int) mmToPixels(297);
    //A2
    public static final int WIDTH_A2 = (int) mmToPixels(594); //A2 is horizontal oriented
    public static final int HEIGHT_A2 = (int) mmToPixels(420);
}
