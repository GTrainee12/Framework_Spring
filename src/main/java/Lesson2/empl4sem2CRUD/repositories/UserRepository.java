package Lesson2.empl4sem2CRUD.repositories;

import Lesson2.empl4sem2CRUD.model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {


    private final JdbcTemplate jdbc;

    public UserRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = (r, i) -> {
            User rowObject = new User();
            rowObject.setId(r.getInt("id"));
            rowObject.setFirstName(r.getString("firstName"));
            rowObject.setLastName(r.getString("lastName"));
            return rowObject;
        };

        return jdbc.query(sql, userRowMapper);
    }

    public User save(User user) {
        String sql = "INSERT INTO userTable (firstName,lastName) VALUES ( ?, ?)";
        jdbc.update(sql, user.getFirstName(), user.getLastName());
        return user;
    }


    /*
     Добавленны методы добавления и удаления
    **/

    // метод public void delete(int id) удаления записи пользователя из БД по ID.
    public void delete(long id) {
        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql, id);
    }
    // метод public User findById(long id) нахождения пользователя по ID
    public User findById(long id) {
        String sql = "SELECT * FROM userTable WHERE id=?";
        return jdbc.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }

    // метод public void update(User user) редактирования пользователя
    public void update(User user) {
        String sql = "UPDATE userTable SET firstName=?, lastName=? WHERE id=?";
        jdbc.update(sql, user.getFirstName(), user.getLastName(), user.getId());
    }
}