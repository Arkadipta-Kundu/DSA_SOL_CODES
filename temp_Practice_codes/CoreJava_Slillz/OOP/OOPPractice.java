package temp_Practice_codes.CoreJava_Slillz.OOP;

// ============= INCOMPLETE CLASSES - IMPLEMENT THESE =============

/**
 * Question 1: Employee Management System (Encapsulation)
 * Create an Employee class with proper encapsulation.
 * Private fields: id, name, salary, department
 * Public methods: getters, setters with validation
 * Validation: salary > 0, name not null/empty, id > 0
 * 
 * TODO: Complete the Employee class
 */
class Employee {
    // Write your code here

}

/**
 * Question 2: Vehicle Hierarchy (Inheritance + Method Overriding)
 * Create a Vehicle base class and Car subclass.
 * Vehicle: brand, model, startEngine() method
 * Car: extends Vehicle, adds numberOfDoors, overrides startEngine()
 * 
 * TODO: Complete both Vehicle and Car classes
 */
class Vehicle {
    // Write your code here

}

class Car extends Vehicle {
    // Write your code here

}

/**
 * Question 3: Shape Calculator (Polymorphism + Abstract Class)
 * Create abstract Shape class with abstract calculateArea() method
 * Create Circle and Rectangle classes extending Shape
 * Circle: radius field, Rectangle: length, width fields
 * 
 * TODO: Complete Shape, Circle, and Rectangle classes
 */
abstract class Shape {
    // Write your code here

}

class Circle extends Shape {
    // Write your code here

}

class Rectangle extends Shape {
    // Write your code here

}

/**
 * Question 4: Animal Behavior (Interface Implementation)
 * Create Flyable and Swimmable interfaces
 * Create Duck class implementing both interfaces
 * Create Fish class implementing only Swimmable
 * 
 * TODO: Complete interfaces and classes
 */
interface Flyable {
    // Write your code here

}

interface Swimmable {
    // Write your code here

}

class Duck implements Flyable, Swimmable {
    // Write your code here

}

class Fish implements Swimmable {
    // Write your code here

}

/**
 * Question 5: Bank Account System (Advanced OOP Concepts)
 * Create BankAccount class with account number, balance, account holder name
 * Create SavingsAccount extending BankAccount with interest rate
 * Implement deposit(), withdraw(), calculateInterest() methods
 * Add proper validation and encapsulation
 * 
 * TODO: Complete BankAccount and SavingsAccount classes
 */
class BankAccount {
    // Write your code here

}

class SavingsAccount extends BankAccount {
    // Write your code here

}

// ============= MAIN CLASS WITH TEST CASES =============

public class OOPPractice {

    public static void main(String[] args) {
        System.out.println("Running OOP Practice Tests...\n");

        int totalTests = 50;
        int passedTests = 0;

        // Test Employee class (10 tests)
        passedTests += testEmployee();

        // Test Vehicle inheritance (10 tests)
        passedTests += testVehicleInheritance();

        // Test Shape polymorphism (10 tests)
        passedTests += testShapePolymorphism();

        // Test Animal interfaces (10 tests)
        passedTests += testAnimalInterfaces();

        // Test Bank Account system (10 tests)
        passedTests += testBankAccountSystem();

        System.out.println("=".repeat(50));
        System.out.println("FINAL RESULT:");
        System.out.println(passedTests + "/" + totalTests + " Test cases passed");

        if (passedTests == totalTests) {
            System.out.println("Status: ACCEPTED ✓");
        } else {
            System.out.println("Status: NOT ACCEPTED ✗");
            System.out.println("Keep practicing! Spring Boot mastery awaits!");
        }
        System.out.println("=".repeat(50));
    }

