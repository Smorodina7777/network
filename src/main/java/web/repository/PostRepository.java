package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Post;

import web.model.User;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findByUserAndPostName(User user, String postName);
  List<Post> findAllByUser_id(Long id);

}
