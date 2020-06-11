package service.impl;

import model.Blog;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import repository.BlogRepository;
import repository.CategoryRepository;
import service.BlogService;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public boolean delete(Integer id) {
        boolean flag = false;
        Blog currentBlog;
        try {
            currentBlog = blogRepository.findOne(id);
            if (currentBlog != null) {
                flag = true;
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return flag;
    }

    @Override
    public List<Blog> findAllByTitleContaining(String title) {
        return blogRepository.findAllByTitleContaining(title);
    }

    @Override
    public List<Blog> findAllByCategoryByCategoryId(Category category) {
        return blogRepository.findAllByCategoryByCategoryId(category);
    }
}