    private static int testEmployee() {
        System.out.println("Testing Employee Encapsulation...");
        int passed = 0;

        try {
            // Test 1: Valid employee creation
            Employee emp1 = new Employee();
            if (emp1 != null)
                passed++;

            // Test 2: Setting valid id
            emp1.setId(101);
            if (emp1.getId() == 101)
                passed++;

            // Test 3: Setting valid name
            emp1.setName("John Doe");
            if ("John Doe".equals(emp1.getName()))
                passed++;

            // Test 4: Setting valid salary
            emp1.setSalary(50000.0);
            if (emp1.getSalary() == 50000.0)
                passed++;

            // Test 5: Setting valid department
            emp1.setDepartment("IT");
            if ("IT".equals(emp1.getDepartment()))
                passed++;

            // Test 6: Invalid salary (should not change)
            double oldSalary = emp1.getSalary();
            emp1.setSalary(-1000);
            if (emp1.getSalary() == oldSalary)
                passed++;

            // Test 7: Invalid id (should not change)
            int oldId = emp1.getId();
            emp1.setId(-5);
            if (emp1.getId() == oldId)
                passed++;

            // Test 8: Null name (should not change)
            String oldName = emp1.getName();
            emp1.setName(null);
            if (oldName.equals(emp1.getName()))
                passed++;

            // Test 9: Empty name (should not change)
            emp1.setName("");
            if (oldName.equals(emp1.getName()))
                passed++;

            // Test 10: Another valid employee
            Employee emp2 = new Employee();
            emp2.setId(102);
            emp2.setName("Jane Smith");
            emp2.setSalary(60000.0);
            emp2.setDepartment("HR");
            if (emp2.getId() == 102 && "Jane Smith".equals(emp2.getName()) &&
                    emp2.getSalary() == 60000.0 && "HR".equals(emp2.getDepartment())) {
                passed++;
            }

        } catch (Exception e) {
            // Tests failed due to implementation issues
        }

        System.out.println("Employee tests: " + passed + "/10 passed\n");
        return passed;
    }

    private static int testVehicleInheritance() {
        System.out.println("Testing Vehicle Inheritance...");
        int passed = 0;

        try {
            // Test 1: Vehicle creation
            Vehicle vehicle = new Vehicle("Toyota", "Generic");
            if (vehicle != null)
                passed++;

            // Test 2: Vehicle brand
            if ("Toyota".equals(vehicle.getBrand()))
                passed++;

            // Test 3: Vehicle model
            if ("Generic".equals(vehicle.getModel()))
                passed++;

            // Test 4: Vehicle startEngine
            String vehicleStart = vehicle.startEngine();
            if (vehicleStart != null && vehicleStart.contains("Vehicle"))
                passed++;

            // Test 5: Car creation
            Car car = new Car("Honda", "Civic", 4);
            if (car != null)
                passed++;

            // Test 6: Car inherits brand
            if ("Honda".equals(car.getBrand()))
                passed++;

            // Test 7: Car inherits model
            if ("Civic".equals(car.getModel()))
                passed++;

            // Test 8: Car specific field
            if (car.getNumberOfDoors() == 4)
                passed++;

            // Test 9: Car overridden method
            String carStart = car.startEngine();
            if (carStart != null && carStart.contains("Car"))
                passed++;

            // Test 10: Polymorphism test
            Vehicle polyVehicle = new Car("BMW", "X5", 4);
            String polyStart = polyVehicle.startEngine();
            if (polyStart != null && polyStart.contains("Car"))
                passed++;

        } catch (Exception e) {
            // Tests failed due to implementation issues
        }

        System.out.println("Vehicle Inheritance tests: " + passed + "/10 passed\n");
        return passed;
    }

    private static int testShapePolymorphism() {
        System.out.println("Testing Shape Polymorphism...");
        int passed = 0;

        try {
            // Test 1: Circle creation
            Circle circle = new Circle(5.0);
            if (circle != null)
                passed++;

            // Test 2: Circle radius
            if (circle.getRadius() == 5.0)
                passed++;

            // Test 3: Circle area calculation
            double circleArea = circle.calculateArea();
            if (Math.abs(circleArea - (Math.PI * 25)) < 0.01)
                passed++;

            // Test 4: Rectangle creation
            Rectangle rectangle = new Rectangle(4.0, 6.0);
            if (rectangle != null)
                passed++;

            // Test 5: Rectangle dimensions
            if (rectangle.getLength() == 4.0 && rectangle.getWidth() == 6.0)
                passed++;

            // Test 6: Rectangle area calculation
            if (rectangle.calculateArea() == 24.0)
                passed++;

            // Test 7: Polymorphism with Circle
            Shape shape1 = new Circle(3.0);
            double area1 = shape1.calculateArea();
            if (Math.abs(area1 - (Math.PI * 9)) < 0.01)
                passed++;

            // Test 8: Polymorphism with Rectangle
            Shape shape2 = new Rectangle(5.0, 8.0);
            if (shape2.calculateArea() == 40.0)
                passed++;

            // Test 9: Different circle
            Circle circle2 = new Circle(2.0);
            double area2 = circle2.calculateArea();
            if (Math.abs(area2 - (Math.PI * 4)) < 0.01)
                passed++;

            // Test 10: Different rectangle
            Rectangle rect2 = new Rectangle(3.0, 7.0);
            if (rect2.calculateArea() == 21.0)
                passed++;

        } catch (Exception e) {
            // Tests failed due to implementation issues
        }

        System.out.println("Shape Polymorphism tests: " + passed + "/10 passed\n");
        return passed;
    }

