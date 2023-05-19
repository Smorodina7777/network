package web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Post;

import web.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
  List<Post> findByUserAndPostName(User user, String postName);
  List<Post> findAllByUser_id(Long id, Pageable pageable);
  List<Post> getPostByUser_Id(Long userId, Pageable pageable);

  Page<Post> findByPubDate(LocalDate pubDate, Pageable pageable);
}
