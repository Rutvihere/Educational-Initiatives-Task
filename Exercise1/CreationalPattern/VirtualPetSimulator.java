// Abstract product classes
interface Pet {
    void play();
    void feed();
}

interface Habitat {
    void clean();
    void upgrade();
}

interface Food {
    void prepare();
}

// Concrete product classes for Aquatic ecosystem
class Fish implements Pet {
    public void play() { System.out.println("Fish is swimming through hoops"); }
    public void feed() { System.out.println("Fish is eating flakes"); }
}

class Aquarium implements Habitat {
    public void clean() { System.out.println("Cleaning the aquarium"); }
    public void upgrade() { System.out.println("Adding a new coral reef"); }
}

class FishFood implements Food {
    public void prepare() { System.out.println("Preparing fish flakes"); }
}

// Concrete product classes for Terrestrial ecosystem
class Hamster implements Pet {
    public void play() { System.out.println("Hamster is running in its wheel"); }
    public void feed() { System.out.println("Hamster is nibbling on seeds"); }
}

class Cage implements Habitat {
    public void clean() { System.out.println("Changing the cage bedding"); }
    public void upgrade() { System.out.println("Adding a new tunnel system"); }
}

class HamsterFood implements Food {
    public void prepare() { System.out.println("Mixing hamster seed mix"); }
}

// Abstract factory
interface PetEcosystemFactory {
    Pet createPet();
    Habitat createHabitat();
    Food createFood();
}

// Concrete factories
class AquaticEcosystemFactory implements PetEcosystemFactory {
    public Pet createPet() { return new Fish(); }
    public Habitat createHabitat() { return new Aquarium(); }
    public Food createFood() { return new FishFood(); }
}

class TerrestrialEcosystemFactory implements PetEcosystemFactory {
    public Pet createPet() { return new Hamster(); }
    public Habitat createHabitat() { return new Cage(); }
    public Food createFood() { return new HamsterFood(); }
}


public class VirtualPetSimulator {
    public static void main(String[] args) {
        simulateEcosystem(new AquaticEcosystemFactory());
        System.out.println();
        simulateEcosystem(new TerrestrialEcosystemFactory());
    }

    private static void simulateEcosystem(PetEcosystemFactory factory) {
        Pet pet = factory.createPet();
        Habitat habitat = factory.createHabitat();
        Food food = factory.createFood();

        pet.play();
        habitat.clean();
        food.prepare();
        pet.feed();
        habitat.upgrade();
    }
}