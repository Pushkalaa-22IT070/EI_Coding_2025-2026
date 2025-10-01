# Printer Spooler (Singleton + Command Pattern)

This project demonstrates the **Singleton Design Pattern** combined with the **Command Pattern** using a **Printer Spooler** example.  

The **Printer Spooler** ensures that only one instance manages the print queue across the system, while the **Command Pattern** allows flexible execution of actions like adding and processing print jobs.  

---

## Description
- A **Printer Spooler** manages print jobs in a queue.  
- It follows the **Singleton Pattern** to make sure only one spooler instance exists.  
- Users can interactively:  
  - Add new print jobs  
  - Process (print) all jobs in the queue  
  - Exit the system  

---

## Features
- Add multiple print jobs to the queue.  
- Process all queued jobs at once in order.  
- Prevents multiple spooler instances (Singleton).  
- Uses **Command Pattern** to decouple job actions from the invoker.  
- Interactive menu-driven program for easy testing.  

---

## OOP Concepts Used
1. **Encapsulation**  
   - Printer jobs and queue management are encapsulated inside the `PrinterSpooler` class.  

2. **Abstraction**  
   - The `Command` interface provides a common abstraction for different actions (`AddPrintJob`, `ProcessPrintJob`).  

3. **Inheritance**  
   - `AddPrintJob` and `ProcessPrintJob` implement (`inherit`) the `Command` interface.  

4. **Polymorphism**  
   - The `execute()` method is implemented differently in each command class, allowing flexible behavior at runtime.  

5. **Singleton Design Pattern**  
   - Ensures only one `PrinterSpooler` instance manages all jobs.  

6. **Command Design Pattern**  
   - Encapsulates actions (Add / Process) as objects, allowing them to be executed via the `PrinterInvoker`.  


---
## Sample input and output:

<img width="702" height="797" alt="{63AA8D4B-FB11-4732-9218-C7C68E14DC26}" src="https://github.com/user-attachments/assets/90d711c1-30b6-466d-a052-5160de2855f5" />


## How to Run  

1. Compile all Java files:  
   ```bash
   javac *.java

2. Run the application:
   ```bash
   java -cp . Main

