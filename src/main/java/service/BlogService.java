package service;

import model.Blog;
import model.Category;

import java.util.List;

public interface BlogService {
    public List<Blog> findAll();

    public Blog findById(Integer id);

    public void save (Blog blog);

    public boolean delete(Integer id);

    public List<Blog> findAllByTitleContaining(String title);

    public List<Blog> findAllByCategoryByCategoryId(Category category);
}
