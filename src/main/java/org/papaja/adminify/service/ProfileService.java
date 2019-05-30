package org.papaja.adminify.service;

import org.papaja.adminify.dao.ProfileDao;
import org.papaja.adminify.entity.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileDao dao;

    @Transactional
    public Profile getProfile(Integer id) {
        return dao.getProfile(id);
    }

    @Transactional
    public void persist(Profile profile) {
        dao.persist(profile);
    }

    @Transactional
    public List<Profile> getProfiles() {
        return dao.getProfiles();
    }
}
