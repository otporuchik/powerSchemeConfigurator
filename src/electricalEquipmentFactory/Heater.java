/*
 *No license, free to use.
 *
 * Made for learning purpose.
 *
 */

package electricalEquipmentFactory;

import grandConfigurator.GrandConfigurator;

/**
 * Basic class for heaters.
 * Counting missed fields like power or current.
 * Getting power protector from Grand Configurator.
 *
 * @version             1.0 02 Feb 2020
 * @author              A.G.D.
 */
public class Heater extends ElectricalEquipment {
    public Heater(int voltage, double operatingCurrent, String name, double power) {
        this.name = name;
        this.voltage = voltage;
        this.operatingCurrent = operatingCurrent;
        this.power = power;
        this.protector = GrandConfigurator.getCircuitBreaker(operatingCurrent);
    }

    /**Counting power method*/
    public static double getPower(int voltage, double operatingCurrent) {

        return voltage * operatingCurrent;
    }

    /**Counting current method*/
    public static double getOperatingCurrent(int voltage, double power) {
        return power / voltage;
    }

    /**Getting objects data method*/
    public String getData() {
        return ("Heater " + name + ": \n" +
                "circuit breaker: " + protector + ";\n" +
                "voltage: " + voltage + "V;\n" +
                "operating current: " + operatingCurrent + "A;\n" +
                "power: " + power + "W.\n");
    }
}
