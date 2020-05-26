package graphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import static constants.Graphics.mmToPixels;

/**
 * Class to store circuit breakers graphics.
 */
public class CircuitBreaker {

    public static void getCircuitBreaker() {
//1 phase circuit breaker module
        //here it starts
        Circle circleL = new Circle();
        circleL.setCenterX(mmToPixels(70));
        circleL.setCenterY(mmToPixels(53));
        circleL.setRadius(mmToPixels(0.8));
        circleL.setFill(Color.BLACK);

        Circle circleN = new Circle();
        circleN.setCenterX(mmToPixels(73));
        circleN.setCenterY(mmToPixels(56));
        circleN.setRadius(mmToPixels(0.8));
        circleN.setFill(Color.BLACK);

        Circle circlePe = new Circle();
        circlePe.setCenterX(mmToPixels(76));
        circlePe.setCenterY(mmToPixels(59));
        circlePe.setRadius(mmToPixels(0.8));
        circlePe.setFill(Color.BLACK);

        Path oneLineModule = new Path();
        oneLineModule.setStroke(Color.BLACK);
        oneLineModule.setStrokeWidth(mmToPixels(0.4));
        MoveTo cbmMove1 = new MoveTo(mmToPixels(70), mmToPixels(53));
        LineTo cbmLine1 = new LineTo(mmToPixels(70), mmToPixels(64));
        MoveTo cbmMove2 = new MoveTo(mmToPixels(70), mmToPixels(70));
        LineTo cbmLine2 = new LineTo(mmToPixels(70), mmToPixels(118));
        MoveTo cbmMove3 = new MoveTo(mmToPixels(70), mmToPixels(70));
        LineTo cbmLine3 = new LineTo(mmToPixels(67), mmToPixels(64));
        MoveTo cbmMove4 = new MoveTo(mmToPixels(67.6), mmToPixels(66));
        LineTo cbmLine4 = new LineTo(mmToPixels(66.5), mmToPixels(66.8));
        LineTo cbmLine5 = new LineTo(mmToPixels(67.7), mmToPixels(69));
        LineTo cbmLine6 = new LineTo(mmToPixels(68.7), mmToPixels(68.3));
        //line from N
        MoveTo cbmMove5 = new MoveTo(mmToPixels(73), mmToPixels(56));
        LineTo cbmLine7 = new LineTo(mmToPixels(73), mmToPixels(73));
        LineTo cbmLine8 = new LineTo(mmToPixels(70), mmToPixels(78));

        oneLineModule.getElements().addAll(cbmMove1, cbmLine1, cbmMove2, cbmLine2, cbmMove3, cbmLine3, cbmMove4,
                cbmLine4, cbmLine5, cbmLine6, cbmMove5, cbmLine7, cbmLine8);

        //line 1 to connect Pe line to circuit breaker
        Line cbmLinePe1 = new Line(mmToPixels(70), mmToPixels(78), mmToPixels(76), mmToPixels(73));
        cbmLinePe1.setStroke(Color.BLACK);
        cbmLinePe1.setStrokeWidth(mmToPixels(0.4));
        cbmLinePe1.getStrokeDashArray().addAll(mmToPixels(3), mmToPixels(1), mmToPixels(0.5), mmToPixels(1));

        //line 2 to connect Pe line to circuit breaker
        Line cbmLinePe2 = new Line(mmToPixels(76), mmToPixels(73), mmToPixels(76), mmToPixels(59));
        cbmLinePe2.setStroke(Color.BLACK);
        cbmLinePe2.setStrokeWidth(mmToPixels(0.4));
        cbmLinePe2.getStrokeDashArray().addAll(mmToPixels(3), mmToPixels(1), mmToPixels(0.5), mmToPixels(1));

        //line to show it is one phase module
        Line line1phase = new Line(mmToPixels(68), mmToPixels(85), mmToPixels(72), mmToPixels(82));
        line1phase.setStroke(Color.BLACK);
        line1phase.setStrokeWidth(mmToPixels(0.18));

        SchemePage.getSchemePage().addToRootPane(circleL, circleN, circlePe, oneLineModule, cbmLinePe1, cbmLinePe2, line1phase);
    }
}
