package SPI;

import java.util.ServiceLoader;

public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<HelloInterface> serviceLoader = ServiceLoader.load(HelloInterface.class);
        System.out.println(serviceLoader);
        for (HelloInterface hello: serviceLoader) {
            System.out.println("dasda");
            hello.sayHello();
        }
    }
}
