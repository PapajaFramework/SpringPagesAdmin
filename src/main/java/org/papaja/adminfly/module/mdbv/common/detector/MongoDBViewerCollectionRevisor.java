package org.papaja.adminfly.module.mdbv.common.detector;

import org.papaja.adminfly.common.detector.Revisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.servlet.http.HttpSession;

public class MongoDBViewerCollectionRevisor implements Revisor<Object> {

    @Autowired
    private HttpSession session;

    protected Environment environment;

    public MongoDBViewerCollectionRevisor(Environment environment) {
        this.environment = environment;
    }

    @Override
    public Object get() {
        return session.getAttribute(environment.getProperty("module.mdbv.currentCollection"));
    }
}
