package graphics;

import constants.Graphics;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.*;

import static constants.Graphics.mmToPixels;

/**
 * Work field for one line power scheme.
 * Table drawn here as path, filled with texts.
 * Three lines which are L, N and Pe lines.
 * Bottom table as path to fill it with electrical
 * equipments data.
 * By default suits for A3, if you need different
 * size, set it before first calling to get work
 * field with "setWidth".
 */
public class WorkField {
    /** Width of Pane where stamp supposed to be.
     *  By default = WIDTH_A3
     */
    private static double width = Graphics.WIDTH_A3;

    /** setting width if it differs from A3 */
    public static void setWidth(double width) {
        WorkField.width = width;
    }

    /**
     * Getting workField.
     */
    public static void getWorkField() {
        //setting path as work fields stamp table bounds
        Path workFieldStamp = new Path();
        workFieldStamp.setStroke(Color.BLACK);
        workFieldStamp.setStrokeWidth(mmToPixels(0.5));
        MoveTo moveTo1 = new MoveTo(mmToPixels(55), mmToPixels(5));
        LineTo line1 = new LineTo(mmToPixels(55), mmToPixels(165));
        LineTo line2 = new LineTo(mmToPixels(20), mmToPixels(165));
        MoveTo move2 = new MoveTo(mmToPixels(20), mmToPixels(22));
        LineTo line3 = new LineTo(mmToPixels(55), mmToPixels(22));
        MoveTo move3 = new MoveTo(mmToPixels(55), mmToPixels(59));
        LineTo line4 = new LineTo(mmToPixels(29), mmToPixels(59));
        MoveTo move5 = new MoveTo(mmToPixels(20), mmToPixels(81));
        LineTo line5 = new LineTo(mmToPixels(55), mmToPixels(81));
        MoveTo move6 = new MoveTo(mmToPixels(29), mmToPixels(22));
        LineTo line6 = new LineTo(mmToPixels(29), mmToPixels(165));
        MoveTo move7 = new MoveTo(mmToPixels(20), mmToPixels(118));
        LineTo line7 = new LineTo(mmToPixels(55), mmToPixels(118));
        MoveTo move8 = new MoveTo(mmToPixels(55), mmToPixels(125));
        LineTo line8 = new LineTo(mmToPixels(29), mmToPixels(125));
        MoveTo move9 = new MoveTo(mmToPixels(29), mmToPixels(132));
        LineTo line9 = new LineTo(mmToPixels(55), mmToPixels(132));
        MoveTo move10 = new MoveTo(mmToPixels(55), mmToPixels(139));
        LineTo line10 = new LineTo(mmToPixels(29), mmToPixels(139));
        MoveTo move11 = new MoveTo(mmToPixels(29), mmToPixels(148));
        LineTo line11 = new LineTo(mmToPixels(55), mmToPixels(148));

        workFieldStamp.getElements().addAll(moveTo1, line1, line2, move2, line3, move3, line4, move5,
                line5, move6, line6, move7, line7, move8, line8, move9, line9, move10, line10, move11, line11);

        //Filling work field stamp with text
        Text text1 = new Text("Данные питающей\nсети");
        text1.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
        text1.setTextAlignment(TextAlignment.CENTER);
        text1.setFill(Color.BLACK);
        text1.setX(mmToPixels(25.5));
        text1.setY(mmToPixels(13));

        Text text2 = new Text("Вводное\nустройство");
        text2.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
        text2.setTextAlignment(TextAlignment.CENTER);
        text2.setFill(Color.BLACK);
        text2.setX(mmToPixels(34.5));
        text2.setY(mmToPixels(40));

        Text text3 = new Text("Автоматический\nвыключатель");
        text3.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
        text3.setTextAlignment(TextAlignment.CENTER);
        text3.setFill(Color.BLACK);
        text3.setX(mmToPixels(31));
        text3.setY(mmToPixels(70));

        Text text4 = new Text("Марка кабеля,\nколичество жил,\nсечение");
        text4.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
        text4.setTextAlignment(TextAlignment.CENTER);
        text4.setFill(Color.BLACK);
        text4.setX(mmToPixels(31.5));
        text4.setY(mmToPixels(96));

        Text text5 = new Text("Условное\nобозначение");
        text5.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
        text5.setTextAlignment(TextAlignment.CENTER);
        text5.setFill(Color.BLACK);
        text5.setX(mmToPixels(33.5));
        text5.setY(mmToPixels(121));

        Text text6 = new Text("Фаза");
        text6.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
//        text6.setTextAlignment(TextAlignment.CENTER);
        text6.setFill(Color.BLACK);
        text6.setX(mmToPixels(38));
        text6.setY(mmToPixels(129));

        Text text7 = new Text("Мощность, кВт");
        text7.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
//        text7.setTextAlignment(TextAlignment.CENTER);
        text7.setFill(Color.BLACK);
        text7.setX(mmToPixels(32));
        text7.setY(mmToPixels(136));

        Text text8 = new Text("Ток, А");
        text8.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
//        text8.setTextAlignment(TextAlignment.CENTER);
        text8.setFill(Color.BLACK);
        text8.setX(mmToPixels(38));
        text8.setY(mmToPixels(144));

        Text text9 = new Text("Наименование\nэлектроприемника");
        text9.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
        text9.setTextAlignment(TextAlignment.CENTER);
        text9.setFill(Color.BLACK);
        text9.setX(mmToPixels(30));
        text9.setY(mmToPixels(155));

        //rotated text
        Text text10 = new Text("Распределительный щит");
        text10.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
        text10.setFill(Color.BLACK);
        text10.setX(mmToPixels(8));
        text10.setY(mmToPixels(55));
        text10.setRotate(-90);

        Text text11 = new Text("Распределительная\nсеть");
        text11.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
        text11.setTextAlignment(TextAlignment.CENTER);
        text11.setFill(Color.BLACK);
        text11.setX(mmToPixels(11.5));
        text11.setY(mmToPixels(99));
        text11.setRotate(-90);

        Text text12 = new Text("Электроприемник");
        text12.setFont(Font.font("ARIAL", FontWeight.NORMAL, FontPosture.REGULAR, mmToPixels(2.8)));
        text12.setFill(Color.BLACK);
        text12.setX(mmToPixels(13));
        text12.setY(mmToPixels(142));
        text12.setRotate(-90);

        //drawing work field
        Line wfTopDashedLine = new Line(mmToPixels(60), mmToPixels(22), width - mmToPixels(10), mmToPixels(22));
        wfTopDashedLine.getStrokeDashArray().addAll(mmToPixels(3), mmToPixels(1));
        wfTopDashedLine.setStroke(Color.BLACK);
        wfTopDashedLine.setStrokeWidth(mmToPixels(0.18));

        Line wfMiddleDashedLine = new Line(mmToPixels(60), mmToPixels(81), width - mmToPixels(10), mmToPixels(81));
        wfMiddleDashedLine.getStrokeDashArray().addAll(mmToPixels(3), mmToPixels(1));
        wfMiddleDashedLine.setStroke(Color.BLACK);
        wfMiddleDashedLine.setStrokeWidth(mmToPixels(0.18));

        Line lineL = new Line(mmToPixels(60), mmToPixels(53), width - mmToPixels(10), mmToPixels(53));
        lineL.setStroke(Color.BLACK);
        lineL.setStrokeWidth(mmToPixels(0.4));

        Line lineN = new Line(mmToPixels(60), mmToPixels(56), width - mmToPixels(10), mmToPixels(56));
        lineN.setStroke(Color.BLACK);
        lineN.setStrokeWidth(mmToPixels(0.4));

        Line LinePe = new Line(mmToPixels(60), mmToPixels(59), width - mmToPixels(10), mmToPixels(59));
        LinePe.getStrokeDashArray().addAll(mmToPixels(3), mmToPixels(1), mmToPixels(0.5), mmToPixels(1));
        LinePe.setStroke(Color.BLACK);
        LinePe.setStrokeWidth(mmToPixels(0.4));

        Text lineLtext = new Text("L");
        lineLtext.setFont(Font.font("ARIAL", FontWeight.BOLD, FontPosture.REGULAR, mmToPixels(3)));
        lineLtext.setFill(Color.BLACK);
        lineLtext.setX(mmToPixels(57));
        lineLtext.setY(mmToPixels(54));

        Text lineNtext = new Text("N");
        lineNtext.setFont(Font.font("ARIAL", FontWeight.BOLD, FontPosture.REGULAR, mmToPixels(3)));
        lineNtext.setFill(Color.BLACK);
        lineNtext.setX(mmToPixels(57));
        lineNtext.setY(mmToPixels(57));

        Text linePEtext = new Text("PE");
        linePEtext.setFont(Font.font("ARIAL", FontWeight.BOLD, FontPosture.REGULAR, mmToPixels(3)));
        linePEtext.setFill(Color.BLACK);
        linePEtext.setX(mmToPixels(55.5));
        linePEtext.setY(mmToPixels(60));

        Path wfDataLines = new Path();
        wfDataLines.setStroke(Color.BLACK);
        wfDataLines.setStrokeWidth(mmToPixels(0.5));
        MoveTo wfMove1 = new MoveTo(mmToPixels(60), mmToPixels(118));
        LineTo wfLine1 = new LineTo(width - mmToPixels(10), mmToPixels(118));
        LineTo wfLine2 = new LineTo(width - mmToPixels(10), mmToPixels(165));
        LineTo wfLine3 = new LineTo(mmToPixels(60), mmToPixels(165));
        LineTo wfLine4 = new LineTo(mmToPixels(60), mmToPixels(118));
        MoveTo wfMove2 = new MoveTo(mmToPixels(60), mmToPixels(125));
        LineTo wfLine5 = new LineTo(width - mmToPixels(10), mmToPixels(125));
        MoveTo wfMove3 = new MoveTo(mmToPixels(60), mmToPixels(132));
        LineTo wfLine6 = new LineTo(width - mmToPixels(10), mmToPixels(132));
        MoveTo wfMove4 = new MoveTo(mmToPixels(60), mmToPixels(139));
        LineTo wfLine7 = new LineTo(width - mmToPixels(10), mmToPixels(139));
        MoveTo wfMove5 = new MoveTo(mmToPixels(60), mmToPixels(148));
        LineTo wfLine8 = new LineTo(width - mmToPixels(10), mmToPixels(148));

        wfDataLines.getElements().addAll(wfMove1, wfLine1, wfLine2, wfLine3, wfLine4, wfMove2, wfLine5,
                wfMove3, wfLine6, wfMove4, wfLine7, wfMove5, wfLine8);

        SchemePage.getSchemePage().addToRootPane(workFieldStamp, text1, text2, text3,
                text4, text5, text6, text7, text8, text9, text10, text11, text12, wfTopDashedLine, wfMiddleDashedLine,
                lineL, lineN, LinePe, lineLtext, lineNtext, linePEtext, wfDataLines);
    }

}
