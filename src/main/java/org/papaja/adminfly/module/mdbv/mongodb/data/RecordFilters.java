package org.papaja.adminfly.module.mdbv.mongodb.data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;

public class RecordFilters implements Serializable {

    private static final String QUERY_REQUEST    = "queryRequest";
    private static final String QUERY_PATH       = "queryPath";
    private static final String QUERY_TYPE       = "queryType";

    private static final long serialVersionUID   = -1121127645216341818L;

    private Map<String, String> data;

    public RecordFilters() {
        data = new HashMap<>();
    }

    public String getQueryRequest() {
        return data.get(QUERY_REQUEST);
    }

    public void setQueryRequest(String request) {
        data.put(QUERY_REQUEST, request);
    }

    public String getQueryPath() {
        return data.get(QUERY_PATH);
    }

    public void setQueryPath(String path) {
        data.put(QUERY_PATH, path);
    }

    public String getQueryType() {
        return data.get(QUERY_TYPE);
    }

    public void setQueryType(String type) {
        data.put(QUERY_TYPE, type);
    }

    @Override
    public String toString() {
        return format("RecordFilters{data=%s}", data);
    }

}
