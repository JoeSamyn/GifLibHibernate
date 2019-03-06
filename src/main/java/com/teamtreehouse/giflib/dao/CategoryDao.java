package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Category;
import org.apache.catalina.startup.Catalina;

import java.util.List;

public interface CategoryDao {

    List<Category> findAll();
    Category findById(Long id);
    void saveCategory(Category category);
    void deleteCategory(Category category);

}
