package electroPackage;

import constants.Electrical;

/**
 * Class to create electrical objects
 * Able to count working power or current if needed.
 */
public class ElectricalEquipment {
    private ElectricalEquipmentTypes type; //type of electrical equipment
    private String name; //name of electrical equipment
    private String circuitBreaker; //It could be motor-protectors, not only circuit breakers
    private String cable; //cable to supply electrical equipment
    private int voltage; //voltage to supply electrical equipment
    private double power; //working power of electrical equipment
    private double operatingCurrent; //working current of electrical equipment

    /** First constructor when all parameters are known */
    public ElectricalEquipment(double power, ElectricalEquipmentTypes type, String name, int voltage,
                               double operatingCurrent) {
        this.type = type;
        this.name = name;
        this.voltage = voltage;
        this.power = power;
        this.operatingCurrent = operatingCurrent;
        this.circuitBreaker = CircuitBreakerStore.getCircuitBreaker(type, operatingCurrent);
        this.cable = CableStore.getCable(type, operatingCurrent);
    }

    /** Second constructor when power missed */
    public ElectricalEquipment(ElectricalEquipmentTypes type, String name, int voltage,
                               double operatingCurrent) {
        this.type = type;
        this.name = name;
        this.voltage = voltage;
        this.operatingCurrent = operatingCurrent;
        this.power = Electrical.getPower(type, voltage, operatingCurrent);
        this.circuitBreaker = CircuitBreakerStore.getCircuitBreaker(type, operatingCurrent);
        this.cable = CableStore.getCable(type, operatingCurrent);
    }

    /** Third constructor when operating Current missed */
    public ElectricalEquipment(double power, ElectricalEquipmentTypes type, String name, int voltage) {
        this.type = type;
        this.name = name;
        this.voltage = voltage;
        this.power = power;
        this.operatingCurrent = Electrical.getCurrent(type, voltage, power);
        this.circuitBreaker = CircuitBreakerStore.getCircuitBreaker(type, operatingCurrent);
        this.cable = CableStore.getCable(type, operatingCurrent);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCircuitBreaker() {
        return circuitBreaker;
    }

    public void setCircuitBreaker(String circuitBreaker) {
        this.circuitBreaker = circuitBreaker;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public double getOperatingCurrent() {
        return operatingCurrent;
    }

    public void setOperatingCurrent(double operatingCurrent) {
        this.operatingCurrent = operatingCurrent;
    }

    public ElectricalEquipmentTypes getType() {
        return type;
    }

    public void setType(ElectricalEquipmentTypes type) {
        this.type = type;
    }
}
