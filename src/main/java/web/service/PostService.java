package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Post;
import web.repository.PostRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class PostService {
  private final PostRepository postRepository;


  @Autowired
  public PostService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public Post save(Post post) {
    return postRepository.save(post);
  }


  public List<Post> findAll() {
    return postRepository.findAll();
  }

  public void delete(Post post) {
    postRepository.delete(post);
  }
  public Page<Post> findByDate(LocalDate pubDate, Pageable pageable) {
    return postRepository.findByPubDate(pubDate, pageable);
  }
  public List<Post> findByUser(Long userId, Pageable pageable) {
    return postRepository.getPostByUser_Id(userId, pageable);
  }
  public Page<Post> findPostByUser(Long userId, Pageable pageable) {
    return (Page<Post>) postRepository.getPostByUser_Id(userId, pageable);
  }
}
