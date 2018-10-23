package uti.ro.java.tutorials.dto;

public class EmployeeMessageDTO extends MessageDTO {

    private long id;

    public EmployeeMessageDTO(Boolean isError, String message, long id) {
        super(isError, message);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
