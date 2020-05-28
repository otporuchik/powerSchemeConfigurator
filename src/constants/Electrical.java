/*
*No license, free to use.
*
* Made for learning purpose.
*
 */

package constants;

import electroPackage.ElectricalEquipmentTypes;

/**
 * Storing miscellaneous electrical constants for further usage in program
 * and methods to use them appropriately.
 *
 * @version             1.0 02 Feb 2020
 * @author              A.G.D.
 */
public class Electrical {

    /**approximate value to count power of electrical motor*/
    public final static double COEFFICIENT_OF_EFFICIENCY = 0.9; //COEFFICIENT_OF_EFFICIENCY = efficiency factor

    /**approximate value to count power of electrical motor*/
    public final static double COS_F = 0.85; //COS_F = power factor

    /**approximate value of deviation*/
    public final static double COEFFICIENT_OF_DEVIATION = 1.15;

    /**array of typical values of electrical motors powers*/
    public static double[] STANDARD_PUMP_POWER_ARRAY = {0.25, 0.37, 0.55, 0.75, 1.1, 1.5, 2.2, 3.0, 4.0, 5.5,
            1.1, 2.2, 3.0, 4.0, 5.5, 7.5, 11.0, 15.0, 18.5,
            22.0, 30.0, 37.0, 45.0, 55.0, 75.0};

    /**array of typical circuit breakers values with most frequent using*/
    public static int[] STANDARD_CIRCUIT_BREAKERS_ARRAY = { 1, 3, 6, 10, 16, 20, 25, 32, 40, 50, 63, 80, 100 };

    /**
     * 2-dimensional array of typical motor protectors values, based on ABB MS-116 type
     * First dimension include array with 2 values. First = min value of motor protector current,
     * second = max value.
     */
    public static double[][] STANDARD_MOTOR_PROTECTORS_ARRAY = { {0.10, 0.16}, {0.16, 0.25}, {0.25, 0.40}, {0.40, 0.63},
                             {0.63, 1.00}, {1.00, 1.6}, {1.6, 2.5}, {2.5, 4.00}, {4.00, 6.3}, {6.3, 10.00}, {8.00, 12.00},
                            {10.00, 16.00}, {16.00, 20.00}, {20.00, 25.00}, {25.00, 32.00}};
    /*
    https://library.e.abb.com/public/7f9b6ba20107808885257d50004b552c/AC1010_2013.pdf
     */

    //methods to work with constants
//useful link: https://elektroshkola.ru/kalkulyatory/onlajn-raschet-xarakteristik-trexfaznyx-elektrodvigatelej/

    /**Getting power.*/
    public static double getPower(ElectricalEquipmentTypes type, int voltage, double operatingCurrent) {
        double power = 0;

        switch(type) {
            case PUMP:
            case VENTILATOR:
            case ANY_OTHER_INDUCTIVE_LOAD:
                power = 1.73 * voltage * operatingCurrent * COEFFICIENT_OF_EFFICIENCY * COS_F / 1000;

                thisLoop: for(int i = 0; i < STANDARD_PUMP_POWER_ARRAY.length; i++) {
                    if ((STANDARD_PUMP_POWER_ARRAY[i] >= power)) {
                        power = STANDARD_PUMP_POWER_ARRAY[i];
                        break thisLoop;
                    } else if (power > STANDARD_PUMP_POWER_ARRAY[STANDARD_PUMP_POWER_ARRAY.length - 1]) {
                        power = 0.0; //This value is not best idea, but it won't get appropriate result and makes operator to think.
                    }
                }
                power *= 1000;
                break;

            case HEATER:
            case LIGHT:
            case SOCKET:
            case ANY_OTHER_RESISTIVE_LOAD:
                power = voltage * operatingCurrent;
                break;
        }
        return power;
    }

    /** Getting operating current */
    public static double getCurrent(ElectricalEquipmentTypes type, int voltage, double power) {
        double coefficientOfEfficiency = COEFFICIENT_OF_EFFICIENCY;
        double cosF = COS_F;
        double operatingCurrent = 0;

        switch (type) {
            case PUMP:
            case VENTILATOR:
            case ANY_OTHER_INDUCTIVE_LOAD:
//      Assuming that voltage is 380V.
                if (power < 1100) {
                    coefficientOfEfficiency = 0.75;
                    cosF = 0.8;
                } else if (power >= 1100 && power < 7500) {
                    coefficientOfEfficiency = 0.8;
                    cosF = 0.85;
                } else if (power >= 7500) {
                    coefficientOfEfficiency = 0.85;
                    cosF = 0.9;
                }
                operatingCurrent = power / (1.73 * voltage * coefficientOfEfficiency * cosF);
                break;

            case HEATER:
            case LIGHT:
            case SOCKET:
            case ANY_OTHER_RESISTIVE_LOAD:
                operatingCurrent = power / voltage;
                break;
        }
        return operatingCurrent;
    }
}

