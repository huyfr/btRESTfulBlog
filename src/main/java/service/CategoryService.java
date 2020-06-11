package service;

import model.Blog;
import model.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> findAll();

    public Category findById(Integer id);

    public void save(Category category);

    public boolean delete(Integer id);
}
