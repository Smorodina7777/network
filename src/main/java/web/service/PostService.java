package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Post;

import web.model.User;
import web.repository.PostRepository;



import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

  public Optional<Post> findById(Long id) {
    return postRepository.findById(id);
  }

  public List<Post> findAll() {
    return postRepository.findAll();
  }
  public List<Post> findAllByUser_id(Long id) {
    return postRepository.findAllByUser_id(id);
  }

  public void delete(Post post) {
    postRepository.delete(post);
  }

  public List<Post> findByUserAndPostName(User user, String postName) {
    return postRepository.findByUserAndPostName(user, postName);
  }

//  public Page<Post> findByPubDate(LocalDate pubDate, Pageable pageable) {
//    return postRepository.findByPubDate(pubDate);
//  }
}
