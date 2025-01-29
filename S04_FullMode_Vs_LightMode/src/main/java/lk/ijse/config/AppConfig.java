package lk.ijse.config;

import lk.ijse.bean.SpringBeanOne;
import lk.ijse.bean.SpringBeanThree;
import lk.ijse.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {
   /* @Bean
    public SpringBeanOne getSpringBeanOne() {
        //If a bean invokes in another bean,It is called as Inter bean Dependency
        SpringBeanTwo springBeanTwo=getSpringBeanTwo();
        SpringBeanTwo springBeanTwo1=getSpringBeanTwo();
        return new SpringBeanOne();
    }

    @Bean
    public SpringBeanTwo getSpringBeanTwo() {
        return new SpringBeanTwo();
    }*/

//    @Bean
//    public SpringBeanTwo SpringBeanTwo(){
//        SpringBeanThree springBeanThree1=SpringBeanThree();
//        SpringBeanThree springBeanThree2=SpringBeanThree();
//        return new SpringBeanTwo();
//    }
//
//    @Bean
//    public SpringBeanThree SpringBeanThree(){
//        return new SpringBeanThree();
//    }
}
