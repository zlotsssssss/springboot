package wx.th.springboot.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import wx.th.springboot.bean.Car;
import wx.th.springboot.bean.Person;


/*
 1.配置类使用@Bean标注在方法上给容器注册组件，默认是单实例
 2.配置类本身也是组件
 3.配置类也是一个bean（默认bean的name将首页字符小写，此文件是beanConfig），所以这个java创建的bean个数是 总数+1
 4.proxyBeanMethods：代理bean的方法
    Full（proxyBeanMethods = true） 组件依赖，用full模式
    Lite（proxyBeanMethods = false) 无代理，类之间无依赖关系，用Lite模式加速启动
 5.@Import({Person.class}) 使用无参函数实例化bean，注册到容器，默认bean名称是全类名
 6.@Conditional 满足条件，组件注入
    @ConditionalOnBean、@ConditionalOnMissingBean  当容器中有这个bean 才注入
    @ConditionalOnClass，@ConditionalOnMissingClass 当容器中有这个class 才注入
    @ConditionalResource，有这个资源
    @ConditionOnJava 某个版本号
    @ConditionOnWebApplication 是web应用
    @ConditionOnProperty 配置文件 配置某些属性后，才注册组件

 */

@Configuration(proxyBeanMethods = false)
@Import({Person.class})
@ImportResource(value = "classpath:bean.xml")
@EnableConfigurationProperties(Car.class)
public class BeanConfig {

    /*
    当配置类的proxyBeanMethods = true时候，外部获得都是一个单实例对象
     */
    @Bean
    //方法名做为组件的id
    public Person person(){
        Person person = new Person();
        person.setAge(18);
        person.setName("zlo");
        person.setSex("男");
        return person;
    }
    //注意依赖，默认通过beanName
    @ConditionalOnBean(name = {"person"})
    @Bean
    Person personz(Person person){
        return  person;
    }


    @Bean
    //方法名做为组件的id
    public Person zlo(){
        Person person = new Person();
        person.setAge(18);
        person.setName("zl1231231o");
        person.setSex("男");
        return person;
    }
}
