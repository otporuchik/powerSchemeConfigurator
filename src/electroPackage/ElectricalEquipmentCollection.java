package electroPackage;

import java.util.ArrayList;

/**
 * Class to create and manage collection of electrical equipments
 * Supposed to be singleton.
 * Not synchronized yet, so, not for multi threads apps...
 */
public class ElectricalEquipmentCollection {

    /** Class lonely object. Available only by method calling. */
    private static ElectricalEquipmentCollection electricalEquipmentCollection;

    /** Class lonely collection for collecting electrical equipments */
    private ArrayList<ElectricalEquipment> collection;

    /** Class object constructor declare memory for collection object */
    private ElectricalEquipmentCollection() {
        collection = new ArrayList<ElectricalEquipment>();
    }

    /** Method to call this class only and lonely object from anywhere.
     * Not synchronized for multi threads working. Lazy initialization.
     */
    public static ElectricalEquipmentCollection getElectricalEquipmentCollection() {
        if (electricalEquipmentCollection == null) {
            electricalEquipmentCollection = new ElectricalEquipmentCollection();
        }
        return electricalEquipmentCollection;
    }

    /** Calling this class lonely collection method */
    public ArrayList<ElectricalEquipment> getCollection() {
        return this.collection;
    }

    /** Adding new objects into this collection method */
    public void addToCollection(ElectricalEquipment electricalEquipment) {
        collection.add(electricalEquipment);
        System.out.println(electricalEquipment.getName() + " added to collection");
    }
}
