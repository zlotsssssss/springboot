package wx.th.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import wx.th.springboot.bean.Car;
import wx.th.springboot.bean.Person;
import wx.th.springboot.config.BeanConfig;

//配置类
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext run = SpringApplication.run(SpringbootApplication.class, args);

        //1.获得所有springboot默认实例化bean
        /*String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }*/
        /*int beanCount = run.getBeanDefinitionCount();
        System.out.println("bean实例个数："+beanCount);
        Person person = (Person) run.getBean("person");
        System.out.println(person);
        Person personz = (Person) run.getBean("personz");
        System.out.println(personz);
        //2.当@Configuration(proxyBeanMethods = true)，代理了配置类的方法，增强功能：先判断容器中是否有该组件，保持单实例
        // 当@Configuration(proxyBeanMethods = false)
        BeanConfig beanConfig = run.getBean("beanConfig", BeanConfig.class);
        Person person1 = beanConfig.person();
        System.out.println(person == person1);*/

        //3.@ImportResource 注解 引入bean.xml
        Person haha = run.getBean("haha",Person.class);
        System.out.println(haha);

        //4.@ConfigurationProperties + @Component  bean的初始化，从配置文件注入属性
        //@ConfigurationProperties bean的初始化，从配置文件注入属性,在配置类上加注解@EnableConfigurationProperties(Car.class)
        //开启Car配置判定、将Car注册到这个容器中。
        Car car = run.getBean(Car.class);
        System.out.println(car);

        Person person = run.getBean("person", Person.class);
        Person person1 = run.getBean("person", Person.class);
        System.out.println(person);
        System.out.println(person1);
        System.out.println(person1 == person);


    }

}
