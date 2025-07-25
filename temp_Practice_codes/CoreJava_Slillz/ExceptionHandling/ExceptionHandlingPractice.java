package temp_Practice_codes.CoreJava_Slillz.ExceptionHandling;

// ============= INCOMPLETE CLASSES - IMPLEMENT THESE =============

/**
 * Question 1: Custom Exception Creation
 * Create a custom exception class called InsufficientBalanceException
 * that extends Exception. It should have constructors to handle messages.
 * 
 * TODO: Create InsufficientBalanceException class
 */
// Write your custom exception class here


/**
 * Question 2: Banking Operations with Exception Handling
 * Create a SimpleBank class with methods that throw and handle exceptions.
 * Methods: deposit(), withdraw(), getBalance()
 * Handle: negative amounts, insufficient balance, null inputs
 * 
 * TODO: Complete SimpleBank class
 */
class SimpleBank {
    // Write your code here
    
}

/**
 * Question 3: File Operations Simulator
 * Create a FileManager class that simulates file operations.
 * Methods: readFile(), writeFile(), deleteFile()
 * Handle: FileNotFoundException, SecurityException, custom exceptions
 * 
 * TODO: Complete FileManager class
 */
class FileManager {
    // Write your code here
    
}

/**
 * Question 4: Input Validator with Multiple Exceptions
 * Create an InputValidator class with methods to validate different inputs.
 * Methods: validateAge(), validateEmail(), validatePhoneNumber()
 * Create and throw custom exceptions for each validation type
 * 
 * TODO: Complete InputValidator class and custom exceptions
 */
// Write your custom validation exception classes here

class InputValidator {
    // Write your code here
    
}

/**
 * Question 5: Advanced Exception Handling Chain
 * Create a DatabaseConnection class that simulates database operations.
 * Methods: connect(), executeQuery(), closeConnection()
 * Implement try-with-resources, exception chaining, and finally blocks
 * 
 * TODO: Complete DatabaseConnection class
 */
class DatabaseConnection {
    // Write your code here
    
}

// ============= MAIN CLASS WITH TEST CASES =============

public class ExceptionHandlingPractice {
    
    public static void main(String[] args) {
        System.out.println("Running Exception Handling Practice Tests...\n");
        
        int totalTests = 50;
        int passedTests = 0;
        
        // Test Custom Exception (10 tests)
        passedTests += testCustomException();
        
        // Test Banking Operations (10 tests)
        passedTests += testBankingOperations();
        
        // Test File Operations (10 tests)
        passedTests += testFileOperations();
        
        // Test Input Validation (10 tests)
        passedTests += testInputValidation();
        
        // Test Database Operations (10 tests)
        passedTests += testDatabaseOperations();
        
        System.out.println("=".repeat(50));
        System.out.println("FINAL RESULT:");
        System.out.println(passedTests + "/" + totalTests + " Test cases passed");
        
        if (passedTests == totalTests) {
            System.out.println("Status: ACCEPTED ✓");
        } else {
            System.out.println("Status: NOT ACCEPTED ✗");
            System.out.println("Keep practicing! Exception mastery is key for Spring Boot!");
        }
        System.out.println("=".repeat(50));
    }
    
    private static int testCustomException() {
        System.out.println("Testing Custom Exception...");
        int passed = 0;
        
        try {
            // Test 1: Custom exception exists
            try {
                Class.forName("temp_Practice_codes.CoreJava_Slillz.ExceptionHandling.InsufficientBalanceException");
                passed++;
            } catch (ClassNotFoundException e) {
                // Custom exception not found
            }
            
            // Test 2: Custom exception extends Exception
            try {
                Class<?> clazz = Class.forName("temp_Practice_codes.CoreJava_Slillz.ExceptionHandling.InsufficientBalanceException");
                if (Exception.class.isAssignableFrom(clazz)) {
                    passed++;
                }
            } catch (Exception e) {
                // Failed
            }
            
            // Test 3-10: Test exception throwing and handling
            SimpleBank bank = new SimpleBank();
            
            // Test 3: Normal deposit works
            try {
                bank.deposit(1000.0);
                if (bank.getBalance() == 1000.0) passed++;
            } catch (Exception e) {
                // Should not throw exception
            }
            
            // Test 4: Negative deposit throws exception
            try {
                bank.deposit(-100.0);
                // Should not reach here
            } catch (Exception e) {
                passed++;
            }
            
            // Test 5: Normal withdrawal works
            try {
                boolean result = bank.withdraw(500.0);
                if (result && bank.getBalance() == 500.0) passed++;
            } catch (Exception e) {
                // Should not throw exception
            }
            
            // Test 6: Insufficient balance throws custom exception
            try {
                bank.withdraw(1000.0);
                // Should not reach here
            } catch (Exception e) {
                if (e.getClass().getSimpleName().equals("InsufficientBalanceException")) {
                    passed++;
                }
            }
            
            // Test 7: Negative withdrawal throws exception
            try {
                bank.withdraw(-100.0);
                // Should not reach here
            } catch (Exception e) {
                passed++;
            }
            
            // Test 8: Exception message is meaningful
            try {
                bank.withdraw(1000.0);
            } catch (Exception e) {
                if (e.getMessage() != null && e.getMessage().length() > 0) {
                    passed++;
                }
            }
            
            // Test 9: Multiple operations handling
            SimpleBank bank2 = new SimpleBank();
            try {
                bank2.deposit(2000.0);
                bank2.withdraw(1000.0);
                bank2.withdraw(500.0);
                if (bank2.getBalance() == 500.0) passed++;
            } catch (Exception e) {
                // Should not throw exception
            }
            
            // Test 10: Zero amount handling
            try {
                bank.deposit(0.0);
                // Should handle zero appropriately
                passed++;
            } catch (Exception e) {
                // Exception is also acceptable for zero amount
                passed++;
            }
            
        } catch (Exception e) {
            // Tests failed due to implementation issues
        }
        
        System.out.println("Custom Exception tests: " + passed + "/10 passed\n");
        return passed;
    }
    
