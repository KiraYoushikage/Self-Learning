package SPI;

public class ImageHello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("image hello!");
    }
}