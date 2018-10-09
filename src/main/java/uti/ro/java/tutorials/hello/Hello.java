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

    public void init(){
        System.out.println("Bean " + this.getClass().getSimpleName() + " is going through init.");
    }
    public void destroy() {
        System.out.println("Bean " + this.getClass().getSimpleName() + " will destroy now thank you");
    }
}