    private static int testBankingOperations() {
        System.out.println("Testing Banking Operations...");
        int passed = 0;
        
        try {
            SimpleBank bank = new SimpleBank();
            
            // Test 1: Initial balance is zero
            if (bank.getBalance() == 0.0) passed++;
            
            // Test 2: Successful deposit
            bank.deposit(1500.0);
            if (bank.getBalance() == 1500.0) passed++;
            
            // Test 3: Multiple deposits
            bank.deposit(500.0);
            if (bank.getBalance() == 2000.0) passed++;
            
            // Test 4: Successful withdrawal
            bank.withdraw(800.0);
            if (bank.getBalance() == 1200.0) passed++;
            
            // Test 5: Exception handling preserves state
            double balanceBefore = bank.getBalance();
            try {
                bank.withdraw(2000.0); // Should fail
            } catch (Exception e) {
                if (bank.getBalance() == balanceBefore) passed++;
            }
            
            // Test 6: Large deposit handling
            bank.deposit(999999.0);
            if (bank.getBalance() > 1000000.0) passed++;
            
            // Test 7: Exact balance withdrawal
            SimpleBank bank2 = new SimpleBank();
            bank2.deposit(100.0);
            bank2.withdraw(100.0);
            if (bank2.getBalance() == 0.0) passed++;
            
            // Test 8: Decimal amount handling
            SimpleBank bank3 = new SimpleBank();
            bank3.deposit(123.45);
            if (Math.abs(bank3.getBalance() - 123.45) < 0.01) passed++;
            
            // Test 9: Exception type verification
            try {
                bank.withdraw(999999999.0);
            } catch (Exception e) {
                if (e.getClass().getSimpleName().contains("Balance") || 
                    e.getClass().getSimpleName().contains("Insufficient")) {
                    passed++;
                }
            }
            
            // Test 10: Null/invalid input handling
            try {
                bank.deposit(Double.NaN);
                // Should handle NaN appropriately
            } catch (Exception e) {
                passed++; // Exception is expected for NaN
            }
            
        } catch (Exception e) {
            // Tests failed due to implementation issues
        }
        
        System.out.println("Banking Operations tests: " + passed + "/10 passed\n");
        return passed;
    }
    
