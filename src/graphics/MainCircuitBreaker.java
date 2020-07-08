package graphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.*;

import static constants.Graphics.mmToPixels;
import static electroPackage.CircuitBreakerStore.getMainCircuitBreaker;

/**
 * Class to choose main circuit breaker.
 */
public class MainCircuitBreaker {
    /**
     * Method to draw main circuit breaker on scheme.
     */
    public static void getMainCircuitBreakerScheme() {
        Text mainCircuitBreaker = new Text();
        mainCircuitBreaker.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(3)));
        mainCircuitBreaker.setFill(Color.BLACK);
        mainCircuitBreaker.setWrappingWidth(mmToPixels(18));
        mainCircuitBreaker.setTextAlignment(TextAlignment.CENTER);
        mainCircuitBreaker.setX(mmToPixels(53));
        mainCircuitBreaker.setY(mmToPixels(35));
        mainCircuitBreaker.setText("QF1" + getMainCircuitBreaker());

        //one line circuit breaker scheme
        Path oneLineModule = new Path();
        oneLineModule.setStroke(Color.BLACK);
        oneLineModule.setStrokeWidth(mmToPixels(0.4));
        MoveTo cbmMove1 = new MoveTo(mmToPixels(70), mmToPixels(22));
        LineTo cbmLine1 = new LineTo(mmToPixels(70), mmToPixels(33));
        MoveTo cbmMove2 = new MoveTo(mmToPixels(70), mmToPixels(39));
        LineTo cbmLine2 = new LineTo(mmToPixels(70), mmToPixels(53));
        MoveTo cbmMove3 = new MoveTo(mmToPixels(70), mmToPixels(39));
        LineTo cbmLine3 = new LineTo(mmToPixels(67), mmToPixels(33));
        MoveTo cbmMove4 = new MoveTo(mmToPixels(67.6), mmToPixels(35));
        LineTo cbmLine4 = new LineTo(mmToPixels(66.5), mmToPixels(35.8));
        LineTo cbmLine5 = new LineTo(mmToPixels(67.7), mmToPixels(38));
        LineTo cbmLine6 = new LineTo(mmToPixels(68.7), mmToPixels(37.3));

        oneLineModule.getElements().addAll(cbmMove1, cbmLine1, cbmMove2, cbmLine2, cbmMove3, cbmLine3, cbmMove4,
                cbmLine4, cbmLine5, cbmLine6);

        //N-line
        Line lineN = new Line(mmToPixels(73), mmToPixels(22),
                mmToPixels(73), mmToPixels(59));
        lineN.setStroke(Color.BLACK);
        lineN.setStrokeWidth(mmToPixels(0.4));
        //Pe-line
        Line linePe = new Line(mmToPixels(76), mmToPixels(22),
                mmToPixels(76), mmToPixels(59));
        linePe.setStroke(Color.BLACK);
        linePe.setStrokeWidth(mmToPixels(0.4));
        linePe.getStrokeDashArray().addAll(mmToPixels(3), mmToPixels(1),
                mmToPixels(0.5), mmToPixels(1));

        SchemePage.getSchemePage().addToRootPane(mainCircuitBreaker, oneLineModule, lineN, linePe);
    }
}
