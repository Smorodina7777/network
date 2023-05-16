package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Post;
import web.repository.PostRepository;

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
}
