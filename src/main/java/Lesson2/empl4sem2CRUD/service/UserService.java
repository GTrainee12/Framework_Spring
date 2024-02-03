package Lesson2.empl4sem2CRUD.service;

import Lesson2.empl4sem2CRUD.model.User;
import Lesson2.empl4sem2CRUD.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    // метод public User findById(long id) нахождения пользователя по ID
    public User findById(long id) {
        return userRepository.findById(id);
    }

    // метод public void updateUser(User user) редактирования пользователя
    public void updateUser(User user) {
        userRepository.update(user);
    }
    // метод public void deleteUser(int id) удаление пользователя через репозиторий.
    public void deleteUser(long id) {
        userRepository.delete(id);
    }
}

