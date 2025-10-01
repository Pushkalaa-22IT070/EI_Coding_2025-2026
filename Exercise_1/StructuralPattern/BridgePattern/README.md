# Smart Remote System - Bridge Pattern

## Description
This Java project demonstrates the **Bridge Design Pattern** using a **Smart Remote System**.  
The program allows a remote control to operate different devices (like **TV** and **Projector**) without tightly coupling the remote to specific devices.  
The **abstraction (RemoteControl)** is separated from the **implementation (Device)**, allowing both to vary independently.

---

## Features
- Choose between multiple devices (TV, Projector).  
- Perform actions on the selected device:
  - Turn ON
  - Turn OFF
  - Check device status  
- Fully interactive, simple, and beginner-friendly.  
- Easy to extend by adding new devices or remote types without modifying existing code.

---

## OOP Concepts Used
1. **Abstraction** – `RemoteControl` abstracts the control functionality.  
2. **Encapsulation** – Device states (like `isOn`) are private and managed through methods.  
3. **Polymorphism** – The same remote can control different devices using the `Device` interface.  
4. **Inheritance** – `AdvancedRemote` inherits from `RemoteControl` to extend functionality.  
5. **Interface** – `Device` interface allows multiple device implementations without changing the remote code.  
6. **Composition** – `RemoteControl` contains a `Device` object (Bridge between abstraction and implementation).

---

## Sample input and output:

<img width="744" height="132" alt="{AE9A1B65-50FA-42BE-89D0-54E6D3132732}" src="https://github.com/user-attachments/assets/dedb29cd-154e-4378-b31f-1a8152ac97a1" />


## How to Run  

1. Compile all Java files:  
   ```bash
   javac *.java

2. Run the application:
   ```bash
   java -cp . Main

