package W1_CollegeScheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private int number;
    private String name;
    private LocalDate date;
    private List<Group> groups;

    public Room() {
        this.groups = new ArrayList<>();
    }

    public Room(int number, String name) {
        this.number = number;
        this.name = name;
        this.groups = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Room nr " + this.number + " \"" + this.name + "\" " + this.scheduledGroups();
    }

    public String scheduledGroups() {
        List<String> groupNames = new ArrayList<>();
        for (Group group : this.groups)
            groupNames.add(group.getName());
        return groupNames.toString();
    }

    public int getNr() {
        return this.number;
    }

    public void addGroup(Group group) {
        int count = 0;
        for (Group g : this.groups) {
            count++;
        }
        if (count < 4) {
            this.groups.add(group);
        } else {
            System.out.println("Room's schedule is full!");
        }
    }

    public void removeGroup(Group group) {
        this.groups.remove(group);
    }
}
