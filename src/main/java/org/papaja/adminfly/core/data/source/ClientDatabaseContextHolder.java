package org.papaja.adminfly.core.data.source;

public class ClientDatabaseContextHolder {

    private static final ThreadLocal<ClientDatabase> CONTEXT;

    static {
        CONTEXT = new ThreadLocal<>();
        setClientDatabase(ClientDatabase.DATABASE_A);
    }

    public static void setClientDatabase(ClientDatabase database) {
        CONTEXT.set(database);
    }

    public static ClientDatabase getCurrentClientDatabase() {
        return CONTEXT.get();
    }

    public static void remove() {
        CONTEXT.remove();
    }

}
