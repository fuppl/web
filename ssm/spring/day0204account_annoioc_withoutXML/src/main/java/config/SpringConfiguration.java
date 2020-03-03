package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Before;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 该类时一个配置类，作用与bean.xml相同
 * todo Spring中的新注解
 *  Configuration
 *      作用：指定当前类是个配置类
 *      细节：当配置类作为AnnotationConfigurationApplicationContext对象创建的参数时，该注解可以不写,简单点说要么写
 *              private ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class)里面的
 *              SpringConfiguration.class，要么写注解
 *  ComponentScan
 *      作用：用于通过注解指定Spring在创建容器时需要扫描的包
 *      属性：
 *          value：与basePackages作用相同，指定包的位置，等同于
 *              <context:component-scan base-package="com.example"/>
 *  Bean
 *      作用：用于把当前方法作为bean对象存入spring的ioc容器中
 *      属性：
 *          name：用于指定bean的id，默认为当前方法名
 *      细节：
 *          当我们使用注解配置方法时，如果方法有参数，spring会在容器中查找有没有可用的bean对象，
 *          查找方式和Autowired注解的作用是一样的
 *  import
 *      作用：用于导入其他的配置类
 *      属性：
 *          value：用于指定其他配置类的字节码，当使用import注解之后，有import的类就是配置类（父配置类），而导入的都是子配置类
 *                  不需要Configuration注解也不需要17行的配置
 *  propertySource
 *      作用：用于指定properties文件的位置
 *      属性：
 *          value：指定文件得名称和路径
 *                  关键字：classpath(全小写) 表示类路径下
 */
@Configuration
@ComponentScan(basePackages = {"com.example","config"})//todo 必须是一个类路径
@Import(JDBCConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
