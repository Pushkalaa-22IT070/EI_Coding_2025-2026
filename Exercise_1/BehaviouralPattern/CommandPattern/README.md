# Command Pattern for Light Switch  

This project demonstrates the **Command Design Pattern** using a simple **Light Switch** example.  
The user can turn a light **ON** or **OFF** through commands.  
This is a **beginner-friendly implementation** to understand how the **Command Pattern decouples the invoker (switch)** from the **receiver (light)**.  

---

## Features  
- Turn the light **ON** and **OFF** using commands.  
- Prevents duplicate actions (won’t turn ON if already ON, etc.).  
- Uses **Command Design Pattern** for clean separation of responsibilities.  
- Beginner-friendly code structure with each class in a separate file.  

---

## Core Functionality  
- Encapsulates ON and OFF actions as separate commands.  
- Invoker (`LightSwitchInvoker`) executes the given command without knowing details.  
- Receiver (`Light`) holds the actual state (ON/OFF).  
- Prevents duplicate actions → warns user if the same state is repeated.  
- Client (`Main`) wires commands, receiver, and invoker together.  

---

## Sample input and output

<img width="957" height="935" alt="{7940CE1E-042F-481D-B601-430F6558AB07}" src="https://github.com/user-attachments/assets/4124de22-1b3a-4337-bdd6-977ee8dd9d62" />


## How to Run  

1. Compile all Java files:  
   ```bash
   javac *.java

2. Run the application:
   ```bash
   java -cp . Main

