# Smart Office Facility Management System

A console-based Java application that manages a smart office facility with conference room bookings, occupancy detection, and automated control of air conditioning and lighting.

## Features

### Design Patterns Implemented
1. **Singleton Pattern**: `OfficeManager` ensures only one instance exists throughout the application
2. **Observer Pattern**: Sensors observe room occupancy changes and trigger actions
3. **Command Pattern**: Booking, cancellation, and occupancy operations are handled through commands

### Core Functionality
- Configure office with specified number of meeting rooms
- Book and cancel conference room bookings
- Occupancy detection (requires at least 2 people to mark room as occupied)
- Automatic booking release after 5 minutes of no occupancy
- Automatic AC and lighting control based on occupancy
- Room usage statistics

## How to Run

1. Compile all Java files:
   ```bash
   javac *.java
   ```

2. Run the application:
   ```bash
   java -cp . Main
   ```

## Available Commands

- `config <room_count>` - Configure office with specified number of rooms
- `capacity <room_id> <max_capacity>` - Set room capacity
- `add <room_id> <occupant_count>` - Add occupants to room
- `book <room_id> <start_time> <duration>` - Book room (time format: HH:MM)
- `cancel <room_id>` - Cancel room booking
- `status` - Show room status
- `stats` - Show usage statistics
- `autorelease` - Check for auto-release of unoccupied bookings
- `quit` - Exit application

## Example Usage

```
Enter command: config 3
Office configured with 3 meeting rooms: Room 1, Room 2, Room 3.

Enter command: capacity 1 10
Room 1 maximum capacity set to 10.

Enter command: add 1 2
Room 1 is now occupied by 2 persons. AC and lights turned on.

Enter command: book 1 09:00 60
Room 1 booked from 09:00 for 60 minutes.

Enter command: cancel 1
Booking for Room 1 cancelled successfully.

Enter command: add 1 0
Room 1 is now unoccupied. AC and lights turned off.

Enter command: status
Room 1 - Capacity: 10, Occupied: false, Booked: false, Occupancy: 0, Lights: OFF, AC: OFF
Room 2 - Capacity: 10, Occupied: false, Booked: false, Occupancy: 0, Lights: OFF, AC: OFF
Room 3 - Capacity: 10, Occupied: false, Booked: false, Occupancy: 0, Lights: OFF, AC: OFF
```

## Class Structure

- `SmartOfficeApp` - Main application entry point
- `OfficeManager` - Singleton class managing the office system
- `Room` - Represents a meeting room with occupancy and booking state
- `RoomObserver` - Interface for observers of room state changes
- `Sensor` - Implements RoomObserver to monitor room changes
- `Command` - Interface for command pattern operations
- `BookingCommand` - Command for booking rooms
- `CancelBookingCommand` - Command for canceling bookings
- `OccupancyCommand` - Command for managing room occupancy
