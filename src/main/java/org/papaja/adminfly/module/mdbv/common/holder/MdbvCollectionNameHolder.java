package org.papaja.adminfly.module.mdbv.common.holder;

import org.papaja.adminfly.common.util.structure.Holder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class MdbvCollectionNameHolder implements Holder<String> {

    @Autowired
    private HttpSession session;

    protected String sessionKey;

    public MdbvCollectionNameHolder(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public String get() {
        return (String) session.getAttribute(sessionKey);
    }

    @Override
    public void set(String value) {
        session.setAttribute(sessionKey, value);
    }

}
