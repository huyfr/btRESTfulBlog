package controller;

import com.sun.org.apache.regexp.internal.RE;
import model.Blog;
import model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.BlogService;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/blog/overview", method = RequestMethod.GET)
    public ResponseEntity<List<Blog>> loadListBlog() {
        ResponseEntity<List<Blog>> reLBlogList = null;
        List<Blog> blogList;
        try {
            blogList = blogService.findAll();
            if (blogList.isEmpty()) {
                reLBlogList = new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                reLBlogList = new ResponseEntity<>(blogList, HttpStatus.OK);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return reLBlogList;
    }

    @RequestMapping(value = "/blog/view/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlog(@PathVariable("id") Integer id) {
        Blog blog;
        ResponseEntity<Blog> viewDetail = null;
        try {
            blog = blogService.findById(id);
            if (blog != null) {
                viewDetail = new ResponseEntity<>(blog, HttpStatus.OK);
            } else {
                viewDetail = new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return viewDetail;
    }
}
