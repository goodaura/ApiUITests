package apiReqres;

public class UnsuccessRegistration {
    public UnsuccessRegistration() {
        super();
    }
    private String error;

    /**
     Generate -> Constructor
     */
    public UnsuccessRegistration(String error) {
        this.error = error;
    }
    /**
     Generate -> Getter
     */
    public String getError() {
        return error;
    }
}
