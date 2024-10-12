package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

  // @Autowired
   private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
       return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
    //   return sessionFactory.getCurrentSession().createQuery("from User JOIN FETCH User.car").getResultList();
   }

   @Override
   public User getUser(String model, int series) {
      return (User) sessionFactory
              .getCurrentSession()
              .createQuery("FROM User u JOIN FETCH u.car WHERE u.car.model = :model AND u.car.series = :series")
              .setParameter("model", model)
              .setParameter("series", series)
              .uniqueResult();
   }

}
