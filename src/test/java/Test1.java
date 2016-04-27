import com.cf.bean.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

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
}
