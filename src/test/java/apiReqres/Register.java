package apiReqres;

public class Register {
    public Register() {
        super();
    }

    private String email;
    private String password;

    /**
     Generate -> Constructor
     */

    public Register(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
