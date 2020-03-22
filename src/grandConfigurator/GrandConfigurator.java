/*
 *No license, free to use.
 *
 * Made for learning purpose.
 *
 */

package grandConfigurator;

import static constants.electrical.*;

/**
 * This class storing static methods which can choose needed power protectors for
 * electrical equipment objects using their operating current.
 *
 * @version             1.0 02 Feb 2020
 * @author              A.G.D.
 */
public class GrandConfigurator {

    /**
     * Choosing circuit breaker for heaters and etc.
     * Restriction - max value of operating current should be less than 100A.
     */
    public static String getCircuitBreaker(double operatingCurrent) {
        String circuitBreakerValue = "0.0"; //IDE worrying if it stays uninitialized (it won't), so, here it is: magic number 0.0.
        Boolean flag = false;

        for(int i = 0; i < STANDART_CIRCUIT_BREAKERS_ARRAY.length; i++) {
            //COEFFICIENT_OF_DEVIATION here is to choose circuit breaker not too close to operating current
            if ((STANDART_CIRCUIT_BREAKERS_ARRAY[i] >= operatingCurrent * COEFFICIENT_OF_DEVIATION) && (!flag)) {
                circuitBreakerValue = "ABB S201C" + String.valueOf(STANDART_CIRCUIT_BREAKERS_ARRAY[i]);
                flag = true;
            }
        }
        return circuitBreakerValue;
    }

    /**
     * Choosing motor-protector for pumps or devices with electrical motors which can starts with high
     * starting current.
     * Restriction - max value of operating current should be less or equal 32A.
     */
    public static String getMotorProtector(double operatingCurrent) {
        String motorProtectorValue = "0.0"; //IDE worrying if it stays uninitialized (it won't), so, here it is: magic number 0.0.

        for(int i = 0; i < STANDART_MOTOR_PROTECTORS_ARRAY.length; i++) {
            if(operatingCurrent >= STANDART_MOTOR_PROTECTORS_ARRAY[i][0] &&
                operatingCurrent <= STANDART_MOTOR_PROTECTORS_ARRAY[i][1]) {
                motorProtectorValue = "ABB MS116-" + STANDART_MOTOR_PROTECTORS_ARRAY[i][1];
            }
        }
        return motorProtectorValue;
    }
}
