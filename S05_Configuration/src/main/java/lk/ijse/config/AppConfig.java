package lk.ijse.config;

import lk.ijse.bean.SpringBean;
import lk.ijse.bean.SpringBean1;
import lk.ijse.bean.SpringBean2;
import org.springframework.context.annotation.*;

@Configuration
@Import({AppConfig1.class, AppConfig2.class})
//this annotation imports both AppConfig1 and AppConfig2 classes. so we don't need to register these classes caz
//AppConfig is already registered.

//@ComponentScan(basePackages = "lk.ijse.bean")
//SpringBean1 and SpringBean2 java classes are configured by this configuration clz caz of this path lk.ijse.bean

//If the file is in root use this way to add an xml file
//@ImportResource("classpath:hibernate.xml")

//If the file isn't in root use this way to add an xml file
//@ImportResource("file:absolute-path-of-hibernate.xml")


public class AppConfig {

@Bean
    public SpringBean springBean(){
   return new SpringBean();
}

    @Bean
    public SpringBean2 springBean2(){
        return new SpringBean2();
    }

}
