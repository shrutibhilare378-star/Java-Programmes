
    class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound.");
    }
}

// Subclass Pig, overriding makeSound()
class Pig extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The pig says: Wee wee.");
    }
}

// Subclass Dog, overriding makeSound()
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog says: Bow wow.");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        // Create an Animal object
        Animal myAnimal = new Animal(); 
        myAnimal.makeSound(); // Output: The animal makes a sound.

        // Create a Pig object and assign it to an Animal reference
        Animal myPig = new Pig(); 
        myPig.makeSound(); // Output: The pig says: Wee wee.

        // Create a Dog object and assign it to an Animal reference
        Animal myDog = new Dog(); 
        myDog.makeSound(); // Output: The dog says: Bow wow.
    }
}
    

