package ua.startup.smartcounter.entities;

import com.orm.SugarRecord;
import org.joda.time.DateTime;

/**
 * @author tsv@ciklum.com
 */
public class Counter extends SugarRecord<Counter> {

    private Long counter;
    private DateTime recordTime;

    public Counter() {
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public DateTime getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(DateTime recordTime) {
        this.recordTime = recordTime;
    }
}
