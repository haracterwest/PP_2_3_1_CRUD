package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
   void saveUser(User user);
   List<User> listUsers();
   void update(int id, User updatedUser);
   void delete(int id);
   User getById(int id);

}
