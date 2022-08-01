import com.hibernate.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtils {
    private static final SessionFactory FACTORY;

    static {
        Configuration configuration = new Configuration();

        Properties props = new Properties();
        props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
        props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
        props.put(Environment.URL, "jdbc:mysql://localhost:3306/hibernate");
        props.put(Environment.USER, "root");
        props.put(Environment.PASS, "");
        props.put(Environment.SHOW_SQL, "true");

        configuration.setProperties(props);

        configuration.addAnnotatedClass(User.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        FACTORY = configuration.buildSessionFactory(registry);
    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }
}
