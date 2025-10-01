public class Sensor implements RoomObserver {
    private String sensorId;
    private String sensorType;

    public Sensor(String sensorId, String sensorType) {
        this.sensorId = sensorId;
        this.sensorType = sensorType;
    }

    @Override
    public void update(Room room) {
        System.out.println("Sensor " + sensorId + " (" + sensorType + ") detected change in Room " + room.getRoomId() + 
                          " - Occupancy: " + room.getCurrentOccupancy() + 
                          ", Occupied: " + room.isOccupied());
    }

    public String getSensorId() {
        return sensorId;
    }

    public String getSensorType() {
        return sensorType;
    }
}
