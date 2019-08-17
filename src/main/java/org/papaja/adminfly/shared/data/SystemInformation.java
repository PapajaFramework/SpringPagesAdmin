package org.papaja.adminfly.shared.data;

public class SystemInformation {

    private Integer mb;
    private Long    total;
    private Long    free;
    private Long    maximum;
    private Long    used;
    private Long    maximumPercent;
    private Long    usedPercent;
    private String  os;
    private String  version;

    public SystemInformation() {
        Runtime runtime = Runtime.getRuntime();

        mb = 1024 * 1024;
        total = runtime.totalMemory() / mb;
        free = runtime.freeMemory() / mb;
        maximum = runtime.maxMemory() / mb;
        used = total - free;
        maximumPercent = total / (maximum / 100);
        usedPercent = used / (total / 100);

        os = System.getProperty("os.name");
        version = System.getProperty("java.version");
    }

    public String getOs() {
        return os;
    }

    public String getVersion() {
        return version;
    }

    public Integer getMb() {
        return mb;
    }

    public Long getTotal() {
        return total;
    }

    public Long getFree() {
        return free;
    }

    public Long getMaximum() {
        return maximum;
    }

    public Long getUsed() {
        return used;
    }

    public Long getMaximumPercent() {
        return maximumPercent;
    }

    public Long getUsedPercent() {
        return usedPercent;
    }

}
