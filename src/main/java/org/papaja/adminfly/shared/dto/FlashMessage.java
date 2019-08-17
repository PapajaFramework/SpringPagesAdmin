package org.papaja.adminfly.shared.dto;

public class FlashMessage {

    private Severity severity;
    private String   text;
    private String   header;

    public FlashMessage(Severity severity, String text, String header) {
        this.severity = severity;
        this.text = text;
        this.header = header;
    }

    public String getSeverity() {
        return severity.getName();
    }

    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }

    public enum Severity {

        INFO("info"),
        SUCCESS("success"),
        ERROR("danger"),
        WARNING("warning"),
        NOTICE("notice");

        private String name;

        Severity(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
