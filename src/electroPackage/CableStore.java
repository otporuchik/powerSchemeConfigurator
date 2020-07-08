package electroPackage;

import static constants.Electrical.*;

/**
 * Class to get cable for electrical equipment to supply
 */
public class CableStore {
    /**
     * method to find cable cross section area knowing current load.
     * @param operatingCurrent
     * @return
     */
    private static double getCableArea(double operatingCurrent) {
        for(int i = 0; i < CABLE_AREA.length; i++) {
            if(CABLE_AREA[i][0] > operatingCurrent * COEFFICIENT_OF_DEVIATION) {
                return CABLE_AREA[i][1];
            }
        }
        return 0;
    }

    /**
     * Getting particular cable knowing voltage (depends 3 or 4 wire cable will be chosen) and current load.
     * @param voltage
     * @param operatingCurrent
     * @return
     */
    public static String getCable(int voltage, double operatingCurrent) {
        String cable;
        cable = "";

        switch (voltage) {
            case 220:
                cable = "ВВГнг(А)-LS 3х" + getCableArea(operatingCurrent);
                break;
            case 380:
                cable = "ВВГнг(А)-LS 4х" + getCableArea(operatingCurrent);
                break;
        }

        return cable;
    }
}
