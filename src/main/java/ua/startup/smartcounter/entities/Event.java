package ua.startup.smartcounter.entities;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsv@ciklum.com
 */
public class Event extends SugarRecord<Event> {

    private String eventName;

    public Event() {
    }

    public Event(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
