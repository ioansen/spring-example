package uti.ro.java.tutorials.hello;

public class Hello {

    private String message;

    public String getMessage() {
        System.out.println("Hello " + message);
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}