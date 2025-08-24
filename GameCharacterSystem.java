
abstract class Character {
    private String name;
    private int health;
    private String weapon;


    public Character(String name, int health, String weapon) {
        try {
            if (name == null || name.trim().isEmpty()) {
                throw new Exception("Name cannot be null or empty!");
            }
            if (health <= 0) {
                throw new Exception("Health must be positive!");
            }
            if (weapon == null || weapon.trim().isEmpty()) {
                throw new Exception("Weapon type cannot be null or empty!");
            }
            this.name = name;
            this.health = health;
            this.weapon = weapon;
        } catch (Exception e) {
            System.out.println("Error creating character: " + e.getMessage());
            this.name = "Unknown";
            this.health = 100;
            this.weapon = "Fist";
        }
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public String getWeapon() {
        return weapon;
    }


    public abstract void attack();
}


class Warrior extends Character {
    public Warrior(String name, int health, String weapon) {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println("Warrior " + getName() + " attacks with " + getWeapon() +
                " dealing heavy melee damage!");
    }
}


class Mage extends Character {
    public Mage(String name, int health, String weapon) {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println("Mage " + getName() + " casts a spell using " + getWeapon() +
                " dealing magical damage!");
    }
}


class
Archer extends Character {
    public Archer(String name, int health, String weapon) {
        super(name, health, weapon);
    }

    @Override
    public void attack() {
        System.out.println("Archer " + getName() + " shoots an arrow with " + getWeapon() +
                " dealing ranged damage!");
    }
}


public class GameCharacterSystem {
    public static void main(String[] args) {
        Character warrior = new Warrior("Arjun", 120, "Sword");
        Character mage = new Mage("Kiran", 90, "Staff");
        Character archer = new Archer("Maya", 100, "Bow");


        Character invalidChar = new Warrior("Test", -50, null);


        warrior.attack();
        mage.attack();
        archer.attack();
        invalidChar.attack();
    }
}

