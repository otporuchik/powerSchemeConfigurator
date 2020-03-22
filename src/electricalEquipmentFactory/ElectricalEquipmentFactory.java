/*
 *No license, free to use.
 *
 * Made for learning purpose.
 *
 */

package electricalEquipmentFactory;

/**
 * Producing electrical equipments objects.
 * There three cases:
 * 1. user inputted power and current.
 * 2. user didn't input power.
 * 3. user didn't input current.
 *
 * @version             1.0 02 Feb 2020
 * @author              A.G.D.
 */
public class ElectricalEquipmentFactory {

    /**Building electrical equipment object when user inputted power and current.*/
    public ElectricalEquipment getElectricalEquipment(ElectricalEquipmentTypes type, int voltage, double operatingCurrent, String name, double power){
        ElectricalEquipment toReturn = null;
        switch (type) {
            case PUMP:
                toReturn = new Pump(voltage, operatingCurrent, name, power);
                break;
            case HEATER:
                toReturn = new Heater(voltage, operatingCurrent, name, power);
                break;
            default:
                throw new IllegalArgumentException("Wrong electrical equipment type: " + type);
        }
        return toReturn;
    }

    /**Building electrical equipment object when user didn't input power.*/
    public ElectricalEquipment getElectricalEquipment(ElectricalEquipmentTypes type, int voltage, double operatingCurrent, String name){
        double power;

        ElectricalEquipment toReturn = null;
        switch (type) {
            case PUMP:
                power = Pump.getPower(voltage, operatingCurrent);
                toReturn = new Pump(voltage, operatingCurrent, name, power);
                break;
            case HEATER:
                power = Heater.getPower(voltage, operatingCurrent);
                toReturn = new Heater(voltage, operatingCurrent, name, power);
                break;
            default:
                System.out.println("Wrong electrical equipment type: " + type);
                //throw new IllegalArgumentException("Wrong electrical equipment type: " + type);
        }
        return toReturn;
    }

    /**Building electrical equipment object when user didn't input current.*/
    public ElectricalEquipment getElectricalEquipment(ElectricalEquipmentTypes type, int voltage, String name, double power){
        double operatingCurrent;

        ElectricalEquipment toReturn = null;
        switch (type) {
            case PUMP:
                operatingCurrent = Pump.getOperatingCurrent(voltage, power);
                toReturn = new Pump(voltage, operatingCurrent, name, power);
                break;
            case HEATER:
                operatingCurrent = Heater.getOperatingCurrent(voltage, power);
                toReturn = new Heater(voltage, operatingCurrent, name, power);
                break;
            default:
                System.out.println("Wrong electrical equipment type: " + type);
                //throw new IllegalArgumentException("Wrong electrical equipment type: " + type);
        }
        return toReturn;
    }
}
