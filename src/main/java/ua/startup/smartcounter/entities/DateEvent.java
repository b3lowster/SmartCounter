package ua.startup.smartcounter.entities;

import com.orm.SugarRecord;
import org.joda.time.DateTime;

/**
 * @author tsv@ciklum.com
 */
public class DateEvent extends SugarRecord<DateEvent> {

    private DateTime recordTime;

    public DateEvent() {
        this.recordTime = DateTime.now();
    }

    public DateEvent(DateTime recordTime) {
        this.recordTime = recordTime;
    }

    public DateTime getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(DateTime recordTime) {
        this.recordTime = recordTime;
    }
}
