import java.time.LocalTime;

public class BookingCommand implements Command {
    private Room room;
    private LocalTime startTime;
    private int durationMinutes;

    public BookingCommand(Room room, LocalTime startTime, int durationMinutes) {
        this.room = room;
        this.startTime = startTime;
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void execute() {
        room.bookRoom(startTime, durationMinutes);
    }
}
