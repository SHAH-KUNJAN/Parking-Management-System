package com.example.abc.project_management;

public class LoginDetails {

    private String useremailid;
    private String password;


    public LoginDetails(String useremailid, String userpassword) {
        this.useremailid = useremailid;
        this.password = userpassword;
    }

    public String getUseremailid() {
        return useremailid;
    }

    public String getPassword() {
        return password;
    }

    public void setUseremailid(String useremailid) {
        this.useremailid = useremailid;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
