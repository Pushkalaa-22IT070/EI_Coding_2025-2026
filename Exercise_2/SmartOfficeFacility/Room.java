import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int roomId;
    private int maxCapacity;
    private int currentOccupancy;
    private boolean isOccupied;
    private boolean isBooked;
    private LocalTime bookingStartTime;
    private int bookingDurationMinutes;
    private boolean lightsOn;
    private boolean acOn;
    private List<RoomObserver> observers;
    private LocalDateTime lastOccupancyTime;

    public Room(int roomId, int maxCapacity) {
        this.roomId = roomId;
        this.maxCapacity = maxCapacity;
        this.currentOccupancy = 0;
        this.isOccupied = false;
        this.isBooked = false;
        this.lightsOn = false;
        this.acOn = false;
        this.observers = new ArrayList<>();
        this.lastOccupancyTime = null;
    }

    public int getRoomId() {
        return roomId;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public boolean isLightsOn() {
        return lightsOn;
    }

    public boolean isAcOn() {
        return acOn;
    }

    public void addObserver(RoomObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(RoomObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (RoomObserver observer : observers) {
            observer.update(this);
        }
    }

    public void addOccupants(int count) {
        if (this.currentOccupancy + count > this.maxCapacity) {
            System.out.println("Cannot add " + count + " occupants to Room " + roomId + 
                             ". Would exceed maximum capacity of " + maxCapacity + 
                             " (current occupancy: " + currentOccupancy + ").");
            return;
        }
        this.currentOccupancy += count;
        this.lastOccupancyTime = LocalDateTime.now();
        
        // Check if room should be marked as occupied (at least 2 people)
        if (this.currentOccupancy >= 2 && !this.isOccupied) {
            this.isOccupied = true;
            turnOnLightsAndAC();
            System.out.println("Room " + roomId + " is now occupied by " + currentOccupancy + " persons. AC and lights turned on.");
        } else if (this.currentOccupancy < 2 && this.isOccupied) {
            this.isOccupied = false;
            turnOffLightsAndAC();
            System.out.println("Room " + roomId + " is now unoccupied. AC and lights turned off.");
        } else if (this.currentOccupancy < 2) {
            System.out.println("Room " + roomId + " occupancy insufficient to mark as occupied.");
        }
        
        notifyObservers();
    }

    public void removeOccupants(int count) {
        this.currentOccupancy = Math.max(0, this.currentOccupancy - count);
        this.lastOccupancyTime = LocalDateTime.now();
        
        if (this.currentOccupancy < 2 && this.isOccupied) {
            this.isOccupied = false;
            turnOffLightsAndAC();
            System.out.println("Room " + roomId + " is now unoccupied. AC and lights turned off.");
        }
        
        notifyObservers();
    }

    public void bookRoom(LocalTime startTime, int durationMinutes) {
        if (this.isBooked) {
            System.out.println("Room " + roomId + " is already booked during this time. Cannot book.");
            return;
        }
        
        this.isBooked = true;
        this.bookingStartTime = startTime;
        this.bookingDurationMinutes = durationMinutes;
        System.out.println("Room " + roomId + " booked from " + startTime + " for " + durationMinutes + " minutes.");
    }

    public void cancelBooking() {
        if (!this.isBooked) {
            System.out.println("Room " + roomId + " is not booked. Cannot cancel booking.");
            return;
        }
        
        this.isBooked = false;
        this.bookingStartTime = null;
        this.bookingDurationMinutes = 0;
        System.out.println("Booking for Room " + roomId + " cancelled successfully.");
    }

    public void checkAutoRelease() {
        if (this.isBooked && !this.isOccupied) {
            LocalDateTime now = LocalDateTime.now();
            
            // If room was never occupied, use booking start time + 5 minutes
            if (this.lastOccupancyTime == null) {
                if (this.bookingStartTime != null) {
                    LocalDateTime releaseTime = this.bookingStartTime.atDate(now.toLocalDate()).plusMinutes(5);
                    if (now.isAfter(releaseTime)) {
                        this.isBooked = false;
                        this.bookingStartTime = null;
                        this.bookingDurationMinutes = 0;
                        System.out.println("Room " + roomId + " booking automatically released - no occupancy for 5 minutes after booking.");
                    }
                }
            } else {
                // If room was occupied before, check if 5 minutes have passed since last occupancy
                if (now.isAfter(this.lastOccupancyTime.plusMinutes(5))) {
                    this.isBooked = false;
                    this.bookingStartTime = null;
                    this.bookingDurationMinutes = 0;
                    System.out.println("Room " + roomId + " booking automatically released due to no occupancy for 5 minutes.");
                }
            }
        }
    }

    private void turnOnLightsAndAC() {
        this.lightsOn = true;
        this.acOn = true;
    }

    private void turnOffLightsAndAC() {
        this.lightsOn = false;
        this.acOn = false;
    }

    @Override
    public String toString() {
        return "Room " + roomId + " - Capacity: " + maxCapacity + 
               ", Occupied: " + isOccupied + 
               ", Booked: " + isBooked + 
               ", Occupancy: " + currentOccupancy + 
               ", Lights: " + (lightsOn ? "ON" : "OFF") + 
               ", AC: " + (acOn ? "ON" : "OFF");
    }
}
