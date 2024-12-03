package Object.Models;

public class LoginUserModel {
    private String loginEmail;
    private String loginPassword;


    public LoginUserModel(String LoginEmail, String LoginPassword) {
        this.loginEmail = loginEmail;

        this.loginPassword = loginPassword;

    }

    public String getLoginEmail() {
        return loginEmail;
    }


    public String getLoginPassword() { return loginPassword;}


}
