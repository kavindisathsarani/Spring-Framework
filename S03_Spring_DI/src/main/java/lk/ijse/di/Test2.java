package lk.ijse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test2 implements DiInterface {

//@Autowired
DI test1;

//constructor through injection
//    public Test2(DI test1) {
//        this.test1=test1;
//    }


    //setter method through injection
    @Autowired
    public void setTest1(DI test1) {
        this.test1 = test1;
    }

    public void display() {
        test1.sayHello();
    }

    @Autowired
    @Override
    public void inJect(DI test1) {
        this.test1=test1;
    }
}
