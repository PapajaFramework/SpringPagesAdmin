package org.papaja.commons.data.pagination;

public class Paging {

    private Number total, current, size;

    public Paging(Number total, Number current, Number size) {
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
