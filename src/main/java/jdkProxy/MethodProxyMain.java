package jdkProxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@Slf4j
public class MethodProxyMain {

    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Student student1=new Student("小明");
        Student student2=new Student("小红");
        Method method= student1.getClass().getMethod("getName");
        String name=(String) method.invoke(student2);
//        log.info("who am i : {}",name);
        System.out.println(name);
    }
    @Test
    public void test2(){
        IUserDao iUserDao= name -> "testUserName:"+name;
        IUserDao userDaoProxy=(IUserDao)ServiceFactory.getService(iUserDao);
        String res=userDaoProxy.getUserName("test");
        System.out.println(res);
    }

}
