package org.papaja.adminfly.module.blog.mapper;

import org.papaja.adminfly.module.blog.dto.CategoryDto;
import org.papaja.adminfly.module.blog.entity.Category;
import org.papaja.adminfly.common.util.Mapper;
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
