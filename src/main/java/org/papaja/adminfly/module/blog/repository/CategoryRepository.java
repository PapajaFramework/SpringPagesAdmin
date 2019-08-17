package org.papaja.adminfly.module.blog.repository;

import org.papaja.adminfly.module.blog.entity.Category;
import org.papaja.adminfly.module.blog.entity.Domain;
import org.papaja.adminfly.shared.repository.AbstractRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CategoryRepository extends AbstractRepository<Category> {

    public List<Category> getCategories(Domain domain) {
        CriteriaBuilder         builder = criteriaBuilder();
        CriteriaQuery<Category> query   = builder.createQuery(getReflection());
        Root<Category>          root    = query.from(getReflection());

        query.select(root);
        query.where(builder.equal(root.get("domain"), domain));

        return getList(query);
    }

    @Override
    public Class<Category> getReflection() {
        return Category.class;
    }

}
