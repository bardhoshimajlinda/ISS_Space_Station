package utils;

import entities.People;
import entities.Station;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class DatabaseUtils {
    private static SessionFactory FACTORY;
    public static SessionFactory getSessionFactory() {
        // Configure and initialize Session factory
        if (FACTORY == null) {
            Properties prop= new Properties();
            prop.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/iss");
            prop.setProperty(Environment.HBM2DDL_AUTO, "update");
            prop.setProperty(Environment.SHOW_SQL, "true");
            prop.setProperty(Environment.FORMAT_SQL, "true");
            prop.setProperty(Environment.USER, "root");
            prop.setProperty(Environment.PASS, System.getenv("MYSQL_PSWD"));
            prop.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            prop.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            prop.setProperty(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

            Configuration config = new Configuration();
            config.setProperties(prop);
            config.addPackage("entities");
            config.addAnnotatedClass(People.class);
            config.addAnnotatedClass(Station.class);
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties()).build();

            FACTORY = config.buildSessionFactory(serviceRegistry);
        }

        return FACTORY;
    }

    public static boolean testConnection() {
        try (Session session = getSessionFactory().openSession()) {
            return session.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
