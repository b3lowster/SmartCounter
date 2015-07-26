package ua.startup.smartcounter.entities;

import com.orm.SugarRecord;
import org.joda.time.DateTime;

/**
 * @author tsv@ciklum.com
 */
public class DateEvent extends SugarRecord<DateEvent> {

    private DateTime recordTime;
    private Long eventId;

    public DateEvent() {
        this.recordTime = DateTime.now();
    }

    public DateEvent(Long eventId) {
        this.recordTime = DateTime.now();
        this.eventId = eventId;
    }

    public DateTime getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(DateTime recordTime) {
        this.recordTime = recordTime;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
}
