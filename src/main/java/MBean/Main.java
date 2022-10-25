package MBean;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        MBeanServer mBeanServer= ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName=new ObjectName("jmx:type=User");
        User bean=new User();
        mBeanServer.registerMBean(bean, objectName);
        String oldName=null;
        String oldPwd=null;
        System.out.println("jmx started!!!");
        int count=0;
        while(true){
            Thread.sleep(2000);
            if (bean.getName()==null){ System.out.printf("name is a init data : %s \n",oldName);}
            if (bean.getPwd()==null) {System.out.printf("pwd is a init data : %s \n",oldPwd);continue;}
            if (Objects.equals(oldName, bean.getName())){
                System.out.printf("name is nothing change : %s \n",oldName);
            }else {
                System.out.printf("name is changed to : %s \n", oldName);
                oldName = bean.getName();
            }
            if (Objects.equals(oldPwd, bean.getPwd())){
                System.out.printf("pwd is nothing change : %s \n",oldPwd);
                count++;
            }else {
                System.out.printf("pwd is  changed to : %s \n",oldPwd);
                oldPwd=bean.getPwd();
                count++;
            }
            if (count==10){
                bean.setName("new name");
                bean.setPwd("new pwd");
                break;
            }
        }
        Thread.sleep(60000);
    }
}
