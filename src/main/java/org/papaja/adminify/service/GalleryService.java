package org.papaja.adminify.service;

import org.papaja.adminify.dao.GalleryDao;
import org.papaja.adminify.entity.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GalleryService {

    @Autowired
    private GalleryDao dao;

    @Transactional
    public void save(Gallery gallery) {
        dao.save(gallery);
    }

    @Transactional
    public List<Gallery> getGalleries() {
        return dao.getGalleries();
    }

}
