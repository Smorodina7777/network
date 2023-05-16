package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;
import web.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceEntity {
  private final UserRepository repo;

  public List<User> listAll() {
    return (List<User>) repo.findAll();
  }

  public User getById(Long id) {
    return repo.findById(id).get();
  }
  public User getUserById(Long id) {
    return repo.getUserById(id);
  }

  public User saveUser(User user) {
    return repo.save(user);
  }

  public void updateUser(User user) {
    if (!repo.existsById(user.getId())) {
      throw new RuntimeException("Не удалось найти пользовтаеля с id:" + user.getId());
    }
    repo.save(user);
  }

  public boolean existUser(String name, String password) {
    return repo.existsUserByNameAndPassword(name, password);
  }

  public User getByName(String name) {
    return repo.findUserByName(name);
  }

  public void addUser(User user) {
    repo.save(user);
  }

  public void deleteUser(User user) {
    repo.delete(user);
  }
@Transactional
  public List<User> findAll() {
    List<User> all = repo.listAll();
    return all;
  }
  public void deleteUserById(Long id) {
    repo.deleteById(id);
  }
}
