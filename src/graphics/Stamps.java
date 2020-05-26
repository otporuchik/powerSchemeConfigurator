package graphics;

import constants.Graphics;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

import static constants.Graphics.mmToPixels;

/** Creating stamps to be set on scheme pages.
 *  By default it'll be ready to be set on A3 size,
 *  if you need it to be set on another size page,
 *  then before using setStamp method, set
 *  width and height.
 */
public class Stamps {
    /** Width of Pane where stamp supposed to be.
     *  By default = WIDTH_A3
     */
    private static double width = Graphics.WIDTH_A3;
    /** Height of Pane where stamp supposed to be
     *  By default = HEIGHT_A3
     */
    private static double height = Graphics.HEIGHT_A3;

    /** setting width if it differs from A3 */
    public static void setWidth(double width) {
        Stamps.width = width;
    }

    /** Setting height if it differs from A3 */
    public static void setHeight(double height) {
        Stamps.height = height;
    }

    /**
     * Dividing row in lines depending on allowed row length.
     * text - one row text to divide on several rows,
     * maxLength - max length of symbols in one row.
     */
    public static String divideRows(String text, int maxLength) {
        int stringLength = text.length();
        int dividerIndex = 0;//индекс последнего разделителя слов
        int charCounter = 0;//количество знаков
        boolean wordFound = false;

        char[] textArray = text.toCharArray();

        //длина строки не должна быть больше максимально допустимого значения
        for(int i = 0; i < stringLength; i++) {
            charCounter++;
            if(charCounter >= maxLength) {
                textArray[dividerIndex] = '\n';
                charCounter = 0;
            }
            //определяем разделители между словами (пробел)
            if(textArray[i] == ' ' && !wordFound) {
                wordFound = true;
                dividerIndex = i;
            } else {
                wordFound = false;
            }
        }

        return new String(textArray);
    }

    /**
     * Setting row high depending on number of rows and initial high
     * when String has only one row.
     */
    public static double getRowHigh(String text, int maxLength, double initHeight) {
        double height = initHeight;//высота расположения начальной строки.
        int rowNumber = 1;//количество строк.
        char[] textArray = text.toCharArray();

        //считаем количество строк.
        for (int i = 0; i < text.length(); i++) {
            if (i > maxLength * rowNumber) {
                rowNumber++;
            }
        }

        if(rowNumber >= 3 && rowNumber < 5) {
            height -= 5; //поднимаем на высоту одной строки. в основном штампе = 5мм.
        } else if(rowNumber >= 5) {
            height -= 10; //поднимаем на две строки.
        }
        return height;
    }

