
class Transport {
    private String passengerName;
    private double distance;

    public Transport(String passengerName, double distance) {
        try {
            if (distance <= 0) {
                throw new Exception("Distance must be greater than zero!");
            }
            this.passengerName = passengerName;
            this.distance = distance;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            this.passengerName = passengerName;
            this.distance = 0;
        }
    }

    public String getPassengerName() {
        return passengerName;
    }

    public double getDistance() {
        return distance;
    }

    public double calculateFare() {
        return 0;
    }
}

class Bus extends Transport {
    private static final double RATE_PER_KM = 5.0;

    public Bus(String passengerName, double distance) {
        super(passengerName, distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * RATE_PER_KM;
    }
}

class Train extends Transport {
    private static final double RATE_PER_KM = 3.0;

    public Train(String passengerName, double distance) {
        super(passengerName, distance);
    }

    @Override
    public double calculateFare() {
        return getDistance() * RATE_PER_KM;
    }
}

class Taxi extends Transport {
    private static final double BASE_FARE = 50.0; // minimum
    private static final double RATE_PER_KM = 10.0;

    public Taxi(String passengerName, double distance) {
        super(passengerName, distance);
    }

    @Override
    public double calculateFare() {
        return BASE_FARE + (getDistance() * RATE_PER_KM);
    }
}

public class TransportFareCalculation {
    public static void main(String[] args) {
        Transport t1 = new Bus("Sita", 10);
        Transport t2 = new Train("Ram", 50);
        Transport t3 = new Taxi("Hari", 15);
        Transport t4 = new Bus("Gita", -5); // invalid test case
        System.out.println(t1.getPassengerName() + " Bus Fare: Rs." + t1.calculateFare());
        System.out.println(t2.getPassengerName() + " Train Fare: Rs." + t2.calculateFare());
        System.out.println(t3.getPassengerName() + " Taxi Fare: Rs." + t3.calculateFare());
        System.out.println(t4.getPassengerName() + " Bus Fare: Rs." + t4.calculateFare());
    }
}

