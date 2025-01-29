package lk.ijse.config;

import lk.ijse.bean.MyConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "lk.ijse.bean")
public class AppConfig {

    @Bean("connection")
    //this bean annotation allows to customize bean id
    @Scope("prototype")
    //scope annotation with prototype word allow to change the singleton behaviour.
    MyConnection getConnection(){
        return new MyConnection();
    }
}
