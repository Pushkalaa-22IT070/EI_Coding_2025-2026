public class OccupancyCommand implements Command {
    private Room room;
    private int occupantCount;

    public OccupancyCommand(Room room, int occupantCount) {
        this.room = room;
        this.occupantCount = occupantCount;
    }

    @Override
    public void execute() {
        if (occupantCount > 0) {
            room.addOccupants(occupantCount);
        } else {
            room.removeOccupants(Math.abs(occupantCount));
        }
    }
}
