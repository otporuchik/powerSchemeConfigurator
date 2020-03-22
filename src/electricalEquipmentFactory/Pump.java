/*
 *No license, free to use.
 *
 * Made for learning purpose.
 *
 */

package electricalEquipmentFactory;

import grandConfigurator.GrandConfigurator;
import static constants.electrical.*;

/**
 * Basic class for pumps.
 * Counting missed fields like power or current.
 * Getting power protector from Grand Configurator.
 *
 * @version             1.0 02 Feb 2020
 * @author              A.G.D.
 */
public class Pump extends ElectricalEquipment {
    public Pump(int voltage, double operatingCurrent, String name, double power) {
        this.name = name;
        this.voltage = voltage;
        this.operatingCurrent = operatingCurrent;
        this.power = power;
        this.protector = GrandConfigurator.getMotorProtector(operatingCurrent);
    }

    //useful link: https://elektroshkola.ru/kalkulyatory/onlajn-raschet-xarakteristik-trexfaznyx-elektrodvigatelej/

    /**Counting power method*/
    public static double getPower(int voltage, double operatingCurrent) {
        double power;
        power = 1.73 * voltage * operatingCurrent * COEFFICIENT_OF_EFFICIENCY * COS_F / 1000;
        return getStandartPumpPower(power);
    }

    /**Getting standard value of power close to counted.*/
    private static double getStandartPumpPower(double power ) {
        boolean flag = false;

        for(int i = 0; i < STANDART_PUMP_POWER_ARRAY.length; i++) {
            if ((STANDART_PUMP_POWER_ARRAY[i] >= power) && (!flag)) {
                power = STANDART_PUMP_POWER_ARRAY[i];
                flag = true;
            } else if (power > STANDART_PUMP_POWER_ARRAY[STANDART_PUMP_POWER_ARRAY.length - 1]) {
                power = 0.0; //This value is not best idea, but it won't get appropriate result and makes operator to think.
             }
        }
        return power * 1000;
    }

    /**Counting current method*/
    public static double getOperatingCurrent(int voltage, double power) {
        double coefficientOfEfficiency = COEFFICIENT_OF_EFFICIENCY;
        double cosF = COS_F;

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

        return (power / (1.73 * voltage * coefficientOfEfficiency * cosF));
    }

    /**Getting objects data method*/
    public String getData() {
        return ("Pump " + name + ": \n" +
                "motor-protector: " + protector + ";\n" +
                "voltage: " + voltage + "V;\n" +
                "operating current: " + operatingCurrent + "A;\n" +
                "power: " + power + "W.\n");
    }
}
