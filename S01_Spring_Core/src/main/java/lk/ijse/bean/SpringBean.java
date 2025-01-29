package lk.ijse.bean;

import org.springframework.stereotype.Component;

//@Component("springbean")
//this allows to customize bean id
@Component
public class SpringBean {
    public SpringBean() {
        System.out.println("Spring Bean Object Created");
    }

    public void testBean(){
        System.out.println("test method");
    }
}
