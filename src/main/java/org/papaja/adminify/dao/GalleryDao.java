package org.papaja.adminify.dao;

import org.hibernate.SessionFactory;
import org.papaja.adminify.entity.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@SuppressWarnings({"all"})
public class GalleryDao {

    @Autowired
    private SessionFactory factory;

    public void save(Gallery gallery) {
        factory.getCurrentSession().save(gallery);
    }

    public List<Gallery> getGalleries() {
        TypedQuery<Gallery> query = factory.getCurrentSession().createQuery("from Gallery");

        query.setMaxResults(100);

        return query.getResultList();
    }

}
