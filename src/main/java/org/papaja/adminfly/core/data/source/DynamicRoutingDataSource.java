package org.papaja.adminfly.core.data.source;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return ClientDatabaseContextHolder.getCurrentClientDatabase();
    }

}
