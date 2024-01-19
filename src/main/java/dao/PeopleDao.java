package dao;

import entities.People;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.DatabaseUtils;

import java.util.List;

public class PeopleDao {
    public void saveOrUpdatePeopleList(List<People> peopleList) {
        Transaction tx = null;
        try (Session session = DatabaseUtils.getSessionFactory().getCurrentSession()) {
            tx = session.beginTransaction();

            for (People person : peopleList) {
                session.saveOrUpdate(person);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
