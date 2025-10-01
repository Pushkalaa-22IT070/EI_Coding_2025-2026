import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OfficeManager {
    private static OfficeManager instance;
    private List<Room> rooms;
    private Scanner scanner;

    private OfficeManager() {
        this.rooms = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public static OfficeManager getInstance() {
        if (instance == null) {
            instance = new OfficeManager();
        }
        return instance;
    }

    public void configureOffice(int roomCount) {
        rooms.clear();
        for (int i = 1; i <= roomCount; i++) {
            Room room = new Room(i, 10); // Default capacity of 10
            rooms.add(room);
            
            // Add sensors to each room
            Sensor occupancySensor = new Sensor("SENSOR_" + i, "Occupancy");
            room.addObserver(occupancySensor);
        }
        
        System.out.println("Office configured with " + roomCount + " meeting rooms:");
        for (int i = 1; i <= roomCount; i++) {
            System.out.print("Room " + i);
            if (i < roomCount) System.out.print(", ");
        }
        System.out.println(".");
    }

    public void setRoomCapacity(int roomId, int maxCapacity) {
        if (roomId > 0 && roomId <= rooms.size()) {
            rooms.get(roomId - 1).setMaxCapacity(maxCapacity);
            System.out.println("Room " + roomId + " maximum capacity set to " + maxCapacity + ".");
        } else {
            System.out.println("Invalid room ID.");
        }
    }

    public void addOccupant(int roomId, int count) {
        if (roomId > 0 && roomId <= rooms.size()) {
            Command command = new OccupancyCommand(rooms.get(roomId - 1), count);
            command.execute();
        } else {
            System.out.println("Invalid room ID.");
        }
    }

    public void bookRoom(int roomId, String timeStr, int duration) {
        if (roomId > 0 && roomId <= rooms.size()) {
            try {
                LocalTime startTime = LocalTime.parse(timeStr);
                Command command = new BookingCommand(rooms.get(roomId - 1), startTime, duration);
                command.execute();
            } catch (Exception e) {
                System.out.println("Invalid time format. Use HH:MM format.");
            }
        } else {
            System.out.println("Invalid room ID.");
        }
    }

    public void cancelBooking(int roomId) {
        if (roomId > 0 && roomId <= rooms.size()) {
            Command command = new CancelBookingCommand(rooms.get(roomId - 1));
            command.execute();
        } else {
            System.out.println("Invalid room ID.");
        }
    }

    public void showRoomStatus() {
        System.out.println("\n=== Room Status ===");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public void checkAutoRelease() {
        for (Room room : rooms) {
            room.checkAutoRelease();
        }
    }

    public void showUsageStatistics() {
        System.out.println("\n=== Usage Statistics ===");
        int totalRooms = rooms.size();
        int occupiedRooms = 0;
        int bookedRooms = 0;
        
        for (Room room : rooms) {
            if (room.isOccupied()) occupiedRooms++;
            if (room.isBooked()) bookedRooms++;
        }
        
        System.out.println("Total Rooms: " + totalRooms);
        System.out.println("Occupied Rooms: " + occupiedRooms);
        System.out.println("Booked Rooms: " + bookedRooms);
        System.out.println("Available Rooms: " + (totalRooms - occupiedRooms));
    }

    public void run() {
        System.out.println("=== Smart Office Facility Management System ===");
        System.out.println("Commands:");
        System.out.println("  config <room_count> - Configure office with specified number of rooms");
        System.out.println("  capacity <room_id> <max_capacity> - Set room capacity");
        System.out.println("  add <room_id> <occupant_count> - Add occupants to room");
        System.out.println("  book <room_id> <start_time> <duration> - Book room (time format: HH:MM)");
        System.out.println("  cancel <room_id> - Cancel room booking");
        System.out.println("  status - Show room status");
        System.out.println("  stats - Show usage statistics");
        System.out.println("  autorelease - Check for auto-release of unoccupied bookings");
        System.out.println("  quit - Exit application");
        System.out.println();

        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ");

            if (parts.length == 0) continue;

            switch (parts[0].toLowerCase()) {
                case "config":
                    if (parts.length >= 2) {
                        try {
                            int roomCount = Integer.parseInt(parts[1]);
                            configureOffice(roomCount);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid room count. Please enter a number.");
                        }
                    } else {
                        System.out.println("Usage: config <room_count>");
                    }
                    break;

                case "capacity":
                    if (parts.length >= 3) {
                        try {
                            int roomId = Integer.parseInt(parts[1]);
                            int capacity = Integer.parseInt(parts[2]);
                            setRoomCapacity(roomId, capacity);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid room ID or capacity. Please enter numbers.");
                        }
                    } else {
                        System.out.println("Usage: capacity <room_id> <max_capacity>");
                    }
                    break;

                case "add":
                    if (parts.length >= 3) {
                        try {
                            int roomId = Integer.parseInt(parts[1]);
                            int count = Integer.parseInt(parts[2]);
                            addOccupant(roomId, count);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid room ID or occupant count. Please enter numbers.");
                        }
                    } else {
                        System.out.println("Usage: add <room_id> <occupant_count>");
                    }
                    break;

                case "book":
                    if (parts.length >= 4) {
                        try {
                            int roomId = Integer.parseInt(parts[1]);
                            String timeStr = parts[2];
                            int duration = Integer.parseInt(parts[3]);
                            bookRoom(roomId, timeStr, duration);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid room ID or duration. Please enter numbers.");
                        }
                    } else {
                        System.out.println("Usage: book <room_id> <start_time> <duration>");
                    }
                    break;

                case "cancel":
                    if (parts.length >= 2) {
                        try {
                            int roomId = Integer.parseInt(parts[1]);
                            cancelBooking(roomId);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid room ID. Please enter a number.");
                        }
                    } else {
                        System.out.println("Usage: cancel <room_id>");
                    }
                    break;

                case "status":
                    showRoomStatus();
                    break;

                case "stats":
                    showUsageStatistics();
                    break;

                case "autorelease":
                    checkAutoRelease();
                    break;

                case "quit":
                case "exit":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Unknown command. Type 'quit' to exit.");
                    break;
            }
            System.out.println();
        }
    }
}
