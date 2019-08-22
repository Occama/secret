package s.s.test.domain.model.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import s.s.test.domain.HibernateSessionFactoryUtil;
import s.s.test.domain.model.Device;
import s.s.test.domain.model.User;

public class UserDAO
{
    public static User findByID(int id)
    {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().byId(User.class).load((Object) id);
    }

    public static void save(User user)
    {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession())
        {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    public static Device findByUserID(int id)
    {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().byId(Device.class).load((Object) id);
    }
}