    /**
     * Getting main stamp on the page.
     * Add this as a Node to rootPane.
     */
    public static void getMainStamp() {
        //mainStamp as canvas
        Canvas mainStamp = new Canvas();
        mainStamp.setWidth(mmToPixels(185));
        mainStamp.setHeight(mmToPixels(55));
        //set canvas position
        mainStamp.setTranslateX(width - mmToPixels(190));
        mainStamp.setTranslateY(height - mmToPixels(60));
        //getting graphic context
        GraphicsContext gc = mainStamp.getGraphicsContext2D();
        //drawing stamps outer frame
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(mmToPixels(1));
        gc.strokeRect(0,0,mmToPixels(185),mmToPixels(55));
        //drawing left table rows
        gc.setLineWidth(mmToPixels(0.18));
        gc.strokeLine(0, mmToPixels(5), mmToPixels(65), mmToPixels(5));
        gc.strokeLine(0, mmToPixels(10), mmToPixels(65), mmToPixels(10));
        gc.strokeLine(0, mmToPixels(15), mmToPixels(65), mmToPixels(15));
        gc.setLineWidth(mmToPixels(0.5));
        gc.strokeLine(0, mmToPixels(20), mmToPixels(65), mmToPixels(20));
        gc.strokeLine(0, mmToPixels(25), mmToPixels(65), mmToPixels(25));
        gc.setLineWidth(mmToPixels(0.18));
        gc.strokeLine(0, mmToPixels(30), mmToPixels(65), mmToPixels(30));
        gc.strokeLine(0, mmToPixels(35), mmToPixels(65), mmToPixels(35));
        gc.strokeLine(0, mmToPixels(40), mmToPixels(65), mmToPixels(40));
        gc.strokeLine(0, mmToPixels(45), mmToPixels(65), mmToPixels(45));
        gc.strokeLine(0, mmToPixels(50), mmToPixels(65), mmToPixels(50));
        //drawing left table columns
        gc.setLineWidth(mmToPixels(0.5));
        gc.strokeLine(mmToPixels(7), 0, mmToPixels(7), mmToPixels(25));
        gc.strokeLine(mmToPixels(17), 0, mmToPixels(17), mmToPixels(55));
        gc.strokeLine(mmToPixels(40), 0, mmToPixels(40), mmToPixels(55));
        gc.strokeLine(mmToPixels(55), 0, mmToPixels(55), mmToPixels(55));
        gc.strokeLine(mmToPixels(65), 0, mmToPixels(65), mmToPixels(55));
        //drawing right side rows
        gc.setLineWidth(mmToPixels(0.5));
        gc.strokeLine(mmToPixels(65), mmToPixels(15), mmToPixels(185), mmToPixels(15));
        gc.strokeLine(mmToPixels(65), mmToPixels(40), mmToPixels(185), mmToPixels(40));
        //drawing right side table columns
        gc.setLineWidth(mmToPixels(0.5));
        gc.strokeLine(mmToPixels(135), mmToPixels(15), mmToPixels(135), mmToPixels(55));
        gc.strokeLine(mmToPixels(150), mmToPixels(15), mmToPixels(150), mmToPixels(35));
        gc.strokeLine(mmToPixels(167), mmToPixels(15), mmToPixels(167), mmToPixels(35));
        gc.strokeLine(mmToPixels(155), mmToPixels(35), mmToPixels(155), mmToPixels(40));
        //drawing right side table rows
        gc.setLineWidth(mmToPixels(0.5));
        gc.strokeLine(mmToPixels(135), mmToPixels(20), mmToPixels(185), mmToPixels(20));
        gc.strokeLine(mmToPixels(135), mmToPixels(35), mmToPixels(185), mmToPixels(35));

        //drawing static text in main stamp
        //filling first head row
        gc.setFont(Font.font("ARIAL", mmToPixels(2.8)));
        gc.fillText("Изм.", mmToPixels(0.8), mmToPixels(24), mmToPixels(6) );
        gc.fillText("Кол.уч.", mmToPixels(7.5), mmToPixels(24), mmToPixels(9.5) );
        gc.fillText("№ документа", mmToPixels(17.5), mmToPixels(24), mmToPixels(22.5) );
        gc.fillText("Подпись", mmToPixels(40.5), mmToPixels(24), mmToPixels(14.5) );
        gc.fillText("Дата", mmToPixels(55.5), mmToPixels(24), mmToPixels(9.5) );
        //filling left main stamp column
        gc.fillText("Разработал", mmToPixels(0.8), mmToPixels(29), mmToPixels(16) );
        gc.fillText("Проверил", mmToPixels(0.8), mmToPixels(34), mmToPixels(16) );
        gc.fillText("Т.контр.", mmToPixels(0.8), mmToPixels(39), mmToPixels(16) );
        gc.fillText("Н.контр.", mmToPixels(0.8), mmToPixels(49), mmToPixels(16) );
        gc.fillText("Утвердил", mmToPixels(0.8), mmToPixels(54), mmToPixels(16) );
        //filling right head column
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("Литера", mmToPixels(142.5), mmToPixels(19), mmToPixels(14.5) );
        gc.fillText("Масса", mmToPixels(158.5), mmToPixels(19), mmToPixels(16.5) );
        gc.fillText("Масштаб", mmToPixels(176), mmToPixels(19), mmToPixels(17.5) );

        //filling pages data. Need to be changed with real pages data.
        gc.setTextAlign(TextAlignment.CENTER);
        gc.fillText("Код документа", mmToPixels(125), mmToPixels(9), mmToPixels(119));

        //Project name
        String projectName = "здесь указывается наименование проекта, например, очень длинное и сложное наименование из целых трёх строк! или даже гораздо больше, например - целых пять строк. Представляете? Пять! Пяяяяяять строк!!!!";
        gc.fillText(divideRows(projectName, 45), mmToPixels(100), mmToPixels(getRowHigh(projectName, 45, 29)));

        gc.fillText("Лист", mmToPixels(145), mmToPixels(39), mmToPixels(19.5) );
        gc.fillText("Листов", mmToPixels(170), mmToPixels(39), mmToPixels(29.5) );

        //Document name
        String documentName = "Название схемы. Например - схема однолинейная простенькая но хорошая. всего в три строки! ТРИИИИИ строки всего...";
        gc.fillText(divideRows(documentName, 45), mmToPixels(100), mmToPixels(getRowHigh(documentName, 45, 49)));

        //Company name
        String companyName = "Название фирмы. Коротенько";
        gc.fillText(divideRows(companyName, 30), mmToPixels(160), mmToPixels(getRowHigh(companyName, 30, 49)));

        SchemePage.getSchemePage().addToRootPane(mainStamp);
    }

