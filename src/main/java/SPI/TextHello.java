package SPI;

public class TextHello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("text hello");
    }
}