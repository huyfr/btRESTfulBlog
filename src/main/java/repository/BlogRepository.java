package repository;

import model.Blog;
import model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
    public List<Blog> findAllByTitleContaining(String title);

    public List<Blog> findAllByCategoryByCategoryId(Category category);
}
