package ua.startup.smartcounter.entities;

import com.orm.SugarRecord;

import java.util.List;

/**
 * @author tsv@ciklum.com
 */
public class Event extends SugarRecord<Event> {

    private String name;
    private Counter counter;

    public Event() {
    }

    public Event(String name) {
        this.name = name;
        this.counter = new Counter();
    }

    public Event(String name, Counter counter) {
        this.name = name;
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Counter getCounter() {
        return counter;
    }

    public void setCounter(Counter counter) {
        this.counter = counter;
    }

}
