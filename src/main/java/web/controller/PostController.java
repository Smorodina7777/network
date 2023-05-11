package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Post;
import web.model.User;
import web.repository.PostCreateService;
import web.service.PostService;
import web.service.UserServiceEntity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class PostController {

  private final PostCreateService postCreateService;
  private final PostService postService;
  private final UserServiceEntity userService;

//  @GetMapping(value = "/createCategory")
//  public ResponseEntity<Void> createCategory() {
//    postCreateService.saveThemes();
//    return ResponseEntity.ok().build();
//  }

  @GetMapping(value = "/createPost")
  public ResponseEntity<String> createProduct() {
    Post randomPostAndTheme = postCreateService.getRandomPostAndTheme();
    return ResponseEntity.ok(randomPostAndTheme.toString());
  }

  @GetMapping(value = "/findPostByUser")
  public ResponseEntity<String> findPostByUser(@RequestParam User user) {
    Pageable pageable = PageRequest.of(0,4, Sort.by("pubDate").ascending());
    return ResponseEntity.ok(postService.findByUserAndPostName(user, pageable.toString()).toString());
  }

//  @GetMapping(value = "/findPostByDate")
//  public ResponseEntity<String> findPostByDate(@RequestParam LocalDate pubDate) {
//    Pageable pageable = PageRequest.of(0,4, Sort.by("pubDate").ascending());
//    Page<Post> result = postService.findByPubDate(pubDate, pageable);
//    System.out.println(result.getNumber());
//    System.out.println(result.getTotalElements());
//    System.out.println(result.getSize());
//    System.out.println(result.getTotalPages());
//    return ResponseEntity.ok(result.toString());
//  }

  @GetMapping(value = "/findAllPosts")
  public ResponseEntity<String> findAllUsers() {
    List<User> all = userService.findAll();
    for (User user : all) {
      for (Post post : user.getPosts()) {
        System.out.println(post);
      }
    }
    return ResponseEntity.ok(all.toString());
  }
}