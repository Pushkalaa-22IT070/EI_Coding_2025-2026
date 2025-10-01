# Car Factory – Factory Design Pattern

This project demonstrates the **Factory Design Pattern** in Java.  
The program allows a user to choose a **Car Type** (Sedan, SUV, or Truck) and then select a **Variant** (Base, Mid, or Top).  
The **CarFactory** class handles the object creation, so the client does not need to know the exact class name.  

This makes the code **flexible, extensible, and easy to maintain**.

---

## Features
- Choose different **Car Types**: Sedan, SUV, Truck  
- Choose different **Variants**: Base, Mid, Top  
- Each car has its own **drive behavior** and **specifications**  
- Demonstrates **clean use of the Factory Pattern**  
- Simple, console-based interactive program  

---

## OOP Concepts Used
- **Abstraction** → `Car` interface defines `drive()` and `specs()` methods.  
- **Inheritance** → `Sedan`, `SUV`, and `Truck` implement the `Car` interface.  
- **Polymorphism** → The same `drive()` and `specs()` methods behave differently for each car type.  
- **Encapsulation** → Car details (features/specs) are hidden inside each class.  
- **Factory Pattern** → `CarFactory` decides which object to create based on user input.  

---
## Sample input and output:

<img width="717" height="240" alt="{8F1B62CD-7590-4C23-B13B-67D5CBB15B0D}" src="https://github.com/user-attachments/assets/1d28af88-c190-4d31-8792-d5194c55ce99" />

## How to Run  

1. Compile all Java files:  
   ```bash
   javac *.java

2. Run the application:
   ```bash
   java -cp . Main

