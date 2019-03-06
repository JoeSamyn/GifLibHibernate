package com.teamtreehouse.giflib.service;

import com.teamtreehouse.giflib.dao.CategoryDao;
import com.teamtreehouse.giflib.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Category findById(Long id) {

        return categoryDao.findById(id);
    }

    @Override
    public void saveCategory(Category category) {
        categoryDao.saveCategory(category);

    }

    @Override
    public void deleteCategory(Category category) {
        categoryDao.deleteCategory(category);
    }
}
