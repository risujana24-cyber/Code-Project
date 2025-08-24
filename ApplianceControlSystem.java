
class InvalidStateException extends Exception {
    public InvalidStateException(String message) {
        super(message);
    }
}

abstract class Appliance {
    private String name;
    private boolean isOn;
    public Appliance(String name, boolean initialState) throws InvalidStateException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidStateException("Appliance name cannot be empty!");
        }
        this.name = name;
        this.isOn = initialState;
    }


    public String getName() {
        return name;
    }

    public boolean isOn() {
        return isOn;
    }


    protected void setOn(boolean on) {
        this.isOn = on;
    }
    public abstract void turnOn() throws InvalidStateException;
    public abstract void turnOff() throws InvalidStateException;
}

class Fan extends Appliance {
    public Fan(boolean initialState) throws InvalidStateException {
        super("Fan", initialState);
    }

    @Override
    public void turnOn() throws InvalidStateException {
        if (isOn()) {
            throw new InvalidStateException("Fan is already ON!");
        }
        setOn(true);
        System.out.println("Fan is now ON.");
    }

    @Override
    public void turnOff() throws InvalidStateException {
        if (!isOn()) {
            throw new InvalidStateException("Fan is already OFF!");
        }
        setOn(false);
        System.out.println("Fan is now OFF.");
    }
}

class Light extends Appliance {
    public Light(boolean initialState) throws InvalidStateException {
        super("Light", initialState);
    }

    @Override
    public void turnOn() throws InvalidStateException {
        if (isOn()) {
            throw new InvalidStateException("Light is already ON!");
        }
        setOn(true);
        System.out.println("Light is now ON.");
    }

    @Override
    public void turnOff() throws InvalidStateException {
        if (!isOn()) {
            throw new InvalidStateException("Light is already OFF!");
        }
        setOn(false);
        System.out.println("Light is now OFF.");
    }
}

class AC extends Appliance {
    public AC(boolean initialState) throws InvalidStateException {
        super("AC", initialState);
    }

    @Override
    public void turnOn() throws InvalidStateException {
        if (isOn()) {
            throw new InvalidStateException("AC is already ON!");
        }
        setOn(true);
        System.out.println("AC is now ON.");
    }

    @Override
    public void turnOff() throws InvalidStateException {
        if (!isOn()) {
            throw new InvalidStateException("AC is already OFF!");
        }
        setOn(false);
        System.out.println("AC is now OFF.");
    }
}

public class ApplianceControlSystem {
    public static void main(String[] args) {
        try {
            // Array of Appliance references
            Appliance[] appliances = new Appliance[3];
            appliances[0] = new Fan(false);
            appliances[1] = new Light(false);
            appliances[2] = new AC(true);
            for (Appliance a : appliances) {
                try {
                    a.turnOn();
                } catch (InvalidStateException e) {
                    System.out.println("Error: " + a.getName() + " -> " + e.getMessage());
                }
            }

            for (Appliance a : appliances) {
                try {
                    a.turnOff();
                } catch (InvalidStateException e) {
                    System.out.println("Error: " + a.getName() + " -> " + e.getMessage());
                }
            }

            appliances[0].turnOff();

        } catch (InvalidStateException e) {
            System.out.println("Initialization Error: " + e.getMessage());
        }
    }
}

