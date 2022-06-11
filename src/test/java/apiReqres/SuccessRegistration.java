package apiReqres;

public class SuccessRegistration {

    public SuccessRegistration() {
        super();
    }

    private Integer id;
    private String token;

    /**
     Generate -> Constructor
     */

    public SuccessRegistration(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    /**
     Generate -> Getter
     */

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
