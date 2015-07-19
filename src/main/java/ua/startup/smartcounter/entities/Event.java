package ua.startup.smartcounter.entities;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsv@ciklum.com
 */
public class Event extends SugarRecord<Event> {

    private String name;
    private List<DateEvent> dateEvents;

    public Event() {
    }

    public Event(String name) {
        this.name = name;
        this.dateEvents = new ArrayList<>();
    }

    public Event(String name, List<DateEvent> counter) {
        this.name = name;
        this.dateEvents = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DateEvent> getDateEvents() {
        return dateEvents;
    }

    public void setDateEvents(List<DateEvent> dateEvents) {
        this.dateEvents = dateEvents;
    }
}
