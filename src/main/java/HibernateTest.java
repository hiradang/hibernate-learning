import com.hibernate.entities.User;
import org.hibernate.Session;

public class HibernateTest {
    public static void main(String[] args) {
        Session session = HibernateUtils.getFACTORY().openSession();

        User user = new User();
        user.setUsername("binhdang");
        user.setPassword("binhdang");
        session.save(user);

        session.close();
    }
}
