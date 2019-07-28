package org.papaja.adminfly.mapper.blog;

import org.papaja.adminfly.commons.mapping.Mapper;
import org.papaja.adminfly.dto.blog.CategoryDto;
import org.papaja.adminfly.entity.blog.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper implements Mapper<CategoryDto, Category> {

    @Override
    public void map(CategoryDto source, Category target) {
        target.setName(source.getName());
    }

    @Override
    public Category get() {
        return new Category();
    }

}
