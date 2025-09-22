// Superclass
class Animal {
void eat() {
System.out.println("This animal eats food.");
}

void sleep() {
System.out.println("This animal sleeps.");
}
}

// Subclass
class Dog extends Animal {
void bark() {
System.out.println("The dog barks.");
}


void showBehavior() {
// Calling methods from the superclass
eat();
sleep();
bark();
}
}

// Main class
public class SingleInheritanceDemo {
public static void main(String[] args) {
Dog myDog = new Dog();
myDog.showBehavior();
}
}