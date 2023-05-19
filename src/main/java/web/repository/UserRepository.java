package web.repository;

import lombok.ToString;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import web.model.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  void deleteById(Long id);

User getUserById(Long id);

  boolean existsUserByNameAndPassword(String name, String password);

  User findUserByName(String name);
@Query("SELECT DISTINCT a FROM User a JOIN FETCH a.posts")
  List<User> listAlluser();


}
