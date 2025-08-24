
class Vehicle {
    private String make;
    private String model;
    private int speed;

    public Vehicle(String make, String model, int initialSpeed) {
        if (initialSpeed < 0) {
            throw new IllegalArgumentException("Initial speed cannot be negative.");
        }
        this.make = make;
        this.model = model;
        this.speed = initialSpeed;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public void accelerate(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Acceleration amount cannot be negative.");
        }
        this.speed += amount;
    }

    public void brake(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Braking amount cannot be negative.");
        }
        this.speed = Math.max(0, this.speed - amount);
    }

    @Override
    public String toString() {
        return "Make: " + make + ", Model: " + model + ", Speed: " + speed + " km/h";
    }
}

class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String make, String model, int initialSpeed, int numberOfDoors) {
        super(make, model, initialSpeed);
        if (numberOfDoors <= 0) {
            throw new IllegalArgumentException("Number of doors must be positive.");
        }
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public String toString() {
        return "Car - " + super.toString() + ", Doors: " + numberOfDoors;
    }
}


class Bike extends Vehicle {
    private boolean hasGears;

    public Bike(String make, String model, int initialSpeed, boolean hasGears) {
        super(make, model, initialSpeed);
        this.hasGears = hasGears;
    }

    public boolean hasGears() {
        return hasGears;
    }

    @Override
    public String toString() {
        return "Bike - " + super.toString() + ", Has Gears: " + hasGears;
    }
}

class Abstract{
    public static void main(String[] args) {
        try {
            Car myCar = new Car("Toyota", "Camry", 60, 4);
            System.out.println(myCar);
            myCar.accelerate(20);
            System.out.println("After acceleration: " + myCar.getSpeed());
            myCar.brake(30);
            System.out.println("After braking: " + myCar.getSpeed());

            Bike myBike = new Bike("Giant", "Escape", 20, true);
            System.out.println(myBike);
            myBike.accelerate(10);
            System.out.println("After acceleration: " + myBike.getSpeed());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}