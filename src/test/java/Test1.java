import com.cf.bean.Class;
import com.cf.bean.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import java.util.Iterator;
import java.util.UUID;

/**
 * Created by cpazstido on 2016/4/26.
 */
public class Test1 {
    @Test
    public void testSpringEnv(){
        //加载Spring的配置文件，得到ApplicationContext对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean对象
        Person person = (Person) context.getBean("person");
        System.out.println(person.getAge());
    }

    @Test
    public void testHibernateEnv(){
        //加载指定目录下的配置文件，得到configuration对象
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        //根据configuration对象得到session工厂对象
        SessionFactory factory = cfg.buildSessionFactory();
        //使用工厂类打开一个session
        Session session = factory.openSession();
        //开启事务
        Transaction tx = session.beginTransaction();
        //创建待插入数据库的对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Class cls=(Class)session.get(Class.class,1);
        Iterator it=cls.getPersonSet().iterator();
        while(it.hasNext())
        {
            Person p=(Person)it.next();
            Class clas=p.getCla();
            System.out.println("cid:"+clas.getCid()+"cname:"+clas.getCname());
            System.out.println("pid:"+p.getPid()+" pname:"+p.getName());
        }
        tx.commit();
        //关闭资源
        session.close();
        factory.close();
    }

    @Test
    public void testHibernateSpring() {
        //加载Spring的配置文件，得到ApplicationContext对象
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取bean对象
        SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
        Session session=factory.openSession();
        Class c=(Class)session.get(Class.class,1);
        System.out.println(c.getCname());
        session.close();
    }
}
