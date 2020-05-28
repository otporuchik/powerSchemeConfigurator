package electroPackage;

import static constants.Electrical.*;

/**
 * Class to get circuit breaker or motor protector for electrical equipment
 */
public class CircuitBreakerStore {
    /**
     * Choosing circuit breaker for heaters and etc.
     * Restriction - max value of operating current should be less than 100A.
     */
    private static String getCircuitBreaker(double operatingCurrent) {
        String circuitBreakerValue = "0.0"; //IDE worrying if it stays uninitialized (it won't), so, here it is: magic number 0.0.

        thisLoop: for(int i = 0; i < STANDARD_CIRCUIT_BREAKERS_ARRAY.length; i++) {
            //COEFFICIENT_OF_DEVIATION here is to choose circuit breaker not too close to operating current
            if ((STANDARD_CIRCUIT_BREAKERS_ARRAY[i] >= operatingCurrent * COEFFICIENT_OF_DEVIATION)) {
                circuitBreakerValue = "ABB S201C" + String.valueOf(STANDARD_CIRCUIT_BREAKERS_ARRAY[i]);
                break thisLoop;
            }
            /*
            else if (operatingCurrent > STANDART_CIRCUIT_BREAKERS_ARRAY[STANDART_CIRCUIT_BREAKERS_ARRAY.length - 1]) {
                circuitBreakerValue = "0.0"; //This value is not best idea, but it won't get appropriate result and makes operator to think.
            }
             */
        }
        return circuitBreakerValue;
    }

    /**
     * Choosing motor-protector for pumps or devices with electrical motors which can starts with high
     * starting current.
     * Restriction - max value of operating current should be less or equal 32A.
     */
    private static String getMotorProtector(double operatingCurrent) {
        String motorProtectorValue = "0.0"; //IDE worrying if it stays uninitialized (it won't), so, here it is: magic number 0.0.

        for(int i = 0; i < STANDARD_MOTOR_PROTECTORS_ARRAY.length; i++) {
            if(operatingCurrent >= STANDARD_MOTOR_PROTECTORS_ARRAY[i][0] &&
                    operatingCurrent <= STANDARD_MOTOR_PROTECTORS_ARRAY[i][1]) {
                motorProtectorValue = "ABB MS116-" + STANDARD_MOTOR_PROTECTORS_ARRAY[i][1];
            }
        }
        return motorProtectorValue;
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
                return getCircuitBreaker(operatingCurrent);
        }
        return "Check getCircuit\nBreaker method!";
    }

}
