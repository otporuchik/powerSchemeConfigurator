package electroPackage;

/**
 * Class to get cable for electrical equipment to supply
 */
public class CableStore {
    public static String getCable(ElectricalEquipmentTypes type, double operatingCurrent) {
        String cable;
        cable = "КГВВнг(А)-LS 3х16";
        return cable;
    }
}
