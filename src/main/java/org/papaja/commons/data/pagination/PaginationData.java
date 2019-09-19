package org.papaja.commons.data.pagination;

public class PaginationData {

    private Number total, current, size;

    public PaginationData(Number total, Number current, Number size) {
        this.total = total;
        this.current = current;
        this.size = size;
    }

    public Number getTotal() {
        return total;
    }

    public Number getCurrent() {
        return current;
    }

    public Number getSize() {
        return size;
    }

}