    private static int testAnimalInterfaces() {
        System.out.println("Testing Animal Interfaces...");
        int passed = 0;

        try {
            // Test 1: Duck creation
            Duck duck = new Duck("Mallard");
            if (duck != null)
                passed++;

            // Test 2: Duck name
            if ("Mallard".equals(duck.getName()))
                passed++;

            // Test 3: Duck can fly
            String flyResult = duck.fly();
            if (flyResult != null && flyResult.toLowerCase().contains("fly"))
                passed++;

            // Test 4: Duck can swim
            String swimResult = duck.swim();
            if (swimResult != null && swimResult.toLowerCase().contains("swim"))
                passed++;

            // Test 5: Fish creation
            Fish fish = new Fish("Goldfish");
            if (fish != null)
                passed++;

            // Test 6: Fish name
            if ("Goldfish".equals(fish.getName()))
                passed++;

            // Test 7: Fish can swim
            String fishSwim = fish.swim();
            if (fishSwim != null && fishSwim.toLowerCase().contains("swim"))
                passed++;

            // Test 8: Interface polymorphism - Flyable
            Flyable flyable = new Duck("Flying Duck");
            String flyTest = flyable.fly();
            if (flyTest != null && flyTest.toLowerCase().contains("fly"))
                passed++;

            // Test 9: Interface polymorphism - Swimmable with Duck
            Swimmable swimmable1 = new Duck("Swimming Duck");
            String swimTest1 = swimmable1.swim();
            if (swimTest1 != null && swimTest1.toLowerCase().contains("swim"))
                passed++;

            // Test 10: Interface polymorphism - Swimmable with Fish
            Swimmable swimmable2 = new Fish("Swimming Fish");
            String swimTest2 = swimmable2.swim();
            if (swimTest2 != null && swimTest2.toLowerCase().contains("swim"))
                passed++;

        } catch (Exception e) {
            // Tests failed due to implementation issues
        }

        System.out.println("Animal Interfaces tests: " + passed + "/10 passed\n");
        return passed;
    }

    private static int testBankAccountSystem() {
        System.out.println("Testing Bank Account System...");
        int passed = 0;

        try {
            // Test 1: BankAccount creation
            BankAccount account = new BankAccount("ACC001", "John Doe", 1000.0);
            if (account != null)
                passed++;

            // Test 2: Account details
            if ("ACC001".equals(account.getAccountNumber()) &&
                    "John Doe".equals(account.getAccountHolderName()) &&
                    account.getBalance() == 1000.0)
                passed++;

            // Test 3: Valid deposit
            account.deposit(500.0);
            if (account.getBalance() == 1500.0)
                passed++;

            // Test 4: Valid withdrawal
            boolean withdraw1 = account.withdraw(300.0);
            if (withdraw1 && account.getBalance() == 1200.0)
                passed++;

            // Test 5: Invalid withdrawal (insufficient funds)
            boolean withdraw2 = account.withdraw(2000.0);
            if (!withdraw2 && account.getBalance() == 1200.0)
                passed++;

            // Test 6: SavingsAccount creation
            SavingsAccount savings = new SavingsAccount("SAV001", "Jane Smith", 2000.0, 0.05);
            if (savings != null)
                passed++;

            // Test 7: SavingsAccount inherits deposit
            savings.deposit(1000.0);
            if (savings.getBalance() == 3000.0)
                passed++;

            // Test 8: Interest rate
            if (savings.getInterestRate() == 0.05)
                passed++;

            // Test 9: Interest calculation
            double interest = savings.calculateInterest();
            if (interest == 150.0)
                passed++; // 3000 * 0.05 = 150

            // Test 10: Polymorphism test
            BankAccount polyAccount = new SavingsAccount("SAV002", "Bob Wilson", 1000.0, 0.03);
            polyAccount.deposit(500.0);
            if (polyAccount.getBalance() == 1500.0)
                passed++;

        } catch (Exception e) {
            // Tests failed due to implementation issues
        }

        System.out.println("Bank Account System tests: " + passed + "/10 passed\n");
        return passed;
    }
}
