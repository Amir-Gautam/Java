class Animal {
    void makeSound() {
        System.out.println("The animal makes a generic sound.");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("The dog barks: Woof woof!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("The cat meows: Meow!");
    }
}

class Cow extends Animal {
    @Override
    void makeSound() {
        System.out.println("The cow moos: Amba!");
    }
}

class Buffalo extends Animal {
    @Override
    void makeSound() {
        System.out.println("The buffalo grunts: Hammm!");
    }
}

class Goat extends Animal {
    @Override
    void makeSound() {
        System.out.println("The goat bleats: Mhe mhe!");
    }
}

public class AnimalSounds {
    public static void main(String[] args) {
        Animal[] animals = { new Cow(), new Buffalo(), new Goat() };

        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}
