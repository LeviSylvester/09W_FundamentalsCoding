package W1_CollegeScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static W1_CollegeScheduler.College.display;

public class School {
    private List<Room> rooms;
    private Scanner scanner;

    public School() {
        this.rooms = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void printRooms() {
        for (Room room : rooms) {
            System.out.println(room);
        }
    }

    public Room existingRoomFromInput() {
        display("Enter the nr of the room you'd like to select:");
        int roomNrFromInput = scanner.nextInt();
        Room existingRoom = new Room();
        for (Room room : this.rooms) {
            if (room.getNr()==roomNrFromInput) {
                existingRoom = room;
            }
        }
        return existingRoom;
    }
}