    /**
     * Getting left side stamp
     */
    public static void getLeftStamp() {
        //additional bottom left side stamp
        //leftBottomStamp as canvas
        Canvas leftBottomStamp = new Canvas();
        leftBottomStamp.setWidth(mmToPixels(287));
        leftBottomStamp.setHeight(mmToPixels(12));

        //getting graphic context
        GraphicsContext gcLeftBottomStamp = leftBottomStamp.getGraphicsContext2D();

        //drawing stamps outer frame
        gcLeftBottomStamp.setStroke(Color.BLACK);
        gcLeftBottomStamp.setLineWidth(mmToPixels(1));
        gcLeftBottomStamp.strokeRect(0,0,mmToPixels(145),mmToPixels(12));
        gcLeftBottomStamp.strokeRect(mmToPixels(167),0,mmToPixels(120),mmToPixels(12));
        //drawing horizontal table row
        gcLeftBottomStamp.setLineWidth(mmToPixels(0.18));
        gcLeftBottomStamp.strokeLine(0, mmToPixels(5), mmToPixels(145), mmToPixels(5));
        gcLeftBottomStamp.strokeLine(mmToPixels(167), mmToPixels(5), mmToPixels(287), mmToPixels(5));
        //drawing vertical lines
        gcLeftBottomStamp.strokeLine(mmToPixels(25), 0, mmToPixels(25), mmToPixels(12));
        gcLeftBottomStamp.strokeLine(mmToPixels(60), 0, mmToPixels(60), mmToPixels(12));
        gcLeftBottomStamp.strokeLine(mmToPixels(85), 0, mmToPixels(85), mmToPixels(12));
        gcLeftBottomStamp.strokeLine(mmToPixels(110), 0, mmToPixels(110), mmToPixels(12));
        gcLeftBottomStamp.strokeLine(mmToPixels(227), 0, mmToPixels(227), mmToPixels(12));

        //set canvas position
        leftBottomStamp.setTranslateX(-mmToPixels(129.3)); //(287/2)-(12/2)-8-0.2
        leftBottomStamp.setTranslateY(height - mmToPixels(154.5));

        //filling left side stamp
        gcLeftBottomStamp.setFont(Font.font("ARIAL", mmToPixels(2.8)));
        gcLeftBottomStamp.fillText("Инв.№ подл.", mmToPixels(1),mmToPixels(4));
        gcLeftBottomStamp.fillText("Подпись и дата", mmToPixels(26),mmToPixels(4));
        gcLeftBottomStamp.fillText("Взам. инв. №", mmToPixels(61),mmToPixels(4));
        gcLeftBottomStamp.fillText("Инв. № дубл.", mmToPixels(86),mmToPixels(4));
        gcLeftBottomStamp.fillText("Подпись и дата", mmToPixels(111),mmToPixels(4));

        //rotate left stamp
        leftBottomStamp.setRotate(-90);

        SchemePage.getSchemePage().addToRootPane(leftBottomStamp);
    }


}
