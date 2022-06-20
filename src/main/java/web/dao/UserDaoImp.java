package web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.config.Util;
import web.model.User;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @PersistenceContext
   private EntityManager entityManager;



   @Override
   //@SuppressWarnings("unchecked")
   public List<User> listUsers() {
      return entityManager.createQuery("SELECT c FROM User c", User.class).getResultList();
   }

   @Override
   public User getById(int id) {
      return entityManager.find(User.class, id);
   }

   @Override
   public void saveUser(User user) {
      entityManager.persist(user);
   }

   @Override
   public void update(int id, User updatedUser) {
      entityManager.merge(updatedUser);
   }


   @Override
   public void delete(int id) {
      User user = entityManager.find(User.class, id);
      entityManager.remove(user);
entityManager.flush();
     // entityManager.remove(user);
   }

}

