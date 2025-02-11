package lk.ijse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = {"lk.ijse.controller"})
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {
    //This is to solve CORS Issue. Override method addCorsMappings(CorsRegistry registry) has been used.
    //This solves CORS issue for the whole application unlike @CrossOrigin annotation which is only limited to the controller class where you put it
  /*  @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //registry.addMapping("api/v1/customer/**") can put also
                .allowedOrigins("*")
//                .allowedOrigins("http//localhost:63342") this means only frontend allows
                //only 2 origins are presented,front end and backend. * is means any origin is allowed
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true)
                .allowedHeaders("*");  //enable all headers
    }*/
}
