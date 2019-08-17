package org.papaja.adminfly.module.blog.service;

import org.papaja.adminfly.module.blog.repository.CategoryRepository;
import org.papaja.adminfly.module.blog.entity.Category;
import org.papaja.adminfly.module.blog.entity.Domain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.Objects.nonNull;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category getCategory(Integer id) {
        boolean isValid = (nonNull(id) && id > 0);

        return isValid ? repository.get(id) : new Category();
    }

    public void remove(Integer id) {
        repository.remove(id);
    }

    public void merge(Category category) {
        repository.merge(category);
    }

    public List<Category> getCategories() {
        return repository.getList();
    }

    public List<Category> getCategories(Domain domain) {
        return repository.getCategories(domain);
    }

}
