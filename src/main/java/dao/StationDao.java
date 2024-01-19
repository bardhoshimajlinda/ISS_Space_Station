package dao;

import entities.Station;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.DatabaseUtils;

import java.util.List;

public class StationDao {
    public Station getStationByTitle(String titleToSearch) {
        Transaction tx = null;

        try (Session session = DatabaseUtils.getSessionFactory().getCurrentSession()) {
            tx = session.beginTransaction();
            List<Station> items = session
                    //.createQuery("from Station where title = 'ISS'")
                    .createQuery("from Station where title = :q")
                    .setParameter("q", "ISS")
                    .getResultList();
            if (items.size() > 0)
                return items.get(0);
            else return null;
        }
    }

    public void saveOrUpdateStation(Station station) {
        Transaction tx = null;
        try (Session session = DatabaseUtils.getSessionFactory().getCurrentSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(station);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }
}
