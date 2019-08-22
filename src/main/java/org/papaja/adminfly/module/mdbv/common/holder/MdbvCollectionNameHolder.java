package org.papaja.adminfly.module.mdbv.common.holder;

import org.papaja.adminfly.common.util.structure.Holder;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class MdbvCollectionNameHolder implements Holder<Integer> {

    @Autowired
    private HttpSession session;

    private String sessionKey;

    public MdbvCollectionNameHolder(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    @Override
    public Integer get() {
        return (Integer) session.getAttribute(sessionKey);
    }

    @Override
    public void set(Integer value) {
        session.setAttribute(sessionKey, value);
    }

}