    private static int testFileOperations() {
        System.out.println("Testing File Operations...");
        int passed = 0;
        
        try {
            FileManager fm = new FileManager();
            
            // Test 1: Read existing file
            try {
                String content = fm.readFile("existing.txt");
                if (content != null) passed++;
            } catch (Exception e) {
                // Should not throw exception for existing file
            }
            
            // Test 2: Read non-existing file throws exception
            try {
                fm.readFile("nonexistent.txt");
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 3: Write file succeeds
            try {
                boolean result = fm.writeFile("test.txt", "Hello World");
                if (result) passed++;
            } catch (Exception e) {
                // Should not throw exception for valid write
            }
            
            // Test 4: Write with null filename throws exception
            try {
                fm.writeFile(null, "content");
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 5: Write with null content throws exception
            try {
                fm.writeFile("file.txt", null);
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 6: Delete existing file
            try {
                boolean result = fm.deleteFile("existing.txt");
                if (result) passed++;
            } catch (Exception e) {
                // Should not throw exception for existing file
            }
            
            // Test 7: Delete non-existing file throws exception
            try {
                fm.deleteFile("nonexistent.txt");
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 8: Exception message is informative
            try {
                fm.readFile("missing.txt");
            } catch (Exception e) {
                if (e.getMessage() != null && e.getMessage().contains("file")) {
                    passed++;
                }
            }
            
            // Test 9: Security exception simulation
            try {
                fm.deleteFile("protected.txt");
                // Should handle security issues
            } catch (Exception e) {
                passed++;
            }
            
            // Test 10: Empty filename handling
            try {
                fm.readFile("");
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
        } catch (Exception e) {
            // Tests failed due to implementation issues
        }
        
        System.out.println("File Operations tests: " + passed + "/10 passed\n");
        return passed;
    }
    
    private static int testInputValidation() {
        System.out.println("Testing Input Validation...");
        int passed = 0;
        
        try {
            InputValidator validator = new InputValidator();
            
            // Test 1: Valid age
            try {
                boolean result = validator.validateAge(25);
                if (result) passed++;
            } catch (Exception e) {
                // Should not throw exception for valid age
            }
            
            // Test 2: Invalid age (negative)
            try {
                validator.validateAge(-5);
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 3: Invalid age (too old)
            try {
                validator.validateAge(150);
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 4: Valid email
            try {
                boolean result = validator.validateEmail("user@example.com");
                if (result) passed++;
            } catch (Exception e) {
                // Should not throw exception for valid email
            }
            
            // Test 5: Invalid email (no @)
            try {
                validator.validateEmail("invalid-email");
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 6: Invalid email (null)
            try {
                validator.validateEmail(null);
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 7: Valid phone number
            try {
                boolean result = validator.validatePhoneNumber("1234567890");
                if (result) passed++;
            } catch (Exception e) {
                // Should not throw exception for valid phone
            }
            
            // Test 8: Invalid phone (too short)
            try {
                validator.validatePhoneNumber("123");
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 9: Invalid phone (contains letters)
            try {
                validator.validatePhoneNumber("12345abcde");
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 10: Custom exception types
            try {
                validator.validateAge(-1);
            } catch (Exception e) {
                if (e.getClass().getSimpleName().contains("Age") || 
                    e.getClass().getSimpleName().contains("Invalid")) {
                    passed++;
                }
            }
            
        } catch (Exception e) {
            // Tests failed due to implementation issues
        }
        
        System.out.println("Input Validation tests: " + passed + "/10 passed\n");
        return passed;
    }
    
    private static int testDatabaseOperations() {
        System.out.println("Testing Database Operations...");
        int passed = 0;
        
        try {
            DatabaseConnection db = new DatabaseConnection();
            
            // Test 1: Successful connection
            try {
                boolean connected = db.connect("localhost", 3306, "testdb");
                if (connected) passed++;
            } catch (Exception e) {
                // Should not throw exception for valid connection
            }
            
            // Test 2: Invalid connection throws exception
            try {
                db.connect("invalid-host", -1, null);
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 3: Execute valid query
            try {
                db.connect("localhost", 3306, "testdb");
                String result = db.executeQuery("SELECT * FROM users");
                if (result != null) passed++;
            } catch (Exception e) {
                // Should not throw exception for valid query
            }
            
            // Test 4: Execute query without connection
            DatabaseConnection db2 = new DatabaseConnection();
            try {
                db2.executeQuery("SELECT 1");
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 5: Null query throws exception
            try {
                db.executeQuery(null);
                // Should throw exception
            } catch (Exception e) {
                passed++;
            }
            
            // Test 6: Close connection
            try {
                boolean closed = db.closeConnection();
                if (closed) passed++;
            } catch (Exception e) {
                // Should not throw exception for close
            }
            
            // Test 7: Try-with-resources simulation
            try {
                DatabaseConnection db3 = new DatabaseConnection();
                db3.connect("localhost", 3306, "testdb");
                db3.executeQuery("SELECT 1");
                db3.closeConnection();
                passed++; // Should handle resource management
            } catch (Exception e) {
                // Exception handling should work
            }
            
            // Test 8: Exception chaining
            try {
                DatabaseConnection db4 = new DatabaseConnection();
                db4.executeQuery("INVALID SQL");
            } catch (Exception e) {
                if (e.getCause() != null || e.getMessage() != null) {
                    passed++;
                }
            }
            
            // Test 9: Multiple operations
            try {
                DatabaseConnection db5 = new DatabaseConnection();
                db5.connect("localhost", 3306, "testdb");
                db5.executeQuery("SELECT 1");
                db5.executeQuery("SELECT 2");
                db5.closeConnection();
                passed++;
            } catch (Exception e) {
                // Should handle multiple operations
            }
            
            // Test 10: Finally block execution
            try {
                DatabaseConnection db6 = new DatabaseConnection();
                db6.connect("localhost", 3306, "testdb");
                try {
                    db6.executeQuery("INVALID QUERY");
                } finally {
                    db6.closeConnection();
                    passed++; // Finally should execute
                }
            } catch (Exception e) {
                // Exception is expected, but finally should still execute
            }
            
        } catch (Exception e) {
            // Tests failed due to implementation issues
        }
        
        System.out.println("Database Operations tests: " + passed + "/10 passed\n");
        return passed;
    }
}
