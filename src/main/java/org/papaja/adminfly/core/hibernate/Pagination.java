package org.papaja.adminfly.core.hibernate;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"unused"})
public class Pagination<E> {

    private int     current;
    private int     limit;
    private int     offset;
    private int     total;
    private List<E> result;

    private Pagination(Query<E> query, int current, int limit) {
        this.current = current > 0 ? current : 1;
        this.limit = limit;
        this.offset = this.limit * (this.current - 1);
        this.result = new ArrayList<>();

        processQuery(query);
    }

    public static <E> Pagination<E> of(Query<E> query, int current, int limit) {
        return new Pagination(query, current, limit);
    }

    private void processQuery(Query<E> query) {
        int               limit  = getLimit();
        ScrollableResults scroll = query.scroll(ScrollMode.SCROLL_INSENSITIVE);

        scroll.first();
        scroll.scroll(this.offset);

        do {
            this.result.add((E) scroll.get(0));
        } while (--limit > 0 && scroll.next());

        scroll.last();

        this.total = scroll.getRowNumber() + 1;
    }

    public int getCurrent() {
        return current;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getTotal() {
        return total;
    }

    public List<E> getResult() {
        return result;
    }

}
