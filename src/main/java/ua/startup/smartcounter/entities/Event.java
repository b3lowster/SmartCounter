package ua.startup.smartcounter.entities;

import com.orm.SugarRecord;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tsv@ciklum.com
 */
public class Event extends SugarRecord<Event> {

    private String eventName;
    private DateTime createdAt;
    
    public Event() {
    }

    public Event(String eventName, DateTime createdAt) {
        this.eventName = eventName;
        this.createdAt = createdAt;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }
}
