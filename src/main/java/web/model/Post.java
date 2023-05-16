package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
@Data
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String postName;
  private String text;
  private LocalDate pubDate;

  @ManyToOne(fetch = FetchType.EAGER)
  private User user;

//  public Post(String postName, String text, LocalDate pubDate, User user) {
//    this.postName = postName;
//    this.text = text;
//    this.pubDate = pubDate;
//    this.user = user;
//  }
}
