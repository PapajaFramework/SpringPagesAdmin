package org.papaja.adminfly.module.mdbv.mongodb.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;
import java.util.Map;

@SuppressWarnings({"unused"})
@Document("records")
public class Record {

    @Id
    private String id;

    private String name;

    private ZonedDateTime time;

    private Map<String, Object> extra;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, Object> extra) {
        this.extra = extra;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return String.format("Record{id='%s', name='%s', time=%s, extra=%s}", id, name, time, extra);
    }



}
