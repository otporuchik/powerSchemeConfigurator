/*
 *No license, free to use.
 *
 * Made for learning purpose.
 *
 */

package electricalEquipmentFactory;
/**
 * Basic class of electrical equipments.
 * Storing common fields.
 *
 * @version             1.0 02 Feb 2020
 * @author              A.G.D.
 */
public abstract class ElectricalEquipment {
    public String name;
    public String protector;
    public int voltage;
    public double operatingCurrent;
    public  double power;

    /**
     * Creating string with object data i.e. fields values.
     * For example: "Heater " + name + ": \n" + "circuit breaker: " + protector + " etc.
     */
    public abstract String getData();
}
