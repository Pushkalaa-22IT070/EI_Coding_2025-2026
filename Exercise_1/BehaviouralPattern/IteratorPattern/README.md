# Iterator Pattern - Playlist Player

This project demonstrates the **Iterator Design Pattern** using a simple **Playlist Player** example.  
The user can add songs to a playlist and play them one by one using an iterator.  
A small delay is added between songs to simulate real music playback.

---

## Features
- Add songs to a playlist.  
- Play songs sequentially using an iterator.  
- Adds a delay between playing each song to mimic real playback.  
- Demonstrates clean separation of responsibilities.  

---

## OOP Concepts Used
- **Encapsulation** → Song details (`title`) are kept private and accessed via getters.  
- **Abstraction** → `Iterator` interface defines abstract methods (`hasNext()`, `next()`).  
- **Polymorphism** → `SongIterator` provides a concrete implementation of the `Iterator` interface.  
- **Composition** → `Playlist` contains a list of `Song` objects.  
- **Separation of Concerns** → Each class has a single responsibility (`Song`, `Playlist`, `Iterator`, `SongIterator`, `Main`).  

---

## How to Run  

1. Compile all Java files:  
   ```bash
   javac src/*.java

2. Run the application:
   ```bash
   java -cp . Main

