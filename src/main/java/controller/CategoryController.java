package controller;

import model.Blog;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.BlogService;
import service.CategoryService;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/category/overview", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> loadListCategory() {
        ResponseEntity<List<Category>> reCategoryList = null;
        List<Category> categoryList;
        try {
            categoryList = categoryService.findAll();
            if (categoryList.isEmpty()) {
                reCategoryList = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                reCategoryList = new ResponseEntity<>(categoryList, HttpStatus.OK);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return reCategoryList;
    }

    @RequestMapping(value = "/category/view/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> getCategory(@PathVariable("id") Integer id) {
        ResponseEntity<List<Blog>> reBlogList = null;
        Category category;
        List<Blog> blogList;
        try {
            category = categoryService.findById(id);
            if (category != null) {
                blogList = blogService.findAllByCategoryByCategoryId(category);
                reBlogList = new ResponseEntity<>(blogList, HttpStatus.OK);
            } else {
                reBlogList = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return reBlogList;
    }
}