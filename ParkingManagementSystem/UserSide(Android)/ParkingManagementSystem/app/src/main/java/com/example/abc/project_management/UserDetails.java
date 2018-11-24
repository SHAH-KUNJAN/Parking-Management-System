package com.example.abc.project_management;

public class UserDetails {

        private String useremailid;
        private String password;
        private Long mobileno;
        private String licence;
        private String firstname;
        private String lastname;

    public UserDetails(String useremailid, String password, Long mobileno, String licence, String firstname, String lastname) {
        this.useremailid = useremailid;
        this.password = password;
        this.mobileno = mobileno;
        this.licence = licence;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getUseremailid() {
        return useremailid;
    }

    public void setUseremailid(String useremailid) {
        this.useremailid = useremailid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMobileno() {
        return mobileno;
    }

    public void setMobileno(Long mobileno) {
        this.mobileno = mobileno;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
