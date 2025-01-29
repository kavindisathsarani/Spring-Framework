package lk.ijse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean implements InitializingBean {
//    public SpringBean() {
//    }

/*
@Autowired(required = false)
//This is used when it's constructor overload. the constructor which has the maximum arguments will get called.

//@Autowired
//This @Autowired allows to command which dependency should get injected.This decides which constructor will run
public SpringBean(@Value("kavi") String name, @Value("3") int id) {

    //@Value annotation is used to print runtime values
    System.out.println("Spring Bean Constructor ");
    System.out.println(name);
    System.out.println(id);

}
    @Autowired(required = false)
    public SpringBean(@Value("kavi") String name, @Value("3") int id, @Value("true") boolean b) {

        //@Value annotation is used to print runtime values
        System.out.println("Spring Bean Constructor ");
        System.out.println(name);
        System.out.println(id);
        System.out.println(b);
    }
*/

    @Value("kavi")
    private String name;

    public SpringBean() {
        System.out.println(name); //null
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(name); //kavi
    }
}
