package ua.startup.smartcounter.entities;

import com.orm.SugarRecord;
import org.joda.time.DateTime;

/**
 * @author tsv@ciklum.com
 */
public class DateEvent extends SugarRecord<DateEvent> {

    private DateTime recordTime;
    private String eventName;

    public DateEvent() {
        this.recordTime = DateTime.now();
    }

    public DateEvent(String eventName) {
        this.recordTime = DateTime.now();
        this.eventName = eventName;
    }

    public DateTime getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(DateTime recordTime) {
        this.recordTime = recordTime;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
}
