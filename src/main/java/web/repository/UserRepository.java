package web.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  User findUserByEmail(String email);

  User findUserByNameAndEmail(String name, String email);

  List<User> findAllByNameContaining(String name);



  boolean existsUserByNameAndPassword(String name, String password);

  User findUserByName(String name);
  @Query("SELECT DISTINCT a FROM User a JOIN FETCH a.posts")
  List<User> listAll();
}
