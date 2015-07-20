package ua.startup.smartcounter.entities;

import java.util.List;

/**
 * @author tsv@ciklum.com
 */
public class ActivityEvent {

    private Event event;
    private List<DateEvent> eventsDates;

    public ActivityEvent() {
    }

    public ActivityEvent(Event event, List<DateEvent> eventsDates) {
        this.event = event;
        this.eventsDates = eventsDates;
    }

    public List<DateEvent> getEventsDates() {
        return eventsDates;
    }

    public void setEventsDates(List<DateEvent> eventsDates) {
        this.eventsDates = eventsDates;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
