package web.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import web.model.Post;

import web.model.User;
import web.service.PostService;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

@Component
@RequiredArgsConstructor
public class PostCreateService {

  private final PostService postService;
  private final String[] themes = {"Книги", "Электроника", "Одежда", "Косметика", "Игрушки", "Спортивные товары"};
  private ArrayList<User> users = new ArrayList<>();

  private final String[][] posts = {
          {"Война и мир", "Преступление и наказание", "Анна Каренина"},
          {"Смартфон Samsung", "Ноутбук HP", "Планшет Apple iPad"},
          {"Футболка Levi's", "Джинсы Wrangler", "Куртка Columbia"},
          {"Тональный крем L'Oreal", "Губная помада Maybelline", "Тени для век MAC"},
          {"Конструктор LEGO", "Мягкая игрушка Teddy Bear", "Настольная игра Monopoly"},
          {"Беговая дорожка NordicTrack", "Велосипед Merida", "Боксерские перчатки Everlast"}
  };

//  public Post getRandomPostAndTheme() {
//    Random random = new Random();
//    int themeIndex = random.nextInt(themes.length);
//    int postIndex = random.nextInt(posts[themeIndex].length);
//    User user = users.get(themeIndex);
//    String post = posts[themeIndex][postIndex];
//    return postService.save(new Post(post, LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), user));
//
//  }

//  public void saveThemes() {
//    for (String theme : themes) {
//      User user = new User(theme);
//      user = userService.save(user);
//      users.add(user);
//      System.out.println("Создана категория:" + category);
//    }
//  }

}
