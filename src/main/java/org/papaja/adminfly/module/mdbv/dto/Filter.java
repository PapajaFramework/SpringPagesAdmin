package org.papaja.adminfly.module.mdbv.dto;

import java.util.List;

public class Filter {

    private List<String> query;
    private List<String> formats;
    private List<String> rules;
    private List<String> paths;

    public List<String> getQuery() {
        return query;
    }

    public void setQuery(List<String> query) {
        this.query = query;
    }

    public List<String> getFormat() {
        return formats;
    }

    public void setFormat(List<String> types) {
        this.formats = types;
    }

    public List<String> getRule() {
        return rules;
    }

    public void setRule(List<String> rules) {
        this.rules = rules;
    }

    public List<String> getPath() {
        return paths;
    }

    public void setPath(List<String> paths) {
        this.paths = paths;
    }

    @Override
    public String toString() {
        return String.format("Filter{query=%s, formats=%s, rules=%s, paths=%s}", query, formats, rules, paths);
    }

}
