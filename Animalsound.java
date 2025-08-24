
abstract class Animal {
    private String name;
    public Animal(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Invalid animal name! Setting default name.");
            this.name = "Unknown";
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Error: Invalid name! Keeping previous value.");
        } else {
            this.name = name;
        }
    }
    public abstract void makeSound();
}
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof! Woof!");
    }
}
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Meow! Meow!");
    }
}
class Cow extends Animal {
    public Cow(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Moo! Moo!");
    }
}
class AnimalSound {
    public static void tagTextAnimalType(Animal animal) {
        System.out.println("This is a " + animal.getClass().getSimpleName());
        animal.makeSound();
    }

    public static void main(String[] args) {
        Animal dog = new Dog("Leo");
        Animal cat = new Cat("Kitty");
        Animal cow = new Cow("Kale");


        Animal invalidAnimal = new Dog(""); // handled by constructor

        
        System.out.println("Polymorphism Demonstration:\n");
        tagTextAnimalType(dog);
        tagTextAnimalType(cat);
        tagTextAnimalType(cow);
        tagTextAnimalType(invalidAnimal);
    }
}

