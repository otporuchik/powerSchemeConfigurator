package graphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;

import static constants.Graphics.mmToPixels;

/**
 * Class to store circuit breakers graphics.
 */
public class CircuitBreaker {

    /** Value to move next breaker to the right after each call creating breaker method. */
    private static int moveCounter = 0;

    public static void getCircuitBreaker() {
//1 phase circuit breaker module
        //here it starts
        Circle circleL = new Circle();
        circleL.setCenterX(mmToPixels(70 + moveCounter));
        circleL.setCenterY(mmToPixels(53));
        circleL.setRadius(mmToPixels(0.8));
        circleL.setFill(Color.BLACK);

        Circle circleN = new Circle();
        circleN.setCenterX(mmToPixels(73 + moveCounter));
        circleN.setCenterY(mmToPixels(56));
        circleN.setRadius(mmToPixels(0.8));
        circleN.setFill(Color.BLACK);

        Circle circlePe = new Circle();
        circlePe.setCenterX(mmToPixels(76 + moveCounter));
        circlePe.setCenterY(mmToPixels(59));
        circlePe.setRadius(mmToPixels(0.8));
        circlePe.setFill(Color.BLACK);

        Path oneLineModule = new Path();
        oneLineModule.setStroke(Color.BLACK);
        oneLineModule.setStrokeWidth(mmToPixels(0.4));
        MoveTo cbmMove1 = new MoveTo(mmToPixels(70 + moveCounter), mmToPixels(53));
        LineTo cbmLine1 = new LineTo(mmToPixels(70 + moveCounter), mmToPixels(64));
        MoveTo cbmMove2 = new MoveTo(mmToPixels(70 + moveCounter), mmToPixels(70));
        LineTo cbmLine2 = new LineTo(mmToPixels(70 + moveCounter), mmToPixels(118));
        MoveTo cbmMove3 = new MoveTo(mmToPixels(70 + moveCounter), mmToPixels(70));
        LineTo cbmLine3 = new LineTo(mmToPixels(67 + moveCounter), mmToPixels(64));
        MoveTo cbmMove4 = new MoveTo(mmToPixels(67.6 + moveCounter), mmToPixels(66));
        LineTo cbmLine4 = new LineTo(mmToPixels(66.5 + moveCounter), mmToPixels(66.8));
        LineTo cbmLine5 = new LineTo(mmToPixels(67.7 + moveCounter), mmToPixels(69));
        LineTo cbmLine6 = new LineTo(mmToPixels(68.7 + moveCounter), mmToPixels(68.3));
        //line from N
        MoveTo cbmMove5 = new MoveTo(mmToPixels(73 + moveCounter), mmToPixels(56));
        LineTo cbmLine7 = new LineTo(mmToPixels(73 + moveCounter), mmToPixels(73));
        LineTo cbmLine8 = new LineTo(mmToPixels(70 + moveCounter), mmToPixels(78));

        oneLineModule.getElements().addAll(cbmMove1, cbmLine1, cbmMove2, cbmLine2, cbmMove3, cbmLine3, cbmMove4,
                cbmLine4, cbmLine5, cbmLine6, cbmMove5, cbmLine7, cbmLine8);

        //line 1 to connect Pe line to circuit breaker
        Line cbmLinePe1 = new Line(mmToPixels(70 + moveCounter), mmToPixels(78), mmToPixels(76 + moveCounter), mmToPixels(73));
        cbmLinePe1.setStroke(Color.BLACK);
        cbmLinePe1.setStrokeWidth(mmToPixels(0.4));
        cbmLinePe1.getStrokeDashArray().addAll(mmToPixels(3), mmToPixels(1), mmToPixels(0.5), mmToPixels(1));

        //line 2 to connect Pe line to circuit breaker
        Line cbmLinePe2 = new Line(mmToPixels(76 + moveCounter), mmToPixels(73), mmToPixels(76 + moveCounter), mmToPixels(59));
        cbmLinePe2.setStroke(Color.BLACK);
        cbmLinePe2.setStrokeWidth(mmToPixels(0.4));
        cbmLinePe2.getStrokeDashArray().addAll(mmToPixels(3), mmToPixels(1), mmToPixels(0.5), mmToPixels(1));

        //line to show it is one phase module
        Line line1phase = new Line(mmToPixels(68 + moveCounter), mmToPixels(85), mmToPixels(72 + moveCounter), mmToPixels(82));
        line1phase.setStroke(Color.BLACK);
        line1phase.setStrokeWidth(mmToPixels(0.18));

        //Electrical equipment circuit breaker border line in data table
        Line rightBorderLine = new Line(mmToPixels(80 + moveCounter), mmToPixels(118), mmToPixels(80 + moveCounter), mmToPixels(165));
        rightBorderLine.setStroke(Color.BLACK);
        rightBorderLine.setStrokeWidth(mmToPixels(0.5));

        //Filling table data
        Text phaseValue = new Text("phase");
        phaseValue.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(3)));
        phaseValue.setFill(Color.BLACK);
        phaseValue.setWrappingWidth(mmToPixels(18));
        phaseValue.setTextAlignment(TextAlignment.CENTER);
        phaseValue.setX(mmToPixels(61 + moveCounter));
        phaseValue.setY(mmToPixels(122.5 + 7));

        Text powerValue = new Text("POWER");
        powerValue.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(3)));
        powerValue.setFill(Color.BLACK);
        powerValue.setWrappingWidth(mmToPixels(18));
        powerValue.setTextAlignment(TextAlignment.CENTER);
        powerValue.setX(mmToPixels(61 + moveCounter));
        powerValue.setY(mmToPixels(122.5 + 7 + 7));

        Text currentValue = new Text("current42");
        currentValue.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(3)));
        currentValue.setFill(Color.BLACK);
        currentValue.setWrappingWidth(mmToPixels(18));
        currentValue.setTextAlignment(TextAlignment.CENTER);
        currentValue.setX(mmToPixels(61 + moveCounter));
        currentValue.setY(mmToPixels(122.5 + 7 + 7 + 7));

        Text nameValue = new Text("name\nsurname\n1543924\nhuhhuhh");
        nameValue.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(3)));
        nameValue.setFill(Color.BLACK);
        nameValue.setWrappingWidth(mmToPixels(18));
        nameValue.setTextAlignment(TextAlignment.CENTER);
        nameValue.setX(mmToPixels(61 + moveCounter));
        nameValue.setY(mmToPixels(122.5 + 7 + 7 + 7 + 8.5));

        SchemePage.getSchemePage().addToRootPane(circleL, circleN, circlePe, oneLineModule, cbmLinePe1, cbmLinePe2, rightBorderLine, line1phase, phaseValue, powerValue, currentValue, nameValue);

        moveCounter += 20;
    }
}
