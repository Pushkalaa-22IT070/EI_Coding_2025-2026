# Media Player - Adapter Pattern

This project demonstrates the **Adapter Pattern** using a simple **Media Player** application in Java.  
The base media player supports only **MP3** format. Using an **Adapter**, it can also play **VLC** and **MP4** files without modifying the client code.

---

## Features
- Play **MP3** files directly.  
- Play **VLC** and **MP4** files through an adapter.  
- Show error messages for unsupported formats.  
- Easy to extend for new formats (just add a new AdvancedMediaPlayer implementation).  

---

## OOP Concepts Used
1. **Abstraction**  
   - `MediaPlayer` and `AdvancedMediaPlayer` interfaces hide the implementation details.  

2. **Inheritance / Implementation**  
   - `AudioPlayer` and `MediaAdapter` implement `MediaPlayer`.  
   - `VlcPlayer` and `Mp4Player` implement `AdvancedMediaPlayer`.  

3. **Encapsulation**  
   - Each class handles its own logic (e.g., `VlcPlayer` only knows how to play VLC files).  

4. **Polymorphism**  
   - `MediaAdapter` decides at runtime which player (`VlcPlayer` or `Mp4Player`) to use.  
   - `AudioPlayer` can play different file types through a common interface.  

---

## How to Run  

1. Compile all Java files:  
   ```bash
   javac *.java

2. Run the application:
   ```bash
   java -cp . Main

