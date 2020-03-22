/*
 *No license, free to use.
 *
 * Made for learning purpose.
 *
 */

package grandConfigurator;

import electricalEquipmentFactory.ElectricalEquipment;
import java.util.ArrayList;

/**
 * This class supposed to store arraylist, that is collection of Pumps and Heaters objects.
 * It is singleton because I might need to call this collection from different places and this is a good API to do it.
 * Also it must be only one collection in each session.
 *
 * @version             1.0 02 Feb 2020
 * @author              A.G.D.
 */
public class GrandCollection {

    /**Storing total sum of pumps group current.*/
    public static double totalPumpCurrent;

    /**Storing total sum of heaters group current.*/
    public static double totalHeaterCurrent;

    /**Storing total sum collection current.*/
    public static double totalCurrent;

    /**Collection storage, Singleton class.*/
    private static GrandCollection grandCollection;

    /**Collection (ArrayList).*/
    private ArrayList<ElectricalEquipment> collection = null;

    /**Getting GrandCollection static class*/
    public static synchronized GrandCollection getGrandCollection() {
        //main trick to create singleton. This is method to call my collection storage from anywhere.
        if (grandCollection == null) {
            grandCollection = new GrandCollection();
        }
        return grandCollection;
    }

    //constructor declare memory for collection.
    private GrandCollection() {
        collection = new ArrayList<ElectricalEquipment>();
    }

//methods to work with my dear collection
    /**Calling collection method*/
    public ArrayList<ElectricalEquipment> getCollection() {
        return this.collection;
    }

    /**Adding to collection*/
    public void addToCollection(ElectricalEquipment electricalEquipment) {
        collection.add(electricalEquipment);
        System.out.println(electricalEquipment.name + " added to collection.");
    }

    /*
    //remove from collection
    public void removeFromCollection(ElectricalEquipment electricalEquipment) {
        collection.remove(electricalEquipment);
        System.out.println(electricalEquipment.name + " was removed from collection.");
    }
    */

    /**
     * Grand Collection methods reminder:
     * 0. Calling/creating grandCollection:
     * ... GrandCollection.getGrandCollection();
     * 1. Calling collection:
     * ...GrandCollection.getGrandCollection().getCollection();
     * 2. Adding to Collection:
     * ...GrandCollection.getGrandCollection().addToCollection(object to add name);
     */
    //Yeap, I know it's dangling JavaDoc comment above. Ashamed.

}

/*
Idea how to work with Singleton collection:
https://stackoverflow.com/questions/40152454/arraylist-initialized-accessed-using-singleton-class
*/