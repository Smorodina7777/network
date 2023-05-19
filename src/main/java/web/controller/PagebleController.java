package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import web.model.Post;
import web.model.User;
import web.service.PostService;
import web.service.UserServiceEntity;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PagebleController {

  private final PostService postService;
  private final UserServiceEntity userService;



  @GetMapping(value = "/user/{userId}")
  public ResponseEntity<String> findPostByUser(@PathVariable Long userId) {
    Pageable pageable = PageRequest.of(0,2, Sort.by("pubDate").ascending());
    return ResponseEntity.ok(postService.findByUser(userId,pageable).toString());
  }

  @GetMapping(value = "/date")
  public ResponseEntity<String> findPostByDate(@RequestParam LocalDate pubDate) {
    Pageable pageable = PageRequest.of(0,2, Sort.by("pubDate").ascending());
    Page<Post> result = postService.findByDate(pubDate, pageable);
    System.out.println(result.getNumber());
    System.out.println(result.getTotalElements());
    System.out.println(result.getSize());
    System.out.println(result.getTotalPages());
    return ResponseEntity.ok(result.toString());
  }

  @GetMapping(value = "/all")
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