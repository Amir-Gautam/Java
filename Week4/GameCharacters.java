class GameCharacter {
    String name;

    GameCharacter(String name) {
        this.name = name;
    }

    void attack() {
        System.out.println(name + " performs a basic attack.");
    }
}

class Warrior extends GameCharacter {
    Warrior(String name) {
        super(name);
    }

    @Override
    void attack() {
        System.out.println(name + " swings a sword for heavy melee damage.");
    }
}

class Archer extends GameCharacter {
    private int arrowCount;

    Archer(String name, int arrowCount) {
        super(name);
        this.arrowCount = arrowCount;
    }

    @Override
    void attack() {
        if (arrowCount > 0) {
            arrowCount--;
            System.out.println(name + " fires an arrow. Arrows left: " + arrowCount);
        } else {
            System.out.println(name + " is out of arrows!");
        }
    }
}

class Mage extends GameCharacter {
    private int mana;

    Mage(String name, int mana) {
        super(name);
        this.mana = mana;
    }

    @Override
    void attack() {
        if (mana >= 10) {
            mana -= 10;
            System.out.println(name + " casts a fireball spell. Mana left: " + mana);
        } else {
            System.out.println(name + " doesn't have enough mana!");
        }
    }
}

public class GameCharacters {
    public static void main(String[] args) {
        GameCharacter[] characters = {
            new Warrior("Bhairav"),
            new Archer("Chandika", 5),
            new Mage("Tantrik Guru", 50)
        };

        for (GameCharacter character : characters) {
            character.attack();
        }
    }
}
