package service.impl;

import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import repository.CategoryRepository;
import service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findOne(id);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag = false;
        Category currentCategory;
        try {
            currentCategory = categoryRepository.findOne(id);
            if (currentCategory != null) {
                flag = true;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return flag;
    }
}
