package electroPackage;

import static constants.Electrical.*;

/**
 * Class to get circuit breaker or motor protector for electrical equipment
 */
public class CircuitBreakerStore {
    /**
     * Choosing standard circuit breaker value.
     * Restriction - max value of operating current should be less than 100A.
     */
    public static double getCircuitBreakerValue(double operatingCurrent) {
        for(int i = 0; i < STANDARD_CIRCUIT_BREAKERS_ARRAY.length; i++) {
            //COEFFICIENT_OF_DEVIATION here is to choose circuit breaker not too close to operating current
            if ((STANDARD_CIRCUIT_BREAKERS_ARRAY[i] >= operatingCurrent * COEFFICIENT_OF_DEVIATION)) {
                return STANDARD_CIRCUIT_BREAKERS_ARRAY[i];
            }
        }
        return 0;
    }

    /**
     * Choosing motor-protector for pumps or devices with electrical motors which can starts with high
     * starting current.
     * Restriction - max value of operating current should be less or equal 32A.
     */
    private static String getMotorProtector(double operatingCurrent) {
        String motorProtector = "";

        for(int i = 0; i < STANDARD_MOTOR_PROTECTORS_ARRAY.length; i++) {
            if(operatingCurrent <= 32) { //max current of motor-protector MS116 is 32A.
                if(operatingCurrent >= STANDARD_MOTOR_PROTECTORS_ARRAY[i][0] &&
                        operatingCurrent <= STANDARD_MOTOR_PROTECTORS_ARRAY[i][1]) {
                    motorProtector = "\nMS116\n" + STANDARD_MOTOR_PROTECTORS_ARRAY[i][1];
                }
            } else {
                motorProtector = "\nS203D\n" + getCircuitBreakerValue(operatingCurrent);
            }

        }
        return motorProtector;
    }

    /** Getting circuit breaker or motor protector depending on type of electrical equipment. */
    public static String getCircuitBreaker(ElectricalEquipmentTypes type, double operatingCurrent) {
        switch (type) {
            case PUMP:
            case VENTILATOR:
            case ANY_OTHER_INDUCTIVE_LOAD:
                return getMotorProtector(operatingCurrent);

            case HEATER:
            case LIGHT:
            case SOCKET:
            case ANY_OTHER_RESISTIVE_LOAD:
                return "\nS201C\n" + getCircuitBreakerValue(operatingCurrent);
        }
        return "Check getCircuit\nBreaker method!";
    }

}
