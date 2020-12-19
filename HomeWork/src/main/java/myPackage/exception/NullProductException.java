package myPackage.exception;

public class NullProductException extends NullPointerException {
    public NullProductException(){
        super("А вот нет такого объекта");
    }
}
